export function Pagination({ page, setPage, totalPages, size, setSize }) {
  const pages = [...Array(totalPages).keys()];

  return (
    <div className="d-flex justify-content-between align-items-center">
      <nav className="mx-auto">
        <ul className="pagination mb-0 justify-content-center">
          <li className={`page-item ${page === 0 ? "disabled" : ""}`}>
            <button
              className="page-link"
              onClick={() => setPage(page - 1)}
              disabled={page === 0}
            >
              Předchozí
            </button>
          </li>
          {pages.map((p) => (
            <li key={p} className={`page-item ${page === p ? "active" : ""}`}>
              <button className="page-link" onClick={() => setPage(p)}>
                {p + 1}
              </button>
            </li>
          ))}
          <li
            className={`page-item ${page === totalPages - 1 ? "disabled" : ""}`}
          >
            <button
              className="page-link"
              onClick={() => setPage(page + 1)}
              disabled={page === totalPages - 1}
            >
              Další
            </button>
          </li>
        </ul>
      </nav>

      <div>
        <select
          id="pageSize"
          className="form-select w-auto d-inline-block"
          value={size}
          onChange={(e) => {
            setPage(0);
            setSize(parseInt(e.target.value));
          }}
        >
          <option value="10">10</option>
          <option value="25">25</option>
          <option value="50">50</option>
          <option value="100">100</option>
        </select>
      </div>
    </div>
  );
}
export default Pagination;
