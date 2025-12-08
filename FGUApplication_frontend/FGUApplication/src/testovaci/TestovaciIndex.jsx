import { useEffect, useState } from "react";
import { apiGet } from "../utils/api";
import { tr } from "date-fns/locale";

const TestovaciIndex = () => {
  const [people, setPeople] = useState([]);
  const [loading, setLoading] = useState(true);

  const tableData = [
    { rank: 1, name: "Domenic", points: 88.11, team: "dcode" },
    { rank: 2, name: "Sally", points: 72.11, team: "Students" },
    { rank: 3, name: "Nic", points: 52.11, team: "dcode" },
  ];

  useEffect(() => {
    apiGet("/person/all").then((data) => {
      setPeople(data);
      setLoading(false);
    });
  }, []);

  if (loading) return <p>Nacitam...</p>;

  return (
    <div>
      <table className="table my-custom-table">
        <thead>
          <tr>
            <th>Jmeno</th>
            <th>Prijmeni</th>
          </tr>
        </thead>
        <tbody>
          {people.slice(0, 5).map((person) => (
            <tr key={person.id}>
              <td>{person.firstName}</td>
              <td>{person.surname}</td>
            </tr>
          ))}
        </tbody>
      </table>

      <div className="row py-5">
        <div className="col-lg-10 mx-auto">
          <div className="card rounded shadow border-0">
            <div className="card-body p-5 bg-white rounded">
              <div className="table-seponsive">
                <table
                  id="example"
                  className="table table-striped table-bordered"
                >
                  <thead>
                    <tr>
                      <th>Rank</th>
                      <th>Name</th>
                      <th>Points</th>
                      <th>Team</th>
                    </tr>
                  </thead>
                  <tbody>
                    {tableData.map((row) => (
                      <tr key={row.rank}>
                        <td>{row.rank}</td>
                        <td>{row.name}</td>
                        <td>{row.points}</td>
                        <td>{row.team}</td>
                      </tr>
                    ))}
                  </tbody>
                </table>
              </div>
            </div>
          </div>
        </div>
      </div>

      <button className="btn btn-warning">Warning</button>
    </div>
  );
};
export default TestovaciIndex;
