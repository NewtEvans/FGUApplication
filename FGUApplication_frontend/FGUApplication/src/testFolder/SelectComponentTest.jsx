import Select from "react-select";

const SelectComponentTest = ({ departmentList, handleChange }) => {
  const mapped = departmentList.map((department) => ({
    label: `${department.departmentName} - ${department.departmentNumber}`,
    value: department.id,
  }));

  return (
    <div>
      <Select options={mapped} onChange={handleChange} />
    </div>
  );
};
export default SelectComponentTest;
