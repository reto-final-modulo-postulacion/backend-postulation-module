package co.com.sofka.model.challenge;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChallengePostulant {
    private String idChallenge;
    private LocalDate registrationDate;
    private LocalDate initialDate;
    private LocalDate finalDate;
    private String language;

    public ChallengePostulant(String idChallenge){
        this.idChallenge = idChallenge;
        this.registrationDate = LocalDate.now();
    }
}
