import { useEffect, useState } from "react";
import { apiGet } from "../utils/api";
import { toast } from "react-toastify";

const Summaryindex = () => {
  const [url, setUrl] = useState("/summary");
  const [data, setData] = useState([]);

  useEffect(() => {
    apiGet(url)
      .then((data) => {
        setData(data);
      })
      .catch((error) => {
        toast.error(`Chyba: ${error.message}`);
        console.error(error.message);
      });
  }, [url]);

  return (
    <div>
      <div>
        <p>Počet absolventů v tomto roce: </p>
        <p>- bakalářská: </p>
        <p>- magisterské: </p>
        <p>- doktorandská: </p>
        <p>- inženýrská: </p>
      </div>
      <div>
        <p>Počet nově přijatých prací v roce:</p>
        <p>- bakalářská: </p>
        <p>- magisterské: </p>
        <p>- doktorandská: </p>
        <p>- inženýrská: </p>
      </div>
    </div>
  );
};

export default Summaryindex;
