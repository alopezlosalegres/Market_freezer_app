package com.gt.marketfreezer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Principal extends AppCompatActivity {

    Button btnProducto;
    Button btnCliente;
    Button btnProvedores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        btnProducto=findViewById(R.id.btnProducto);
        btnCliente=findViewById(R.id.btnClientes);
        btnProvedores=findViewById(R.id.btnProveedores);

        btnProducto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Producto.class);
                startActivity(intent);
            }
        });

        btnCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Principal.this,"Muy Pronto estara habilitado los Clientes",Toast.LENGTH_LONG).show();
            }
        });

        btnProvedores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Principal.this,"Muy Pronto estara habilitado los Proveedores",Toast.LENGTH_LONG).show();
            }
        });

    }
}