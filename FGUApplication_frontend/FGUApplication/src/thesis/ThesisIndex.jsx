import { useEffect, useState } from "react";
import ThesisTable from "./ThesisTable";
import { apiGet } from "../utils/api";
import { Link } from "react-router";
import { Pagination } from "../components/Pagination";
import FilterForm from "../components/filter/FilterForm";

const ThesisIndex = () => {
  const [url, setUrl] = useState("/thesis/all");
  const [theses, setTheses] = useState([]);

  const [page, setPage] = useState(0);
  const [totalPages, setTotalPages] = useState();
  const [size, setSize] = useState(10);

  const [filter, setFilter] = useState([]);
  const filterFields = [
    { name: "nameCzFilter", label: "Český název práce:", type: "text" },
    { name: "nameEnFilter", label: "Anglický název práce:", type: "text" },
    /* { name: "thesisTypeFilter", label: "Druh práce", type: "select" }, */

    {
      type: "date-range",
      label: "Rozsah data zahájení:",
      nameFrom: "startDateFilterFrom",
      nameTo: "startDateFilterTo",
    },
    {
      type: "date-range",
      label: "Rozsah data ukončení:",
      nameFrom: "endDateFilterFrom",
      nameTo: "endDateFilterTo",
    },
  ];

  const handleFilter = (filterData) => {
    setPage(0);
    setFilter(filterData);
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
        setTheses(data.content);
        setTotalPages(data.totalPages);
      })
      .catch((error) => {
        console.error(error);
      });
  }, [url, page, totalPages, filter, size]);

  return (
    <div>
      <h1>Práce studentů</h1>
      <div className="d-flex justify-content-between">
        <p>Počet prací v databázi: {theses.length}</p>
        <Link to="create" className="btn btn-md btn-success">
          Nová práce
        </Link>
      </div>

      <FilterForm onFilter={handleFilter} fields={filterFields} />
      <br />
      <ThesisTable theses={theses} />
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

export default ThesisIndex;
