package com.example.automex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MechanicRegister extends AppCompatActivity {
    // variables
    TextInputLayout regName, regUsername, regEmail , regPhoneNo, regCnic, regLicense, regPassword;
    Button callSigninPage,callDashboard, regBtn;

    FirebaseDatabase rootNode;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_mechanic_register);

        // All XML elements
        regName = findViewById(R.id.regMecFullName);
        regUsername = findViewById(R.id.regMecUsername);
        regEmail = findViewById(R.id.regMecEmail);
        regPhoneNo = findViewById(R.id.regMecPhoneNo);
        regCnic = findViewById(R.id.regMecCnic);
        regLicense = findViewById(R.id.regMecLicenseNo);
        regPassword = findViewById(R.id.regMecPassword);
        regBtn = findViewById(R.id.regMecBtn);
        callSigninPage = findViewById(R.id.signin_page);


            // save data in firebase on button click
        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("users");
                registerMechanic(view);


            }
        });

        callSigninPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( MechanicRegister.this,Login.class);
                startActivity(intent);

            }
        });

//
//        callDashboard.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent( MechanicRegister.this,Dashboard.class);
//                startActivity(intent);
//
//            }
//        });
    }

    private Boolean validateName(){
        String valName = regName.getEditText().getText().toString();
        if (valName.isEmpty()) {
            regName.setError("Field cannot be empty");
            return false;
        } else {
            regName.setError(null);
            return true;
        }
    }
    private Boolean validateUserName(){
        String valUserName = regUsername.getEditText().getText().toString();
        if (valUserName.isEmpty()) {
            regUsername.setError("Field cannot be empty");
            return false;
        }else if(valUserName.length()>=15){
            regUsername.setError("Username too long");
            return false;
        } else {
            regUsername.setError(null);
            return true;
        }
    }
    private Boolean validateEmail () {
        String valEmail = regEmail.getEditText().getText().toString();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if (valEmail.isEmpty()) {
            regEmail.setError("Field cannot be empty");
            return false;
        } else if (!valEmail.matches(emailPattern)){
            regEmail.setError("Invalid email address");
            return false;
        } else {
            regEmail.setError(null);
            return true;
        }
    }
    private Boolean validatePhoneNO(){
        String valPhoneNO = regPhoneNo.getEditText().getText().toString();
        if (valPhoneNO.isEmpty()) {
            regPhoneNo.setError("Field cannot be empty");
            return false;
        } else {
            regPhoneNo.setError(null);
            return true;
        }
    }
    private Boolean validateCnicNO(){
        String valCnicNO = regCnic.getEditText().getText().toString();
//        String cnicPattern = "^[0-9]{5}-[0-9]{7}-[0-9]{1}$";
        if (valCnicNO.isEmpty()) {
            regCnic.setError("Field cannot be empty");
            return false;
        }
//        else if (!valCnicNO.matches(cnicPattern)){
//            regUsername.setError("Invalid email address");
//            return false;
//        }
        else {
            regCnic.setError(null);
            return true;
        }
    }
    private Boolean validateLicenseNO(){
        String valLicense = regLicense.getEditText().getText().toString();
        if (valLicense.isEmpty()) {
            regLicense.setError("Field cannot be empty");
            return false;
        } else {
            regLicense.setError(null);
            return true;
        }
    }
    private Boolean validatePassword(){
        String valPassword = regPassword.getEditText().getText().toString();
//        String passwordVal = "^"+
//                "(?=.*[a-zA-Z])" +     //any letter +
//                "(?=.*[@#$%^&+=])"+   //at least 1 special character
//                "(?=\\s+$)" +        //no white spaces
//                ".{4,}"+            //at least 4 characters
//                "$";

        if (valPassword.isEmpty()) {
            regPassword.setError("Field cannot be empty");
            return false;
        }
//        else if (!valPassword.matches(passwordVal)){
//            regPassword.setError("Password is too weak");
//            return false;
//        }
        else {
            regPassword.setError(null);
            return true;
        }
    }

    public void registerMechanic(View view){

        if (!validateName()| !validateUserName() | !validateEmail() | validatePhoneNO() | validateCnicNO() | validateLicenseNO() | validatePassword()){
            return;
        }

        // Get all the values in String
        String fullName=regName.getEditText().getText().toString();
        String userName=regUsername.getEditText().getText().toString();
        String email=regEmail.getEditText().getText().toString();
        String phoneNO=regPhoneNo.getEditText().getText().toString();
        String cnicNO=regCnic.getEditText().getText().toString();
        String licenseNO=regLicense.getEditText().getText().toString();
        String password=regPassword.getEditText().getText().toString();
        UserHelperClass helperClass=new UserHelperClass(fullName,userName,email,phoneNO,cnicNO,licenseNO,password);
        reference.child(phoneNO).setValue(helperClass);
    }
}