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
      <div className="row">
        <div className="col">
          <h1>Práce studentů</h1>
        </div>
        <div className="col">
          <Link to="create" className="btn btn-md btn-success">
            Nová práce
          </Link>
        </div>
      </div>
      <ThesisTable theses={theses} />
    </div>
  );
};

export default ThesisIndex;
