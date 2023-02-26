package com.pragma;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(value="com.pragma.usecases",
        useDefaultFilters = false, includeFilters = @ComponentScan.Filter
        (type = FilterType.REGEX, pattern = ".*UseCase")
)
public class UsuarioConfig {
}
