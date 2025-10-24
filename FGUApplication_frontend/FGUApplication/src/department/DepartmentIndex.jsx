import {useEffect, useState} from "react";
import {apiGet} from "../utils/api";
import {Link} from "react-router";
import {Pagination} from "../components/Pagination";

import DepartmentTable from "./DepartmentTable";
import FilterForm from "../components/filter/FilterForm";
import LoadingSpinner from "../components/LoadingSpinner.jsx";

const DepartmentIndex = () => {
    const [url, setUrl] = useState("/department/all/pageable");

    const [departments, setDepartments] = useState([]);

    const [loading, setLoading] = useState(true);

    const [numberOfRecords, setNumberOfRecords] = useState();

    const [page, setPage] = useState(0);
    const [totalPages, setTotalPages] = useState();
    const [size, setSize] = useState(10);

    const [sort, setSort] = useState("departmentNumber");

    const [filter, setFilter] = useState({
        departmentNameFilter: "",
        departmentNumberFilter: "",
    });

    const filterFields = [
        {name: "number", label: "Číslo oddělení", type: "text"},
        {name: "name", label: "Název oddělení", type: "text"},
    ];

    const handleFilter = (filterData) => {
        setPage(0);
        setFilter({
            departmentNameFilter: filterData.name,
            departmentNumberFilter: filterData.number,
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
                setDepartments(data.content);
                setTotalPages(data.totalPages);
            })
            .catch((error) => {
                toast.error(`Chyba: ${error.message}`);
                console.error(error);
            })
            .finally(() => setLoading(false));
    }, [url, page, size, filter]);

    useEffect(() => {
        apiGet("/department/count")
            .then((data) => setNumberOfRecords(data))
            .catch((error) => {
                toast.error(`Chyba: ${error.message}`);
                console.error(error);
            });
    }, []);

    if (loading) {
        return (
            <LoadingSpinner/>
        );
    }

    return (
        <div>
            <h1>Seznam všech oddělení</h1>

            <div className="d-flex justify-content-between">
                <p>Počet oddělení v databázi: {numberOfRecords}</p>
                <Link to="create" className="btn btn-md btn-success">
                    Nové oddělení
                </Link>
            </div>

            <div>
                <FilterForm onFilter={handleFilter} fields={filterFields}/>
            </div>

            <br/>
            <DepartmentTable departments={departments}/>

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

export default DepartmentIndex;
