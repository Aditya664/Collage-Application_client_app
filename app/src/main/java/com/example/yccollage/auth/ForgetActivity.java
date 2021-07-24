package com.example.yccollage.auth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.yccollage.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgetActivity extends AppCompatActivity {
    private EditText foremail;
    private Button  forbtn;
    private String email;
    private FirebaseAuth authh;
    private ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);
        authh = FirebaseAuth.getInstance();
        foremail= findViewById(R.id.ForgetEmail);
        forbtn= findViewById(R.id.forbtn);
        pd = new ProgressDialog(this);

        forbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateData();
            }
        });

    }

    private void validateData() {
        email = foremail.getText().toString();
        if(email.isEmpty()){
            foremail.setError("required");
        }else
        {
            forgetpass();
        }
    }

    private void forgetpass() {
        pd.setTitle("Please wait");
        pd.setMessage("Sending Email");
        pd.show();
        authh.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    pd.dismiss();
                    Toast.makeText(ForgetActivity.this, "Check you Email", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(ForgetActivity.this,LoginActivity.class));
                    finish();
                }else {
                    pd.dismiss();
                    Toast.makeText(ForgetActivity.this, "Error:"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}