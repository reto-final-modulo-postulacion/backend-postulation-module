package co.com.sofka.api.postulant;


import co.com.sofka.model.postulant.Postulant;
import co.com.sofka.usecase.postulantusecase.createpostulant.CreatePostulantUseCase;
import co.com.sofka.usecase.postulantusecase.deletepostulant.DeletePostulantUseCase;
import co.com.sofka.usecase.postulantusecase.findallpostulant.FindAllPostulantUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class HandlerPostulant {

    private final CreatePostulantUseCase createPostulantUseCase;
    private final DeletePostulantUseCase deletePostulantUseCase;
    private final FindAllPostulantUseCase findAllPostulantUseCase;

    public Mono<ServerResponse> listenPostCreatePostulantUseCase(ServerRequest serverRequest){
        return serverRequest.bodyToMono(Postulant.class)
                .flatMap(postulant -> ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(createPostulantUseCase.createPostulant(postulant), Postulant.class));
    }

    public Mono<ServerResponse> listenDeletePostulant(ServerRequest serverRequest){
        var id = serverRequest.pathVariable("id");
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(deletePostulantUseCase.deletePostulant(id), Postulant.class);
    }

    public Mono<ServerResponse> listenGetFindAllPostulant(ServerRequest serverRequest){
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(findAllPostulantUseCase.findAllPostulant(), Postulant.class);
    }
}
