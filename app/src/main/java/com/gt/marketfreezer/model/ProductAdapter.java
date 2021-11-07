package com.gt.marketfreezer.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.List;
import com.google.gson.Gson;
import com.gt.marketfreezer.R;

public class ProductAdapter extends ArrayAdapter {

    private RequestQueue requestQueue;
    JsonObjectRequest jsArrayRequest;
    private static final String URL_BASE = "http://3.129.211.86:3000/api/product/findAll";
    private static final String TAG = "ProductAdapter";
    List<Product> items;

    public ProductAdapter(@NonNull Context context) {
        super(context, 0);

        requestQueue = Volley.newRequestQueue(context);

        JsonObjectRequest jsonRequest = new JsonObjectRequest(Request.Method.GET, URL_BASE, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Gson gson = new Gson();

                ResponseGenericProduct responseGeneric = gson.fromJson(response.toString(), ResponseGenericProduct.class);

                if(responseGeneric.getStatusCode() == 200){

                    items =  responseGeneric.getBody();
                    notifyDataSetChanged();

                }else{
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();

            }
        });

        requestQueue.add(jsonRequest);
    }

    @Override
    public int getCount() {
        return items != null ? items.size() : 0;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItemView;

        listItemView=  null == convertView ? layoutInflater.inflate(
                R.layout.producto_row_item,
                parent,
                false
        ): convertView;

        Product item = items.get(position);

        TextView textoNombre = (TextView) listItemView.findViewById(R.id.tv_nombre);
        TextView textoDescripcion = (TextView) listItemView.findViewById(R.id.tv_descripcion);
        TextView textoCantidad = (TextView) listItemView.findViewById(R.id.tv_cantidad);
        final ImageView imageFreeze = (ImageView) listItemView.findViewById(R.id.imageFreeze);

        textoNombre.setText(item.getNombre());
        textoDescripcion.setText(item.getDescripcion());
        textoCantidad.setText(String.valueOf(item.getCantidad()));

        ImageRequest request = new ImageRequest(
                item.getImagenproducto(),
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap response) {
                        imageFreeze.setImageBitmap(response);
                    }
                }, 0, 0, null,
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        imageFreeze.setImageResource(R.drawable.ic_launcher_background);
                        Log.d(TAG, "Error en respuesta Bitmap: "+ error.getMessage());
                    }
                }
        );

        requestQueue.add(request);
        return listItemView;
    }

}
