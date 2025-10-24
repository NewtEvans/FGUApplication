import {useEffect, useState} from "react";
import {useNavigate, useParams} from "react-router";
import {apiGet, apiPost, apiPut} from "../utils/api";

import InputField from "../components/InputField";
import {toast} from "react-toastify";
import LoadingSpinner from "../components/LoadingSpinner.jsx";

const FacultyForm = () => {
    const navigate = useNavigate();
    const {id} = useParams();
    const [loading, setLoading] = useState(true);

    const [faculty, setFaculty] = useState({
        facultyName: "",
        facultyAbbreviation: "",
        school: "",
    });

    useEffect(() => {
        if (id) {
            apiGet("/faculty/" + id)
                .then((data) => setFaculty(data))
                .catch((error) => {
                    toast.error(`Chyba: ${error.message}`);
                    console.error(error.message);
                });
        }
        setLoading(false)
    }, [id]);

    const handleSubmit = (e) => {
        e.preventDefault();
        (id ? apiPut("/faculty/" + id, faculty) : apiPost("/faculty", faculty))
            .then(() => {
                toast.success(`Fakulta byla ${id ? "upravena" : "vytvořena"} úspěšně.`);
                id ? navigate("/faculties/detail/" + id) : navigate("/faculties");
            })
            .catch((error) => {
                toast.error(`Chyba: ${error.message}`);
                console.error(error.messagte);
            });
    };

    if (loading) {
        return (
            <LoadingSpinner/>
        );
    }

    return (
        <div>
            <h1>{id ? "Upravit" : "Vytvořit"} fakultu</h1>

            <hr/>

            <form onSubmit={handleSubmit}>
                <InputField
                    required={true}
                    type="text"
                    name="facultyName"
                    label="Název fakulty"
                    prompt="Zadej název fakulty"
                    value={faculty.facultyName}
                    handleChange={(e) => {
                        setFaculty({...faculty, facultyName: e.target.value});
                    }}
                />

                <InputField
                    required={true}
                    type="text"
                    name="facultyAbbreviation"
                    label="Zkratka fakulty"
                    prompt="Zadej zkratku fakulty"
                    value={faculty.facultyAbbreviation}
                    handleChange={(e) => {
                        setFaculty({...faculty, facultyAbbreviation: e.target.value});
                    }}
                />

                <InputField
                    required={true}
                    type="text"
                    name="school"
                    label="Škola"
                    prompt="Zadej školu"
                    value={faculty.school}
                    handleChange={(e) => {
                        setFaculty({...faculty, school: e.target.value});
                    }}
                />

                <br/>
                <div className="d-flex justify-content-between">
                    <input type="submit" className="btn btn-success" value="Uložit"/>
                    <button className="btn btn-danger" onClick={() => navigate(-1)}>Storno</button>
                </div>
            </form>
        </div>
    );
};

export default FacultyForm;
