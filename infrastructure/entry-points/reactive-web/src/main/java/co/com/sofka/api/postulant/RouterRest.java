package co.com.sofka.api.postulant;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;


@Configuration
public class RouterRest {
    @Bean
    public RouterFunction<ServerResponse> routerFunction(HandlerPostulant handler) {
        return null;/*route(POST("/api/trainingleague"), handler::listenPostAddTrainingLeagueUseCase)
                .andRoute(GET("/api/trainingleague"), handler::listenFindAllTrainingLeagueUseCase)
                .andRoute(GET("/api/trainingleague/{id}"), handler::listenFindTrainingLeagueUseCase)
                .andRoute(PUT("/api/trainingleague/{id}"), handler::listenUpdateTrainingLeagueUseCase)
                .andRoute(DELETE("/api/trainingleague/{id}"), handler::listenDeleteTrainingLeagueUseCase);*/
    }
}
