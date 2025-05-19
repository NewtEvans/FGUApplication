import { useEffect, useState } from "react";
import { Link } from "react-router";

import FacultyTable from "./FacultyTable";

import { apiGet } from "../utils/api";

const FacultyIndex = () => {
  const [url, setUrl] = useState("/faculty/all");
  const [faculties, setFaculties] = useState([]);

  const [page, setPage] = useState(0);
  const [totalPages, setTotalPages] = useState();
  const [size, setSize] = useState(10);

  useEffect(() => {
    apiGet(url, {
      page: page,
      totalPages: totalPages,
      size: size,
    })
      .then((data) => {
        setFaculties(data.content);
        setTotalPages(data.totalPages);
      })
      .catch((error) => {
        console.error(error);
      });
  }, [url, page, totalPages, size]);

  return (
    <div>
      <h1>Seznam všech fakult</h1>
      <div className="d-flex justify-content-between">
        <p>Počet fakult v databázi: {faculties.length}</p>
        <Link to="create" className="btn btn-md btn-success">
          Nová fakulta
        </Link>
      </div>
      <br />
      <FacultyTable faculties={faculties} />
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
          value={size}
          onChange={(e) => {
            setPage(0);
            setSize(e.target.value);
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

export default FacultyIndex;
