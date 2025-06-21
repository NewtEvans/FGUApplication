const FilterCheckBoxField = ({ name, label, register, value }) => {
  return (
    <div>
      <input
        type="checkbox"
        className="form-check-input"
        value={value}
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
