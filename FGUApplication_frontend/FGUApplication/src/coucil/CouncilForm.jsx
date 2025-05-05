import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router";
import { apiGet, apiPost, apiPut } from "../utils/api";
import InputField from "../components/InputField";

const CouncilForm = () => {
  const navigate = useNavigate();
  const { id } = useParams();
  const [council, setCouncil] = useState({
    councilName: "",
    councilAbbreviation: "",
    councilNumber: "",
  });

  useEffect(() => {
    if (id) {
      apiGet("/council/" + id).then((data) => setCouncil(data));
    }
  }, [id]);

  const handleSubmit = (e) => {
    e.preventDefault();
    (id ? apiPut("/council/" + id, council) : apiPost("/council", council))
      .then((data) => {
        navigate("/counciles");
      })
      .catch((error) => {
        console.log(error.message);
      });
  };

  return (
    <div>
      Council formulář
      <h1>{id ? "Upravit" : "Vytvořit"} radu</h1>
      <hr />
      <form onSubmit={handleSubmit}>
        <InputField
          required={true}
          type="text"
          name="councilName"
          label="Název rady"
          prompt="Zadej název rady"
          value={council.councilName}
          handleChange={(e) => {
            setCouncil({ ...council, councilName: e.target.value });
          }}
        />
        <InputField
          required={true}
          type="text"
          name="councileAbbreviation"
          label="Zkratka rady"
          prompt="Zadej zkratku rady"
          value={council.councilAbbreviation}
          handleChange={(e) => {
            setCouncil({ ...council, councilAbbreviation: e.target.value });
          }}
        />
        <InputField
          required={true}
          type="text"
          name="councilNumber"
          label="Číslo rady"
          prompt="Zadej číslo rady"
          value={council.councilNumber}
          handleChange={(e) => {
            setCouncil({ ...council, councilNumber: e.target.value });
          }}
        />
        <br />
        <input type="submit" className="btn btn-success" value="Uložit" />
      </form>
    </div>
  );
};

export default CouncilForm;
