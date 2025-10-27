import {useEffect, useState} from "react";
import {Link, useNavigate, useParams} from "react-router";
import {apiDelete, apiGet} from "../utils/api";
import {toast} from "react-toastify";
import LoadingSpinner from "../components/LoadingSpinner.jsx";

const FacultyDetail = () => {
    const navigate = useNavigate();
    const {id} = useParams();
    const [faculty, setFaculty] = useState();
    const [loading, setLoading] = useState(true);

    const deleteFunction = async (id) => {
        const confirmed = window.confirm("Opravdu chcete smazat tuto fakultu?");
        if (!confirmed) return;

        try {
            await apiDelete("/faculty/" + id);
            toast.success("Fakulta byla smazána.");
        } catch (error) {
            toast.error(`Chyba: ${error.message}`);
            console.error(error.message);
        }
        navigate("/faculties");
    };

    useEffect(() => {
        apiGet("/faculty/" + id)
            .then((data) => {
                setFaculty(data);
            })
            .catch((error) => {
                toast.error(`Chyba: ${error.message}`);
                console.error(error.message);
            })
            .finally(() => setLoading(false));
    }, []);

    if (loading) {
        return (
            <LoadingSpinner/>
        );
    }

    return (
        <div>
            <div className="d-flex align-items-center justify-content-between">
                <h1>Detail fakulty</h1>
                <div>
                    <Link
                        to={`/faculties/edit/${id}`}
                        className="btn btn-md btn-warning me-1"
                    >
                        Upravit fakultu
                    </Link>
                    <button
                        className="btn btn-danger btn-md"
                        onClick={() => deleteFunction(id)}
                    >
                        Smazat fakultu
                    </button>
                </div>
            </div>
            <hr/>
            <p>
                <strong>Název fakulty:</strong> {faculty?.facultyName}
            </p>
            <p>
                <strong>Zkratka fakulty: </strong> {faculty?.facultyAbbreviation}
            </p>
            <p>
                <strong>Název školy: </strong> {faculty?.school}
            </p>
        </div>
    );
};

export default FacultyDetail;
