package com.epamcourse.data.loginuser;

public class LoginUserBuilder {
    private String username;
    private String password;

    public LoginUserBuilder withUsername(String username) {
        this.username = username;
        return this;
    }

    public LoginUserBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

    public LoginUser build() {
        return new LoginUser(username, password);
    }


    public static LoginUser validUser() {
        return new LoginUserBuilder()
                .withUsername("standard_user")
                .withPassword("secret_sauce")
                .build();
    }

    public static LoginUser invalidUser() {
        return new LoginUserBuilder()
                .withUsername("baduser") // Usuario vacío
                .withPassword("invalid_password")
                .build();
    }

    public static LoginUser blockUser() {
        return new LoginUserBuilder()
                .withUsername("locked_out_user") // Usuario vacío
                .withPassword("secret_sauce")
                .build();
    }
}
