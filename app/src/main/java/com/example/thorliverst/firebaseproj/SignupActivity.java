package com.example.thorliverst.firebaseproj;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignupActivity extends AppCompatActivity {
    private FirebaseAuth firebaseAuth;
    private EditText username;
    private EditText password;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        firebaseAuth = FirebaseAuth.getInstance();
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        Button signupb = findViewById(R.id.signup);
        progressDialog = new ProgressDialog(this);
        signupb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });
    }
    private void registerUser() {

        String user = username.getText().toString().trim();
        String pass = password.getText().toString().trim();
        if (TextUtils.isEmpty(user)){
            Toast.makeText(this,"Plase enter your email", Toast.LENGTH_LONG).show();
            return;
        }
        if (TextUtils.isEmpty(pass)){
            Toast.makeText(this,"Plase enter your password", Toast.LENGTH_LONG).show();
            return;
        }
        progressDialog.setMessage("Registering Please wait...");
        progressDialog.show();
        firebaseAuth.createUserWithEmailAndPassword(user, pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(SignupActivity.this,"Successfully registered",Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(SignupActivity.this,"Registration Error",Toast.LENGTH_LONG).show();
                        }
                        progressDialog.dismiss();
                    }
                });
    }
}
