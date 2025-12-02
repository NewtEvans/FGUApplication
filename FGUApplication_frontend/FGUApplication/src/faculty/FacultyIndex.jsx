import { useEffect, useState } from "react";
import { Link } from "react-router";
import FacultyTable from "./FacultyTable";
import { apiGet } from "../utils/api";
import { Pagination } from "../components/Pagination";
import FilterForm from "../components/filter/FilterForm";
import SortDropdown from "../components/SortDropdown";
import { toast } from "react-toastify";
import LoadingSpinner from "../components/LoadingSpinner.jsx";

const FacultyIndex = () => {
  const [url, setUrl] = useState("/faculty/all/pageable");
  const [faculties, setFaculties] = useState([]);
  const [numberOfRecords, setNumberOfRecords] = useState();
  const [loading, setLoading] = useState(true);
  const [page, setPage] = useState(0);
  const [totalPages, setTotalPages] = useState();
  const [size, setSize] = useState(10);
  const [sort, setSort] = useState("facultyName");
  const [filter, setFilter] = useState({
    facultyNameFilter: "",
    schoolFilter: "",
    facultyAbbreviationFilter: "",
  });

  const filterFields = [
    { name: "facultyAbbreviation", label: "Zkratka fakulty", type: "text" },
    { name: "facultyName", label: "Název fakulty", type: "text" },
    { name: "school", label: "Škola", type: "text" },
  ];
  const sortFields = [
    { value: "facultyName", label: "Název fakulty" },
    { value: "school", label: "Škola" },
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
      sort,
      ...filter,
    };

    apiGet(url, params)
      .then((data) => {
        setFaculties(data.content);
        setTotalPages(data.totalPages);
      })
      .catch((error) => {
        toast.error(`Chyba: ${error.message}`);
        console.error(error);
      })
      .finally(() => setLoading(false));
  }, [url, page, size, filter, sort]);

  useEffect(() => {
    apiGet("/faculty/count")
      .then((data) => setNumberOfRecords(data))
      .catch((error) => {
        toast.error(`Chyba: ${error.message}`);
        console.error(error.message);
      });
  }, []);

  if (loading) {
    return <LoadingSpinner />;
  }

  return (
    <div>
      <h1>Seznam všech fakult</h1>
      <div className="d-flex justify-content-between">
        <p>Počet fakult v databázi: {numberOfRecords}</p>
        <Link to="create" className="btn btn-md btn-success">
          Nová fakulta
        </Link>
      </div>
      <FilterForm onFilter={handleFilter} fields={filterFields} />
      <SortDropdown sort={sort} setSort={setSort} fields={sortFields} />
      <FacultyTable faculties={faculties} />
      <Pagination
        currentPage={page}
        setPage={setPage}
        totalPages={totalPages}
        size={size}
        setSize={setSize}
      />
    </div>
  );
};

export default FacultyIndex;
