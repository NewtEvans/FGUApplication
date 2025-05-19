import { useEffect, useState } from "react";
import { apiGet } from "../utils/api";
import { Link } from "react-router";

import DepartmentTable from "./DepartmentTable";

const DepartmentIndex = () => {
  const [url, setUrl] = useState("/department/all");
  const [departments, setDepartments] = useState([]);

  const [page, setPage] = useState(0);
  const [totalPages, setTotalPages] = useState();
  const [size, setSize] = useState(10);

  useEffect(() => {
    apiGet(url, {
      page: page,
      size: size,
      totalPages: totalPages,
    })
      .then((data) => {
        setDepartments(data.content);
        setTotalPages(data.totalPages);
      })
      .catch((error) => {
        console.error(error);
      });
  }, [url, page, size, totalPages]);

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
      <div className="d-flex justify-content-between">
        <button
          className="btn btn-primary btn-sm"
          disabled={page === 0}
          onClick={() => setPage(page - 1)}
        >
          Předchozí
        </button>
        <select
          id="pageSize"
          className="form-select w-auto d-inline-block"
          onChange={(e) => {
            setPage(0);
            setSize(parseInt(e.target.value));
          }}
        >
          <option value="10">10</option>
          <option value="25">25</option>
          <option value="50">50</option>
          <option value="100">100</option>
        </select>
        <button
          className="btn btn-primary btn-sm"
          disabled={page + 1 >= totalPages}
          onClick={() => setPage(page + 1)}
        >
          Další
        </button>
      </div>
    </div>
  );
};

export default DepartmentIndex;
