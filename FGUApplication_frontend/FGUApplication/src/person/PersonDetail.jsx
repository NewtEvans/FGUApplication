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

  const deleteFunction = async (id) => {
    try {
      await apiDelete("/person/delete/" + id);
    } catch (error) {
      console.log(error.message);
      alert(error.message);
    }
    navigate("/person");
  };

  useEffect(() => {
    apiGet("/person/detail/" + id)
      .then((data) => {
        setPerson(data);
      })
      .catch((error) => {
        console.log(error);
      });
  }, []);

  return (
    <div>
      <h1>Detail osoby</h1>
      <hr />
      <p>
        <strong>Předložný titul:</strong> {person.titleBeforeName}
      </p>
      <p>
        <strong>Jméno:</strong> {person.name}
      </p>
      <p>
        <strong>Přijmení:</strong> {person.surname}
      </p>
      <p>
        <strong>Příjmenkový titul:</strong> {person.titleAfterName}
      </p>
      <DepartmentTable departments={person.departments || []} />
      <hr />
      <h2>Vlastní práce: </h2>
      <hr />
      <h2>Školené práce: </h2>
      <hr />
      <h2>Konzultované práce:</h2>

      <Link to={`/person/edit/${id}`} className="btn btn-md btn-warning">
        Upravit osobu
      </Link>
      <button
        className="btn btn-danger btn-md"
        onClick={() => deleteFunction(id)}
      >
        Smazat osobu
      </button>
    </div>
  );
};

export default PersonDetail;
