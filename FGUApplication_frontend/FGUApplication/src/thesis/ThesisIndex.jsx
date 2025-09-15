import { useEffect, useState } from "react";
import ThesisTable from "./ThesisTable";
import { apiGet } from "../utils/api";
import { Link } from "react-router";
import { Pagination } from "../components/Pagination";
import FilterForm from "../components/filter/FilterForm";
import SortDropdown from "../components/SortDropdown";
import { toast } from "react-toastify";
import thesisType from "./ThesisType";

const ThesisIndex = () => {
  const [url, setUrl] = useState("/thesis/all");
  const [theses, setTheses] = useState([]);
  const [numberOfRecords, setNumberOfRecords] = useState();
  const [loading, setLoading] = useState(true);
  const [people, setPeople] = useState([]);
  const [faculty, setFaculty] = useState([]);
  const [council, setCouncil] = useState([]);

  const [page, setPage] = useState(0);
  const [totalPages, setTotalPages] = useState();
  const [size, setSize] = useState(10);

  const [sort, setSort] = useState();
  const sortFields = [
    { value: "nameCz", label: "CZ název" },
    { value: "nameEn", label: "EN název" },
    { value: "startDate", label: "Datum zaháhejí" },
    { value: "endDate", label: "Datum ukončení" },
    { value: "id", label: "ID" },
  ];

  const [filter, setFilter] = useState([]);
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

    /* {
      name: "facultyIdFilter",
      label: "Fakulta",
      type: "select",
      options: people,
    }, */

    /* {
      name: "councilIdFilter",
      label: "Rada",
      type: "select",
      options: people,
    }, */
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
        apiGet("/person/all/names").then((data) => {
          const mapped = data.map((person) => ({
            label: `${person.surname} ${person.firstName}`,
            id: person.id,
          }));
          setPeople(mapped);
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
    return (
      <div className="text-center mt-5">
        <div className="spinner-border text-primary" />
      </div>
    );
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
