import FilterDateField from "./FilterDateField";
import FilterField from "./FilterField";
import FilterCheckBoxField from "./FilterCheckBoxField";
import { useForm } from "react-hook-form";

const FilterForm = ({ onFilter, fields }) => {
  const { register, handleSubmit, reset } = useForm();

  const onSubmit = (data) => {
    onFilter(data);
  };

  const handleReset = () => {
    reset();
    onFilter({});
  };

  return (
    <div>
      <form onSubmit={handleSubmit(onSubmit)}>
        <div className="d-flex fustify-content-between gap-3">
          {fields.map((field) => {
            if (field.type === "date-range") {
              return (
                <FilterDateField
                  key={field.nameFrom + field.nameTo}
                  label={field.label}
                  nameFrom={field.nameFrom}
                  nameTo={field.nameTo}
                  register={register}
                />
              );
            }
            if (field.type === "checkbox") {
              return (
                <FilterCheckBoxField
                  key={field.name}
                  name={field.name}
                  label={field.label}
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

        <button type="submit" className="btn btn-primary btn-md">
          Filtrovat
        </button>
        <button onClick={handleReset} className="btn btn-danger btn-md">
          Reset
        </button>
      </form>
    </div>
  );
};
export default FilterForm;
