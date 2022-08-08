package co.com.sofka.usecase.trainingLeagueusecase.findtrainingleague;

import co.com.sofka.model.trainingleague.TrainingLeague;
import co.com.sofka.model.trainingleague.gateways.TrainingLeagueRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class FindTrainingLeagueUseCaseTest {

    @InjectMocks
    FindTrainingLeagueUseCase findTrainingLeagueUseCase;

    @Mock
    TrainingLeagueRepository trainingLeagueRepository;

    @Test
    void findTrainingLeague() {
        TrainingLeague trainingLeague = new TrainingLeague("1", "drescripcion1", LocalDate.of(2022, 10, 10));

        Mono<TrainingLeague> trainingLeagueMono = Mono.just(trainingLeague);
        when(trainingLeagueRepository.findById("1")).thenReturn(trainingLeagueMono);

        StepVerifier.create(findTrainingLeagueUseCase.findTrainingLeague("1"))
                .expectNextMatches(trainingLeague1 -> trainingLeague1.equals(trainingLeague))
                .expectComplete()
                .verify();
    }
}