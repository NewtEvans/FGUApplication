import {useEffect, useState} from "react";
import {Link, useNavigate, useParams} from "react-router-dom";
import {apiDelete, apiGet} from "../utils/api";
import {toast} from "react-toastify";
import LoadingSpinner from "../components/LoadingSpinner.jsx";

const CouncilDetail = () => {
    const navigate = useNavigate();
    const {id} = useParams();

    const [council, setCouncil] = useState({});

    const [loading, setLoading] = useState(true);

    useEffect(() => {
        apiGet("/council/" + id)
            .then((data) => {
                setCouncil(data);
            })
            .catch((error) => {
                toast.error(`Chyba: ${error.message}`);
                console.error(error.message);
            })
            .finally(() => setLoading(false));
    }, []);

    const deleteFunction = async (id) => {
        const confirmed = window.confirm("Opravdu chcete tuto radu smazat?");
        if (!confirmed) return;

        try {
            await apiDelete("/council/" + id);
            toast.success("Rada byla úspešně smazána.");
        } catch (error) {
            toast.error(`Chyba: ${error.message}`);
            console.error(error.message);
        }
        navigate("/counciles");
    };

    if (loading) {
        return (
            <LoadingSpinner/>
        );
    }

    return (
        <div>
            <div className="d-flex align-items-center justify-content-between">
                <h1>Detail oborové rady</h1>

                <div>
                    <Link
                        to={`/counciles/edit/${id}`}
                        className="btn btn-md btn-warning me-1"
                    >
                        Upravit radu
                    </Link>
                    <button
                        className="btn btn-danger btn-md"
                        onClick={() => deleteFunction(id)}
                    >
                        Smazat radu
                    </button>
                </div>
            </div>
            <hr/>
            <p>
                <strong>Název rady:</strong> {council.councilName}
            </p>

            <p>
                <strong>Zkratka rady:</strong> {council.councilAbbreviation}
            </p>

            <p>
                <strong>Číslo rady:</strong> {council.councilNumber}
            </p>
        </div>
    );
};

export default CouncilDetail;
