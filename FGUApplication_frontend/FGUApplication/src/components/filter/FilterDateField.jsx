import { useFormContext } from "react-hook-form";

const FilterDateField = ({ label, nameFrom, nameTo, register }) => {
  return (
    <div className="mb-3">
      <label className="form-label">{label}</label>
      <input type="date" className="form-control" {...register(nameFrom)} />
      <input type="date" className="form-control" {...register(nameTo)} />
    </div>
  );
};

export default FilterDateField;
