import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router";
import { apiGet, apiPost, apiPut } from "../utils/api";

import InputField from "../components/InputField";

const DepartmentForm = () => {
  const navigate = useNavigate();
  const { id } = useParams();
  const [department, setDepartment] = useState({
    departmentName: "",
    departmentId: "",
    people: [{}],
  });

  useEffect(() => {
    if (id) {
      apiGet("/department/detail/" + id).then((data) => setDepartment(data));
    }
  }, [id]);

  const handleSubmit = (e) => {
    e.preventDefault();
    (id
      ? apiPut("/department/edit/" + id, department)
      : apiPost("/department/create", department)
    )
      .then((data) => {
        navigate("/departments");
      })
      .catch((error) => {
        console.log(error.message);
      });
  };

  return (
    <div>
      <h1>{id ? "Upravit" : "Vytvořit"} oddělení</h1>
      <hr />
      <form onSubmit={handleSubmit}>
        <InputField
          required={true}
          type="text"
          name="departmentName"
          label="Název oddělení"
          prompt="Zadej název oddělení"
          value={department.departmentName}
          handleChange={(e) => {
            setDepartment({ ...department, departmentName: e.target.value });
          }}
        />
        <InputField
          required={true}
          type="text"
          name="departmentNumber"
          label="Číslo oddělení"
          prompt="Zadej číslo oddělení"
          value={department.departmentNumber}
          handleChange={(e) => {
            setDepartment({ ...department, departmentNumber: e.target.value });
          }}
        />
        <br />
        <input type="submit" className="btn btn-success" value="Uložit" />
      </form>
    </div>
  );
};

export default DepartmentForm;
