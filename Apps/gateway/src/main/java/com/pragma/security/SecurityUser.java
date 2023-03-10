package com.pragma.security;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class SecurityUser {
    private Integer id;
    private String username;
    private String password;
    private String email;
    private String rol;
}
