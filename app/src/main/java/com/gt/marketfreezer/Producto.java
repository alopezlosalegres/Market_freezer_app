package com.gt.marketfreezer;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.gt.marketfreezer.model.ProductAdapter;


public class Producto extends AppCompatActivity {

    ListView listView;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto);

        listView = (ListView) findViewById(R.id.listview);
        adapter = new ProductAdapter(getApplicationContext());
        listView.setAdapter(adapter);

    }


}