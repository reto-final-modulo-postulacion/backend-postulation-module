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
    private String department;
    private String municipality;
    private String address;
    private String englishLevel;
    private Boolean isStudying;
    private String aboutYou;
    private String urlCV;
    private String linkedin;
    private Boolean sessionOn;
    private ChallengePostulant challenge;

    public Postulant(String id, DocumentUser documentUser, String dateOfBirth, String nationality, String urlPhoto,
                     String phone, String workExperience, String currentOccupation, String educationalLevel,
                     String country, String department, String municipality, String address, String englishLevel,
                     Boolean isStudying, String aboutYou, String urlCV, String linkedin, Boolean sessionOn,
                     ChallengePostulant challenge) {
        this.id = id;
        this.documentUser = documentUser;
        this.dateOfBirth = LocalDate.parse(dateOfBirth);
        this.nationality = nationality;
        this.urlPhoto = urlPhoto;
        this.phone = phone;
        this.workExperience = workExperience;
        this.currentOccupation = currentOccupation;
        this.educationalLevel = educationalLevel;
        this.country = country;
        this.department = department;
        this.municipality = municipality;
        this.address = address;
        this.englishLevel = englishLevel;
        this.isStudying = isStudying;
        this.aboutYou = aboutYou;
        this.urlCV = urlCV;
        this.linkedin = linkedin;
        this.sessionOn = sessionOn;
        this.challenge = challenge;
    }

    public Postulant(String id, DocumentUser documentUser, String dateOfBirth, String nationality, String phone) {
        this.id = id;
        this.documentUser = documentUser;
        this.dateOfBirth = LocalDate.parse(dateOfBirth);
        this.nationality = nationality;
        this.phone = phone;
    }
}
