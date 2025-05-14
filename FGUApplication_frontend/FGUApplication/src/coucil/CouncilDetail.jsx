import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import { apiGet, apiDelete } from "../utils/api";
import { Link } from "react-router-dom";

const CouncilDetail = () => {
  const navigate = useNavigate();
  const { id } = useParams();
  const [council, setCouncil] = useState({});

  useEffect(() => {
    apiGet("/council/" + id)
      .then((data) => {
        setCouncil(data);
      })
      .catch((error) => {
        console.log(error);
      });
  }, []);

  const deleteFunction = async (id) => {
    const confirmed = window.confirm("Opravdu chcete tuto radu smazat?");
    if (!confirmed) return;

    try {
      await apiDelete("/council/" + id);
      alert("Rada byla úspešně smazána.");
    } catch (error) {
      console.log(error.message);
      alert(error.message);
    }
    navigate("/counciles");
  };

  return (
    <div>
      <div className="d-flex align-items-center justify-content-between">
        <h1>Detail oborové rady</h1>
        <div>
          <Link
            to={`/counciles/edit/${id}`}
            className="btn btn-md btn-warning me-1"
          >
            Upravit radu
          </Link>
          <button
            className="btn btn-danger btn-md"
            onClick={() => deleteFunction(id)}
          >
            Smazat radu
          </button>
        </div>
      </div>
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
    </div>
  );
};

export default CouncilDetail;
