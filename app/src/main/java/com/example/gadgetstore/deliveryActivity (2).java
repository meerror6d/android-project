package com.example.gadgetstore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class deliveryActivity extends AppCompatActivity {

    private RecyclerView deliveryrecyclerview;
    private Button changeoraddnewaddress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Delivery");

        deliveryrecyclerview=findViewById(R.id.deliveryrecyclerview);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        deliveryrecyclerview.setLayoutManager(layoutManager);

        changeoraddnewaddress=findViewById(R.id.button2);


        List<cartitemmodel> cartitemmodelList= new ArrayList<>();
        cartitemmodelList.add(new cartitemmodel(0,R.drawable.phone,"Galaxy S22+","75,000/- ONLY",1));
        cartitemmodelList.add(new cartitemmodel(0,R.drawable.phone,"Galaxy S22+","75,000/- ONLY",1));
        cartitemmodelList.add(new cartitemmodel(0,R.drawable.phone,"Galaxy S22+","75,000/- ONLY",1));
        cartitemmodelList.add(new cartitemmodel(1,"price (3 items)","Rs 75000","Free","RS 75000"));

        cartadaptar cartadaptar=new cartadaptar(cartitemmodelList);
        deliveryrecyclerview.setAdapter(cartadaptar);
        cartadaptar.notifyDataSetChanged();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id==android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}