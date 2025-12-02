import { useState } from "react";
import DatePicker from "react-datepicker";
import { cs } from "date-fns/locale";

const InputDateField = ({ label, name, value, onChange }) => {
  const [date, setDate] = useState(value ? value : null);

  const handleChange = (change) => {
    setDate(change);

    onChange(name, change);
  };

  return (
    <div>
      <label>{label}:</label>
      <br />
      <DatePicker
        selected={date}
        isClearable
        placeholderText="Zadej datum"
        onChange={handleChange}
        locale={cs}
        dateFormat="dd.MM.yyyy"
        className="form-control"
      />
    </div>
  );
};

export default InputDateField;
