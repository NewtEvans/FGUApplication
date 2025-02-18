const PersonTable = ({ people }) => {
  return (
    <div>
      <table className="table table-boarded">
        <thead>
          <tr>
            <td>#</td>
            <td>Titul</td>
            <td>Jméno</td>
            <td>Přijmení</td>
            <td>Titul</td>
            <td>Oddělení</td>
            <td>Akce</td>
          </tr>
        </thead>
        <tbody></tbody>
      </table>
    </div>
  );
};

export default PersonTable;
