package co.com.sofka.api.challenge;


import co.com.sofka.model.challenge.Challenge;
import co.com.sofka.usecase.challengeusecase.createchallenge.CreateChallengeUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class HandlerChallenge {

    private final CreateChallengeUseCase createChallengeUseCase;

    Mono<ServerResponse> listenPostCreateChallenge(ServerRequest serverRequest){
        return serverRequest.bodyToMono(Challenge.class)
                .flatMap(challenge -> ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(createChallengeUseCase.createChallenge(challenge), Challenge.class));
    }

}
