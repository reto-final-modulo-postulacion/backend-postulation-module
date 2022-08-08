package co.com.sofka.model.challenge;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
public class ChallengePostulant extends Challenge{
    private Byte deadlineDays;
    private LocalDate initialDate;
    private LocalDate finalDate;
    private String language;
}
