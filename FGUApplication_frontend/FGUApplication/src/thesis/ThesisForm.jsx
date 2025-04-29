import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router";
import { apiGet, apiPost, apiPut } from "../utils/api";

import InputField from "../components/InputField";
import InputSelect from "../components/InputSelect";
import InputCheck from "../components/InputCheck";

const ThesisForm = () => {
  const navigate = useNavigate();
  const { id } = useParams();
  const [thesis, setThesis] = useState({
    startDate: "",
    nameCz: "",
    nameEn: "",
    student: { id: 0 },
    trainer: { id: 0 },
    consultant: { id: 0 },
    faculty: { id: 0 },
    council: { id: 0 },
    endDate: "",
    note: "",
  });
  const [people, setPeople] = useState([]);
  const [faculty, setFaculty] = useState([]);
  const [council, setCouncil] = useState([]);

  useEffect(() => {
    if (id) {
      apiGet("/thesis/detail/" + id).then((data) => setThesis(data));
    }
    apiGet("/person/all").then((data) => setPeople(data));
    apiGet("/faculty/all").then((data) => setFaculty(data));
    apiGet("/council/all").then((data) => setCouncil(data));
  }, [id]);

  const handleSubmit = (e) => {
    e.preventDefault();
    (id
      ? apiPut("/thesis/edit/" + id, thesis)
      : apiPost("/thesis/create", thesis)
    )
      .then((data) => {
        navigate("/theses");
      })
      .catch((error) => {
        console.log(error.message);
      });
  };

  return (
    <div>
      <h1>{id ? "Upravit" : "Vytvořit"} práci</h1>
      <hr />
      <form onSubmit={handleSubmit}>
        <InputField
          required={false}
          type="date"
          name="startDate"
          label="Datum začátku"
          prompt="Zadej datum začátku"
          value={thesis.startDate}
          handleChange={(e) => {
            setThesis({ ...thesis, startDate: e.target.value });
          }}
        />
        <InputField
          required={false}
          type="text"
          name="nameCz"
          label="Český název"
          prompt="Zadej český název práce"
          value={thesis.nameCz}
          handleChange={(e) => {
            setThesis({ ...thesis, nameCz: e.target.value });
          }}
        />
        <InputField
          required={false}
          type="text"
          name="nameEn"
          label="Anglický název"
          prompt="Zadej anglický název práce"
          value={thesis.nameEn}
          handleChange={(e) => {
            setThesis({ ...thesis, nameEn: e.target.value });
          }}
        />
        <InputSelect
          name="student"
          items={people}
          label="Student"
          prompt="Vyber studenta"
          showLabel="surname"
          showLabel2="name"
          value={thesis.student.id}
          handleChange={(e) => {
            setThesis({ ...thesis, student: { id: e.target.value } });
          }}
        />
        <InputSelect
          name="trainer"
          items={people}
          label="Školitel"
          prompt="Vyber školitele"
          showLabel="surname"
          showLabel2="name"
          value={thesis.trainer.id}
          handleChange={(e) => {
            setThesis({ ...thesis, trainer: { id: e.target.value } });
          }}
        />
        <InputSelect
          name="consultant"
          items={people}
          label="Konzultant"
          prompt="Vyber konzultanta"
          showLabel="surname"
          showLabel2="name"
          value={thesis.consultant.id}
          handleChange={(e) => {
            setThesis({ ...thesis, consultant: { id: e.target.value } });
          }}
        />
        <InputSelect
          name="faculty"
          items={faculty}
          label="Fakulta"
          prompt="Vyber fakultu"
          value={thesis.faculty.id}
          showLabel="facultyName"
          handleChange={(e) => {
            setThesis({ ...thesis, faculty: { id: e.target.value } });
          }}
        />
        <InputSelect
          name="council"
          items={council}
          label="Rada"
          prompt="Vyber radu"
          value={thesis.council?.id}
          showLabel="councilName"
          handleChange={(e) => {
            setThesis({ ...thesis, council: { id: e.target.value } });
          }}
        />
        <InputField
          required={false}
          type="number"
          name="endDate"
          label="Datum ukončení"
          prompt="Zadej datum ukončení práce"
          value={thesis.endDate}
          handleChange={(e) => {
            setThesis({ ...thesis, endDate: e.target.value });
          }}
        />
        <InputField
          required={false}
          type="text"
          name="note"
          label="Poznámka"
          prompt="Zadej poznámku"
          value={thesis.note}
          handleChange={(e) => {
            setThesis({ ...thesis, note: e.target.value });
          }}
        />
        <br />
        <input type="submit" className="btn btn-success" value="Uložit" />
      </form>
    </div>
  );
};

export default ThesisForm;
