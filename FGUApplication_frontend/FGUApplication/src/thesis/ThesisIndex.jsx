import { useEffect, useState } from "react";
import ThesisTable from "./ThesisTable";
import { apiGet } from "../utils/api";
import { Link } from "react-router";

const ThesisIndex = () => {
  const [url, setUrl] = useState("/thesis/all");
  const [theses, setTheses] = useState([]);

  useEffect(() => {
    apiGet(url).then((data) => setTheses(data));
  }, []);

  return (
    <div>
      <h1>Práce studentů</h1>
      <div className="d-flex justify-content-between">
        <p>Počet prací v databázi: {theses.length}</p>
        <Link to="create" className="btn btn-md btn-success">
          Nová práce
        </Link>
      </div>
      <ThesisTable theses={theses} />
    </div>
  );
};

export default ThesisIndex;
