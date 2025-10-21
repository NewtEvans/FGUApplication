export const ThesisStatusTransfer = ({thesisStatus}) => {
    switch (thesisStatus) {
        case "PROBIHAJICI":
            return "Probíhající";
            break;
        case "PRERUSENA":
            return "Přerušená";
            break;
        case "UKONCENA":
            return "Ukončená";
            break;
        case "PREDCASNE_UKONCENA":
            return "Předčasně ukončená";
            break;
        default:
            return "nic";
            break;
    }
};
