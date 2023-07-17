package com.example.gadgetstore;

import static com.example.gadgetstore.MainActivity.showcart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

public class productdetailActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ViewPager productimageviewpager;
    private TabLayout viewpagerindicator;
    private FloatingActionButton addwishlist;
    private static boolean already_added_wish_list=false;
    private ViewPager productdetailsviewpager;
    private TabLayout productdetailstablayout;
    private Button buynowbutton;
    private FirebaseFirestore firebaseFirestore;
    private TextView producttitle;
    private TextView productprice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productdetail);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        productimageviewpager=findViewById(R.id.product_images_viewpage);
        viewpagerindicator=findViewById(R.id.view_pager_indicator);
        addwishlist=findViewById(R.id.add_to_wishlist_button);
        buynowbutton=findViewById(R.id.buynowbutton);

        productdetailsviewpager=findViewById(R.id.productdetailsviewpager);
        productdetailstablayout=findViewById(R.id.productdetailstablayout);
        producttitle=findViewById(R.id.product_title);
        productprice=findViewById(R.id.productprize);

        firebaseFirestore=FirebaseFirestore.getInstance();

        List<String>productimages=new ArrayList<>();

        firebaseFirestore.collection("products").document("xL7C7PnEuFFVCANvmSCH")
                .get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if(task.isSuccessful()){
                            DocumentSnapshot documentSnapshot= task.getResult();

                            for(long x=1;x<(long)documentSnapshot.get("no_of_images")+1;x++){
                                    productimages.add(documentSnapshot.get("product_image_"+x).toString());
                            }
                            productimageadapter productimageadapter=new productimageadapter(productimages);
                            productimageviewpager.setAdapter(productimageadapter);

                            producttitle.setText(documentSnapshot.get("product_title").toString());
                            productprice.setText(documentSnapshot.get("product_price").toString());

                        }
                        else{
                            String error=task.getException().getMessage();
                            Toast.makeText(productdetailActivity.this,error,Toast.LENGTH_SHORT).show();
                        }
                    }
                });

        viewpagerindicator.setupWithViewPager(productimageviewpager,true);

        addwishlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(already_added_wish_list){
                    already_added_wish_list=false;
                    addwishlist.setSupportImageTintList(ColorStateList.valueOf(Color.parseColor("#9e9e9e")));
                }
                else{
                    already_added_wish_list=true;
                    addwishlist.setSupportImageTintList(ColorStateList.valueOf(Color.parseColor("white")));
                }
            }
        });
        productdetailsviewpager.setAdapter(new productdetailsadaptar(getSupportFragmentManager(),productdetailstablayout.getTabCount()));
        productdetailsviewpager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(productdetailstablayout));
        productdetailstablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                productdetailsviewpager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        buynowbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent deliveryIntent=new Intent(productdetailActivity.this,deliveryActivity.class);
                startActivity(deliveryIntent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_and_cart_icon, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(item.getItemId() == android.R.id.home){
            finish();
        }
        else if (id == R.id.search_icon) {
            //showToast("Search");
            return true;
        } else if (id == R.id.cart_icon) {
            Intent cartIntent=new Intent(productdetailActivity.this,MainActivity.class);
            showcart=true;
            startActivity(cartIntent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}