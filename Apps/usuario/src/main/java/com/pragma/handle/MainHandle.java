package com.pragma.handle;


import com.pragma.usecases.HelpUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class MainHandle {

    @Bean
    public RouterFunction<ServerResponse> crear(HelpUseCase usecase) {

        return route(
                POST("/helpy").and(accept(MediaType.APPLICATION_JSON)),
                request -> usecase
                        .apply(request.bodyToMono(String.class))
//                        .then(ServerResponse.ok().build())
                        .flatMap(s -> ServerResponse.ok()
                                .contentType(MediaType.TEXT_PLAIN)
                                .bodyValue(s))
//                        .onErrorResume(errorHandler::badRequest)


        );
    }


}
