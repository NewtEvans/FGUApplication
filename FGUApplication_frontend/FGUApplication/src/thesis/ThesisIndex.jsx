import { useEffect, useState } from "react";
import ThesisTable from "./ThesisTable";
import { apiGet } from "../utils/api";

const ThesisIndex = () => {
  const [url, setUrl] = useState("/thesis/all");
  const [theses, setTheses] = useState([]);

  useEffect(() => {
    apiGet(url).then((data) => setTheses(data));
  }, []);

  return (
    <div>
      <h1>Práce studentů</h1>
      <ThesisTable theses={theses} />
    </div>
  );
};

export default ThesisIndex;
