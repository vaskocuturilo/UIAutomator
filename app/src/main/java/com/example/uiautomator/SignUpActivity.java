package com.example.uiautomator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignUpActivity extends AppCompatActivity {

    private EditText nameView;
    private EditText emailView;
    private EditText passwordView;
    private EditText passwordAgainView;

    @Override
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_sign_up);
        final TextView swipeLeft = (TextView) findViewById(R.id.swipeLeft);
        swipeLeft.bringToFront();
        swipeLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                final Intent myIntent = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(myIntent);
            }
        });

        nameView = findViewById(R.id.et_name);
        emailView = findViewById(R.id.et_email);
        passwordView = findViewById(R.id.et_password);
        passwordAgainView = findViewById(R.id.et_repassword);

        final Button buttonRegister = findViewById(R.id.btn_register);
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {

                boolean validationError = false;

                final StringBuilder stringBuilder = new StringBuilder("Please, insert ");

                if (isEmpty(nameView)) {
                    validationError = true;
                    stringBuilder.append("an Full Name ");
                }
                if (isEmpty(emailView)) {
                    validationError = true;
                    stringBuilder.append("an Email ");
                }
                if (isEmpty(passwordView)) {
                    if (validationError) {
                        stringBuilder.append(" and ");
                    }
                    validationError = true;
                    stringBuilder.append("a Password");
                }
                if (isEmpty(passwordAgainView)) {
                    if (validationError) {
                        stringBuilder.append(" and ");
                    }
                    validationError = true;
                    stringBuilder.append("your password again");
                } else {
                    if (!isMatching(passwordView, passwordAgainView)) {
                        if (validationError) {
                            stringBuilder.append(" and ");
                        }
                        validationError = true;
                        stringBuilder.append("the same password twice.");
                    }
                }
                stringBuilder.append(".");

                if (validationError) {
                    Toast.makeText(SignUpActivity.this, stringBuilder.toString(), Toast.LENGTH_LONG).show();
                    return;
                }

                final ProgressDialog dlg = new ProgressDialog(SignUpActivity.this);
                dlg.setTitle("Please, wait a moment.");
                dlg.setMessage("Signing up...");
                dlg.show();

                final ParseUser user = new ParseUser();
                user.setUsername(emailView.getText().toString());
                user.setPassword(passwordView.getText().toString());
                user.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(final ParseException exception) {
                        if (exception == null) {
                            dlg.dismiss();
                            alertDisplay("Successful Login", "Welcome " + emailView.getText().toString() + " ");

                        } else {
                            dlg.dismiss();
                            ParseUser.logOut();
                            Toast.makeText(SignUpActivity.this, exception.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });

            }
        });
    }

    private boolean isEmpty(final EditText text) {
        if (text.getText().toString().trim().length() > 0) {
            return false;
        } else {
            return true;
        }
    }

    private boolean isMatching(final EditText text1, final EditText text2) {
        if (text1.getText().toString().equals(text2.getText().toString())) {
            return true;
        } else {
            return false;
        }
    }

    private void alertDisplay(final String title, final String message) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(SignUpActivity.this)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(final DialogInterface dialog, final int which) {
                        dialog.cancel();
                        Intent intent = new Intent(SignUpActivity.this, LogoutActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                    }
                });
        final AlertDialog dialog = builder.create();
        dialog.show();
    }
}