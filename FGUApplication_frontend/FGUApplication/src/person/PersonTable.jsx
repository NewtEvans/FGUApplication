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
        <tbody>
          {people.map((person, index) => (
            <tr key={person.id}>
              <td>{index + 1}</td>
              <td>{person.titleBeforeName}</td>
              <td>{person.name}</td>
              <td>{person.surname}</td>
              <td>{person.titleAfterName}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default PersonTable;
