import {useEffect, useState} from "react";
import PersonTable from "./PersonTable";
import {apiGet} from "../utils/api";
import {Link} from "react-router-dom";
import {Pagination} from "../components/Pagination";
import FilterForm from "../components/filter/FilterForm";
import SortDropdown from "../components/SortDropdown";
import {toast} from "react-toastify";
import LoadingSpinner from "../components/LoadingSpinner.jsx";

const PersonIndex = () => {
    const [url, setUrl] = useState("/person/all/pageable");
    const [people, setPeople] = useState([]);
    const [numberOfRecords, setNumberOfRecords] = useState();
    const [loading, setLoading] = useState(true);
    const [page, setPage] = useState(0);
    const [totalPages, setTotalPages] = useState();
    const [size, setSize] = useState(10);
    const [sort, setSort] = useState("surname");
    const [filter, setFilter] = useState({
        firstNameFilter: "",
        surnameFilter: "",
        isArchived: false
    });

    const filterFields = [
        {name: "firstName", label: "Jméno", type: "text"},
        {name: "surname", label: "Přijmení", type: "text"},
        {
            name: "isArchived",
            label: "Archivovaní",
            type: "checkbox",
            value: "",
        },
    ];
    const sortFields = [
        {value: "surname", label: "Přijmení"},
        {value: "firstName", label: "Jméno"},
    ];

    const handleFilter = (filterData) => {
        setPage(0);
        setFilter({
            firstNameFilter: filterData.firstName,
            surnameFilter: filterData.surname,
            isArchivedFilter: filterData.isArchived,
        });
    };

    useEffect(() => {
        const params = {
            page,
            size,
            totalPages,
            sort,
            ...filter,
        };

        apiGet(url, params)
            .then((data) => {
                setPeople(data.content);
                setTotalPages(data.totalPages);
            })
            .catch((error) => {
                toast.error(`Chyba: ${error.message}`);
                console.error(error);
            })
            .finally(() => setLoading(false));
    }, [url, page, size, filter, sort]);

    useEffect(() => {
        apiGet("/person/count")
            .then((data) => setNumberOfRecords(data))
            .catch((error) => {
                toast.error(`Chyba: ${error.message}`);
                console.log(error.message);
            });
    }, []);

    if (loading) {
        return (
            <LoadingSpinner/>
        );
    }

    return (
        <div>
            <h1>Seznam všeh osob</h1>
            <div className="d-flex justify-content-between">
                <p>Počet osob v databázi: {numberOfRecords}</p>
                <Link to="create" className="btn btn-md btn-success">
                    Nová osoba
                </Link>
            </div>
            <FilterForm onFilter={handleFilter} fields={filterFields}/>
            <SortDropdown setSort={setSort} fields={sortFields}/>
            <PersonTable people={people}/>
            <Pagination
                page={page}
                setPage={setPage}
                totalPages={totalPages}
                size={size}
                setSize={setSize}
            />
        </div>
    );
};

export default PersonIndex;
