import { useEffect, useState } from "react";

import FacultyTable from "./FacultyTable";

import { apiGet } from "../utils/api";

const FacultyIndex = () => {
  const [url, setUrl] = useState("/faculty/all");
  const [faculties, setFaculties] = useState([]);

  useEffect(() => {
    apiGet(url).then((data) => setFaculties(data));
  }, []);

  return (
    <div>
      <h1>Seznam všech fakult</h1>
      <FacultyTable faculties={faculties} />
    </div>
  );
};

export default FacultyIndex;
