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
/**
 * Počet absolventů v roce 2024: 49
 * - počet bakalářských - 19
 * - počet magisterských - 15
 * - počet doktorandských - 13
 * - počet inženýrských - 2
 * <p>
 * Počet nově přijatých prací v roce 2024: 33
 * - počet bakalářských - 7
 * - počet magisterských - 19
 * - počet doktorandských - 6
 * - počet inženýrských - 1
 * <p>
 * Počet rozpracovaných prací v roce 2024: 169
 * <p>
 * Počet přerušených prací v roce 2024: 1
 * <p>
 * Počet předčasně ukončených prací v roce 2024: 2
 */

