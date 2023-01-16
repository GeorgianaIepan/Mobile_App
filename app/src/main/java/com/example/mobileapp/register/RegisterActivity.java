package com.example.mobileapp.register;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mobileapp.R;
import com.example.mobileapp.model.User;
import com.example.mobileapp.dataBase.DataBase;
import com.example.mobileapp.ui.login.LoginActivity;

public class RegisterActivity extends AppCompatActivity {

    private RegisterViewModel registerViewModel;

    Button btnRegister;
    EditText textUsername, textName, textPassword, textEmail, textPhoneNumber;

    DataBase dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnRegister = findViewById(R.id.btnRegister);
        textUsername = findViewById(R.id.username);
        textName = findViewById(R.id.name);
        textPassword = findViewById(R.id.password);
        textEmail = findViewById(R.id.email);
        textPhoneNumber = findViewById(R.id.phoneNumber);



        registerViewModel.getRegisterFormState().observe(this, new Observer<RegisterFormState>() {
            @Override
            public void onChanged(@Nullable RegisterFormState registerFormState) {
                if (registerFormState == null) {
                    return;
                }
                btnRegister.setEnabled(registerFormState.isDataValid());

                if (registerFormState.getUsernameError() != null) {
                    textUsername.setError(getString(registerFormState.getUsernameError()));
                }
                if (registerFormState.getNameError() != null) {
                    textName.setError(getString(registerFormState.getNameError()));
                }
                if (registerFormState.getPasswordError() != null) {
                    textPassword.setError(getString(registerFormState.getPasswordError()));
                }
                if (registerFormState.getEmailError() != null) {
                    textEmail.setError(getString(registerFormState.getEmailError()));
                }
                if (registerFormState.getPhoneError() != null) {
                    textPhoneNumber.setError(getString(registerFormState.getPhoneError()));
                }
            }
        });

        registerViewModel.getRegisterResult().observe(this, new Observer<RegisterResult>() {
            @Override
            public void onChanged(@Nullable RegisterResult registerResult) {
                if (registerResult == null) {
                    return;
                }
                //loadingProgressBar.setVisibility(View.GONE);
                if (registerResult.getError() != null) {
                    showRegisterFailed(registerResult.getError());
                }
                if (registerResult.getSuccess() != null) {
                    updateUiWithUser(registerResult.getSuccess());
                }
                setResult(Activity.RESULT_OK);

                //Complete and destroy login activity once successful
                finish();
            }
        });

        TextWatcher afterTextChangedListener = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // ignore
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // ignore
            }

            @Override
            public void afterTextChanged(Editable s) {
                registerViewModel.registerDataChanged(textUsername.getText().toString(),
                        textName.getText().toString(),
                        textPassword.getText().toString(),
                        textEmail.getText().toString(),
                        textPhoneNumber.getText().toString());
            }
        };
        textUsername.addTextChangedListener(afterTextChangedListener);
        textName.addTextChangedListener(afterTextChangedListener);
        textPassword.addTextChangedListener(afterTextChangedListener);
        textEmail.addTextChangedListener(afterTextChangedListener);
        textPhoneNumber.addTextChangedListener(afterTextChangedListener);

        textPassword.setOnEditorActionListener(new TextView.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    registerViewModel.register(textUsername.getText().toString(),
                            textName.getText().toString(),
                            textPassword.getText().toString(),
                            textEmail.getText().toString(),
                            textPhoneNumber.getText().toString());
                }
                return false;
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                User user;
                try {
                    user = new User(-1, textUsername.getText().toString(), textName.getText().toString(), textPassword.getText().toString(), textEmail.getText().toString(), textPhoneNumber.getText().toString());
                    // Toast.makeText(RegisterActivity.this, user.toString(), Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(RegisterActivity.this, "Error creating user", Toast.LENGTH_SHORT).show();
                    user = new User(-1, "error", null, null, null, null);
                }

                /*if(textUsername.getText().toString().equals(u.getUsername())){

                }*/

                dataBase = new DataBase(RegisterActivity.this);
                boolean succes = dataBase.addUser(user);

                Toast.makeText(RegisterActivity.this, "Succes= " + succes, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

    }

    private void updateUiWithUser(RegisterdUserView model) {
        String welcome = "Welcome" + model.getDisplayName();
        // TODO : initiate successful logged in experience

        Toast.makeText(getApplicationContext(), welcome, Toast.LENGTH_LONG).show();
    }

    private void showRegisterFailed(@StringRes Integer errorString) {
        Toast.makeText(getApplicationContext(), errorString, Toast.LENGTH_SHORT).show();
    }
}