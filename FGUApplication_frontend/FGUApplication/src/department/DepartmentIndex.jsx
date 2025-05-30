import { useEffect, useState } from "react";
import { apiGet } from "../utils/api";
import { Link } from "react-router";
import { Pagination } from "../components/Pagination";

import DepartmentTable from "./DepartmentTable";
import FilterForm from "../components/filter/FilterForm";

const DepartmentIndex = () => {
  const [url, setUrl] = useState("/department/all");
  const [departments, setDepartments] = useState([]);

  const [page, setPage] = useState(0);
  const [totalPages, setTotalPages] = useState();
  const [size, setSize] = useState(10);

  const [sort, setSort] = useState();

  const [filter, setFilter] = useState([]);

  const filterFields = [
    { name: "number", label: "Číslo oddělení", type: "text" },
    { name: "name", label: "Název oddělení", type: "text" },
  ];

  const handleFilter = (filterData) => {
    setPage(0);
    setFilter({
      departmentNameFilter: filterData.name,
      departmentNumberFilter: filterData.number,
    });
  };

  useEffect(() => {
    const params = {
      page,
      size,
      totalPages,
      ...filter,
    };

    apiGet(url, params)
      .then((data) => {
        setDepartments(data.content);
        setTotalPages(data.totalPages);
      })
      .catch((error) => {
        console.error(error);
      });
  }, [url, page, size, filter]);

  return (
    <div>
      <h1>Seznam všech oddělení</h1>
      <div className="d-flex justify-content-between">
        <p>Počet oddělení v databázi: {departments.length}</p>
        <Link to="create" className="btn btn-md btn-success">
          Nové oddělení
        </Link>
      </div>
      <div>
        <FilterForm onFilter={handleFilter} fields={filterFields} />
      </div>

      <br />
      <DepartmentTable departments={departments} />
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

export default DepartmentIndex;
