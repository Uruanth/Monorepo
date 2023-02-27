package com.pragma.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import reactor.core.publisher.Mono;

@Data
@AllArgsConstructor
public class InMemoryUserService {
    private final SecurityUser user;

    public Mono<SecurityUser> findByUsername(String username){
        return Mono.just(this.user);
    }

}
