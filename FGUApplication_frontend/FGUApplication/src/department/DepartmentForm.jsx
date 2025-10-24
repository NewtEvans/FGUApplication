import {useEffect, useState} from "react";
import {useNavigate, useParams} from "react-router";
import {apiGet, apiPost, apiPut} from "../utils/api";
import {toast} from "react-toastify";

import InputField from "../components/InputField";
import LoadingSpinner from "../components/LoadingSpinner.jsx";

const DepartmentForm = () => {
    const navigate = useNavigate();
    const {id} = useParams();
    const [loading, setLoading] = useState(true)
    const [department, setDepartment] = useState({
        departmentName: "",
        departmentNumber: "",
        people: [{}],
    });

    useEffect(() => {
        if (id) {
            apiGet("/department/" + id).then((data) => setDepartment(data))
                .catch((error) => {
                    toast.error(`Chyba: ${error.message}`);
                    console.error(error.message);
                })
        }
        setLoading(false);
    }, [id]);

    const handleSubmit = (e) => {
        e.preventDefault();

        (id
                ? apiPut("/department/" + id, department)
                : apiPost("/department", department)
        )
            .then(() => {
                toast.success(
                    `Oddělení bylo ${id ? "upraveno" : "vytvořeno"} úspěšně.`
                );
                id ? navigate("/departments/detail/" + id) : navigate("/departments");
            })
            .catch((error) => {
                toast.error(`Chyba: ${error.message}`);
                console.log(error.message);
            });
    };

    if (loading) {
        return (
            <LoadingSpinner/>
        );
    }

    return (
        <div>
            <h1>{id ? "Upravit" : "Vytvořit"} oddělení</h1>
            <hr/>
            <form onSubmit={handleSubmit}>
                <InputField
                    required={true}
                    type="text"
                    name="departmentName"
                    label="Název oddělení"
                    prompt="Zadej název oddělení"
                    value={department.departmentName}
                    handleChange={(e) => {
                        setDepartment({...department, departmentName: e.target.value});
                    }}
                />
                <InputField
                    required={true}
                    type="text"
                    name="departmentNumber"
                    label="Číslo oddělení"
                    prompt="Zadej číslo oddělení"
                    value={department.departmentNumber}
                    handleChange={(e) => {
                        setDepartment({...department, departmentNumber: e.target.value});
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

export default DepartmentForm;
