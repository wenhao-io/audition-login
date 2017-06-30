package io.wenhao.exception;

public class UserConflictException extends RuntimeException {
    private String email;

    public UserConflictException(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }
}