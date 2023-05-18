package com.example.appaptiendamovil;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class InicioActivity extends AppCompatActivity implements View.OnClickListener {

    public ImageView ivTienda,ivSoporte,inUnirse;

    int REQUEST_CODE = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        ivTienda = findViewById(R.id.ivTienda);
        ivSoporte = findViewById(R.id.ivSoporte);
        inUnirse = findViewById(R.id.inUnirse);

        ivTienda.setOnClickListener(this);
        ivSoporte.setOnClickListener(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ivTienda:{
                Intent intent = new Intent(InicioActivity.this,TiendaActivity.class);
                startActivity(intent);
                finish();
                break;
            }
            case R.id.ivSoporte:{
                //Antes que nada pedimos el permiso
                int permisoLLamada = ContextCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE);
                if(permisoLLamada == PackageManager.PERMISSION_GRANTED){
                    //SI SI TENEMOS PERMISO ENTONCES
                    Intent intentLLamada = new Intent(Intent.ACTION_CALL, Uri.parse("tel:+52 1 55 2866 0126"));
                    startActivity(intentLLamada);
                }else{//SI NO LO PEDIMOS
                    Toast.makeText(this, "SE REALIZARA UNA LLAMADA A NUESTRA CLINICA", Toast.LENGTH_SHORT).show();
                    requestPermissions(new String[]{Manifest.permission.CALL_PHONE},REQUEST_CODE);
                }
                break;
            }
            case R.id.inUnirse:{
                Intent intent = new Intent(InicioActivity.this,UnirseActivity.class);
                startActivity(intent);
                finish();
            }
        }
    }
}