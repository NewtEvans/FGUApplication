import FilterField from "./FilterField";
import FilterCheckBoxField from "./FilterCheckBoxField";
import {useForm} from "react-hook-form";
import FilterSelect from "./FilterSelect";
import {endOfYear, format, startOfYear} from "date-fns";
import DatePicker from "react-datepicker";
import {useState} from "react";
import FilterDateField from "./FilterDateField.jsx";

const FilterForm = ({onFilter, fields}) => {
    const {register, handleSubmit, reset} = useForm();
    const [date, setDate] = useState()

    const onSubmit = (data) => {
        if (data.isArchived) {
            data.siArchived = "";
        }
        onFilter(data);
    };

    const handleReset = () => {
        reset();
        onFilter({});
    };

    function praceSDatumem(date, setDate) {

        const handleChange = (date) => {
            setDate(date);

            const startDateFormatted = format(startOfYear(date), "yyyy-MM-dd");
            const endDateFormatted = format(endOfYear(date), "yyyy-MM-dd");

        }

        return (
            <DatePicker
                selected={date}
                onChange={handleChange}
                showYearPicker
                dateFormat="yyyy"
                placeholderText="Vyber rok"
            />
        )
    }

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
                                // praceSDatumem(date, setDate)

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
