import { useEffect, useState } from "react";
import { apiGet } from "../utils/api";
import { Link } from "react-router-dom";
import { Pagination } from "../components/Pagination";

import CouncilTable from "./CouncilTable";
import FilterForm from "../components/filter/FilterForm";

const CouncilIndex = () => {
  const [url, setUrl] = useState("/council/all");
  const [councils, setCounciles] = useState([]);
  const [numberOfRecords, setNumberOfRecords] = useState();
  const [loading, setLoading] = useState(true);

  const [page, setPage] = useState(0);
  const [totalPages, setTotalPages] = useState();
  const [size, setSize] = useState(10);

  const [filter, setFilter] = useState([]);

  const filterFields = [
    { name: "councilNameFilter", label: "Název rady", type: "text" },
    { name: "councilAbbreviation", label: "Zkratka rady", type: "text" },
    { name: "councilNumberFilter", label: "Číslo rady", type: "text" },
  ];

  const handleFilter = (filterData) => {
    setPage(0);
    setFilter({
      councilNameFilter: filterData.councilNameFilter,
      councilAbbreviationFilter: filterData.councilAbbreviationFilter,
      councilNumberFilter: filterData.councilNumberFilter,
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
        setCounciles(data.content);
        setTotalPages(data.totalPages);
      })
      .catch((error) => {
        toast.error(`Chyba: ${error.message}`);
        console.error(error.message);
      })
      .finally(() => setLoading(false));
  }, [url, page, filter, size]);

  useEffect(() => {
    apiGet("/council/count")
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
      <h1>Seznam všech oborových rad</h1>
      <div className="d-flex justify-content-between">
        <p>Počet oddělení v databázi: {numberOfRecords}</p>
        <Link to="create" className="btn btn-md btn-success">
          Nové rada
        </Link>
      </div>
      <FilterForm fields={filterFields} onFilter={handleFilter} />
      <br />
      <CouncilTable councils={councils} />
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

export default CouncilIndex;
