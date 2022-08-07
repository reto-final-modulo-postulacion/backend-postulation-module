package co.com.sofka.usecase.trainingLeagueusecase.deletetrainingleague;

import co.com.sofka.model.trainingleague.TrainingLeague;
import co.com.sofka.model.trainingleague.gateways.TrainingLeagueRepository;
import co.com.sofka.usecase.trainingLeagueusecase.addtrainingleague.AddTrainingLeagueUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.LocalDate;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DeleteTrainingLeagueUseCaseTest {

    @InjectMocks
    DeleteTrainingLeagueUseCase deleteTrainingLeagueUseCase;

    @InjectMocks
    AddTrainingLeagueUseCase addTrainingLeagueUseCase;

    @Mock
    TrainingLeagueRepository repository;


    @Test
    void deleteTrainingLeague(){
        // ARR
        TrainingLeague trainingLeague = new TrainingLeague("1", "descripcion", LocalDate.of(2022, 10, 10));

        Mono<TrainingLeague> trainingLeagueMono = Mono.just(trainingLeague);
        when(repository.save(trainingLeague)).thenReturn(trainingLeagueMono);

        Mono<Void> then = Mono.empty();
        when(repository.deleteById("1")).thenReturn(then );

        // ACT
        StepVerifier.create(deleteTrainingLeagueUseCase.deletetrainingleague("1"))
                .expectNextMatches((a) -> a.equals(Mono.empty()))
                .verifyComplete();
    }


}
