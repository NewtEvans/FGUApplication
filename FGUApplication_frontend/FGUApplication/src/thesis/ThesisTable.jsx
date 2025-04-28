import { Link } from "react-router";

const ThesisTable = ({ theses }) => {
  return (
    <div>
      <br />
      <table className="table table-bordered table-hover ">
        <thead>
          <tr className="table-primary text-center">
            <th>Název práce</th>
            <th>Druh</th>
            <th>Student</th>
            <th>Datum ukončení</th>
            <th>Školitel</th>
            <th>Konzultant</th>
            <th>Poznámka</th>
          </tr>
        </thead>
        <tbody className="text-center">
          {theses.map((thesis) => (
            <tr key={thesis.id}>
              <td>
                <Link
                  to={`/theses/detail/${thesis.id}`}
                  className="d-block text-decoration-none text-dark p-3"
                >
                  {thesis.nameCz}
                </Link>
              </td>
              <td>
                <Link
                  to={`/theses/detail/${thesis.id}`}
                  className="d-block text-decoration-none text-dark p-3"
                >
                  {thesis.thesisType}
                </Link>
              </td>
              <td>
                <Link
                  to={`/theses/detail/${thesis.id}`}
                  className="d-block text-decoration-none text-dark p-3"
                >
                  {`${thesis.student?.name} ${thesis.student?.surname}`}
                </Link>
              </td>
              <td>
                <Link
                  to={`/theses/detail/${thesis.id}`}
                  className="d-block text-decoration-none text-dark p-3"
                >
                  {thesis.endDate ? thesis.endDate : "Studuje"}
                </Link>
              </td>
              <td>
                <Link
                  to={`/theses/detail/${thesis.id}`}
                  className="d-block text-decoration-none text-dark p-3"
                >{`${thesis.trainer?.name} ${thesis.trainer?.surname}`}</Link>
              </td>
              <td>
                <Link
                  to={`/theses/detail/${thesis.id}`}
                  className="d-block text-decoration-none text-dark p-3"
                >{`${thesis.consultant?.name} ${thesis.consultant?.surname}`}</Link>
              </td>
              <td>
                <Link
                  to={`/theses/detail/${thesis.id}`}
                  className="d-block text-decoration-none text-dark p-3"
                >
                  {thesis.note}
                </Link>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default ThesisTable;
