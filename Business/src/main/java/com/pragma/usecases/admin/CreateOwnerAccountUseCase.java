package com.pragma.usecases.admin;

import com.pragma.RolEnum;
import com.pragma.generic.Usecase;
import com.pragma.usecases.repositories.UserRepo;
import com.pragma.usuario.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@AllArgsConstructor
public class CreateOwnerAccountUseCase extends Usecase<User, Mono<User>> {
private final UserRepo repo;
    @Override
    public Mono<User> apply(User user) {

        if(user.getRol().getId() != RolEnum.OWNER.getCode()){
            throw new RuntimeException("rol no valid");
        }
        return repo.saveUser(user);
    }
}
