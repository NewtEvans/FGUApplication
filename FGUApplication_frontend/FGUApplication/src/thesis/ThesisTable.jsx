import {Link} from "react-router";
import {ThesisTypeTransfer} from "../utils/ThesisTypeTransfer";
import {formatDate} from "../utils/dateUtil";
import thesisStatus from "./ThesisStatus.jsx";

const getRowClass = (thesis) => {
    if (thesis.thesisStatus === thesisStatus.UKONCENA || thesis.thesisStatus === thesisStatus.PREDCASNE_UKONCENA) return "table-danger"
    if (thesis.thesisStatus === thesisStatus.PRERUSENA) return "table-warning"
    if (thesis.thesisStatus === thesisStatus.PROBIHAJICI) return "table-success"
}

const ThesisTable = ({theses}) => {
    return (
        <div>
            <br/>
            <table className="table table-bordered table-hover ">
                <thead>
                <tr className="table-primary text-center">
                    <th>Název práce</th>
                    <th>Druh práce</th>
                    <th>Student</th>
                    <th>Datum zahájení</th>
                    <th>Datum ukončení</th>
                    <th>Školitel</th>
                    <th>Konzultant</th>
                    <th>Poznámka</th>
                </tr>
                </thead>

                <tbody className="text-center">
                {theses.map((thesis) => (
                    <tr key={thesis.id} className={getRowClass(thesis)}>
                        <td>
                            <Link
                                to={`/theses/detail/${thesis.id}`}
                                className="d-block text-decoration-none text-dark p-3"
                            >
                                {thesis.nameCz}
                            </Link>
                        </td>

                        <td>
                            <Link
                                to={`/theses/detail/${thesis.id}`}
                                className="d-block text-decoration-none text-dark p-3"
                            >
                                <ThesisTypeTransfer thesisType={thesis.thesisType}/>
                            </Link>
                        </td>

                        <td>
                            <Link
                                to={`/theses/detail/${thesis.id}`}
                                className="d-block text-decoration-none text-dark p-3"
                            >
                                {thesis.student
                                    ? `${thesis.student?.firstName} ${thesis.student?.surname}`
                                    : ""}
                            </Link>
                        </td>

                        <td>
                            <Link
                                to={`/theses/detail/${thesis.id}`}
                                className="d-block text-decoration-none text-dark p-3"
                            >
                                {formatDate(thesis.startDate)}
                            </Link>
                        </td>

                        <td>
                            <Link
                                to={`/theses/detail/${thesis.id}`}
                                className="d-block text-decoration-none text-dark p-3"
                            >
                                {formatDate(thesis.endDate)
                                    ? formatDate(thesis.endDate)
                                    : "Studuje"}
                            </Link>
                        </td>

                        <td>
                            <Link
                                to={`/theses/detail/${thesis.id}`}
                                className="d-block text-decoration-none text-dark p-3"
                            >
                                {thesis.trainer
                                    ? `${thesis.trainer?.firstName} ${thesis.trainer?.surname}`
                                    : "-"}
                            </Link>
                        </td>

                        <td>
                            <Link
                                to={`/theses/detail/${thesis.id}`}
                                className="d-block text-decoration-none text-dark p-3"
                            >
                                {thesis.consultant
                                    ? `${thesis.consultant?.firstName} ${thesis.consultant?.surname}`
                                    : "-"}
                            </Link>
                        </td>

                        <td>
                            <Link
                                to={`/theses/detail/${thesis.id}`}
                                className="d-block text-decoration-none text-dark p-3"
                            >
                                {thesis.note}
                            </Link>
                        </td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    );
};

export default ThesisTable;
