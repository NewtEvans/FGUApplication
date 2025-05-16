import { useEffect, useState } from "react";
import PersonTable from "./PersonTable";
import { apiGet } from "../utils/api";
import { Link } from "react-router-dom";

const PersonIndex = () => {
  /* const [url, setUrl] = useState("/person/all"); */
  const [url, setUrl] = useState("/person/people/test");
  const [people, setPeople] = useState([]);

  const [page, setPage] = useState(0);
  const [totalPages, setTotalPages] = useState();
  const [size, setSize] = useState(3);

  useEffect(() => {
    apiGet(url, {
      page: page,
      size: size,
      totalPages: totalPages,
    })
      .then((data) => {
        setPeople(data.content);
        setTotalPages(data.totalPages);
      })
      .catch((error) => {
        console.error(error);
      });
  }, [url, page, size]);

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
      <div className="d-flex justify-content-between">
        <button
          className="btn btn-primary btn-sm"
          disabled={page === 0}
          onClick={() => setPage(page - 1)}
        >
          Předchozí
        </button>
        <select
          id="pageSize"
          className="form-select w-auto d-inline-block"
          value={size}
          onChange={(e) => {
            setPage(0);
            setSize(parseInt(e.target.value));
          }}
        >
          <option value="5">5</option>
          <option value="25">25</option>
          <option value="50">50</option>
          <option value="100">100</option>
        </select>
        <button
          className="btn btn-primary btn-sm"
          disabled={page + 1 >= totalPages}
          onClick={() => setPage(page + 1)}
        >
          Další
        </button>
      </div>
    </div>
  );
};

export default PersonIndex;
