import { useEffect, useState } from "react";
import PersonTable from "./PersonTable";

const PersonIndex = () => {
  const [people, setPeople] = useState([]);

  useEffect(() => {
    fetch("http://localhost:8081/people").then((data) => setPeople(data));
  }, []);

  return (
    <div>
      <h1>Seznam všeh osob</h1>
      <PersonTable />
    </div>
  );
};

export default PersonIndex;
