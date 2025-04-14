import { useState } from "react";
import InputSelect from "../components/InputSelect";

const TestComponent = () => {
  const [oddeleni, setOddeleni] = useState([
    { name: "ahoj" },
    { name: "ahoj2" },
    { name: "Ahoj3" },
  ]);

  const [item, setItem] = useState({
    department: "",
  });

  return (
    <div>
      <h1>TestComponent</h1>
      <hr />
      <InputSelect
        name="departments"
        items={oddeleni}
        label="Oddělení"
        prompt="Vyber oddělení"
        showLable="name"
        value={item.department}
        handleChange={(e) => {
          setItem({ ...item, department: { id: e.target.value } });
        }}
      />

      <p>{item.department}</p>
    </div>
  );
};

export default TestComponent;
