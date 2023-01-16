package com.example.mobileapp.register;

import androidx.annotation.Nullable;

public class RegisterFormState {

    @Nullable
    private Integer usernameError;
    @Nullable
    private Integer nameError;
    @Nullable
    private Integer passwordError;
    @Nullable
    private Integer emailError;
    @Nullable
    private Integer phoneError;
    private boolean isDataValid;

    RegisterFormState(@Nullable Integer usernameError, @Nullable Integer nameError, @Nullable Integer passwordError, @Nullable Integer emailError, @Nullable Integer phoneError) {
        this.usernameError = usernameError;
        this.nameError = nameError;
        this.passwordError = passwordError;
        this.emailError = emailError;
        this.phoneError = phoneError;
        this.isDataValid = false;
    }

    RegisterFormState(boolean isDataValid) {
        this.usernameError = null;
        this.nameError = null;
        this.passwordError = null;
        this.emailError = null;
        this.phoneError = null;
        this.isDataValid = isDataValid;
    }

    @Nullable
    Integer getUsernameError() {
        return usernameError;
    }

    @Nullable
    Integer getPasswordError() {
        return passwordError;
    }

    @Nullable
    public Integer getNameError() {
        return nameError;
    }

    @Nullable
    public Integer getEmailError() {
        return emailError;
    }

    @Nullable
    public Integer getPhoneError() {
        return phoneError;
    }

    boolean isDataValid() {
        return isDataValid;
    }
}
