package com.pragma.generic;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.Serializable;
import java.util.function.Function;

public abstract class Usecase<R, G> implements Function<R, G> {

    public abstract G apply(R r);

}
