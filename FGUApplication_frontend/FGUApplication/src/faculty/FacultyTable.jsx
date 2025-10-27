import {Link} from "react-router";

const FacultyTable = ({faculties}) => {
    return (
        <div>
            <br/>
            <table className="table table-bordered table-hover">
                <thead>
                <tr className="table-primary text-center">
                    <th className="col-2">Zkratka fakulty</th>
                    <th className="col-7">Název fakulty</th>
                    <th>škola</th>
                </tr>
                </thead>
                <tbody className="text-center">
                {faculties.map((faculty, index) => (
                    <tr key={faculty.id}>
                        <td>
                            <Link
                                to={`detail/${faculty.id}`}
                                className="d-block text-decoration-none text-dark p-3"
                            >
                                {faculty.facultyAbbreviation}
                            </Link>
                        </td>
                        <td>
                            <Link
                                to={`detail/${faculty.id}`}
                                className="d-block text-decoration-none text-dark p-3"
                            >
                                {faculty.facultyName}
                            </Link>
                        </td>
                        <td>
                            <Link
                                to={`detail/${faculty.id}`}
                                className="d-block text-decoration-none text-dark p-3"
                            >
                                {faculty.school}
                            </Link>
                        </td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    );
};

export default FacultyTable;
