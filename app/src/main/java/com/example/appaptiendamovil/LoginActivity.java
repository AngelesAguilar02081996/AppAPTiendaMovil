package com.example.appaptiendamovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    public EditText etUsuario,etContra;

    public Button btnEntrar;

    public TextView tvRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsuario = findViewById(R.id.etUsuario);
        etContra = findViewById(R.id.etContra);
        btnEntrar = findViewById(R.id.btnEntrar);
        tvRegister = findViewById(R.id.tvRegister);

        btnEntrar.setOnClickListener(this);
        tvRegister.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnEntrar:{
                if(etUsuario.getText().toString().isEmpty()){
                    Toast.makeText(this, "Ingresa un usuario", Toast.LENGTH_SHORT).show();
                }else{
                    if(etContra.getText().toString().isEmpty()){
                        Toast.makeText(this, "Ingresa Contrasena", Toast.LENGTH_SHORT).show();
                    }else{
                        Intent intent = new Intent(LoginActivity.this,InicioActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }
                break;
            }
            case R.id.tvRegister:{
                Intent intent = new Intent(LoginActivity.this,RegistroActivity.class);
                startActivity(intent);
                break;
            }
        }
    }
}