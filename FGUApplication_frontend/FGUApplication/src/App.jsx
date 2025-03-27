import "./App.css";
import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap/dist/js/bootstrap.bundle.js";
import PersonIndex from "./person/PersonIndex";
import PersonDetail from "./person/PersonDetail";
import PersonForm from "./person/PersonForm";
import ThesisIndex from "./thesis/ThesisIndex";

import {
  BrowserRouter as Router,
  Link,
  Route,
  Routes,
  Navigate,
} from "react-router-dom";

function App() {
  return (
    <Router>
      <div className="container">
        <nav className="navbar navbar-expand-lg bg-body-tertiary">
          <div className="container-fluid">
            <a className="navbar-brand" href="/people">
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
                <li className="nav-item">
                  <Link to={"/thesis"} className="nav-link active">
                    Přehled
                  </Link>
                </li>
                <li className="nav-item">
                  <a className="nav-link" href="#">
                    Roční přehled
                  </a>
                </li>
                <li className="nav-item">
                  <a className="nav-link" href="#">
                    Kvalifikační práce
                  </a>
                </li>
                <li className="nav-item">
                  <a className="nav-link" href="#">
                    Nastavení
                  </a>
                </li>
              </ul>
            </div>
          </div>
        </nav>

        <Routes>
          <Route index element={<Navigate to={"/people"} />} />
          <Route path="/people">
            <Route index element={<PersonIndex />} />
            <Route path="show/:id" element={<PersonDetail />} />
            <Route path="edit/:id" element={<PersonForm />} />
            <Route path="create" element={<PersonForm />} />
          </Route>
          <Route index element={<Navigate to={"/thesis"} />} />
          <Route path="/thesis">
            <Route index element={<ThesisIndex />} />
            <Route path="show/:id" element={"#"} />
            <Route path="edit/:id" element={"#"} />
            <Route path="create" element={"#"} />
          </Route>
        </Routes>
      </div>
    </Router>
  );
}

export default App;
