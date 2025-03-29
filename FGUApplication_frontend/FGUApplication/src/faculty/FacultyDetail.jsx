import { useEffect, useState } from "react";
import { Link, useParams } from "react-router";
import { apiGet } from "../utils/api";

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

  return (
    <div>
      <h1>Detail faculty</h1>
      <hr />
      <p>
        <strong>Název fakulty:</strong> {faculty?.facultyName}
      </p>
      <p>
        <strong>Zkratka fakulty: </strong> {faculty?.facultyAbbreviation}
      </p>
      <Link to={`/faculties/edit/${id}`} className="btn btn-md btn-warning">
        Upravit fakultu
      </Link>
    </div>
  );
};

export default FacultyDetail;
