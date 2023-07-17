package com.example.gadgetstore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class vieallactivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private GridView gridview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vieallactivity);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Deals of the day!");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView=findViewById(R.id.viewall_recyclerview);
        gridview=findViewById(R.id.grid_layout_gridview);

        recyclerView.setVisibility(View.VISIBLE);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        List<wishlistmodel> wishlistmodelList=new ArrayList<>();
        wishlistmodelList.add(new wishlistmodel(R.drawable.phone,"Samsung Galaxy S22+ 5G","3","Rs. 75000/-","Cash on delivery available."));
        wishlistmodelList.add(new wishlistmodel(R.drawable.iphone,"Samsung Galaxy S22+ 5G","3","Rs. 75000/-","Cash on delivery available."));
        wishlistmodelList.add(new wishlistmodel(R.drawable.samsung3,"Samsung Galaxy S22+ 5G","3","Rs. 75000/-","Cash on delivery available."));
        wishlistmodelList.add(new wishlistmodel(R.drawable.samsung6,"Samsung Galaxy S22+ 5G","3","Rs. 75000/-","Cash on delivery available."));
        wishlistmodelList.add(new wishlistmodel(R.drawable.headphone,"Samsung Galaxy S22+ 5G","3","Rs. 75000/-","Cash on delivery available."));
        wishlistmodelList.add(new wishlistmodel(R.drawable.hp_laptop,"Samsung Galaxy S22+ 5G","3","Rs. 75000/-","Cash on delivery available."));
        wishlistmodelList.add(new wishlistmodel(R.drawable.phone,"Samsung Galaxy S22+ 5G","3","Rs. 75000/-","Cash on delivery available."));
        wishlistmodelList.add(new wishlistmodel(R.drawable.iphone,"Samsung Galaxy S22+ 5G","3","Rs. 75000/-","Cash on delivery available."));
        wishlistmodelList.add(new wishlistmodel(R.drawable.samsung3,"Samsung Galaxy S22+ 5G","3","Rs. 75000/-","Cash on delivery available."));
        wishlistmodelList.add(new wishlistmodel(R.drawable.samsung6,"Samsung Galaxy S22+ 5G","3","Rs. 75000/-","Cash on delivery available."));
        wishlistmodelList.add(new wishlistmodel(R.drawable.headphone,"Samsung Galaxy S22+ 5G","3","Rs. 75000/-","Cash on delivery available."));
        wishlistmodelList.add(new wishlistmodel(R.drawable.hp_laptop,"Samsung Galaxy S22+ 5G","3","Rs. 75000/-","Cash on delivery available."));

        wishlistadapter wishlistadapter=new wishlistadapter(wishlistmodelList,false);
        recyclerView.setAdapter(wishlistadapter);
        wishlistadapter.notifyDataSetChanged();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()==android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}