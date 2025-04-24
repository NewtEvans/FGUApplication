import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router";
import { apiGet, apiDelete } from "../utils/api";
import { Link } from "react-router";
import PersonTable from "../person/PersonTable";

const DepartmentDetail = () => {
  const navigate = useNavigate();
  const { id } = useParams();
  const [department, setDepartment] = useState({});
  const [people, setPeople] = useState([]);

  const deleteFunction = async (id) => {
    try {
      await apiDelete("/department/delete/" + id);
    } catch (error) {
      console.log(error.message);
      alert(error.message);
    }
    navigate("/departments");
  };

  useEffect(() => {
    apiGet("/department/detail/" + id)
      .then((data) => {
        setDepartment(data);
      })
      .catch((error) => {
        console.log(error);
      });
    apiGet("/person/info/" + id)
      .then((data) => {
        setPeople(data);
      })
      .catch((error) => {
        console.log(error);
      });
  }, []);

  return (
    <div>
      <h1>Detail oddělení</h1>
      <hr />
      <h2>
        {department.departmentName} (odd. {department.departmentNumber})
      </h2>

      <PersonTable people={people} />

      <Link to={`/departments/edit/${id}`} className="btn btn-md btn-warning">
        Upravit oddělení
      </Link>
      <button
        className="btn btn-danger btn-md"
        onClick={() => deleteFunction(id)}
      >
        Smazat oddělení
      </button>
    </div>
  );
};
export default DepartmentDetail;
