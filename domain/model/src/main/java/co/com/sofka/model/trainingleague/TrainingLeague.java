package co.com.sofka.model.trainingleague;

import java.time.LocalDate;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class TrainingLeague {
    private String id;
    private String description;
    private LocalDate dateConvocationEnd;
}
