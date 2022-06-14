package com.example.automex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class RegisterMenu extends AppCompatActivity {
    Button callUserRegister;
    Button callMechanicRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_register_menu);

        callUserRegister = findViewById(R.id.registerUser);

        callUserRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( RegisterMenu.this,UserRegister.class);
                startActivity(intent);

            }
        });

        callMechanicRegister = findViewById(R.id.registerMechanic);

        callMechanicRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( RegisterMenu.this,MechanicRegister.class);
                startActivity(intent);

            }
        });
    }
}