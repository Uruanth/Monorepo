package com.pragma.usecases;

import com.pragma.usecases.repositories.UserRepo;
import com.pragma.usuario.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class HelpUseCaseTest {
    @Mock
    private UserRepo repo;

    @InjectMocks
    private HelpUseCase useCase;

    @Test
    void helpy() {
        User userTestRepo = User.builder()
                .id(1)
                .mobile("+573113294143")
                .email("admin@admin.com")
                .name("admin")
                .lastName("test")
                .pass("admin")
                .build();
        Mockito.when(repo.saveUser(Mockito.any())).thenReturn(Mono.just(userTestRepo));

        String salida = userTestRepo.toString();

        StepVerifier.create(useCase.apply(Mono.just("admin")))
                .expectNext(salida)
                .verifyComplete();

    }


}