import { useEffect, useState } from "react";
import { useParams } from "react-router";
import { apiGet, apiDelete } from "../utils/api";
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

  const deleteFunction = async (id) => {
    try {
      await apiDelete("/council/delete/" + id);
    } catch (error) {
      console.log(error.message);
      alert(error.message);
    }
    navigate("/council");
  };

  return (
    <div>
      <div className="d-flex align-items-center justify-content-between">
        <h1>Detail oborové rady</h1>
        <div>
          <Link to={`/counciles/edit/${id}`} className="btn btn-md btn-warning">
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
