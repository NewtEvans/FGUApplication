import { useEffect, useState } from "react";
import ThesisTable from "./ThesisTable";
import { apiGet } from "../utils/api";
import { data } from "react-router";

const ThesisIndex = () => {
  const [url, setUrl] = useState("/thesis");
  const [theses, setTheses] = useState([]);

  useEffect(() => {
    apiGet(url).then((data) => setTheses(data));
  }, []);

  return (
    <div>
      <h1>Práce studentů</h1>
      <br />
      <ThesisTable theses={theses} />
    </div>
  );
};

export default ThesisIndex;
