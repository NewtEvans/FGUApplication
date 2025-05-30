import { useEffect, useState } from "react";
import { Link } from "react-router";

import FacultyTable from "./FacultyTable";

import { apiGet } from "../utils/api";

import { Pagination } from "../components/Pagination";
import FilterForm from "../components/filter/FilterForm";

const FacultyIndex = () => {
  const [url, setUrl] = useState("/faculty/all");
  const [faculties, setFaculties] = useState([]);

  const [page, setPage] = useState(0);
  const [totalPages, setTotalPages] = useState();
  const [size, setSize] = useState(10);

  const [filter, setFilter] = useState([]);

  const filterFields = [
    { name: "facultyAbbreviation", label: "Zkratka fakulty", type: "text" },
    { name: "facultyName", label: "Název fakulty", type: "text" },
    { name: "school", label: "Škola", type: "text" },
  ];

  const handleFilter = (filterData) => {
    setPage(0);
    setFilter({
      facultyNameFilter: filterData.facultyName,
      schoolFilter: filterData.school,
      facultyAbbreviationFilter: filterData.facultyAbbreviation,
    });
  };

  useEffect(() => {
    const params = {
      page,
      totalPages,
      size,
      ...filter,
    };
    apiGet(url, params)
      .then((data) => {
        setFaculties(data.content);
        setTotalPages(data.totalPages);
      })
      .catch((error) => {
        console.error(error);
      });
  }, [url, page, size, filter]);

  return (
    <div>
      <h1>Seznam všech fakult</h1>
      <div className="d-flex justify-content-between">
        <p>Počet fakult v databázi: {faculties.length}</p>
        <Link to="create" className="btn btn-md btn-success">
          Nová fakulta
        </Link>
      </div>

      <FilterForm onFilter={handleFilter} fields={filterFields} />
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
