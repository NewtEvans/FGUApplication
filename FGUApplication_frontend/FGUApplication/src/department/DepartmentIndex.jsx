import { useEffect, useState } from "react";
import { apiGet } from "../utils/api";
import { Link } from "react-router";

import DepartmentTable from "./DepartmentTable";

const DepartmentIndex = () => {
  const [url, setUrl] = useState("/department/all");
  const [departments, setDepartments] = useState([]);

  useEffect(() => {
    apiGet(url).then((data) => setDepartments(data));
  }, []);

  return (
    <div>
      <h1>Seznam všech oddělení</h1>
      <div className="d-flex justify-content-between">
        <p>Počet oddělení v databázi: {departments.length}</p>
        <Link to="create" className="btn btn-md btn-success">
          Nové oddělení
        </Link>
      </div>
      <br />
      <DepartmentTable departments={departments} />
    </div>
  );
};

export default DepartmentIndex;
