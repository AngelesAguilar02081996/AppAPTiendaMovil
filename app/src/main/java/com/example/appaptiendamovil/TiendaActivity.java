package com.example.appaptiendamovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.Toast;


public class TiendaActivity extends AppCompatActivity implements View.OnClickListener {

    public ListView lvProductos;
    public ImageView ivCarrito;
    private List<String> productos = new ArrayList<>();
    private ArrayList<String> carrito = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tienda);
        lvProductos = (ListView) findViewById(R.id.lvProductos);
        ivCarrito = (ImageView) findViewById(R.id.ivCarrito);

        llenoProductos();
        //Definicion de un  adapter  pra lista de productos
        ArrayAdapter <String> adapter= new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,productos);
        lvProductos.setAdapter(adapter);

        lvProductos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                // Obtener el ID del elemento seleccionado
                carrito.add((String) adapterView.getItemAtPosition(position));
                AlertDialog.Builder builder = new AlertDialog.Builder(TiendaActivity.this);
                builder.setTitle("Confirmación");
                builder.setMessage("¿Quieres agregar al carrito?");

                builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // Acción a realizar si se confirma
                        dialogInterface.dismiss(); // Cierra el cuadro de diálogo
                    }
                });

                builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // Acción a realizar si se cancela
                        dialogInterface.dismiss(); // Cierra el cuadro de diálogo
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        ivCarrito.setOnClickListener(this);
    }

    private void llenoProductos() {
        productos.add("Pantalon con pinzas");
        productos.add("Pantalon negro");
        productos.add("Pantalon rojo");
        productos.add("Pantalon amarillo");
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == ivCarrito.getId()){
            if(carrito.size()==0){
                Toast.makeText(this, "No hay productos en tu carrito", Toast.LENGTH_SHORT).show();
            }else{
                for(int i=0;i<carrito.size();i++){
                    System.out.println("Seleccione: "+carrito.get(i));
                    Bundle mandoDatos = new Bundle();
                    mandoDatos.putStringArrayList("carrito",carrito);
                    Intent intent = new Intent(TiendaActivity.this,CarritoActivity.class);
                    intent.putExtras(mandoDatos);
                    startActivity(intent);
                }
            }
        }
    }
}