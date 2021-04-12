package com.example.uiautomator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.parse.ParseUser;

public class LogoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);

        final Button logoutButton = findViewById(R.id.logout_button);

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ProgressDialog progressDialog = new ProgressDialog(LogoutActivity.this);
                ParseUser.logOutInBackground(e -> {
                    progressDialog.dismiss();
                    if (e == null)
                        alertDisplay("So, that you're going...", "Ok...Bye-bye then");
                });
            }
        });
    }

    private void alertDisplay(final String title, final String message) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(LogoutActivity.this)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(final DialogInterface dialog, final int which) {
                        dialog.cancel();
                        Intent intent = new Intent(LogoutActivity.this, LoginActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                    }
                });
        final AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
