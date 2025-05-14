import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router";
import { apiGet, apiPost, apiPut } from "../utils/api";
import InputField from "../components/InputField";
import InputSelect from "../components/InputSelect";
import InputCheck from "../components/InputCheck";

const PersonForm = () => {
  const navigate = useNavigate();
  const { id } = useParams();
  const [person, setPerson] = useState({
    titleBeforeName: "",
    name: "",
    surname: "",
    titleAfterName: "",
    isEmployee: "IPHYS",
    departments: [],
  });

  const [departmentList, setDepartmentList] = useState([]);

  useEffect(() => {
    if (id) {
      apiGet("/person/" + id).then((data) => setPerson(data));
    }
    apiGet("/department/all").then((data) => setDepartmentList(data));
  }, [id]);

  const handleSubmit = (e) => {
    e.preventDefault();
    (id ? apiPut("/person/" + id, person) : apiPost("/person", person))
      .then((data) => {
        id ? navigate("/person/detail/" + id) : navigate("/person");
      })
      .catch((error) => {
        console.log(error.message);
      });
  };

  return (
    <div>
      <h1>{id ? "Upravit" : "Vytvořit"} osobu</h1>
      <hr />
      <form onSubmit={handleSubmit}>
        <InputField
          required={false}
          type="text"
          name="titleBeforeName"
          label="Titul před jménem"
          prompt="Zadej titul osoby"
          value={person.titleBeforeName}
          handleChange={(e) => {
            setPerson({ ...person, titleBeforeName: e.target.value });
          }}
        />
        <InputField
          required={true}
          type="text"
          name="name"
          label="Jméno"
          prompt="Zadej jméno osoby"
          value={person.name}
          handleChange={(e) => {
            setPerson({ ...person, name: e.target.value });
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
            setPerson({ ...person, surname: e.target.value });
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
            setPerson({ ...person, titleAfterName: e.target.value });
          }}
        />
        <InputSelect
          name="departments"
          items={departmentList}
          multiple={true}
          label="Oddělení"
          prompt="Vyber oddělení"
          showLabel="departmentNumber"
          showLabel2="departmentName"
          value={person.departments.id}
          handleChange={(e) => {
            const selectedDepartments = Array.from(
              e.target.selectedOptions,
              (options) => options.value
            );
            const departments = selectedDepartments.map((id) => ({ id }));
            setPerson({ ...person, departments });
          }}
        />

        <div className="d-flex gap-3">
          <InputCheck
            type="radio"
            name="isEmployee"
            label="Zaměstnanec FGÚ"
            value="IPHYS"
            handleChange={(e) => {
              setPerson({ ...person, isEmployee: e.target.value });
            }}
            checked={person.isEmployee === "IPHYS"}
          />

          <InputCheck
            type="radio"
            name="isEmployee"
            label="Není zaměstnancem FGÚ"
            value="none"
            handleChange={(e) => {
              setPerson({ ...person, isEmployee: e.target.value });
            }}
            checked={person.isEmployee === "none"}
          />
        </div>
        <br />
        <input type="submit" className="btn btn-success" value="Uložit" />
      </form>
    </div>
  );
};

export default PersonForm;
