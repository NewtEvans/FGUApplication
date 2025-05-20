import { useEffect, useState } from "react";
import PersonTable from "./PersonTable";
import { apiGet } from "../utils/api";
import { Link } from "react-router-dom";
import { pageUI } from "../components/Pagination";

const PersonIndex = () => {
  const [url, setUrl] = useState("/person/all");
  const [people, setPeople] = useState([]);

  const [page, setPage] = useState(0);
  const [totalPages, setTotalPages] = useState();
  const [size, setSize] = useState(10);
  const [sort, setSort] = useState("surname");

  useEffect(() => {
    apiGet(url, {
      page: page,
      size: size,
      totalPages: totalPages,
      sort: sort,
    })
      .then((data) => {
        setPeople(data.content);
        setTotalPages(data.totalPages);
      })
      .catch((error) => {
        console.error(error);
      });
  }, [url, page, size, totalPages]);

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
      <PersonTable people={people} />
      {pageUI({ page, setPage, totalPages, size, setSize })}
    </div>
  );
};

export default PersonIndex;
