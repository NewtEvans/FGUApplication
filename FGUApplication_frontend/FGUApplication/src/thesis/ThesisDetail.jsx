import {useEffect, useState} from "react";
import {useNavigate, useParams} from "react-router-dom";
import {apiDelete, apiGet} from "../utils/api";
import {Link} from "react-router";
import {ThesisTypeTransfer} from "../utils/ThesisTypeTransfer";
import {formatDate} from "../utils/dateUtil";
import {toast} from "react-toastify";
import {ThesisStatusTransfer} from "../utils/ThesisStatusTransfer.jsx";

function ThesisDetail() {
    const navigate = useNavigate();
    const {id} = useParams();

    const [thesis, setThesis] = useState({});

    const deleteFunction = async (id) => {
        const confirmed = window.confirm("Opravdu chcete smazat tuto práci?");
        if (!confirmed) return;

        try {
            await apiDelete("/thesis/" + id);
            toast.success("Práce byla úspěšně smazána.");
        } catch (error) {
            toast.error(`Chyba: ${error.message}`);
            console.error(error.message);
        }
        navigate("/theses");
    };

    useEffect(() => {
        apiGet("/thesis/" + id)
            .then((data) => {
                setThesis(data);
            })
            .catch((error) => {
                toast.error(`Chyba: ${error.message}`);
                console.log(error.message);
            });
    }, [id]);

    return (
        <div>
            <div className="d-flex align-items-center justify-content-between">
                <h1>
                    Detail práce <em>({thesis.nameCz})</em>
                </h1>

                <div>
                    <Link
                        to={`/theses/edit/${id}`}
                        className="btn btn-md btn-warning me-1"
                    >
                        Upravit práci
                    </Link>
                    <button
                        className="btn btn-danger btn-md"
                        onClick={() => deleteFunction(id)}
                    >
                        Smazat práci
                    </button>
                </div>
            </div>

            <hr/>

            <p>
                <strong>Druh práce: </strong>{" "}
                <ThesisTypeTransfer thesisType={thesis.thesisType}/>
            </p>

            <p>
                <strong>Celé datum zahájení:</strong> {formatDate(thesis.startDate)}
            </p>

            <p>
                <strong>Český název:</strong> {thesis.nameCz}
            </p>

            <p>
                <strong>Anglický název:</strong> {thesis.nameEn}
            </p>

            <p>
                <strong>Student:</strong>{" "}
                <Link
                    to={`/person/detail/${thesis.student?.id}`}
                    className="link-dark link-underline-opacity-0 link-underline-opacity-100-hover"
                >
                    {thesis.student?.firstName} {thesis.student?.surname}
                </Link>
            </p>

            <p>
                <strong>Školitel:</strong>{" "}
                <Link
                    to={`/person/detail/${thesis.trainer?.id}`}
                    className="link-dark link-underline-opacity-0 link-underline-opacity-100-hover"
                >
                    {thesis.trainer?.firstName} {thesis.trainer?.surname}
                </Link>
            </p>

            <p>
                <strong>Konzultant:</strong>{" "}
                <Link
                    to={`/person/detail/${thesis.consultant?.id}`}
                    className="link-dark link-underline-opacity-0 link-underline-opacity-100-hover"
                >
                    {thesis.consultant?.firstName} {thesis.consultant?.surname}
                </Link>
            </p>

            <p>
                <strong>Fakulta:</strong>{" "}
                <Link
                    to={`/faculties/detail/${thesis.faculty?.id}`}
                    className="link-dark link-underline-opacity-0 link-underline-opacity-100-hover"
                >
                    {thesis.faculty?.facultyName}
                </Link>
            </p>

            <p>
                <strong>Rada:</strong>{" "}
                <Link
                    to={`/counciles/detail/${thesis.council?.id}`}
                    className="link-dark link-underline-opacity-0 link-underline-opacity-100-hover"
                >
                    {thesis.council?.councilName}
                </Link>
            </p>

            <p>
                <strong>Celé datum ukončení:</strong> {formatDate(thesis.endDate)}
            </p>

            <p>
                <strong>Poznámka:</strong> {thesis.note}
            </p>

            <p>
                <strong>Status: </strong>
                <span><ThesisStatusTransfer thesisStatus={thesis.thesisStatus}/></span>
            </p>

            <hr/>
        </div>
    );
}

export default ThesisDetail;
