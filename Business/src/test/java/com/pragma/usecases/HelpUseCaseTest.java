package com.pragma.usecases;

import com.pragma.usecases.repositories.UserRepo;
import com.pragma.usuario.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
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