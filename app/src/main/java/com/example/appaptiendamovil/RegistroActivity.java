package com.example.appaptiendamovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegistroActivity extends AppCompatActivity implements View.OnClickListener {

    public EditText etNombre,etApellidos,etCorreo,etContrasena,etTelefono;

    public Button btnRegistrar;

    public TextView tvCuentaExist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        etNombre = findViewById(R.id.etNombre);
        etApellidos = findViewById(R.id.etApellidos);
        etCorreo = findViewById(R.id.etCorreo);
        etContrasena = findViewById(R.id.etContrasena);
        etTelefono = findViewById(R.id.etTelefono);
        btnRegistrar = findViewById(R.id.btnRegistrar);
        tvCuentaExist = findViewById(R.id.tvCuentaExist);

        btnRegistrar.setOnClickListener(this);
        tvCuentaExist.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnRegistrar:{
                if(camposVacios()==false){
                    Toast.makeText(this, "Error, alguno de los campos no tiene que estar vacio", Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent = new Intent(RegistroActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                break;
            }
            case R.id.tvCuentaExist:{
                Intent intent = new Intent(RegistroActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
                break;
            }
        }
    }

    private boolean camposVacios() {
        boolean regreso = false;
        if(!(etNombre.getText().toString().isEmpty() || etApellidos.getText().toString().isEmpty() || etCorreo.getText().toString().isEmpty() ||
                etContrasena.getText().toString().isEmpty() || etTelefono.getText().toString().isEmpty()) ){
            regreso = true;
        }
        return regreso;
    }
}