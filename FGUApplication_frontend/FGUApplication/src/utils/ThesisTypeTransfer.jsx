export const ThesisTypeTransfer = ({ thesisType }) => {
  switch (thesisType) {
    case "bakalarska":
      return "Bakalářská";
      break;
    case "magisterska":
      return "Magisterská";
      break;
    case "doktorandska":
      return "Doktorandská";
      break;
    case "inzenyrska":
      return "Inženýrská";
      break;
    default:
      return "nic";
      break;
  }
};
