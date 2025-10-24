import {useEffect, useState} from "react";
import {useNavigate, useParams} from "react-router";
import {apiGet, apiPost, apiPut} from "../utils/api";
import InputField from "../components/InputField";
import InputSelect from "../components/InputSelect";
import InputCheck from "../components/InputCheck";
import {toast} from "react-toastify";
import LoadingSpinner from "../components/LoadingSpinner.jsx";

const PersonForm = () => {
    const navigate = useNavigate();
    const {id} = useParams();

    const [loading, setLoading] = useState(true)

    const [person, setPerson] = useState({
        titleBeforeName: "",
        firstName: "",
        surname: "",
        titleAfterName: "",
        isEmployee: "IPHYS",
        isArchived: false,
        departments: [],
    });
    const [departmentList, setDepartmentList] = useState([]);

    useEffect(() => {
        if (id) {
            apiGet("/person/" + id).then((data) => setPerson(data))
                .catch((error) => {
                    toast.error(`Chyba ${error.message}`);
                    console.error(error.message);
                });
        }
        apiGet("/department/all").then((data) => setDepartmentList(data))
            .catch((error) => {
                toast.error(`Chyba: ${error.message}`);
                console.error(error.message)
            })
            .finally(() => {
                setLoading(false)
            })
    }, [id]);

    const handleSubmit = (e) => {
        e.preventDefault();
        (id ? apiPut("/person/" + id, person) : apiPost("/person", person))
            .then(() => {
                toast.success(`Osoba byla ${id ? "upravena" : "založena"} úspešně.`);
                id ? navigate("/person/detail/" + id) : navigate("/person");
            })
            .catch((error) => {
                toast.error(`Chyba: ${error.message}`);
                console.error(error.message);
            });
    };

    if (loading) {
        return (
            <LoadingSpinner/>
        );
    }

    return (
        <div>
            <h1>{id ? "Upravit" : "Vytvořit"} osobu</h1>

            <hr/>
            <form onSubmit={handleSubmit}>
                <InputField
                    required={false}
                    type="text"
                    name="titleBeforeName"
                    label="Titul před jménem"
                    prompt="Zadej titul osoby"
                    value={person.titleBeforeName}
                    handleChange={(e) => {
                        setPerson({...person, titleBeforeName: e.target.value});
                    }}
                />

                <InputField
                    required={true}
                    type="text"
                    name="name"
                    label="Jméno"
                    prompt="Zadej jméno osoby"
                    value={person.firstName}
                    handleChange={(e) => {
                        setPerson({...person, firstName: e.target.value});
                    }}
                />

                <InputField
                    required={true}
                    type="text"
                    name="surname"
                    label="Přijmení"
                    prompt="Zadej přijmení osoby"
                    value={person.surname}
                    handleChange={(e) => {
                        setPerson({...person, surname: e.target.value});
                    }}
                />

                <InputField
                    required={false}
                    type="text"
                    name="titleAfterName"
                    label="Titul za jménem"
                    prompt="Zadej titul osoby"
                    value={person.titleAfterName}
                    handleChange={(e) => {
                        setPerson({...person, titleAfterName: e.target.value});
                    }}
                />

                <InputSelect
                    name="departments"
                    items={departmentList}
                    label="Oddělení"
                    placeHolder="Vyber oddělení"
                    value={
                        person.isEmployee === "none"
                            ? []
                            : person.departments.map((department) => department.id)
                    }
                    showLabel="departmentNumber"
                    showLabel2="departmentName"
                    isMulti={true}
                    isDisabled={person.isEmployee === "none"}
                    onChange={(ids) => {
                        setPerson({...person, departments: ids.map((id) => ({id}))});
                    }}
                />

                <div className="d-flex gap-3">
                    <InputCheck
                        type="radio"
                        name="isEmployee"
                        label="Zaměstnanec FGÚ"
                        value="IPHYS"
                        handleChange={(e) => {
                            setPerson({...person, isEmployee: e.target.value});
                        }}
                        checked={person.isEmployee === "IPHYS"}
                    />

                    <InputCheck
                        type="radio"
                        name="isEmployee"
                        label="Není zaměstnancem FGÚ"
                        value="none"
                        handleChange={(e) => {
                            setPerson({
                                ...person,
                                isEmployee: e.target.value,
                                departments: [],
                            });
                        }}
                        checked={person.isEmployee === "none"}
                    />
                </div>
                <br/>
                <div className="d-flex justify-content-between">
                    <input type="submit" className="btn btn-success" value="Uložit"/>
                    <button className="btn btn-danger" onClick={() => navigate(-1)}>Storno</button>
                </div>
            </form>
        </div>
    );
};

export default PersonForm;
