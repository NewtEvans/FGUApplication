export default function FilterSelect({ name, label, options, register }) {
  return (
    <div className="mb-3">
      {label && <label htmlFor={name}>{label}</label>}
      <select id={name} {...register(name)} className="form-select">
        {options.map((opt) => (
          <option key={opt.value} value={opt.value}>
            {opt.label}
          </option>
        ))}
      </select>
    </div>
  );
}
