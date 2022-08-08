package co.com.sofka.api.challenge;



import co.com.sofka.model.challenge.Challenge;
import co.com.sofka.usecase.challenge.createchallenge.CreateChallengeUseCase;
import co.com.sofka.usecase.challenge.deletechallenge.DeleteChallengeUseCase;
import co.com.sofka.usecase.challenge.findallchallenge.FindAllChallengeUseCase;
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
    private final DeleteChallengeUseCase deleteChallengeUseCase;
    private final FindAllChallengeUseCase findAllChallengeUseCase;

    Mono<ServerResponse> listenPostCreateChallengeUseCase(ServerRequest serverRequest){
        return serverRequest.bodyToMono(Challenge.class)
                .flatMap(challenge -> ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(createChallengeUseCase.createChallenge(challenge), Challenge.class));
    }

    Mono<ServerResponse> listenDeleteChallengeUseCase(ServerRequest serverRequest){
        var id = serverRequest.pathVariable("id");
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(deleteChallengeUseCase.deleteChallenge(id), Challenge.class);
    }

    Mono<ServerResponse> listenGetFindAllChallenge(ServerRequest serverRequest){
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(findAllChallengeUseCase.findAllChallenge(), Challenge.class);
    }
}
