import { Link } from "react-router-dom";

const PersonTable = ({ people }) => {
  return (
    <div>
      <table className="table table-bordered table-hover rounded-top">
        <thead>
          <tr className="table-primary text-center">
            <th>Titul</th>
            <th>Jméno</th>
            <th>Přijmení</th>
            <th>Titul</th>
          </tr>
        </thead>
        <tbody className="text-center">
          {people.map((person) => (
            <tr key={person.id}>
              <td>
                <Link
                  to={`/person/detail/${person.id}`}
                  className="d-block text-decoration-none text-dark p-3"
                >
                  {person.titleBeforeName}
                </Link>
              </td>
              <td>
                <Link
                  to={`/person/detail/${person.id}`}
                  className="d-block text-decoration-none text-dark p-3"
                >
                  {person.firstName}
                </Link>
              </td>

              <td>
                <Link
                  to={`/person/detail/${person.id}`}
                  className="d-block text-decoration-none text-dark p-3"
                >
                  {person.surname}
                </Link>
              </td>
              <td>
                <Link
                  to={`/person/detail/${person.id}`}
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
