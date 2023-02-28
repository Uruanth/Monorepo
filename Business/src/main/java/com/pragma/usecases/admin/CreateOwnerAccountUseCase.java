package com.pragma.usecases.admin;

import com.pragma.generic.Usecase;
import com.pragma.usecases.repositories.UserRepo;
import com.pragma.usuario.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@AllArgsConstructor
public class CreateOwnerAccountUseCase extends Usecase<User, Mono<User>> {
private final UserRepo repo;
    @Override
    public Mono<User> apply(User user) {
        return repo.saveUser(user);
    }
}
