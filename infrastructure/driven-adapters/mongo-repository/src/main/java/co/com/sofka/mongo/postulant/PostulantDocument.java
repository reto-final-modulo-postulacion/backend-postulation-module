package co.com.sofka.mongo.postulant;

import co.com.sofka.model.challenge.ChallengePostulant;
import co.com.sofka.model.postulant.DocumentUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class PostulantDocument {
    @Id
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
    private String idTraining;
}
