import { useEffect, useState } from "react";
import { apiGet } from "../utils/api";
import { Link } from "react-router-dom";
import { Pagination } from "../components/Pagination";
import { toast } from "react-toastify";
import CouncilTable from "./CouncilTable";
import FilterForm from "../components/filter/FilterForm";
import LoadingSpinner from "../components/LoadingSpinner.jsx";

const CouncilIndex = () => {
  const [url, setUrl] = useState("/council/all/pageable");
  const [councils, setCounciles] = useState([]);
  const [loading, setLoading] = useState(true);
  const [numberOfRecords, setNumberOfRecords] = useState();
  const [page, setPage] = useState(0);
  const [totalPages, setTotalPages] = useState();
  const [size, setSize] = useState(10);
  const [filter, setFilter] = useState({
    councilNameFilter: "",
    councilAbbreviationFilter: "",
    councilNumberFilter: "",
  });

  const filterFields = [
    { name: "councilNameFilter", label: "Název rady", type: "text" },
    { name: "councilAbbreviationFilter", label: "Zkratka rady", type: "text" },
    { name: "councilNumberFilter", label: "Číslo rady", type: "text" },
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
        setCounciles(data.content || []);
        setTotalPages(data.totalPages || 0);
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
    return <LoadingSpinner />;
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
        currentPage={page}
        setPage={setPage}
        totalPages={totalPages}
        size={size}
        setSize={setSize}
      />
    </div>
  );
};

export default CouncilIndex;
