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

    long numberOfNewTheses;
    long newBakalarska;
    long newMagisterska;
    long newDoktorandska;
    long newInzenyrska;

    long numberOfEndedTheses;
    long endedBakalarska;
    long endedMagisterska;
    long endedDoktorandska;
    long endedInzenyrska;
}

