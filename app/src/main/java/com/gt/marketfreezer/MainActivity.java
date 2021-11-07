package com.gt.marketfreezer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.gt.marketfreezer.model.ResponseGenericUsuario;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    EditText edtUsuario,edtPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtUsuario=findViewById(R.id.edtUsuario);
        edtPassword=findViewById(R.id.edtPassword);
        btnLogin=findViewById(R.id.btnLogin);
        
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validarUsuario("http://3.129.211.86:3000/api/user/login");
            }
        });
    }

    private void validarUsuario(String Url){
        Map<String, String> postParam= new HashMap<String, String>();
        postParam.put("nombre",edtUsuario.getText().toString());
        postParam.put("contrasenia",edtPassword.getText().toString());

        JSONObject parameters = new JSONObject(postParam);

        JsonObjectRequest jsonRequest = new JsonObjectRequest(Request.Method.POST, Url, parameters, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Gson gson = new Gson();
                Toast.makeText(MainActivity.this,response.toString(),Toast.LENGTH_LONG).show();
                ResponseGenericUsuario responseGeneric = gson.fromJson(response.toString(), ResponseGenericUsuario.class);
                Toast.makeText(MainActivity.this,responseGeneric.toString(),Toast.LENGTH_LONG).show();
                if(responseGeneric.getStatusCode() == 200){
                    Intent intent = new Intent(getApplicationContext(),Principal.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this,"Usuario y contraseña incorrectos",Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this,error.toString(),Toast.LENGTH_LONG).show();
                error.printStackTrace();
                //TODO: handle failure
            }
        });

        Volley.newRequestQueue(this).add(jsonRequest);

    }


}