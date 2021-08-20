package com.akash.smartmeet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignupActivity extends AppCompatActivity {
    FirebaseAuth auth;
    EditText emailid, passwordid, nameboxid;
    Button loginbtn, createbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        auth= FirebaseAuth.getInstance();
        emailid= findViewById(R.id.emailid);
        nameboxid= findViewById(R.id.nameboxid);
        passwordid= findViewById(R.id.passwordid);
        loginbtn= findViewById(R.id.loginbtn);
        createbtn= findViewById(R.id.createbtn);

        createbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email, pass, name;
                email= emailid.getEditableText().toString();
                pass=passwordid.getEditableText().toString();
                name=nameboxid.getEditableText().toString();
//                email= emailid.getEditableText()Text().toString();
//                pass= passwordid.getEditableText()Text().toString();
//                name= nameboxid.getEditableText()Text().toString();
                auth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(SignupActivity.this, "Account is created", Toast.LENGTH_SHORT).show();
                            //success
                        }else {
                            Toast.makeText(SignupActivity.this, task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

    }
}
