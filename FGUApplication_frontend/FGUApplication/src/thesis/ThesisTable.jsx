import { Link } from "react-router";

const ThesisTable = ({ theses }) => {
  return (
    <div>
      <div className="d-flex justify-content-between">
        <p>Počet prací v databázi: {theses.length}</p>
        <Link to="create" className="btn btn-md btn-success">
          Nová práce
        </Link>
      </div>
      <br />
      <table className="table table-bordered table-hover ">
        <thead>
          <tr className="table-primary text-center">
            <th>Student</th>
            <th>Druh</th>
            <th>Název</th>
            <th>Datum ukončení</th>
            <th>Oddělení</th>
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
                  to={`detail/${thesis.id}`}
                  className="d-block text-decoration-none text-dark p-3"
                >
                  {`${thesis.student?.name} ${thesis.student?.surname}`}
                </Link>
              </td>
              <td>
                <Link
                  to={`detail/${thesis.id}`}
                  className="d-block text-decoration-none text-dark p-3"
                >
                  {thesis.thesisType}
                </Link>
              </td>
              <td>
                <Link
                  to={`detail/${thesis.id}`}
                  className="d-block text-decoration-none text-dark p-3"
                >
                  {thesis.nameCz}
                </Link>
              </td>
              <td>
                <Link
                  to={`detail/${thesis.id}`}
                  className="d-block text-decoration-none text-dark p-3"
                >
                  {thesis.endDate ? thesis.endDate : "Studuje"}
                </Link>
              </td>
              <td>
                <Link
                  to={`detail/${thesis.id}`}
                  className="d-block text-decoration-none text-dark p-3"
                >
                  Oddělení
                </Link>
              </td>
              <td>
                <Link
                  to={`detail/${thesis.id}`}
                  className="d-block text-decoration-none text-dark p-3"
                >{`${thesis.trainer?.name} ${thesis.trainer?.surname}`}</Link>
              </td>
              <td>
                <Link
                  to={`detail/${thesis.id}`}
                  className="d-block text-decoration-none text-dark p-3"
                >{`${thesis.consultant?.name} ${thesis.consultant?.surname}`}</Link>
              </td>
              <td>
                <Link
                  to={`detail/${thesis.id}`}
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
