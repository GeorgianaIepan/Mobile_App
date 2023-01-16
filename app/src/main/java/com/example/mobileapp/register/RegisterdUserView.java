package com.example.mobileapp.register;

public class RegisterdUserView {

    private String displayName;
    //... other data fields that may be accessible to the UI

    RegisterdUserView(String displayName) {
        this.displayName = displayName;
    }

    String getDisplayName() {
        return displayName;
    }
}
