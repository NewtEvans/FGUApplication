import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router";
import { apiGet, apiDelete } from "../utils/api";

import ThesisTable from "../thesis/ThesisTable";

import { Link } from "react-router";

import DepartmentTable from "../department/DepartmentTable";

const PersonDetail = () => {
  const navigate = useNavigate();
  const { id } = useParams();
  const [person, setPerson] = useState({});
  const [studentTheses, setStuedentTheses] = useState([]);
  const [consultantTheses, setConsultantTheses] = useState([]);
  const [trainerTheses, setTrainerTheses] = useState([]);

  const deleteFunction = async (id) => {
    const confirmed = window.confirm("Opravdu chcete archivovat tuto osobu?");
    if (!confirmed) return;

    try {
      await apiDelete("/person/" + id);
      alert("Osoba byla úspešně archivována.");
    } catch (error) {
      console.log(error.message);
      alert(error.message);
    }
    navigate("/person");
  };

  useEffect(() => {
    apiGet("/person/" + id)
      .then((data) => {
        setPerson(data);
      })
      .catch((error) => {
        console.log(error);
      });
  }, []);

  useEffect(() => {
    apiGet("/thesis/consultant/" + id)
      .then((data) => {
        setConsultantTheses(data);
      })
      .catch((error) => {
        console.log(error);
      });
  }, []);

  useEffect(() => {
    apiGet("/thesis/student/" + id)
      .then((data) => {
        setStuedentTheses(data);
      })
      .catch((error) => {
        console.log(error);
      });
  }, []);

  useEffect(() => {
    apiGet("/thesis/trainer/" + id)
      .then((data) => {
        setTrainerTheses(data);
      })
      .catch((error) => {
        console.log(error);
      });
  }, []);

  return (
    <div>
      <div className="d-flex align-items-center justify-content-between">
        <h1>Detail osoby</h1>
        <div>
          <Link
            to={`/person/edit/${id}`}
            className="btn btn-md btn-warning me-1"
          >
            Upravit osobu
          </Link>
          {/* Podminka pro archivovaci tlacitko a nebo enablovaci tlacitko */}
          <button
            className="btn btn-danger btn-md"
            onClick={() => deleteFunction(id)}
          >
            Archivovat osobu
          </button>
        </div>
      </div>
      <hr />
      <p>
        <strong>Předložný titul:</strong> {person.titleBeforeName}
      </p>
      <p>
        <strong>Jméno:</strong> {person.firstName}
      </p>
      <p>
        <strong>Přijmení:</strong> {person.surname}
      </p>
      <p>
        <strong>Příjmenkový titul:</strong> {person.titleAfterName}
      </p>
      <p>
        <strong>Zaměstnanec FGÚ: </strong>{" "}
        {person.isEmployee === "IPHYS" ? "Ano" : "Není"}
      </p>
      <DepartmentTable departments={person.departments || []} />
      <br />
      <h2>Vlastní práce: </h2>
      <ThesisTable theses={studentTheses} />
      <br />
      <h2>Školené práce: </h2>
      <ThesisTable theses={trainerTheses} />
      <br />
      <h2>Konzultované práce:</h2>
      <ThesisTable theses={consultantTheses} />
    </div>
  );
};

export default PersonDetail;
