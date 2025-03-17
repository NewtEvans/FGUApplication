import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router";
import { apiGet, apiPost, apiPut } from "../utils/api";

const PersonForm = () => {
  const navigate = useNavigate();
  const { id } = useParams();
  const [person, setPerson] = useState({
    titleBeforeName: "",
    name: "",
    surname: "",
    titleAfterName: "",
  });

  useEffect(() => {
    if (id) {
      apiGet("/people/" + id).then((data) => setPerson(data));
    }
  }, [id]);

  const handleSubmit = (e) => {
    e.preventDefault();
    (id ? apiPut("#") : apiPost("#"))
      .then((data) => {
        navigate("/people");
      })
      .catch((error) => {
        console.log(error.message);
      });
  };

  return (
    <div>
      <h1>{id ? "Upravit" : "Vytvořit"} osobu</h1>
      <hr />
    </div>
  );
};

export default PersonForm;
