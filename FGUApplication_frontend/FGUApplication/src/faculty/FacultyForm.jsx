import { useState, useEffect } from "react";
import { useNavigate, useParams } from "react-router";
import { apiGet, apiPut, apiPost } from "../utils/api";

import InputField from "../components/InputField";

const FacultyForm = () => {
  const navigate = useNavigate();
  const { id } = useParams();
  const [faculty, setFaculty] = useState({
    facultyName: "",
    facultyAbbreviation: "",
  });

  useEffect(() => {
    if (id) {
      apiGet("/faculty/detail/" + id).then((data) => setFaculty(data));
    }
  }, [id]);

  const handleSubmit = (e) => {
    e.preventDefault();
    (id
      ? apiPut("/faculty/edit/" + id, faculty)
      : apiPost("/faculty/create", faculty)
    )
      .then((data) => {
        navigate("/faculty");
      })
      .catch((error) => {
        console.log(error.messagte);
      });
  };

  return (
    <div>
      <h1>{id ? "Upravit" : "Vytvořit"} fakultu</h1>
      <hr />
      <form onSubmit={handleSubmit}>
        <InputField
          required={false}
          type="text"
          name="facultyName"
          label="Název fakulty"
          prompt="Zadej název fakulty"
          value={faculty.facultyName}
          handleChange={(e) => {
            setFaculty({ ...faculty, facultyName: e.target.value });
          }}
        />
        <InputField
          required={false}
          type="text"
          name="facultyAbbreviation"
          label="Zkratka fakulty"
          prompt="Zadej zkratku fakulty"
          value={faculty.facultyAbbreviation}
          handleChange={(e) => {
            setFaculty({ ...faculty, facultyAbbreviation: e.target.value });
          }}
        />
        <br />
        <input type="submit" className="btn btn-success" value="Uložit" />
      </form>
    </div>
  );
};

export default FacultyForm;
