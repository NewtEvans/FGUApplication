import { useState, useEffect } from "react";
import { useNavigate, useParams } from "react-router";
import { apiDelete, apiGet } from "../utils/api";

import { Link } from "react-router";

const ThesisDetail = () => {
  const navigate = useNavigate();
  const { id } = useParams();
  const [thesis, setThesis] = useState({});

  const deleteFunction = async (id) => {
    try {
      await apiDelete("/thesis/delete/" + id);
    } catch (error) {
      console.log(error.message);
      alert(error.message);
    }
    navigate("/theses");
  };

  useEffect(() => {
    apiGet("/thesis/detail/" + id)
      .then((data) => {
        setThesis(data);
      })
      .catch((error) => {
        console.log(error);
      });
  }, []);

  return (
    <div>
      <h1>
        Detail práce <em>({thesis.nameCz})</em>
      </h1>
      <hr />
      <p>
        <strong>ID:</strong> {thesis.id}
      </p>
      <p>
        <strong>Celé datum zahájení:</strong> {thesis.startDate}
      </p>
      <p>
        <strong>Český název:</strong> {thesis.nameCz}
      </p>
      <p>
        <strong>Anglický název:</strong> {thesis.nameEn}
      </p>
      <p>
        <strong>Student:</strong>{" "}
        <Link
          to={`/person/detail/${thesis.student?.id}`}
          className="link-dark link-underline-opacity-0 link-underline-opacity-100-hover"
        >
          {thesis.student?.name} {thesis.student?.surname}
        </Link>
      </p>
      <p>
        <strong>Školitel:</strong>{" "}
        <Link
          to={`/person/detail/${thesis.trainer?.id}`}
          className="link-dark link-underline-opacity-0 link-underline-opacity-100-hover"
        >
          {thesis.trainer?.name} {thesis.trainer?.surname}
        </Link>
      </p>
      <p>
        <strong>Konzultant:</strong>{" "}
        <Link
          to={`/person/detail/${thesis.trainer?.id}`}
          className="link-dark link-underline-opacity-0 link-underline-opacity-100-hover"
        >
          {thesis.consultant?.name} {thesis.consultant?.surname}
        </Link>
      </p>
      <p>
        <strong>Fakulta:</strong>{" "}
        <Link
          to={`/faculties/detail/${thesis.faculty?.id}`}
          className="link-dark link-underline-opacity-0 link-underline-opacity-100-hover"
        >
          {thesis.faculty?.facultyName}
        </Link>
      </p>
      <p>
        <strong>Rada:</strong>{" "}
        <Link
          to={`/counciles/detail/${thesis.council?.id}`}
          className="link-dark link-underline-opacity-0 link-underline-opacity-100-hover"
        >
          {thesis.council?.councilName}
        </Link>
      </p>
      <p>
        <strong>Celé datum ukončení:</strong> {thesis.endDate}
      </p>
      <p>
        <strong>Poznámka:</strong> {thesis.note}
      </p>
      <hr />
      <Link to={`/theses/edit/${id}`} className="btn btn-md btn-warning">
        Upravit práci
      </Link>
      <button
        className="btn btn-danger btn-md"
        onClick={() => deleteFunction(id)}
      >
        Smazat osobu
      </button>
    </div>
  );
};

export default ThesisDetail;
