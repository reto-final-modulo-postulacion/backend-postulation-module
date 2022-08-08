package co.com.sofka.usecase.trainingLeagueusecase.deletetrainingleague;

import co.com.sofka.model.trainingleague.TrainingLeague;
import co.com.sofka.model.trainingleague.gateways.TrainingLeagueRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DeleteTrainingLeagueUseCaseTest {

    @InjectMocks
    DeleteTrainingLeagueUseCase deleteTrainingLeagueUseCase;

    @Mock
    TrainingLeagueRepository trainingLeagueRepository;

    @Test
    void deletetrainingleague() {
        TrainingLeague trainingLeague = new TrainingLeague("1", "descripcion", LocalDate.of(2022, 10, 10));

        Mono<Void> trainingLeagueMono = Mono.empty();
        when(trainingLeagueRepository.deleteById("1")).thenReturn(trainingLeagueMono);

        // ACT
        StepVerifier.create(deleteTrainingLeagueUseCase.deletetrainingleague("1"))
                .expectNextMatches(unused -> false)
                .expectNext();
    }
}