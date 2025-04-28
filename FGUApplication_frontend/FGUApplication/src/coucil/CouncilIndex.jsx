import { useEffect, useState } from "react";
import { apiGet } from "../utils/api";
import { Link } from "react-router";

import CouncilTable from "./CouncilTable";

const CouncilIndex = () => {
  const [counciles, setCounciles] = useState([]);
  const [url, setUrl] = useState("/council/all");

  useEffect(() => {
    apiGet(url).then((data) => setCounciles(data));
  }, []);

  return (
    <div>
      <h1>Seznam všeh oborových rad</h1>
      <div className="d-flex justify-content-between">
        <p>Počet oddělení v databázi: {counciles.length}</p>
        <Link to="create" className="btn btn-md btn-success">
          Nové rada
        </Link>
      </div>
      <br />
      <CouncilTable counciles={counciles} />
    </div>
  );
};

export default CouncilIndex;
