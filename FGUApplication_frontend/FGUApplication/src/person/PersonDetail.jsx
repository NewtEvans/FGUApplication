import { useEffect, useState } from "react";
import { useParams } from "react-router";
import { apiGet } from "../utils/api";

const PersonDetail = () => {
  const { id } = useParams();
  const [person, setPerson] = useState({});

  useEffect(() => {
    apiGet("/people/" + id)
      .then((data) => {
        setPerson(data);
      })
      .catch(
        (error) => {
          console.log(error);
        },
        [id]
      );
  });

  return (
    <div>
      <h1>Detail osoby</h1>
      <hr />
      <h2>{/* {{person.name} {person.surname}} */}</h2>
    </div>
  );
};

export default PersonDetail;
