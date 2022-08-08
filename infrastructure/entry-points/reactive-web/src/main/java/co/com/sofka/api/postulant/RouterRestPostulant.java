package co.com.sofka.api.postulant;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;


@Configuration
public class RouterRestPostulant {
    @Bean
    public RouterFunction<ServerResponse> routerFunctionPostulant(HandlerPostulant handler) {
        return route(POST("/api/postulant"), handler::listenPostCreatePostulantUseCase)
                .andRoute(DELETE("/api/postulant/{id}"), handler::listenDeletePostulant)
                .andRoute(GET("/api/postulant"), handler::listenGetFindAllPostulant)
                .andRoute(GET("/api/postulant/{id}"), handler::listenGetFindPostulant)
                .andRoute(PUT("/api/postulant/{id}"), handler::listenPutUpdatePostulant)
                .andRoute(PUT("/api/postulant/{idTraining}/{idPostulant}"), handler::listenPutRegisterToTraining);
    }
}
