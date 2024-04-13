package com.dev.spring.domain.enums;

public enum ClientType {
    INDIVIDUAL(1, "Individual Person"),
    LEGALENTITY(2, "Legal Entity");

    private int code;
    private String description;

    ClientType(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    // Ao informar o código, o método retorna o enum
    public static ClientType toEnum(Integer code) {
        if (code == null) {
            return null;
        }

        for (ClientType x : ClientType.values()) {
            if (code.equals(x.getCode())) {
                return x;
            }
        }

        throw new IllegalArgumentException("Invalid id: " + code);
    }
}
