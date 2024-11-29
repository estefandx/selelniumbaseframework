package com.epamcourse.data.userinfo;

public class UserInfoBuilder {
    private String firstName;
    private String lastName;
    private String postalCode;

    public UserInfoBuilder withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UserInfoBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UserInfoBuilder withPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public UserInfo build() {
        return new UserInfo(firstName, lastName, postalCode);
    }


    public static UserInfo validUser() {
        return new UserInfoBuilder()
                .withFirstName("Bryan")
                .withLastName("Moreno")
                .withPostalCode("10005")
                .build();
    }

    public static UserInfo invalidUser() {
        return new UserInfoBuilder()
                .withFirstName("")
                .withLastName("Moreno")
                .withPostalCode("10005")
                .build();
    }
}


