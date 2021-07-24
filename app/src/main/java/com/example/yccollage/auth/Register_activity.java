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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Register_activity extends AppCompatActivity {
    private EditText name,email,password;
    private Button registerbtn;
    private String uname,uemail,upass;
    private FirebaseAuth auth;

    private DatabaseReference reference;
    private DatabaseReference dbref;
    private ProgressDialog pgbar;
    private TextView openlog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        auth =   FirebaseAuth.getInstance();
        reference = FirebaseDatabase.getInstance().getReference();
        pgbar = new ProgressDialog(this);
        openlog = findViewById(R.id.openlog);


         name = findViewById(R.id.regName);
         email = findViewById(R.id.regEmail);
         password = findViewById(R.id.regPass);
         registerbtn = findViewById(R.id.registerbtn);

         openlog.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 oprnlogin();
             }
         });

         registerbtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 vadidateData();
             }
         });

    }

    private void oprnlogin() {
        startActivity(new Intent(Register_activity.this, LoginActivity.class));
        finish();
    }

    private void vadidateData() {

        uname = name.getText().toString();
        uemail = email.getText().toString();
        upass = password.getText().toString();

        if(uname.isEmpty()){
            name.setError("Empty");
            name.requestFocus();
        }else if(uemail.isEmpty()){
            email.setError("Empty");
            email.requestFocus();
        }else if(upass.isEmpty()){
            password.setError("Empty");
            password.requestFocus();
        }else{
            createUser();
        }
    }


    @Override
    protected void onStart() {
        super.onStart();
        if(auth.getCurrentUser() != null){
            openMain();
        }
    }

    private void openMain() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    private void createUser() {
        pgbar.setTitle("Please wait");
        pgbar.setMessage("Creating user...");
        pgbar.show();
        auth.createUserWithEmailAndPassword(uemail,upass)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            uploadData();
                            pgbar.dismiss();
                        }else {
                            Toast.makeText(Register_activity.this, "Error"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            pgbar.dismiss();

                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Register_activity.this, "Error"+e.getMessage(), Toast.LENGTH_SHORT).show();
                pgbar.dismiss();
            }
        });

    }

    private void uploadData() {
        dbref = reference.child("users");
        String key = dbref.push().getKey();

        HashMap<String,String> user = new HashMap<>();
        user.put("key",key);
        user.put("name",uname);
        user.put("email",uemail);

        dbref.child(key).setValue(user)
          .addOnCompleteListener(new OnCompleteListener<Void>() {
              @Override
              public void onComplete(@NonNull Task<Void> task) {
                  if(task.isSuccessful()){
                      Toast.makeText(Register_activity.this, "User created", Toast.LENGTH_SHORT).show();
                      openMain();
                      pgbar.dismiss();

                  }else {
                      Toast.makeText(Register_activity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                      pgbar.dismiss();
                  }

              }
          }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull  Exception e) {
                Toast.makeText(Register_activity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}