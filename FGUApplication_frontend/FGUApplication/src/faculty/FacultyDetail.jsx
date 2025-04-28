import { useEffect, useState } from "react";
import { Link, useParams } from "react-router";
import { apiGet, apiDelete } from "../utils/api";

const FacultyDetail = () => {
  const { id } = useParams();
  const [faculty, setFaculty] = useState();

  useEffect(() => {
    apiGet("/faculty/detail/" + id)
      .then((data) => {
        setFaculty(data);
      })
      .catch((error) => {
        console.log(error);
      });
  }, []);

  const deleteFunction = async (id) => {
    try {
      await apiDelete("/faculty/delete/" + id);
    } catch (error) {
      console.log(error.message);
      alert(error.message);
    }
    navigate("/faculty");
  };

  return (
    <div>
      <div className="d-flex align-items-center justify-content-between">
        <h1>Detail fakulty</h1>
        <div>
          <Link to={`/faculties/edit/${id}`} className="btn btn-md btn-warning">
            Upravit fakultu
          </Link>
          <button
            className="btn btn-danger btn-md"
            onClick={() => deleteFunction(id)}
          >
            Smazat fakultu
          </button>
        </div>
      </div>
      <hr />
      <p>
        <strong>Název fakulty:</strong> {faculty?.facultyName}
      </p>
      <p>
        <strong>Zkratka fakulty: </strong> {faculty?.facultyAbbreviation}
      </p>
      <p>
        <strong>Název školy: </strong> {faculty?.school}
      </p>
    </div>
  );
};

export default FacultyDetail;
