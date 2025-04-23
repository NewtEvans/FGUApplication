import { apiDelete } from "./api";

const deleteFunction = ({ item, id }) => {
  async (id) => {
    try {
      await apiDelete(item + "/delete/" + id);
    } catch (error) {
      console.log(error.message);
      alert(error.message);
    }
  };
};

export default deleteFunction;
