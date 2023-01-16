package com.example.mobileapp.register;

import android.util.Patterns;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mobileapp.R;
import com.example.mobileapp.data.LoginRepository;
import com.example.mobileapp.data.RegisterRepository;
import com.example.mobileapp.data.Result;
import com.example.mobileapp.model.LoggedInUser;
import com.example.mobileapp.model.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterViewModel extends ViewModel {

    private MutableLiveData<RegisterFormState> registerFormState = new MutableLiveData<>();
    private MutableLiveData<RegisterResult> registerResult = new MutableLiveData<>();
    private RegisterRepository registerRepository;

    RegisterViewModel(RegisterRepository registerRepository) {
        this.registerRepository = registerRepository;
    }

    LiveData<RegisterFormState> getRegisterFormState() {
        return registerFormState;
    }

    LiveData<RegisterResult> getRegisterResult() {
        return registerResult;
    }

    public void register(String username, String name, String password, String email, String phoneNumber) {
        // can be launched in a separate asynchronous job
        Result<User> result = registerRepository.register(username, name, password, email, phoneNumber);

        if (result instanceof Result.Success) {
            User data = ((Result.Success<User>) result).getData();
            registerResult.setValue(new RegisterResult(new RegisterdUserView(username)));
        } else {
            registerResult.setValue(new RegisterResult(R.string.register_failed));
        }
    }

    public void registerDataChanged(String username, String name, String password, String email, String phoneNumber) {
        if (!isUserNameValid(username)) {
            registerFormState.setValue(new RegisterFormState(R.string.invalid_username, null, null, null, null));
        } else if (!isNameValid(name)) {
            registerFormState.setValue(new RegisterFormState(null, R.string.invalid_name, null, null, null));
        } else if (!isPasswordValid(password)) {
            registerFormState.setValue(new RegisterFormState(null, null, R.string.invalid_password, null, null));
        } else if (!isEmailValid(email)) {
            registerFormState.setValue(new RegisterFormState(null, null, null, R.string.invalid_email, null));
        } else if (!isPhoneNumberValid(phoneNumber)) {
            registerFormState.setValue(new RegisterFormState(null,null, null, null, R.string.invalid_phone));
        } else {
            registerFormState.setValue(new RegisterFormState(true));
        }
    }

    // A placeholder username validation check
    private boolean isUserNameValid(String username) {
        if (username == null) {
            return false;
        }
        if (username.contains("@")) {
            return Patterns.EMAIL_ADDRESS.matcher(username).matches();
        } else {
            return !username.trim().isEmpty();
        }
    }

    private boolean isNameValid(String name) {
        if (name == null) {
            return false;
        }
        if (name.contains("@0123456789")) {
            return false;
        } else {
            return !name.trim().isEmpty();
        }
    }

    // A placeholder password validation check
    private boolean isPasswordValid(String password) {
        return password != null && password.trim().length() > 5;
    }

    private boolean isEmailValid(String email) {
        Pattern p = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
        Matcher m = p.matcher(email);
        return m.matches();
    }

    private boolean isPhoneNumberValid(String phoneNumber) {
        Pattern p = Pattern.compile("^\\d{10}$");
        Matcher m = p.matcher(phoneNumber);
        return m.matches();
    }
}
