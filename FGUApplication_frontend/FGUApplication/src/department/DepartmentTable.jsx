import { Link } from "react-router";

const DepartmentTable = ({ departments }) => {
  return (
    <div>
      <table className="table table-bordered table-hover ">
        <thead>
          <tr className="table-primary text-center">
            <th>Číslo oddělení</th>
            <th className="col-10">Název oddělení</th>
          </tr>
        </thead>
        <tbody className="text-center">
          {departments.map((department) => (
            <tr key={department.id}>
              <td>
                <Link
                  to={`/departments/detail/${department.id}`}
                  className="d-block text-decoration-none text-dark p-3"
                >
                  {department.departmentNumber}
                </Link>
              </td>
              <td>
                <Link
                  to={`/departments/detail/${department.id}`}
                  className="d-block text-decoration-none text-dark p-3"
                >
                  {department.departmentName}
                </Link>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default DepartmentTable;
