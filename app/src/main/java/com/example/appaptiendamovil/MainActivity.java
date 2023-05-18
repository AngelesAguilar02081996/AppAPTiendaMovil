package com.example.appaptiendamovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    
    public Button btnLogin;
    
    public TextView tvRegistrate;
        
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvRegistrate = findViewById(R.id.tvRegistrate);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(this);
        tvRegistrate.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btnLogin:{
                Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.tvRegistrate:{
                Intent intent = new Intent(MainActivity.this,RegistroActivity.class);
                startActivity(intent);
                break;
            }
        }
    }
}