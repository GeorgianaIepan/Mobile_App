package com.example.mobileapp.register;

import androidx.annotation.Nullable;

public class RegisterResult {

    @Nullable
    private RegisterdUserView success;
    @Nullable
    private Integer error;

    RegisterResult(@Nullable Integer error) {
        this.error = error;
    }

    RegisterResult(@Nullable RegisterdUserView success) {
        this.success = success;
    }

    @Nullable
    RegisterdUserView getSuccess() {
        return success;
    }

    @Nullable
    Integer getError() {
        return error;
    }
}
