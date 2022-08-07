package co.com.sofka.usecase.trainingLeagueusecase.updatetrainingleague;

import co.com.sofka.model.trainingleague.TrainingLeague;
import co.com.sofka.model.trainingleague.gateways.TrainingLeagueRepository;
import lombok.RequiredArgsConstructor;
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
class UpdateTrainingLeagueUseCaseTest {

    @InjectMocks
    UpdateTrainingLeagueUseCase updateTrainingLeagueUseCase;

    @Mock
    TrainingLeagueRepository repository;

    @Test
    void updateTrainingLeague(){

        TrainingLeague trainingLeague=
                new TrainingLeague("1", "descripcion2", LocalDate.of(2022, 11, 11));

        TrainingLeague newTrainingLeague=
                new TrainingLeague("1", "QA", LocalDate.of(2022, 10, 17));

        Mono<TrainingLeague> trainingLeagueMono = Mono.just(newTrainingLeague);

        when(updateTrainingLeagueUseCase.updateTrainingLeague(trainingLeague.getId(), newTrainingLeague)).thenReturn(trainingLeagueMono);

        StepVerifier.create(updateTrainingLeagueUseCase.updateTrainingLeague("1", newTrainingLeague))
                .expectNextMatches(trainingLeagueNew -> trainingLeagueNew.getDescription().equals("QA"))
                .verifyComplete();
    }
}
