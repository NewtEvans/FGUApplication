import { useEffect, useState } from "react";
import { useParams } from "react-router";
import { apiGet } from "../utils/api";

import { Link } from "react-router";

import DepartmentTable from "../department/DepartmentTable";

const PersonDetail = () => {
  const { id } = useParams();
  const [person, setPerson] = useState({});

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
      <p>
        <strong>Oddělení:</strong>
      </p>
      <hr />
      {/* <DepartmentTable departments={person.departments} /> */}

      <Link to={`/person/edit/${id}`} className="btn btn-md btn-warning">
        Upravit osobu
      </Link>
    </div>
  );
};

export default PersonDetail;
