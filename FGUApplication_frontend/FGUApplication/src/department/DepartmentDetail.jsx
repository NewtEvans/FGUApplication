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
      <div className="d-flex align-items-center justify-content-between">
        <h1>Detail oddělení</h1>
        <div>
          <Link
            to={`/departments/edit/${id}`}
            className="btn btn-md btn-warning"
          >
            Upravit oddělení
          </Link>
          <button
            className="btn btn-danger btn-md"
            onClick={() => deleteFunction(id)}
          >
            Smazat oddělení
          </button>
        </div>
      </div>
      <hr />
      <h2>
        <strong>
          {department.departmentName} (odd. {department.departmentNumber})
        </strong>
      </h2>

      <PersonTable people={people} />
    </div>
  );
};
export default DepartmentDetail;
