package com.bank.entity;

import java.util.Arrays;

public enum RoleEntity {
    USER;

    public static RoleEntity valueOfByName(String name) {
        return Arrays.stream(values())
                .filter(x -> x.name().equals(name))
                .findAny()
                .orElse(null);
    }
}
