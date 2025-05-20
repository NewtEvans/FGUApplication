import { useEffect, useState } from "react";
import { apiGet } from "../utils/api";
import { Link } from "react-router-dom";
import { Pagination } from "../components/Pagination";

import CouncilTable from "./CouncilTable";

const CouncilIndex = () => {
  const [councils, setCounciles] = useState([]);
  const [url, setUrl] = useState("/council/all");

  const [page, setPage] = useState(0);
  const [totalPages, setTotalPages] = useState();
  const [size, setSize] = useState(10);

  useEffect(() => {
    apiGet(url, {
      page: page,
      totalPages: totalPages,
      size: size,
    })
      .then((data) => {
        setCounciles(data.content);
        setTotalPages(data.totalPages);
      })
      .catch((error) => {
        console.error(error);
      });
  }, [url, page, totalPages, size]);

  return (
    <div>
      <h1>Seznam všech oborových rad</h1>
      <div className="d-flex justify-content-between">
        <p>Počet oddělení v databázi: {councils.length}</p>
        <Link to="create" className="btn btn-md btn-success">
          Nové rada
        </Link>
      </div>
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
