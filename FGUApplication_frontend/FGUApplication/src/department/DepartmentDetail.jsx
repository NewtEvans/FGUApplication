import { useEffect, useState } from "react";
import { useParams } from "react-router";
import { apiGet } from "../utils/api";
import { Link } from "react-router";

const DepartmentDetail = () => {
  const { id } = useParams();
  const [department, setDepartment] = useState({});

  useEffect(() => {
    apiGet("/department/detail/" + id)
      .then((data) => {
        setDepartment(data);
      })
      .catch((error) => {
        console.log(error);
      });
  }, []);

  return (
    <div>
      <h1>Detail oddělení</h1>
      <hr />
      <h2>{department.departmentName}</h2>

      <Link to={`/departments/edit/${id}`} className="btn btn-md btn-warning">
        Upravit oddělení
      </Link>
    </div>
  );
};
export default DepartmentDetail;
