package com.pragma;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

@AllArgsConstructor
public  class EncrypSecurity {
    @Autowired
    private static PasswordEncoder encoder;
    public  String encode(String pass){
        return encoder.encode(pass);
    }


}
