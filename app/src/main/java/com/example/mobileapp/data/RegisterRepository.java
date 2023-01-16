package com.example.mobileapp.data;

import com.example.mobileapp.model.LoggedInUser;
import com.example.mobileapp.model.User;
import com.example.mobileapp.register.RegisterdUserView;

public class RegisterRepository {

    private static volatile RegisterRepository instance;

    private RegisterDataSource dataSource;

    // If user credentials will be cached in local storage, it is recommended it be encrypted
    // @see https://developer.android.com/training/articles/keystore
    private User user = null;

    // private constructor : singleton access
    private RegisterRepository(RegisterDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static RegisterRepository getInstance(RegisterDataSource dataSource) {
        if (instance == null) {
            instance = new RegisterRepository(dataSource);
        }
        return instance;
    }

    private void setRegisterdUser(User user) {
        this.user = user;
    }

    public Result<User> register(String username, String name, String password, String email, String phoneNumber) {
        // handle login
        Result<User> result = dataSource.register(username, name, password, email, phoneNumber);
        if (result instanceof Result.Success) {
            setRegisterdUser(((Result.Success<User>) result).getData());
        }
        return result;
    }
}
