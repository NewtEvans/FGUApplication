import { useEffect, useState } from "react";
import PersonTable from "./PersonTable";
import { apiGet } from "../utils/api";

const PersonIndex = () => {
  const [url, setUrl] = useState("/person/all");
  const [people, setPeople] = useState([]);

  useEffect(() => {
    apiGet(url).then((data) => setPeople(data));
  }, []);

  return (
    <div>
      <h1>Seznam všeh osob</h1>
      <PersonTable people={people} />
    </div>
  );
};

export default PersonIndex;
