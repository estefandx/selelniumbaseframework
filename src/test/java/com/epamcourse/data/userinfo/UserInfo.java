package com.epamcourse.data.userinfo;

public class UserInfo {
    private final String firstName;
    private final String lastName;
    private final String postalCode;

    public UserInfo(String firstName, String lastName, String postalCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.postalCode = postalCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPostalCode() {
        return postalCode;
    }
}
