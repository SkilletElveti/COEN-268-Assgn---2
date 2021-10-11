package com.example.coen268;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;

import com.example.coen268.R.drawable;

public class MainActivity extends AppCompatActivity {
    String bandName[];
    String bandDescription[];
    int bandImages[] = {
            R.drawable.log,
            R.drawable.fossils,
            R.drawable.aur,
            R.drawable.hqdefault,
            R.drawable.pt,
            R.drawable.dm,
            drawable.tb,
            drawable.nb,
            drawable.pf,
            drawable.trivium,
            drawable.met
            };
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("DEBUG","On Create");
        bandName = getResources().getStringArray(R.array.Musicians);
        int d = bandName.length;
        Log.d("DEBUG","On Create "+ bandName.length +" sad");
        bandDescription = getResources().getStringArray(R.array.description);
        recyclerView = findViewById(R.id.bands);
        MyAdapter myAdapter = new MyAdapter(this, bandName, bandDescription, bandImages);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}