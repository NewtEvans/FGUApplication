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
              <td>{`${thesis.student?.name} ${thesis.student?.surname}`}</td>
              <td>{thesis.thesisType}</td>
              <td>{thesis.nameCz}</td>
              <td>{thesis.endDate}</td>
              <td>Oddělení</td>
              <td>{`${thesis.trainer?.name} ${thesis.trainer?.surname}`}</td>
              <td>{`${thesis.consultant?.name} ${thesis.consultant?.surname}`}</td>
              <td>{thesis.note}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default ThesisTable;
