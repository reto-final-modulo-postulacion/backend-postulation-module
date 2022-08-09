package co.com.sofka.model.challenge;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Challenge {
    private String id;
    private String name;
    private String description;
    private String urlDocument;
    private LocalDate closingDate;
}
