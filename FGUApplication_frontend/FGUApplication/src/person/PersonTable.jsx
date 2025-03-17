import ActionTable from "../utils/actionTable";
import { Link } from "react-router";

const PersonTable = ({ people }) => {
  return (
    <div>
      <div className="d-flex justify-content-between">
        <p>Počet osob v databázi: {people.length}</p>
        <button type="button" className="btn btn-md btn-success">
          Nová osoba
        </button>
      </div>
      <br />
      <table className="table table-bordered table-hover">
        <thead>
          <tr className="table-primary text-center">
            <th>#</th>
            <th>Titul</th>
            <th>Jméno</th>
            <th>Přijmení</th>
            <th>Titul</th>
          </tr>
        </thead>
        <tbody className="text-center">
          {people.map((person, index) => (
            <tr key={person.id}>
              <td>
                <Link
                  to="#"
                  className="d-block text-decoration-none text-dark p-3"
                >
                  {index + 1}
                </Link>
              </td>
              <td>
                <Link
                  to="#"
                  className="d-block text-decoration-none text-dark p-3"
                >
                  {person.titleBeforeName}
                </Link>
              </td>
              <td>
                <Link
                  to="#"
                  className="d-block text-decoration-none text-dark p-3"
                >
                  {person.name}
                </Link>
              </td>

              <td>
                <Link
                  to="#"
                  className="d-block text-decoration-none text-dark p-3"
                >
                  {person.surname}
                </Link>
              </td>
              <td>
                <Link
                  to="#"
                  className="d-block text-decoration-none text-dark p-3"
                >
                  {person.titleAfterName}
                </Link>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default PersonTable;
