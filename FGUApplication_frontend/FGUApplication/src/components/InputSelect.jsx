import Select from "react-select";

export function InputSelect({
  items, //vsechna data
  value, //aktualni vybrana hodnota
  onChange, //funkce, co se ma zavolat pri vyberu
  label,
  name,
  isMulti = false,
  placeHolder,
  showLabel = "name",
  showLabel2,
  isDisabled = false,
}) {
  const options = items.map((item) => ({
    value: item.id,
    label: showLabel2
      ? `${item[showLabel]} ${item[showLabel2]}`
      : item[showLabel],
  }));

  const selectedValue = isMulti
    ? options.filter((option) => value?.includes(option.value))
    : options.find((option) => option.value === value);

  return (
    <div className="form-group">
      <label>{label}</label>
      <Select
        isMulti={isMulti}
        name={name}
        placeholder={placeHolder}
        options={options}
        value={selectedValue}
        onChange={(selected) =>
          onChange(
            isMulti
              ? selected.map((option) => option.value)
              : selected?.value || null
          )
        }
        className="basic-single"
        classNamePrefix="select"
        isClearable={!isMulti}
        isDisabled={isDisabled}
      />
    </div>
  );
}

export default InputSelect;
