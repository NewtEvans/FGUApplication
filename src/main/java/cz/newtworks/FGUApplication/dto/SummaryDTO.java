package cz.newtworks.FGUApplication.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SummaryDTO {

    int numberOfNewTheses;
    int newBakalarska;
    int newMagisterska;
    int newDoktorandska;
    int newInzenyrska;

    int numberOfEndedTheses;
    int endedBakalarska;
    int endedMagisterska;
    int endedDoktorandska;
    int endedInzenyrska;
}

