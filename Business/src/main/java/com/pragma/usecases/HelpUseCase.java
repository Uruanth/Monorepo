package com.pragma.usecases;

import com.pragma.generic.Usecase;
import com.pragma.usecases.repositories.UserRepo;
import com.pragma.usuario.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;


@Slf4j
@AllArgsConstructor
public class HelpUseCase extends Usecase<Mono<String>, Mono<String>> {
    private final UserRepo repo;

    @Override
    public Mono<String> apply(Mono<String> stringMono) {
        log.info("guardar admin");
        return stringMono.flatMap(s ->
            repo.saveUser(User.builder()
                    .mobile("+573113294143")
                    .email("admin@admin.com")
                    .name("admin")
                    .lastName("test")
                    .pass(s)
                    .build())
        ).map(User::toString);


    }
}
