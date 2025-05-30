import { useEffect, useState } from "react";
import PersonTable from "./PersonTable";
import { apiGet } from "../utils/api";
import { Link } from "react-router-dom";
import { Pagination } from "../components/Pagination";
import FilterForm from "../components/filter/FilterForm";

const PersonIndex = () => {
  const [url, setUrl] = useState("/person/all");
  const [people, setPeople] = useState([]);

  const [page, setPage] = useState(0);
  const [totalPages, setTotalPages] = useState();
  const [size, setSize] = useState(10);

  const [sort, setSort] = useState("surname");

  const [filter, setFilter] = useState([]);

  const filterFields = [
    { name: "name", label: "Jméno", type: "text" },
    { name: "surname", label: "Přijmení", type: "text" },
  ];

  const handleFilter = (filterData) => {
    setPage(0);
    setFilter({
      nameFilter: filterData.name,
      surnameFilter: filterData.surname,
    });
  };

  useEffect(() => {
    const params = {
      page,
      size,
      totalPages,
      sort,
      ...filter,
    };

    apiGet(url, params)
      .then((data) => {
        setPeople(data.content);
        setTotalPages(data.totalPages);
      })
      .catch((error) => {
        console.error(error);
      });
  }, [url, page, size, filter]);

  return (
    <div>
      <h1>Seznam všeh osob</h1>
      <div className="d-flex justify-content-between">
        <p>Počet osob v databázi: {people.length}</p>
        <Link to="create" className="btn btn-md btn-success">
          Nová osoba
        </Link>
      </div>
      <br />

      {/* Zde prijde komponenta pro sort menu */}
      <FilterForm onFilter={handleFilter} fields={filterFields} />
      <br />
      <PersonTable people={people} />
      <div className="d-flex justify-content-between align-item-center">
        <div className="dropdown">
          <button
            id="sortDropdownMenuButton1"
            className="btn dropdown-toggle"
            type="button"
            data-bs-toggle="dropdown"
            aria-expanded="false"
            onChange={(e) => {
              setSort(e.target.value);
            }}
          >
            Seřadit dle
          </button>
          <div
            className="dropdown-menu"
            aria-labelledby="sortDropdownMenuButton2"
          >
            <option value="surname" className="dropdown-item">
              prijmeni
            </option>
            <option value="name" className="dropdown-item">
              name
            </option>
            <option value="id" className="dropdown-item">
              id
            </option>
          </div>
        </div>

        <span className="mx-auto">
          <Pagination
            page={page}
            setPage={setPage}
            totalPages={totalPages}
            size={size}
            setSize={setSize}
          />
        </span>
      </div>
    </div>
  );
};

{
  /* <select
        id="allResultsSort"
        className="form-select w-auto d-inline-block"
        value={sort}
        onChange={(e) => {
          setSort(e.target.value);
        }}
      >
        <option value="surname">prijmeni</option>
        <option value="name">name</option>
        <option value="id">id</option>
      </select>
      <select
        id="employeeSort"
        className="form-select w-auto d-inline-block"
        value={sort}
        onChange={(e) => {
          setSort(e.target.value);
        }}
      >
        <option value="surname">prijmeni</option>
        <option value="name">name</option>
        <option value="id">id</option>
      </select>
      <select
        id="nonEmployeeSort"
        className="form-select w-auto d-inline-block"
        value={sort}
        onChange={(e) => {
          setSort(e.target.value);
        }}
      >
        <option value="surname">prijmeni</option>
        <option value="name">name</option>
        <option value="id">id</option>
      </select> */
}

export default PersonIndex;
