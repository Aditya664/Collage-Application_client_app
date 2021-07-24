package com.example.yccollage.auth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yccollage.MainActivity;
import com.example.yccollage.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    private TextView openreg,openforg;
    private EditText logemail,logpass;
    private Button logbtn;
    private String email,pass;
    private FirebaseAuth auth;
    private ProgressDialog pgbar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        pgbar = new ProgressDialog(this);
        openforg = findViewById(R.id.openforg);

        auth = FirebaseAuth.getInstance();
        openreg =findViewById(R.id.opereg);
        logbtn = findViewById(R.id.loginbtn);
        logemail = findViewById(R.id.logEmail);
        logpass = findViewById(R.id.logPass);

        openreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openregister();
            }
        });

        logbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valiData();
            }
        });
        openforg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,ForgetActivity.class));
            }
        });
    }

    private void valiData() {
        email = logemail.getText().toString();
        pass = logpass.getText().toString();

        if(email.isEmpty() ||pass.isEmpty()){
            Toast.makeText(this, "Please provide all fields", Toast.LENGTH_SHORT).show();
        }else {
            loginuser();
        }
    }

    private void loginuser() {
        pgbar.setTitle("Please wait");
        pgbar.setMessage(" Login...");
        pgbar.show();
        auth.signInWithEmailAndPassword(email,pass)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            pgbar.dismiss();
                            openMain();
                        }else {
                            pgbar.dismiss();
                            Toast.makeText(LoginActivity.this, "Error"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(LoginActivity.this, "Error:" +e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void openMain() {
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
        finish();
    }

    private void openregister() {
        startActivity(new Intent(LoginActivity.this,Register_activity.class));
        finish();
    }
}