package co.com.sofka.usecase.trainingLeagueusecase.addtrainingleague;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;

import co.com.sofka.model.trainingleague.TrainingLeague;
import co.com.sofka.model.trainingleague.gateways.TrainingLeagueRepository;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.*;

import java.sql.Date;

class AddTrainingLeagueUseCaseTest {

    @MockBean
    TrainingLeagueRepository repository;

    @SpyBean
    AddTrainingLeagueUseCase addTrainingLeagueUseCase;

    @BeforeEach
    public void setUp() {
        repository = mock(TrainingLeagueRepository.class);
        addTrainingLeagueUseCase = new AddTrainingLeagueUseCase(repository);
    }

    void addTrainingLeagueUseCaseTest() {
        TrainingLeague trainingLeague = new TrainingLeague("1", "Liga de entrenamiento QA",
                Date.valueOf("1970-01-01T00:00:01.000+00:00"));
        Mono<TrainingLeague> trainingLeagueMono = Mono.just(trainingLeague);

        when(repository.save(Mockito.any(TrainingLeague.class))).thenReturn(trainingLeagueMono);

        StepVerifier.create(addTrainingLeagueUseCase.addTrainingLeague(trainingLeague))
                .expectNextMatches(idTrainingLeague -> idTrainingLeague.getId().equals("1"))
                .expectComplete()
                .verify();
    }
}
