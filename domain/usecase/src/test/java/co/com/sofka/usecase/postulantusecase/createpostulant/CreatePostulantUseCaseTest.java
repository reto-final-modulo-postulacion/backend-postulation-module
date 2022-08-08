package co.com.sofka.usecase.postulantusecase.createpostulant;

import co.com.sofka.model.postulant.DocumentUser;
import co.com.sofka.model.postulant.Postulant;
import co.com.sofka.model.postulant.gateways.PostulantRepository;
import co.com.sofka.usecase.postulantusecase.createpostulant.CreatePostulantUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreatePostulantUseCaseTest {

    @InjectMocks
    CreatePostulantUseCase createPostulantUseCase;

    @Mock
    PostulantRepository postulantRepository;

    @Test
    void createPostulant() {
        Postulant postulant = new Postulant("1", new DocumentUser(), "1990-02-10", "Colombiano", "555555", "1");

        Mono<Postulant> postulantMono = Mono.just(postulant);
        when(postulantRepository.save(postulant)).thenReturn(postulantMono);

        StepVerifier.create(createPostulantUseCase.createPostulant(postulant))
                .expectNextMatches(postulant1 -> postulant1.getId().equals("1"))
                .expectComplete()
                .verify();
    }
}