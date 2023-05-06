package com.pragma.handle;


import com.pragma.defaultsBean.PassEncoder;
import com.pragma.usecases.HelpUseCase;
import com.pragma.usecases.admin.CreateOwnerAccountUseCase;
import com.pragma.usuario.User;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;


import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
@RequiredArgsConstructor
public class MainHandle {

    @Bean
    public RouterFunction<ServerResponse> helpy(HelpUseCase usecase) {
        return route(
                RequestPredicates.GET("/helpy").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),
                request -> usecase
                        .apply(request.bodyToMono(String.class))
//                        .then(ServerResponse.ok().build())
                        .flatMap(s -> ServerResponse.ok()
                                .contentType(MediaType.TEXT_PLAIN)
                                .bodyValue(s))
//                        .onErrorResume(errorHandler::badRequest)


        );
    }


    @Bean
    public RouterFunction<ServerResponse> helpyCreate(HelpUseCase usecase) {
        return route(
                RequestPredicates.POST("/helpy")
                        .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),
                request -> usecase
                        .apply(request.bodyToMono(String.class)
                                .map(cadena -> new PassEncoder().encode(cadena))
                                )
                        .flatMap(s -> ServerResponse.ok()
                                .contentType(MediaType.TEXT_PLAIN)
                                .bodyValue(s))
//                        .onErrorResume(errorHandler::badRequest)


        );
    }


    @Bean
    public RouterFunction<ServerResponse> createUser(CreateOwnerAccountUseCase useCase){
        return route(
                RequestPredicates.POST("/createOwner")
                        .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(User.class)
                        .flatMap(user -> useCase.apply(user))
                        .flatMap(user -> ServerResponse.ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(user))
                        .onErrorResume(throwable -> ServerResponse.badRequest()
                                .bodyValue(throwable.getMessage()))
        );
    }

}
