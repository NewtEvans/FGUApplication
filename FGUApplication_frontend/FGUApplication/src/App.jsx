import "./App.css";
import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap/dist/js/bootstrap.bundle.js";
import PersonIndex from "./person/PersonIndex";

function App() {
  return (
    <div className="container">
      <nav class="navbar navbar-expand-lg bg-body-tertiary">
        <div class="container-fluid">
          <a class="navbar-brand" href="#"></a>
          <button
            class="navbar-toggler"
            type="button"
            data-bs-toggle="collapse"
            data-bs-target="#navbarNav"
            aria-controls="navbarNav"
            aria-expanded="false"
            aria-label="Toggle navigation"
          >
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
              <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="#">
                  Přehled
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">
                  Roční přehled
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">
                  Kvalifikační práce
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link disabled" aria-disabled="true">
                  Nastavení
                </a>
              </li>
            </ul>
          </div>
        </div>
      </nav>
      <PersonIndex />
    </div>
  );
}

export default App;
