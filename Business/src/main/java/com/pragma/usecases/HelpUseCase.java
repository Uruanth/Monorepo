package com.pragma.usecases;

import com.pragma.generic.Usecase;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;


@Slf4j
public class HelpUseCase extends Usecase<Mono<String>, Mono<String>> {

    @Override
    public Mono<String> apply(Mono<String> stringMono) {
        log.info("adasdasd");
        return Mono.just("Test handle");
    }
}
