const PersonTable = ({ people }) => {
  return (
    <div>
      <table className="table table-bordered">
        <thead>
          <tr>
            <td>#</td>
            <td>Titul</td>
            <td>Jméno</td>
            <td>Přijmení</td>
            <td>Titul</td>
            <td>Oddělení FGÚ</td>
            <td>Akce</td>
          </tr>
        </thead>
        <tbody></tbody>
      </table>
    </div>
  );
};

export default PersonTable;
