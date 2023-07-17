package com.example.gadgetstore;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginAcitivty extends AppCompatActivity {

    EditText mEmail,mPassword;
    Button mlogin;
    TextView mcreatelogin;
    ProgressBar mprogressbar;
    boolean passwordvisibility;

    FirebaseAuth fAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        mEmail = findViewById(R.id.email);
        mPassword = findViewById(R.id.password);
        mprogressbar = findViewById(R.id.progressbar);
        mlogin = findViewById(R.id.Login);
        mcreatelogin = findViewById(R.id.text2);

        fAuth = FirebaseAuth.getInstance();

        mcreatelogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
            }
        });


        mlogin.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public void onClick(View view) {
                String email=mEmail.getText().toString().trim();
                String password=mPassword.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    mEmail.setError("E-mail is required");
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    mPassword.setError("Password is required");
                    return;
                }

                if (password.length() < 6) {
                    mPassword.setError("Password must be > than 6 character");
                    return;
                }

                mprogressbar.setVisibility(View.VISIBLE);


                fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(getApplicationContext(),"LOGIN SUCCESSFUL !",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        }

                        else
                        {
                            Toast.makeText(getApplicationContext(),"ERROR !" + task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                            mprogressbar.setVisibility(View.GONE);
                        }
                    }
                });

                mPassword.setOnTouchListener(new OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        final int Right=2;
                        if(event.getAction()==MotionEvent.ACTION_UP){
                            if(event.getRawX()>=mPassword.getRight()-mPassword.getCompoundDrawables()[Right].getBounds().width()){
                                int selection=mPassword.getSelectionEnd();
                                if(passwordvisibility){
                                    mPassword.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.ic_baseline_info_24,0,R.drawable.ic_baseline_visibility_off_24,0);
                                    mPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                                    passwordvisibility=false;
                                }
                                else{
                                    mPassword.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.ic_baseline_info_24,0,R.drawable.ic_baseline_visibility_24,0);
                                    mPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                                    passwordvisibility=true;
                                }
                                mPassword.setSelection(selection);
                                return true;
                            }
                        }
                        return false;
                    }
                });


            }
        });


    }
}