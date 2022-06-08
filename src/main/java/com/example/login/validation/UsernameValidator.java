package com.example.login.validation;

/**
 * 02/06/2022.
 *
 * @author Laurent Lamiral
 */
public class UsernameValidator {

    public boolean validate(String username) {

        return username.length() < 10 && username.length() > 2;

    }


}
