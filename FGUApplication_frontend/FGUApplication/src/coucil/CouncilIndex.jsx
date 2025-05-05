import { useEffect, useState } from "react";
import { apiGet } from "../utils/api";
import { Link } from "react-router-dom";

import CouncilTable from "./CouncilTable";

const CouncilIndex = () => {
  const [councils, setCounciles] = useState([]);
  const [url, setUrl] = useState("/council/all");

  useEffect(() => {
    apiGet(url)
      .then((data) => setCounciles(data))
      .catch((error) => {
        console.error("Error during loading councils ", error);
      });
  }, [url]);

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
    </div>
  );
};

export default CouncilIndex;
