package org.example;

public class CorrectFixedPasswordGenerator implements PasswordGenerator{

    @Override
    public String generalPassword() {
        return "abcdefg3678"; //8글자

    }
}
