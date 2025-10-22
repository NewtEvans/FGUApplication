import {useState} from "react";
import DatePicker from "react-datepicker";
import {cs} from "date-fns/locale";
import {endOfYear, format, startOfYear} from "date-fns";

const TestovaciIndex = () => {
    const [date, setDate] = useState(new Date());
    const [year, setYear] = useState();

    const handleChange = (date) => {
        setDate(date);

        const formattedForBeckend = format(date, "yyyy-MM-dd");
        console.log("Pro backend: ", formattedForBeckend)
    }

    const handleChangeYear = (year) => {
        setYear(year);

        const startYear = startOfYear(year);
        const endYear = endOfYear(year);

        const startFormatted = format(startYear, "yyyy-MM-dd")
        const endFormatted = format(endYear, "yyyy-MM-dd")

        console.log("Rozsah pro backend: ", startFormatted, "->", endFormatted);
    }

    return (
        <div>
            <DatePicker
                selected={date}
                onChange={handleChange}
                dateFormat="dd-MM-yyyy"
                locale={cs}
                placeholderText="Vyber datum"
                showIcon
                isClearable={true}
            />
            <strong>Vybral jsi: </strong> {date.toDateString()}
            {console.log(date)}

            <DatePicker
                selected={year}
                onChange={handleChangeYear}
                showYearPicker
                dateFormat="yyyy"
                placeholderText="pouze rok"
            />
        </div>
    );
}
export default TestovaciIndex;