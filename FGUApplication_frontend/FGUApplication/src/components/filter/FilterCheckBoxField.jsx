const FilterCheckBoxField = ({ name, label, register }) => {
  return (
    <div>
      <input
        type="checkbox"
        className="form-check-input"
        id={name}
        {...register(name)}
      />
      <label htmlFor={name} className="form-check-label">
        {label}
      </label>
    </div>
  );
};

export default FilterCheckBoxField;
