import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router";
import { apiGet, apiPost, apiPut } from "../utils/api";

import InputField from "../components/InputField";
import InputSelect from "../components/InputSelect";
import InputCheck from "../components/InputCheck";
import thesisType from "./ThesisType";
import { toast } from "react-toastify";

const ThesisForm = () => {
  const navigate = useNavigate();
  const { id } = useParams();
  const [thesis, setThesis] = useState({
    startDate: "",
    nameCz: "",
    nameEn: "",
    student: {},
    trainer: {},
    consultant: {},
    faculty: {},
    council: {},
    endDate: "",
    thesisType: "",
    note: "",
  });
  const [people, setPeople] = useState([]);
  const [faculty, setFaculty] = useState([]);
  const [council, setCouncil] = useState([]);

  useEffect(() => {
    if (id) {
      apiGet("/thesis/" + id).then((data) => setThesis(data));
    }
    apiGet("/person/all").then((data) => setPeople(data.content));
    apiGet("/faculty/all").then((data) => setFaculty(data.content));
    apiGet("/council/all").then((data) => setCouncil(data.content));
  }, [id]);

  const handleSubmit = (e) => {
    e.preventDefault();
    (id ? apiPut("/thesis/" + id, thesis) : apiPost("/thesis", thesis))
      .then((data) => {
        toast.success(`Práce byla ${id ? "upravena" : "založena"} úspěšně.`);
        id ? navigate("/theses/detail/" + id) : navigate("/theses");
      })
      .catch((error) => {
        toast.error(`Chyba: ${error.message}`);
        console.error(error.message);
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
          prompt="Zadej datum začátku práce"
          value={thesis.startDate}
          handleChange={(e) => {
            setThesis({ ...thesis, startDate: e.target.value });
          }}
        />
        <InputField
          required={true}
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
          placeHolder="Vyber studenta"
          showLabel="surname"
          showLabel2="firstName"
          value={thesis.student.id}
          onChange={(id) => {
            setThesis({ ...thesis, student: { id } });
          }}
        />
        <InputSelect
          name="trainer"
          items={people}
          label="Školitel"
          placeHolder="Vyber školitele"
          showLabel="surname"
          showLabel2="firstName"
          value={thesis.trainer.id}
          onChange={(id) => {
            setThesis({ ...thesis, trainer: { id } });
          }}
        />
        <InputSelect
          name="consultant"
          items={people}
          label="Konzultant"
          placeHolder="Vyber konzultanta"
          showLabel="surname"
          showLabel2="firstName"
          value={thesis.consultant.id}
          onChange={(id) => {
            setThesis({
              ...thesis,
              consultant: { id },
            });
          }}
        />
        <InputSelect
          name="faculty"
          items={faculty}
          label="Fakulta"
          placeHolder="Vyber fakultu"
          value={thesis.faculty.id}
          showLabel="facultyName"
          onChange={(id) => {
            setThesis({ ...thesis, faculty: { id } });
          }}
        />
        <InputSelect
          name="council"
          items={council}
          label="Rada"
          placeHolder="Vyber radu"
          value={thesis.council?.id}
          showLabel="councilName"
          onChange={(id) => {
            setThesis({ ...thesis, council: { id } });
          }}
        />
        <InputField
          required={false}
          type="date"
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
        <p>Druh práce:</p>
        <div className="d-flex align-items-center justify-content-between">
          <InputCheck
            type="radio"
            name="thesisType"
            label="Bakalářská"
            value={thesisType.BAKALARSKA}
            handleChange={(e) => {
              setThesis({ ...thesis, thesisType: e.target.value });
            }}
            checked={thesisType.BAKALARSKA === thesis.thesisType}
          />

          <InputCheck
            type="radio"
            name="thesisType"
            label="Magisterská"
            value={thesisType.MAGISTERSKA}
            handleChange={(e) => {
              setThesis({ ...thesis, thesisType: e.target.value });
            }}
            checked={thesisType.MAGISTERSKA === thesis.thesisType}
          />

          <InputCheck
            type="radio"
            name="thesisType"
            label="Doktorandská"
            value={thesisType.DOKTORANDSKA}
            handleChange={(e) => {
              setThesis({ ...thesis, thesisType: e.target.value });
            }}
            checked={thesisType.DOKTORANDSKA === thesis.thesisType}
          />

          <InputCheck
            type="radio"
            name="thesisType"
            label="Inženýrská"
            value={thesisType.INZENYRSKA}
            handleChange={(e) => {
              setThesis({ ...thesis, thesisType: e.target.value });
            }}
            checked={thesisType.INZENYRSKA === thesis.thesisType}
          />
        </div>
        <br />
        <input type="submit" className="btn btn-success" value="Uložit" />
      </form>
    </div>
  );
};

export default ThesisForm;
