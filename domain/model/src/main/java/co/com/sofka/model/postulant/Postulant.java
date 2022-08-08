package co.com.sofka.model.postulant;

import co.com.sofka.model.challenge.ChallengePostulant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Postulant {
    private String id;
    private DocumentUser documentUser;
    private LocalDate dateOfBirth;
    private String nationality;
    private String urlPhoto;
    private String phone;
    private String workExperience;
    private String currentOccupation;
    private String educationalLevel;
    private String country;
    private String departament;
    private String municipality;
    private String address;
    private String englishLevel;
    private Boolean isStudying;
    private String aboutYou;
    private String urlCV;
    private String linkedin;
    private Boolean sessionOn;
    private ChallengePostulant challenge;
}
