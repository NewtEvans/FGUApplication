import {useEffect, useState} from "react";
import {useNavigate, useParams} from "react-router";
import {apiGet, apiPost, apiPut} from "../utils/api";
import InputField from "../components/InputField";
import {toast} from "react-toastify";
import LoadingSpinner from "../components/LoadingSpinner.jsx";

const CouncilForm = () => {
    const navigate = useNavigate();
    const {id} = useParams();

    const [loading, setLoading] = useState(true)

    const [council, setCouncil] = useState({
        councilName: "",
        councilAbbreviation: "",
        councilNumber: "",
    });

    const handleChange = (e) => {
        setCouncil({...council, [e.target.name]: e.target.value});
    };

    useEffect(() => {
        if (id) {
            apiGet("/council/" + id)
                .then((data) => setCouncil(data))
                .catch((error) => {
                    toast.error(`Chyba: ${error.message}`);
                    console.error(error.message);
                }).finally(() => setLoading(false));
        }
        setLoading(false)
    }, [id]);

    const handleSubmit = (e) => {
        e.preventDefault();

        (id ? apiPut("/council/" + id, council) : apiPost("/council", council))
            .then(() => {
                toast.success(`Rada byla ${id ? "upravena" : "založena"} úspěšně.`);
                id ? navigate("/counciles/detail/" + id) : navigate("/counciles");
            })
            .catch((error) => {
                toast.error(`Chyba: ${error.message}`);
                console.error(error.message);
            });
    };

    if (loading) {
        return (
            <LoadingSpinner/>
        )
    }
    return (
        <div>
            <h1>{id ? "Upravit" : "Vytvořit"} oborovou radu</h1>
            <hr/>
            <form onSubmit={handleSubmit}>
                <InputField
                    required={true}
                    type="text"
                    name="councilName"
                    label="Název rady"
                    prompt="Zadej název rady"
                    value={council.councilName}
                    handleChange={handleChange}
                />

                <InputField
                    required={true}
                    type="text"
                    name="councilAbbreviation"
                    label="Zkratka rady"
                    prompt="Zadej zkratku rady"
                    value={council.councilAbbreviation}
                    handleChange={handleChange}
                />

                <InputField
                    required={true}
                    type="text"
                    name="councilNumber"
                    label="Číslo rady"
                    prompt="Zadej číslo rady"
                    value={council.councilNumber}
                    handleChange={handleChange}
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

export default CouncilForm;
