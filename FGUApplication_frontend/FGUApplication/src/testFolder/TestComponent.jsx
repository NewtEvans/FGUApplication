import { useEffect, useState } from "react";
import { apiGet } from "../utils/api";
import InputSelect from "../components/InputSelect";

import Select from "react-select";
import AsyncSelect from "react-select/async";

const TestComponent = () => {
  const options = [
    { value: "chocolate", label: "Chocolate" },
    { value: "vanilla", label: "Vanilla" },
    { value: "strawberry", label: "Strawberry" },
  ];

  const [departments, setDepartments] = useState([]);

  useEffect(() => {
    apiGet("/department/all").then((data) => {
      const mapped = data.map((department) => ({
        label: `${department.departmentName} - ${department.departmentNumber}`,
        value: department.id,
      }));
      setDepartments(mapped);
      console.log("done");
      console.log(mapped);
    });
  }, []);

  const handleChange = (selectedOption) => {
    console.log("handleChange", selectedOption);
  };

  const loadOption = (serachValue, callback) => {
    setTimeout(() => {}, 2000);
  };

  const SelectOptoin = () => (
    <Select options={departments} onChange={handleChange} />
  );

  const ApiOption = () => (
    <AsyncSelect loadOptions={loadOption} onChange={handleChange} />
  );

  return (
    <div>
      <SelectOptoin />
    </div>
  );
};

/* const TestComponent = () => {
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
        value={item.department}
        handleChange={(e) => {
          setItem({ ...item, department: { name: e.target.value } });
        }}
      />
    </div>
  );
}; */

export default TestComponent;
