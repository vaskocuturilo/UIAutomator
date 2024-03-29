package com.example.uiautomator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class LoginActivity extends AppCompatActivity {

    private static EditText usernameView;

    private EditText passwordView;

    @Override
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_login);
        createJsonDataFile("account.json");
        final TextView swipeRight = findViewById(R.id.swipeRight);
        swipeRight.bringToFront();
        swipeRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                final Intent myIntent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(myIntent);
            }
        });

        usernameView = findViewById(R.id.et_email);
        passwordView = findViewById(R.id.et_password);

        final Button loginButton = findViewById(R.id.btn_login);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {

                boolean validationError = false;

                final StringBuilder builder = new StringBuilder("Please, insert ");
                if (isEmpty(usernameView)) {
                    validationError = true;
                    builder.append("an Email");
                }
                if (isEmpty(passwordView)) {
                    if (validationError) {
                        builder.append(" and ");
                    }
                    validationError = true;
                    builder.append("a Password");
                }
                builder.append(".");

                if (validationError) {
                    alertView(R.string.alert_title, builder.toString());

                    return;
                }

                final ProgressDialog dlg = new ProgressDialog(LoginActivity.this);
                dlg.setTitle("Please, wait a moment.");
                dlg.setMessage("Logging in...");
                dlg.show();

                ParseUser.logInInBackground(usernameView.getText().toString(), passwordView.getText().toString(), new LogInCallback() {
                    @Override
                    public void done(final ParseUser parseUser, final ParseException parseEx) {
                        if (parseUser != null) {
                            dlg.dismiss();
                            alertDisplay(R.string.alert_title, "Welcome back " + usernameView.getText().toString() + " ");
                        } else {
                            dlg.dismiss();
                            ParseUser.logOut();
                            //Toast.makeText(LoginActivity.this, parseEx.getMessage(), Toast.LENGTH_LONG).show();
                            alertView(R.string.alert_title, parseEx.getMessage());
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

    private void alertDisplay(final int title, final String message) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(final DialogInterface dialog, final int which) {
                        dialog.cancel();
                        Intent intent = new Intent(LoginActivity.this, LogoutActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                    }
                });
        final AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void alertView(final int title, final String message) {
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }

    private void createJsonDataFile(final String filename) {
        OutputStreamWriter outputStreamWriter = null;
        Faker faker = new Faker();
        Register register = new Register(faker.name().fullName(), faker.internet().emailAddress(), faker.internet().password());
        Gson gson = new Gson();
        try {
            FileOutputStream fw = new FileOutputStream("/data/data/" + this.getPackageName() + "/" + filename);
            outputStreamWriter = new OutputStreamWriter(fw);
            outputStreamWriter.write(gson.toJson(register));
            outputStreamWriter.flush();
            fw.getFD().sync();
        } catch (IOException e) {
            Log.d("MDC_CREATE_FILE", "The method createJsonDataFile is down");
        } finally {
            try {
                outputStreamWriter.close();
            } catch (IOException ex) {
                Log.d("MDC_CREATE_FILE_CLOSE", "Can't close file.");
            }
        }
    }
}
