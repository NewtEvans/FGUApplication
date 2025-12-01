import { useEffect, useState } from "react";
import { toast } from "react-toastify";
import { apiGet } from "../utils/api";
import { Link } from "react-router";
import { Pagination } from "../components/Pagination";

import FilterForm from "../components/filter/FilterForm";
import SortDropdown from "../components/SortDropdown";
import thesisType from "./ThesisType";
import ThesisTable from "./ThesisTable";
import thesisStatus from "./ThesisStatus.jsx";
import LoadingSpinner from "../components/LoadingSpinner.jsx";

const ThesisIndex = () => {
  const [url, setUrl] = useState("/thesis/all/pageable");

  const [theses, setTheses] = useState([]);
  const [people, setPeople] = useState([]);
  const [faculty, setFaculty] = useState([]);
  const [council, setCouncil] = useState([]);

  const [numberOfRecords, setNumberOfRecords] = useState();

  const [loading, setLoading] = useState(true);

  const [page, setPage] = useState(0);
  const [totalPages, setTotalPages] = useState();
  const [size, setSize] = useState(10);

  const [sort, setSort] = useState();

  const [filter, setFilter] = useState({
    nameCzFilter: "",
    nameEnFilter: "",
    startDateFilterFrom: null,
    startDateFilterTo: null,
    endDateFilterFrom: null,
    endDateFilterTo: null,
    thesisTypeFilter: null,
    thesisStatusFilter: null,
    studentIdFilter: null,
    trainerIdFilter: null,
    consultantIdFilter: null,
    facultyIdFilter: null,
    councilIdFilter: null,
  });

  const sortFields = [
    { value: "nameCz", label: "CZ název" },
    { value: "nameEn", label: "EN název" },
    { value: "startDate", label: "Datum zaháhejí" },
    { value: "endDate", label: "Datum ukončení" },
    { value: "id", label: "ID" },
  ];

  const filterFields = [
    { name: "nameCzFilter", label: "Český název práce:", type: "text" },
    { name: "nameEnFilter", label: "Anglický název práce:", type: "text" },

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

    {
      name: "thesisTypeFilter",
      label: "Druh práce",
      type: "select",
      options: [
        { value: thesisType.BAKALARSKA, label: "Bakalářská" },
        { value: thesisType.DOKTORANDSKA, label: "Doktorandská" },
        { value: thesisType.INZENYRSKA, label: "Inženýrská" },
        { value: thesisType.MAGISTERSKA, label: "Magisterská" },
      ],
    },
    {
      name: "thesisStatusFilter",
      label: "Status",
      type: "select",
      options: [
        { value: thesisStatus.PROBIHAJICI, label: "Probíhající" },
        { value: thesisStatus.UKONCENA, label: "Ukončená" },
        { value: thesisStatus.PRERUSENA, label: "Přerušená" },
        { value: thesisStatus.PREDCASNE_UKONCENA, label: "Předčasně ukončená" },
      ],
    },

    {
      name: "studentIdFilter",
      label: "Student",
      type: "select",
      options: people,
    },

    {
      name: "trainerIdFilter",
      label: "Školitel",
      type: "select",
      options: people,
    },

    {
      name: "consultantIdFilter",
      label: "Konzultant",
      type: "select",
      options: people,
    },

    {
      name: "facultyIdFilter",
      label: "Fakulta",
      type: "select",
      options: faculty,
    },

    {
      name: "councilIdFilter",
      label: "Rada",
      type: "select",
      options: council,
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
      sort,
      ...filter,
    };

    apiGet(url, params)
      .then((data) => {
        setTheses(data.content);
        setTotalPages(data.totalPages);
      })
      .then(
        apiGet("/person/all").then((data) => {
          const mapped = data.map((person) => ({
            label: `${person.surname} ${person.firstName}`,
            id: person.id,
          }));
          setPeople(mapped);
        })
      )
      .then(
        apiGet("/faculty/all").then((data) => {
          const mapped = data.map((faculty) => ({
            label: `${faculty.facultyName}`,
            id: faculty.id,
          }));
          setFaculty(mapped);
        })
      )
      .then(
        apiGet("/council/all").then((data) => {
          const mapped = data.map((council) => ({
            label: `${council.councilName}`,
            id: council.id,
          }));
          setCouncil(mapped);
        })
      )
      .catch((error) => {
        toast.error(`Chyba: ${error.message}`);
        console.error(error.message);
      })
      .finally(() => setLoading(false));
  }, [url, page, totalPages, filter, size, sort]);

  useEffect(() => {
    apiGet("/thesis/count")
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
      <h1>Práce studentů</h1>

      <div className="d-flex justify-content-between">
        <p>Počet prací v databázi: {numberOfRecords}</p>
        <Link to="create" className="btn btn-md btn-success">
          Nová práce
        </Link>
      </div>

      <FilterForm onFilter={handleFilter} fields={filterFields} />

      <SortDropdown fields={sortFields} setSort={setSort} sort={sort} />

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
