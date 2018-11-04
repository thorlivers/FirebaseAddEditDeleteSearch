package com.example.thorliverst.firebaseproj;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SigninActivity extends AppCompatActivity {
    private EditText editusername;
    private EditText editpassword;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        firebaseAuth = FirebaseAuth.getInstance();
        editusername = (EditText) findViewById(R.id.username);
        editpassword = (EditText) findViewById(R.id.password);
    }
    public void Signin_Click(View v) {
        final ProgressDialog progressDialog = ProgressDialog.show(SigninActivity.this, "Please wait....", "Processing", true);

        (firebaseAuth.signInWithEmailAndPassword(editusername.getText().toString(), editpassword.getText().toString()))
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();

                        if (task.isSuccessful()) {
                            Toast.makeText(SigninActivity.this,"Login successful", Toast.LENGTH_LONG).show();
                        } else {
                            Log.e("Error", task.getException().toString());
                            Toast.makeText(SigninActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }


}
