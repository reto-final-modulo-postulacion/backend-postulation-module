package co.com.sofka.usecase.trainingLeagueusecase.findtrainingleague;

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

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class FindTrainingLeagueUseCaseTest {

    @InjectMocks
    FindTrainingLeagueUseCase findTrainingLeagueUseCase;

    @Mock
    TrainingLeagueRepository trainingLeagueRepository;

    @Test
    void findTrainingLeague() {
        TrainingLeague trainingLeague = new TrainingLeague("1", "descripcion", LocalDate.of(2022, 10, 10));

        Mono<TrainingLeague> trainingLeagueMono = Mono.just(trainingLeague);
        when(trainingLeagueRepository.findById("1")).thenReturn(trainingLeagueMono);

        StepVerifier.create(findTrainingLeagueUseCase.findTrainingLeague("1"))
                .expectNextMatches(trainingLeague1 -> trainingLeague1.getId().equals("1"))
                .expectComplete()
                .verify();
    }
}