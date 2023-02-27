package com.pragma.defaultsBean;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.beans.BeanProperty;
import java.util.Base64;

@Slf4j
public class PassEncoder implements PasswordEncoder{

    @Override
    public String encode(CharSequence rawPassword) {
        return Base64.getEncoder().encodeToString(rawPassword.toString().getBytes());
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        String passPost = Base64.getEncoder().encodeToString(rawPassword.toString().getBytes());
        return passPost.equals(encodedPassword);
    }
}
