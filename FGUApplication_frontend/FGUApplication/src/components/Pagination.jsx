export const pageUI = ({ page, setPage, totalPages, size, setSize }) => {
  return (
    <div className="d-flex justify-content-between align-items-end">
      <div className="d-flex flex-grow-1 justify-content-center">
        <button
          className="btn btn-primary btn-sm"
          disabled={page === 0}
          onClick={() => setPage(page - 1)}
        >
          Předchozí
        </button>
        <button
          className="btn btn-primary btn-sm"
          disabled={page + 1 >= totalPages}
          onClick={() => setPage(page + 1)}
        >
          Další
        </button>
      </div>
      <div className="d-flex align-items-end">
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
};
