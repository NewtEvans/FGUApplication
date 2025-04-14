import { useEffect, useState } from "react";
import { useParams } from "react-router";
import { apiGet } from "../utils/api";
import { Link } from "react-router";
import PersonTable from "../person/PersonTable";

const DepartmentDetail = () => {
  const { id } = useParams();
  const [department, setDepartment] = useState({});
  const [people, setPeople] = useState([]);

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
    </div>
  );
};
export default DepartmentDetail;
