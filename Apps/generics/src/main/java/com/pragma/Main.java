package com.pragma;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.stream.Collectors;

@Slf4j
public class Main {

    public static void main(String[] args) {

        Arrays.stream(RolEnum.values()).collect(Collectors.toList())
                .stream().forEach(rolEnum -> {
                    System.out.println(rolEnum.getTipo());
                });

        var list =Arrays.stream(RolEnum.values())
                .filter(rolEnum -> rolEnum.getTipo().equals("ADMINISTRADOR"))
                .collect(Collectors.toList());

        if (list.isEmpty()){
            log.info("no encontro nada");
        }else {
            log.info("es "+list.get(0).getCode());
        }
    }

}
