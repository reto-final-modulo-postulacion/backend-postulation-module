package co.com.sofka.usecase.postulantusecase.registertotraining;

import co.com.sofka.model.postulant.DocumentUser;
import co.com.sofka.model.postulant.Postulant;
import co.com.sofka.model.postulant.gateways.PostulantRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RegisterToTrainingUseCaseTest {

    @InjectMocks
    RegisterToTrainingUseCase registerToTrainingUseCase;

    @Mock
    PostulantRepository postulantRepository;

    @Test
    void registerToTraining() {
        Postulant postulant = new Postulant(
                "1", new DocumentUser(),
                "1990-02-10",
                "Peruano",
                "5555555",
                "1",
                "email@gmail.com");

        Mono<Postulant> postulantMono = Mono.just(postulant);
        when(postulantRepository.update("1", postulant)).thenReturn(postulantMono);

        StepVerifier.create(registerToTrainingUseCase.registerToTraining("1", "1"))
                .expectNextMatches(postulant1 -> postulant1.getId().equals("1") && postulant1.getIdTraining().equals("1"))
                .expectComplete()
                .verify();
    }
}