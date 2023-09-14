package com.example.talkenbackend.user.domain;

public enum UserAuthority {

    USER(Authority.USER),
    ;

    private final String authority;

    UserAuthority(String authority) {
        this.authority = authority;
    }

    public String getAuthority() {
        return this.authority;
    }

    public static class Authority {
        public static final String USER = "USER";
    }
}
