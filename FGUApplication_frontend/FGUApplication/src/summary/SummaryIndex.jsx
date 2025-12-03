import { useEffect, useState } from "react";
import { apiGet } from "../utils/api";
import { toast } from "react-toastify";
import LoadingSpinner from "../components/LoadingSpinner.jsx";

const SummaryIndex = () => {
  const [url, setUrl] = useState("/summary");
  const [data, setData] = useState([]);

  const [loading, setLoading] = useState(true);

  const [years, setYears] = useState([]);
  const [year, setYear] = useState(new Date().getFullYear());

  useEffect(() => {
    const params = {
      year,
    };

    apiGet("/thesis/years")
      .then((data) => setYears(data))
      .catch((error) => {
        toast.error(`Chyba: ${error.message}`);
        console.error(error.message);
      });

    apiGet(url, params)
      .then((data) => {
        setData(data);
      })
      .catch((error) => {
        toast.error(`Chyba: ${error.message}`);
        console.error(error.message);
      })
      .finally(() => {
        setLoading(false);
      });
  }, [url, year]);

  if (loading) {
    return <LoadingSpinner />;
  }

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
        <p>Počet rozpracovaných prací v roce {year}: </p>
        <p>
          Počet přerušených prací v roce {year}: {data.numberOfPausedTheses}
        </p>
        <p>
          Počet předčasně ukončených prací v roce {year}:{" "}
          {data.numberOfAbandonedTheses}
        </p>
      </div>
    </div>
  );
};

export default SummaryIndex;
