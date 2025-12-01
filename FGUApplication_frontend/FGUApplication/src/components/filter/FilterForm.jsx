import FilterField from "./FilterField";
import FilterCheckBoxField from "./FilterCheckBoxField";
import { useForm } from "react-hook-form";
import FilterSelect from "./FilterSelect";
import FilterDateField from "./FilterDateField.jsx";
import FilterFields from "./FilterFields.jsx";

const FilterForm = ({ onFilter, fields }) => {
  const { register, handleSubmit, reset, setValue } = useForm();

  const onSubmit = (data) => {
    if (data.isArchived) {
      data.siArchived = "";
    }
    onFilter(data);
  }; //Spusti handleFilter z Indexu -> cili co se ma stat po kliknuti na tlacitko submit

  const handleReset = () => {
    reset();
    onFilter({});
  };

  return (
    <div>
      <form onSubmit={handleSubmit(onSubmit)}>
        <FilterFields fields={fields} register={register} setValue={setValue} />

        <div className="d-flex justify-content-end gap-2 mt-2 mb-2">
          <button type="submit" className="btn btn-primary">
            Filtrovat
          </button>
          <button onClick={handleReset} className="btn btn-danger">
            Reset
          </button>
        </div>
      </form>
    </div>
  );
};
export default FilterForm;
