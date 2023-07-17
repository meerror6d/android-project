package com.example.gadgetstore;

import static android.text.Selection.setSelection;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {

    public static final String TAG="TAG";
    EditText mUsername,mEmail,mPassword;
    Button mregisterbutton;
    TextView mlogin;
    ProgressBar mProgressbar;
    boolean passwordvisibility;
    public static boolean setsignupfragment=false;

    FirebaseFirestore fstore;
    String userId;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_register);

        mUsername = findViewById(R.id.username);
        mEmail = findViewById(R.id.email);
        mPassword = findViewById(R.id.password);
        mregisterbutton = findViewById(R.id.register);
        mlogin = findViewById(R.id.text2);
        mProgressbar = findViewById(R.id.progressbar);

        fAuth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();

        if(fAuth.getCurrentUser()!=null){
            startActivity(new Intent(RegisterActivity.this,MainActivity.class));
            finish();
        }


        mlogin.setOnClickListener(view -> startActivity(new Intent(RegisterActivity.this, LoginAcitivty.class)));

        mPassword.setOnTouchListener(new View.OnTouchListener() {
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

        mregisterbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = mEmail.getText().toString().trim();
                String password = mPassword.getText().toString().trim();
                final String username = mUsername.getText().toString();

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

                mProgressbar.setVisibility(View.VISIBLE);


                fAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            FirebaseUser fUser = fAuth.getCurrentUser();
                            fUser.sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                    Toast.makeText(getApplicationContext(), "REGISTER SUCCESSFUL", Toast.LENGTH_SHORT).show();
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.d(TAG, "Onfailure: Email not sent!" + e.getMessage());
                                }
                            });

                            Toast.makeText(getApplicationContext(), "User created", Toast.LENGTH_SHORT).show();
                            userId = fAuth.getCurrentUser().getUid();
                            DocumentReference documentReference = fstore.collection("user").document(userId);
                            Map<String, Object> user = new HashMap<>();
                            user.put("fname", username);
                            user.put("email", email);
                            documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                    Log.d(TAG, "ON SUCCESS: USER PROFILE IS CREATED" + userId);
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.d(TAG, "ON FAILURE: " + e.toString());
                                }
                            });

                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        } else {
                            Toast.makeText(RegisterActivity.this, "ERROR! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            mProgressbar.setVisibility(View.GONE);
                        }
                    }
                });
            }
        });

    }
}