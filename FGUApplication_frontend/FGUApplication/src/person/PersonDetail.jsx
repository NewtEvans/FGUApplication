import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router";
import { apiGet, apiDelete } from "../utils/api";

import ThesisTable from "../thesis/ThesisTable";

import { Link } from "react-router-dom";

import DepartmentTable from "../department/DepartmentTable";
import { toast } from "react-toastify";

const PersonDetail = () => {
  const navigate = useNavigate();
  const { id } = useParams();
  const [person, setPerson] = useState({});
  const [studentTheses, setStudentTheses] = useState([]);
  const [consultantTheses, setConsultantTheses] = useState([]);
  const [trainerTheses, setTrainerTheses] = useState([]);

  const [loading, setLoading] = useState(true);

  const archiveFunction = async (id) => {
    const message = person.archived
      ? "Opravdu chcete osobu obnovit?"
      : "Opravdu chcete archivovat osobu?";

    const confirmed = window.confirm(message);
    if (!confirmed) return;

    try {
      await apiDelete("/person/" + id);
      toast.success("Akce proběhla úspešně!");
    } catch (error) {
      toast.error(`Chyba: ${error.message}`);
      console.error(error.message);
    }
    navigate("/person");
  };

  useEffect(() => {
    apiGet("/person/" + id)
      .then((data) => {
        setPerson(data);
      })
      .catch((error) => {
        toast.error(`Chyba: ${error.message}`);
        console.error(error.message);
      });
    apiGet("/thesis/consultant/" + id)
      .then((data) => {
        setConsultantTheses(data);
      })
      .catch((error) => {
        toast.error(`Chyba: ${error.message}`);
        console.error(error.message);
      });
    apiGet("/thesis/student/" + id)
      .then((data) => {
        setStudentTheses(data);
      })
      .catch((error) => {
        toast.error(`Chyba: ${error.message}`);
        console.error(error.message);
      });
    apiGet("/thesis/trainer/" + id)
      .then((data) => {
        setTrainerTheses(data);
      })
      .catch((error) => {
        toast.error(`Chyba: ${error.message}`);
        console.error(error.message);
      })
      .finally(() => setLoading(false));
  }, []);

  if (loading) {
    return (
      <div className="text-center mt-5">
        <div className="spinner-border text-primary" />
      </div>
    );
  }

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
          {person.archived ? (
            <button
              className="btn btn-success btn-md"
              onClick={() => archiveFunction(id)}
            >
              Obnovit osobu
            </button>
          ) : (
            <button
              className="btn btn-danger btn-md"
              onClick={() => archiveFunction(id)}
            >
              Archivovat osobu
            </button>
          )}
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
