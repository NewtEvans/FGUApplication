import { useEffect, useState } from "react";
import { useParams } from "react-router";
import { apiGet } from "../utils/api";
import { Link } from "react-router";

const CouncilDetail = () => {
  const { id } = useParams();
  const [council, setCouncil] = useState({});

  useEffect(() => {
    apiGet("/council/detail/" + id)
      .then((data) => {
        setCouncil(data);
      })
      .catch((error) => {
        console.log(error);
      });
  }, []);

  return (
    <div>
      <h1>Detail rady</h1>
      <hr />
      <p>
        <strong>Název rady:</strong> {council.councilName}
      </p>
      <p>
        <strong>Zkratka rady:</strong> {council.councilAbbreviation}
      </p>
      <p>
        <strong>Číslo rady:</strong> {council.councilNumber}
      </p>

      <Link to={`/counciles/edit/${id}`} className="btn btn-md btn-warning">
        Upravit radu
      </Link>
    </div>
  );
};

export default CouncilDetail;
