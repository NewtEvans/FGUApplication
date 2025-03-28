import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router";
import { apiGet, apiPost, apiPut } from "../utils/api";

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
      apiGet("/department/detail" + id).then((data) => setDepartment(data));
    }
  }, [id]);

  const handleSubmit = (e) => {
    e.preventDefault();
    (id
      ? apiPut("/department/edit" + id, department)
      : apiPost("/department/create", department)
    )
      .then((data) => {
        navigate("/department");
      })
      .catch((error) => {
        console.log(error.message);
      });
  };

  return (
    <div>
      <h1>{id ? "Upravit" : "Vytvořit"} oddělení</h1>
      <hr />
    </div>
  );
};

export default DepartmentForm;
