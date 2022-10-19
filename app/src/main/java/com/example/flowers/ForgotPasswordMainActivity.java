package com.example.flowers;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class ForgotPasswordMainActivity extends AppCompatActivity {

    TextView buttonLogin;
    EditText editEmail, editPassword, editConfPassword;
    Button buttonReset;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password_main);

        editEmail = findViewById(R.id.editEmail);
        editPassword = findViewById(R.id.editPassword);
        editConfPassword = findViewById(R.id.editConfPassword);
        buttonLogin = findViewById(R.id.buttonLogin);
        buttonReset = findViewById(R.id.buttonReset);
        db = new DBHelper(this);

        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email, password,repassword;
                try{

                    email = editEmail.getText().toString();
                    password = editPassword.getText().toString();
                    repassword = editConfPassword.getText().toString();

                    if(email.equals("")|| password.equals("")||repassword.equals(""))
                    {
                        Toast.makeText(ForgotPasswordMainActivity.this,"Molimo Vas unesite sva polja!", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        if(password.equals(repassword)){
                            int updatepassword=db.updatepassword(email,password);
                            if(updatepassword==1){
                                editEmail.setText("");
                                editConfPassword.setText("");
                                Toast.makeText(ForgotPasswordMainActivity.this, "Lozinka je uspješno resetirana!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(ForgotPasswordMainActivity.this,LoginActivity1.class);
                                startActivity(intent);
                                finish();

                            }
                            else {
                                Toast.makeText(ForgotPasswordMainActivity.this,"Pogrešna email adresa!",Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(ForgotPasswordMainActivity.this, "Lozinke se ne podudaraju!", Toast.LENGTH_SHORT).show();
                        }
                    }

                }
                catch (Exception e){
                    Toast.makeText(ForgotPasswordMainActivity.this,"Izvan mreže!"+e.getMessage(),Toast.LENGTH_SHORT).show();
                }
            }
        });




        buttonLogin.setOnClickListener(view -> {
                    Intent intent = new Intent(getApplicationContext(), LoginActivity1.class);
                    startActivity(intent);
                });

    }
}

