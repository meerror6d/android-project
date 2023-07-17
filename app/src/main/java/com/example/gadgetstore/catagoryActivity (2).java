package com.example.gadgetstore;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class catagoryActivity extends AppCompatActivity {

    private RecyclerView catagoryrecyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catagory);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String title=getIntent().getStringExtra("catagory");
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayShowTitleEnabled(true);

        catagoryrecyclerview=findViewById(R.id.catagory_recycler_view);

        List<slider_model> slidermodelList = new ArrayList<slider_model>();

        slidermodelList.add(new slider_model(R.drawable.ic_baseline_info_24, "#077AE4"));
        slidermodelList.add(new slider_model(R.drawable.ic_baseline_shopping_cart_24, "#077AE4"));
        slidermodelList.add(new slider_model(R.mipmap.ic_launcher_round,"#077AE4"));

        slidermodelList.add(new slider_model(R.drawable.ic_baseline_search_24, "#077AE4"));
        slidermodelList.add(new slider_model(R.drawable.ic_baseline_mail_24,"#077AE4"));
        slidermodelList.add(new slider_model(R.drawable.ic_baseline_person_24, "#077AE4"));
        slidermodelList.add(new slider_model(R.drawable.ic_baseline_shopping_basket_24, "#077AE4"));
        slidermodelList.add(new slider_model(R.drawable.ic_baseline_store_mall_directory_24, "#077AE4"));
        slidermodelList.add(new slider_model(R.drawable.ic_baseline_info_24, "#077AE4"));

        slidermodelList.add(new slider_model(R.drawable.ic_baseline_shopping_cart_24, "#077AE4"));
        slidermodelList.add(new slider_model(R.mipmap.ic_launcher_round,"#077AE4"));
        slidermodelList.add(new slider_model(R.drawable.ic_baseline_search_24, "#077AE4"));

        ////banner slider

        ////horizontal product
        List<horizontalscrollmodel>horizontalproductscrollmodellist=new ArrayList<>();

        horizontalproductscrollmodellist.add(new horizontalscrollmodel(R.drawable.phone,"Galaxy S22+","128GB 8GB RAM","Unofficial Price: ৳75,000"));
        horizontalproductscrollmodellist.add(new horizontalscrollmodel(R.drawable.phone,"Galaxy S22+","128GB 8GB RAM","Unofficial Price: ৳75,000"));
        horizontalproductscrollmodellist.add(new horizontalscrollmodel(R.drawable.phone,"Galaxy S22+","128GB 8GB RAM","Unofficial Price: ৳75,000"));
        horizontalproductscrollmodellist.add(new horizontalscrollmodel(R.drawable.phone,"Galaxy S22+","128GB 8GB RAM","Unofficial Price: ৳75,000"));
        horizontalproductscrollmodellist.add(new horizontalscrollmodel(R.drawable.phone,"Galaxy S22+","128GB 8GB RAM","Unofficial Price: ৳75,000"));
        horizontalproductscrollmodellist.add(new horizontalscrollmodel(R.drawable.phone,"Galaxy S22+","128GB 8GB RAM","Unofficial Price: ৳75,000"));
        horizontalproductscrollmodellist.add(new horizontalscrollmodel(R.drawable.phone,"Galaxy S22+","128GB 8GB RAM","Unofficial Price: ৳75,000"));
        horizontalproductscrollmodellist.add(new horizontalscrollmodel(R.drawable.phone,"Galaxy S22+","128GB 8GB RAM","Unofficial Price: ৳75,000"));
        /////horizontal product

        LinearLayoutManager testingLayoutmanager=new LinearLayoutManager(this);
        testingLayoutmanager.setOrientation(LinearLayoutManager.VERTICAL);
        catagoryrecyclerview.setLayoutManager(testingLayoutmanager);

        List<homepafemodel>homepafemodelList=new ArrayList<>();
        homepafemodelList.add(new homepafemodel(0,slidermodelList));
        homepafemodelList.add(new homepafemodel(1,R.drawable.banner,"#00000000"));
        homepafemodelList.add(new homepafemodel(0,slidermodelList));
        homepafemodelList.add(new homepafemodel(1,R.drawable.banner,"#00000000"));
        homepafemodelList.add(new homepafemodel(0,slidermodelList));
        homepafemodelList.add(new homepafemodel(1,R.drawable.banner,"#00000000"));

        homepageadaptar homepageadaptar=new homepageadaptar(homepafemodelList);
        catagoryrecyclerview.setAdapter(homepageadaptar);
        homepageadaptar.notifyDataSetChanged();
    }

    private void setSupportActionBar(Toolbar toolbar) {
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.searchicon,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.search_icon) {
            //showToast("Search");
            return true;
        }
        else if(id==android.R.id.home){
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}