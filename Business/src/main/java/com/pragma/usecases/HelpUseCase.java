package com.pragma.usecases;

import reactor.core.publisher.Mono;

import java.util.function.Function;

public class HelpUseCase implements Function<Mono<String>, Mono<String>> {

    @Override
    public Mono<String> apply(Mono<String> stringMono) {
        return Mono.just("Test handle");
    }
}
