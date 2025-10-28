import {useState} from "react";

const SortDropdown = ({setSort, fields}) => {
    const [actualSort, setActualSort] = useState("Seřadit");
    return (
        <div className="dropdown float-end">
            <button
                id="sortDropdownMenuButton"
                className="btn dropdown-toggle"
                type="button"
                data-bs-toggle="dropdown"
                aria-expanded="false"
            >
                {actualSort}
            </button>

            <ul className="dropdown-menu" aria-labelledby="sortDropdownMenuButton">
                {fields.map((field) => (
                    <li key={field.value}>
                        <button
                            className="dropdown-item"
                            onClick={() => {
                                setSort(field.value);
                                setActualSort(field.label);
                            }}
                        >
                            {field.label}
                        </button>
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default SortDropdown;
