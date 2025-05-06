import { useEffect, useState } from "react";
import PersonTable from "./PersonTable";
import { apiGet } from "../utils/api";
import { Link } from "react-router-dom";

const PersonIndex = () => {
  const [url, setUrl] = useState("/person/all");
  const [people, setPeople] = useState([]);

  useEffect(() => {
    apiGet(url)
      .then((data) => setPeople(data))
      .catch((error) => {
        console.error(error);
      });
  }, [url]);

  return (
    <div>
      <h1>Seznam všeh osob</h1>
      <div className="d-flex justify-content-between">
        <p>Počet osob v databázi: {people.length}</p>
        <Link to="create" className="btn btn-md btn-success">
          Nová osoba
        </Link>
      </div>
      <br />
      <PersonTable people={people} />
    </div>
  );
};

export default PersonIndex;
