import { useEffect, useState } from "react";
import { apiGet } from "../utils/api";
import { toast } from "react-toastify";

const Summaryindex = () => {
  const [url, setUrl] = useState("/summary");
  const [data, setData] = useState([]);

  const [years, setYears] = useState([]);
  const [year, setYear] = useState(new Date().getFullYear());

  useEffect(() => {
    const params = {
      year,
    };

    apiGet("/thesis/years").then((data) => setYears(data));

    apiGet(url, params)
      .then((data) => {
        setData(data);
      })
      .catch((error) => {
        toast.error(`Chyba: ${error.message}`);
        console.error(error.message);
      });
  }, [url, year]);

  return (
    <div>
      <select value={year} onChange={(e) => setYear(e.target.value)}>
        {years.map((year) => (
          <option key={year} value={year}>
            {year}
          </option>
        ))}
      </select>

      <h1>Výpis statistik za rok: {year}</h1>

      <br />
      <div>
        <p>Počet absolventů v tomto roce: {data.numberOfEndedTheses}</p>
        <p>- bakalářská: {data.endedBakalarska}</p>
        <p>- magisterské: {data.endedMagisterska}</p>
        <p>- doktorandská: {data.endedDoktorandska}</p>
        <p>- inženýrská: {data.endedInzenyrska}</p>
      </div>
      <div>
        <p>Počet nově přijatých prací v roce: {data.numberOfNewTheses}</p>
        <p>- bakalářská: {data.newBakalarska}</p>
        <p>- magisterské: {data.newMagisterska}</p>
        <p>- doktorandská: {data.newDoktorandska}</p>
        <p>- inženýrská: {data.newInzenyrska}</p>
      </div>
      <div>
        <p>Počet probíhajících prací: </p>
        <p>- bakalářská: {}</p>
        <p>- magisterské: {}</p>
        <p>- doktorandská: {}</p>
        <p>- inženýrská: {}</p>
      </div>
    </div>
  );
};

export default Summaryindex;
