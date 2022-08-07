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

  @InjectMocks FindTrainingLeagueUseCase findTrainingLeagueUseCase;

  @Mock TrainingLeagueRepository trainingLeagueRepository;

  @Test
  void findTrainingLeague() {

    TrainingLeague trainingLeague2 =
        new TrainingLeague("2", "descripcion2", LocalDate.of(2022, 11, 11));

    Mono<TrainingLeague> trainingLeagueMono = Mono.just(trainingLeague2);

    when(trainingLeagueRepository.findById("2")).thenReturn(trainingLeagueMono);

    StepVerifier.create(findTrainingLeagueUseCase.findTrainingLeague("2"))
        .expectNextMatches(trainingleague -> trainingleague.getId().equals("2"))
        .verifyComplete();
  }
}
