import DatePicker from "react-datepicker";
import {useState} from "react";
import {endOfYear, format, startOfYear} from "date-fns";

const FilterDateField = ({label, nameFrom, nameTo, setValue}) => {
    const [dateRange, setDateRange] = useState([null, null]);
    const [startDate, endDate] = dateRange

    const handleChange = (change) => { //change [Date(2020-01-01), Date(2021-01-01)]
        setDateRange(change);

        const [startYear, endYear] = change;

        if (startYear && endYear) {
            const startFormatted = format(startOfYear(startYear), "yyyy-MM-dd");
            const endFormatted = format(endOfYear(endYear), "yyyy-MM-dd");

            setValue(nameFrom, startFormatted)
            setValue(nameTo, endFormatted)

            console.log("done")
        }


    };


    return (
        <div>
            {label}
            <DatePicker
                selectsRange
                showYearPicker
                dateFormat="yyyy"
                startDate={startDate}
                endDate={endDate}
                onChange={handleChange}
                className="form-control"
            />
        </div>
    );
}

export default FilterDateField;


// return (
//   <div className="mb-3">
//     <label className="form-label">{label}</label>
//     <input type="date" className="form-control" {...register(nameFrom)} />
//     <input type="date" className="form-control" {...register(nameTo)} />
//   </div>
// );
