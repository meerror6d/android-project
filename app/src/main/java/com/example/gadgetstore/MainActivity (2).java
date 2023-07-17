package com.example.gadgetstore;

import static com.example.gadgetstore.R.id.actionbarname;
import static com.example.gadgetstore.R.id.register;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity {

    private static final int Home_fragment=0;
    private static final int cart_fragment=1;
    private static final int orders_fragment=2;
    private static final int wishlist_fragment=3;

    public static boolean showcart=false;

    private AppBarConfiguration mAppBarConfiguration;

    private Toolbar toolbar;

    private DrawerLayout drawerLayout;
    private NavigationView navView;
    private NavController navController;

    private FrameLayout frameLayout;
    private int currentfragment=-1;
    private TextView actionbarname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        View view = findViewById(R.id.app_bar_main);

        toolbar = view.findViewById(R.id.toolbar);
        actionbarname=findViewById(R.id.actionbarname);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);

        navView = findViewById(R.id.nav_view);

        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_store,R.id.nav_orders, R.id.nav_cart, R.id.nav_wishlist,R.id.contactus,R.id.privacypolicy,R.id.aboutus,R.id.signout)
                .setOpenableLayout(drawerLayout)
                .build();

        navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if(navController == null) return false;

                if(item.getItemId()==R.id.nav_store){
                    actionbarname.setVisibility(View.VISIBLE);
                    invalidateOptionsMenu();
                    setFragment(new HomeFragment(),Home_fragment);
                }

                else if(item.getItemId()==R.id.nav_cart ){
                    gotofragment("My Cart",new myCartFragment(),cart_fragment);
                }

                else if(item.getItemId() == R.id.nav_orders){
                    gotofragment("My Orders",new myordersfragment(),orders_fragment);
                }
                else if(item.getItemId() ==R.id.nav_wishlist){
                    gotofragment("My Wishlist",new Mywishlistfragment(),wishlist_fragment);
                }

                else if(item.getItemId() == R.id.contactus){
                    contactUs();
                    return false;
                }
                else if(item.getItemId() == R.id.privacypolicy){
                    showPolicy();
                    return false;
                }
                else if(item.getItemId() == R.id.aboutus){
                    showAboutUs();
                    return false;
                }
                else if(item.getItemId() == R.id.signout){
                    signOutUser();
                    return false;
                }

                int id = item.getItemId();
                if(id == R.id.nav_store || id == R.id.nav_orders || id == R.id.nav_wishlist || id == R.id.nav_cart){
                    /*
                    navController.navigate(id);
                    navView.setCheckedItem(id);
                    */
                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                return true;
            }
        });
        navView.getMenu().getItem(0).setChecked(true);

        frameLayout=findViewById(R.id.nav_host_fragment_content_main);
        if(showcart){
            drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

                gotofragment("My Cart ",new myCartFragment(),-2);
        }
        else {
            setFragment(new HomeFragment(), Home_fragment);
        }



    }

    public void onBackPressed(){
        DrawerLayout drawer=(DrawerLayout) findViewById(R.id.drawer_layout);
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }
        else{
            if(currentfragment==Home_fragment){
                super.onBackPressed();
            }
            else{
                if(showcart){
                    showcart=false;
                    finish();
                }
                else {
                    actionbarname.setVisibility(View.VISIBLE);
                    invalidateOptionsMenu();
                    setFragment(new HomeFragment(), Home_fragment);
                    navView.getMenu().getItem(0).setChecked(true);
                }
            }
        }
    }

    private void contactUs(){
        //rest of the code for contact us
        showToast("Contact us");
    }

    private void showAboutUs(){
        //rest of the code for about us
        showToast("About us");
    }

    private void showPolicy(){
        //rest of the code for policy
        showToast("Policy clicked");
    }

    private void signOutUser(){
        //rest of the code for sign out
        showToast("sign out clicked");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if(currentfragment==Home_fragment) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getMenuInflater().inflate(R.menu.main, menu);
        } return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.search_icon) {
            showToast("Search");
            return true;
        } else if (id == R.id.notification_icon) {
            showToast("Notification");
            return true;
        } else if (id == R.id.cart_icon) {
            final Dialog sign_in_dialog = new Dialog(MainActivity.this);

            sign_in_dialog.setContentView(R.layout.sign_in_dialog);
            sign_in_dialog.setCancelable(true);
            sign_in_dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);

            Button dialogsigninbtn=sign_in_dialog.findViewById(R.id.sign_in_btn);
            Button dialogsignupbtn=sign_in_dialog.findViewById(R.id.sign_up_btn);

            dialogsigninbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    sign_in_dialog.dismiss();
                    Intent loginIntent=new Intent(MainActivity.this,LoginAcitivty.class);
                    startActivity(loginIntent);
                }
            });

            dialogsignupbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    sign_in_dialog.dismiss();
                    Intent registerIntent=new Intent(MainActivity.this,RegisterActivity.class);
                    startActivity(registerIntent);
                }
            });
            sign_in_dialog.show();
            //gotofragment("My Cart",new myCartFragment(),cart_fragment);
            return true;
        }
        else if(id==android.R.id.home){
            if(showcart){
                showcart=false;
                finish();
            }
        }
        return super.onOptionsItemSelected(item);
    }

    private void gotofragment(String title,Fragment fragment,int fragmentno) {
        actionbarname.setVisibility(View.GONE);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle(title);
        invalidateOptionsMenu();
        setFragment(fragment,fragmentno);
        if(fragmentno==cart_fragment){
            navView.getMenu().getItem(2).setChecked(true);
        }

    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    private void showToast(String message){
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }

    private void setFragment(Fragment fragment,int fragmentno){
        if(fragmentno!=currentfragment){
            currentfragment=fragmentno;
            FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(frameLayout.getId(),fragment);
            fragmentTransaction.commit();
        }

    }



}
