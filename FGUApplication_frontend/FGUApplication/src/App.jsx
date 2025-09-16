import "./App.css";
import "bootstrap/dist/css/bootstrap.min.css";
import * as bootstrap from "bootstrap/dist/js/bootstrap.bundle.min.js";
import PersonIndex from "./person/PersonIndex";
import PersonDetail from "./person/PersonDetail";
import PersonForm from "./person/PersonForm";
import ThesisIndex from "./thesis/ThesisIndex";
import ThesisDetail from "./thesis/ThesisDetail";
import ThesisForm from "./thesis/ThesisForm";
import DepartmentIndex from "./department/DepartmentIndex";
import DepartmentForm from "./department/DepartmentForm";
import DepartmentDetail from "./department/DepartmentDetail";
import FacultyIndex from "./faculty/FacultyIndex";
import FacultyDetail from "./faculty/FacultyDetail";
import FacultyForm from "./faculty/FacultyForm";
import CouncilIndex from "./coucil/CouncilIndex";
import CouncilDetail from "./coucil/CouncilDetail";
import CouncilForm from "./coucil/CouncilForm";
import { ToastContainer } from "react-toastify";

import {
  BrowserRouter as Router,
  Link,
  Route,
  Routes,
  Navigate,
} from "react-router-dom";
import Summaryindex from "./summary/SummaryIndex";

window.bootstrap = bootstrap;

function App() {
  return (
    <Router>
      <div className="container">
        <nav className="navbar navbar-expand-lg bg-body-tertiary">
          <div className="container-fluid">
            <a className="navbar-brand" href="/theses">
              <img
                src="public\fgu_text_1r_Black_CZ.webp"
                alt="Fyziologický ústav"
                width={200}
                height={30}
              />
            </a>
            <button
              className="navbar-toggler"
              type="button"
              data-bs-toggle="collapse"
              data-bs-target="#navbarNav"
              aria-controls="navbarNav"
              aria-expanded="false"
              aria-label="Toggle navigation"
            >
              <span className="navbar-toggler-icon"></span>
            </button>
            <div className="collapse navbar-collapse" id="navbarNav">
              <ul className="navbar-nav">
                <li className="nav-item dropdown">
                  <Link
                    to={"/theses"}
                    className="nav-link dropdown-toggle"
                    role="button"
                    data-bs-toggle="dropdown"
                    aria-expanded="false"
                  >
                    Přehledy
                  </Link>
                  <ul className="dropdown-menu">
                    <li>
                      <Link to={"person"} className="dropdown-item">
                        Osoby
                      </Link>
                    </li>
                    <li>
                      <Link to={"departments"} className="dropdown-item">
                        Oddělení
                      </Link>
                    </li>
                    <li>
                      <Link to={"faculties"} className="dropdown-item">
                        Fakulty
                      </Link>
                    </li>
                    <li>
                      <Link to={"counciles"} className="dropdown-item">
                        Oborové rady
                      </Link>
                    </li>
                    <li>
                      <Link to={"theses"} className="dropdown-item">
                        Práce
                      </Link>
                    </li>
                  </ul>
                </li>
                <li className="nav-item">
                  <Link to={"summary"} className="nav-link">
                    Roční přehled
                  </Link>
                </li>
              </ul>
            </div>
          </div>
        </nav>

        <Routes>
          <Route index element={<Navigate to={"/person"} />} />
          <Route path="/person">
            <Route index element={<PersonIndex />} />
            <Route path="detail/:id" element={<PersonDetail />} />
            <Route path="edit/:id" element={<PersonForm />} />
            <Route path="create" element={<PersonForm />} />
          </Route>
          <Route index element={<Navigate to={"/theses"} />} />
          <Route path="/theses">
            <Route index element={<ThesisIndex />} />
            <Route path="detail/:id" element={<ThesisDetail />} />
            <Route path="edit/:id" element={<ThesisForm />} />
            <Route path="create" element={<ThesisForm />} />
          </Route>
          <Route index element={<Navigate to={"/departments"} />} />
          <Route path="/departments">
            <Route index element={<DepartmentIndex />} />
            <Route path="detail/:id" element={<DepartmentDetail />} />
            <Route path="edit/:id" element={<DepartmentForm />} />
            <Route path="create" element={<DepartmentForm />} />
          </Route>
          <Route index element={<Navigate to={"/faculties"} />} />
          <Route path="/faculties">
            <Route index element={<FacultyIndex />} />
            <Route path="detail/:id" element={<FacultyDetail />} />
            <Route path="edit/:id" element={<FacultyForm />} />
            <Route path="create" element={<FacultyForm />} />
          </Route>
          <Route index element={<Navigate to={"/counciles"} />} />
          <Route path="/counciles">
            <Route index element={<CouncilIndex />} />
            <Route path="detail/:id" element={<CouncilDetail />} />
            <Route path="edit/:id" element={<CouncilForm />} />
            <Route path="create" element={<CouncilForm />} />
          </Route>
          <Route index element={<Navigate to={"/summary"} />} />
          <Route path="/summary">
            <Route index element={<Summaryindex />} />
          </Route>
        </Routes>
        <ToastContainer position="top-center" autoClose={3000} />
      </div>
    </Router>
  );
}

export default App;
