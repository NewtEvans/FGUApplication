import { useEffect, useState } from "react";
import { Link } from "react-router";

import FacultyTable from "./FacultyTable";

import { apiGet } from "../utils/api";

import { Pagination } from "../components/Pagination";

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
      <Pagination
        page={page}
        setPage={setPage}
        totalPages={totalPages}
        size={size}
        setSize={setSize}
      />
    </div>
  );
};

export default FacultyIndex;
