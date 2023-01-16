package com.example.mobileapp.data;

import com.example.mobileapp.model.LoggedInUser;
import com.example.mobileapp.model.User;

import java.io.IOException;

public class RegisterDataSource {

    public Result<User> register(String username, String name, String password, String email, String phoneNumber) {

        try {
            User user = new User(-1, username, name, password, email, phoneNumber);
            return new Result.Success<>(user);
        } catch (Exception e) {
            return new Result.Error(new IOException("Error register", e));
        }
    }
}
