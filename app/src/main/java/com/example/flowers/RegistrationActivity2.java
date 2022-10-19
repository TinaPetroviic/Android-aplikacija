package com.example.flowers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class RegistrationActivity2 extends AppCompatActivity {
    Button btn_signup;
    TextView textview_login;
    EditText full_name, edittext_email, edittext_password, conf_password;
    DBHelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration2);
        btn_signup = findViewById(R.id.btn_signup);
        textview_login = findViewById(R.id.textview_login);
        full_name = findViewById(R.id.full_name);
        edittext_email=findViewById(R.id.edittext_email);
        edittext_password=findViewById(R.id.edittext_password);
        conf_password=findViewById(R.id.conf_password);

        DB = new DBHelper(this);


        btn_signup.setOnClickListener(view -> {

            String user = edittext_email.getText().toString();
            String pass = edittext_password.getText().toString();
            String repass = conf_password.getText().toString();


            if(user.equals("")||pass.equals("")||repass.equals(""))
                Toast.makeText(RegistrationActivity2.this, "Molimo Vas unesite sva polja!", Toast.LENGTH_SHORT).show();
            else{
                if(pass.equals(repass)){
                    Boolean checkuser= DB.checkusername(user);
                    if(!checkuser){
                        Boolean insert = DB.insertData(user, pass);
                        if(insert){
                            Toast.makeText(RegistrationActivity2.this, "Prijava je uspješna!", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), FlowersActivity3.class);
                            startActivity(intent);

                        }
                        else{
                            Toast.makeText(RegistrationActivity2.this, "Registracija nije uspijela!", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(RegistrationActivity2.this, "Korisnik već postoji, molimo prijavite se!", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(RegistrationActivity2.this, "Lozinke se ne podudaraju!", Toast.LENGTH_SHORT).show();
                }
            } });


        textview_login.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), LoginActivity1.class);
            startActivity(intent);
        });
    }
}