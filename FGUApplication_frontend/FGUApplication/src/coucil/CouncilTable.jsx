import { Link } from "react-router-dom";

const CouncilTable = ({ councils }) => {
  return (
    <div>
      <table className="table table-bordered table-hover ">
        <thead>
          <tr className="table-primary text-center">
            <th>Název rady</th>
            <th className="col-2">Zkratka rady</th>
            <th>Číslo rady</th>
          </tr>
        </thead>

        <tbody className="text-center">
          {councils.map((council) => (
            <tr key={council.id}>
              <td>
                <Link
                  to={`detail/${council.id}`}
                  className="d-block text-decoration-none text-dark p-3"
                >
                  {council.councilName}
                </Link>
              </td>

              <td>
                <Link
                  to={`detail/${council.id}`}
                  className="d-block text-decoration-none text-dark p-3"
                >
                  {council.councilAbbreviation}
                </Link>
              </td>

              <td>
                <Link
                  to={`detail/${council.id}`}
                  className="d-block text-decoration-none text-dark p-3"
                >
                  {council.councilNumber}
                </Link>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default CouncilTable;
