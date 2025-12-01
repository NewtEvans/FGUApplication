import FilterField from "./FilterField";
import FilterDateField from "./FilterDateField";
import FilterCheckBoxField from "./FilterCheckBoxField";
import FilterSelect from "./FilterSelect";

const FilterFields = ({ fields, setValue, register }) => {
  return (
    <div>
      <div className="d-flex fustify-content-between gap-3">
        {fields.map((field) => {
          if (field.type === "date-range") {
            return (
              <FilterDateField
                key={field.nameFrom + field.nameTo}
                label={field.label}
                nameFrom={field.nameFrom}
                nameTo={field.nameTo}
                setValue={setValue}
              />
            );
          }
          if (field.type === "checkbox") {
            return (
              <FilterCheckBoxField
                key={field.name}
                name={field.name}
                label={field.label}
                value={field.value}
                register={register}
              />
            );
          }
          if (field.type === "select") {
            return (
              <FilterSelect
                key={field.name}
                label={field.label}
                name={field.name}
                options={field.options}
                register={register}
              />
            );
          }

          return (
            <FilterField
              key={field.name}
              name={field.name}
              label={field.label}
              type={field.type}
              register={register}
            />
          );
        })}
      </div>
    </div>
  );
};

export default FilterFields;
