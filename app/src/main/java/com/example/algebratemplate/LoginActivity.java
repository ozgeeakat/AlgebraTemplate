/* -------------------------------------------------------------------------------------------
#Project          : Algebra Android Assignment
#SDK Version      : 30
#File Name        : LoginActivity.java
#Package          : algebratemplate
#Author           : Özge AKAT
#Created On       : 2020/09/04

#Description      : Login Page Activity. Also entry point for app.

#Last Modified By :
#Last Modified On :

#Change Log       :
        -

#Function Params  : Manuel User Input from R.id.username field.
-------------------------------------------------------------------------------------------- */
package com.example.algebratemplate;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import data.DataModel;


public class LoginActivity extends AppCompatActivity {
    public Button         loginButton;
    public EditText       usernameEditText;
    public ProgressDialog pdi;
    String validUserName = DataModel.getLoginName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);
        usernameEditText = findViewById(R.id.username);
        loginButton      = findViewById(R.id.btn_login);
        loginButton.setOnClickListener(view -> {
            login(usernameEditText.getText().toString(),validUserName);

    });
    }

    public Boolean login(String a,String  b) {
        if (a.equals(b)) {
            this.pdi = ProgressDialog.show(this, "Algebra",
                    "Loading...Please wait...", true, false);

            Runnable progressRunnable = new Runnable() {
                @Override
                public void run() {
                    pdi.cancel();
                }
            };

            Handler pdCanceller = new Handler();
            pdCanceller.postDelayed(progressRunnable, 3000);
            Intent i = new Intent(getApplicationContext(), LoadProductsAPI.class);
            startActivity(i);
            return true;
        }
        return false;

    }

        public void onBackPressed() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
            alertDialog.setMessage("Are you sure you want to close this activity?");
            alertDialog.setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                System.exit(0);

            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog alert = alertDialog.create();
        alert.show();
    }


}

