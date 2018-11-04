package com.example.thorliverst.firebaseproj;

import android.app.ProgressDialog;
import android.content.Intent;
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

public class MainActivity extends AppCompatActivity {
    private Button button1;
    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1= findViewById(R.id.btn_signup);
        button1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                sign_up();
            }
        });

        button2= findViewById(R.id.btn_signin);
        button2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                sign_in();
            }
        });

    }
    public void sign_up(){
        Intent intent = new Intent(this, SignupActivity.class);
        startActivities(new Intent[]{intent});
    }

    public void sign_in(){
        Intent intent = new Intent(this, SigninActivity.class);
        startActivities(new Intent[]{intent});
    }

}
