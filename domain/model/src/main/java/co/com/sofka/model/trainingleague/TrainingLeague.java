package co.com.sofka.model.trainingleague;

import java.time.LocalDate;
import java.util.List;

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
    private String name;
    private String description;
    private List<String> expecialities;
    private LocalDate dateConvocationEnd;
    private String img;
}
