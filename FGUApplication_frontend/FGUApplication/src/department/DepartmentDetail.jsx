import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router";
import { apiGet, apiDelete } from "../utils/api";
import { Link } from "react-router";
import PersonTable from "../person/PersonTable";
import { toast } from "react-toastify";

const DepartmentDetail = () => {
  const navigate = useNavigate();
  const { id } = useParams();
  const [department, setDepartment] = useState({});
  const [people, setPeople] = useState([]);

  const [loading, setLoading] = useState(true);

  const deleteFunction = async (id) => {
    const confirmed = window.confirm("Opravdu chcete smazat toto oddělení?");
    if (!confirmed) return;

    try {
      await apiDelete("/department/" + id);
      toast.success("Oddělení bylo smazáno.");
    } catch (error) {
      toast.error(`Chyba: ${error.message}`);
      console.log(error.message);
    }
    navigate("/departments");
  };

  useEffect(() => {
    apiGet("/department/" + id)
      .then((data) => {
        setDepartment(data);
      })
      .catch((error) => {
        toast.error(`Chyba: ${error.message}`);
        console.error(error.message);
      });

    apiGet("/person/department/" + id)
      .then((data) => {
        setPeople(data);
      })
      .catch((error) => {
        toast.error(`Chyba: ${error.message}`);
        console.error(error.message);
      })
      .finally(() => setLoading(false));
  }, [id]);

  if (loading) {
    return (
      <div className="text-center mt-5">
        <div className="spinner-border text-primary" />
      </div>
    );
  }

  return (
    <div>
      <div className="d-flex align-items-center justify-content-between">
        <h1>Detail oddělení</h1>
        <div>
          <Link
            to={`/departments/edit/${id}`}
            className="btn btn-md btn-warning me-1"
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
