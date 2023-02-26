package com.pragma.usecases;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Slf4j
public class HelpUseCase implements Function<Mono<String>, Mono<String>> {

    @Override
    public Mono<String> apply(Mono<String> stringMono) {
        log.info(stringMono.block());
        return Mono.just("Test handle");
    }
}
