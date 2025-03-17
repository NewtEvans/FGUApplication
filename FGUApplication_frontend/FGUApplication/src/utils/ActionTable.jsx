import React from "react";
import { Link } from "react-router";

const ActionTable = () => {
  return (
    <div className="d-flex justify-content-evenly">
      <Link to={"#"} className="btn btn-info">
        Test
      </Link>
    </div>
  );
};

export default ActionTable;
