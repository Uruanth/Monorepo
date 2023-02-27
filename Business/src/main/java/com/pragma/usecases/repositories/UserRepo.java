package com.pragma.usecases.repositories;

import com.pragma.usuario.User;
import reactor.core.publisher.Mono;

public interface UserRepo {
    Mono<User> saveUser(User user);

}
