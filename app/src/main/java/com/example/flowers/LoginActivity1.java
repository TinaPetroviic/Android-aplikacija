package com.example.flowers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity1 extends AppCompatActivity {
    EditText email_edit, password_edit;
    Button btn_login;
    TextView textview_signup, forgotPassword;
    DBHelper DB;
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Email = "email";
    public static final String Password = "password";
    SharedPreferences sharedpreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login1);
        email_edit = findViewById(R.id.email_edit);
        password_edit = findViewById(R.id.password_edit);
        btn_login = findViewById(R.id.btn_login);
        textview_signup = findViewById(R.id.textview_signup);
        forgotPassword = findViewById(R.id.forgotPassword);

        DB = new DBHelper(this);

            btn_login.setOnClickListener(view -> {

                String user = email_edit.getText().toString();
                String pass = password_edit.getText().toString();

                if (user.equals("") || pass.equals(""))
                    Toast.makeText(LoginActivity1.this, "Molimo Vas unesite sva polja!", Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkuserpass = DB.checkusernamepassword(user, pass);
                    if (checkuserpass) {
                        Toast.makeText(LoginActivity1.this, "Prijava je uspješna!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), FlowersActivity3.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(LoginActivity1.this, "Pogrešan email ili lozinka!", Toast.LENGTH_SHORT).show();
                    }
                }
            });

            textview_signup.setOnClickListener(view -> {
                Intent intent = new Intent(getApplicationContext(), RegistrationActivity2.class);
                startActivity(intent);
            });

            forgotPassword.setOnClickListener(view -> {
                Intent intent = new Intent(getApplicationContext(), ForgotPasswordMainActivity.class);
                startActivity(intent);
            });

        }
    }



