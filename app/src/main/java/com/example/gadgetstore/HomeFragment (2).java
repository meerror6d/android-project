package com.example.gadgetstore;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class HomeFragment extends Fragment {

    public HomeFragment(){

    }
    private RecyclerView catagoryrecyclerview;
    private CatagoryAdaptar catagoryAdaptar;
    private  RecyclerView testing;
    private List<CatagoryModel> catagoryModelList;
    private FirebaseFirestore firebaseFirestore;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        catagoryrecyclerview = view.findViewById(R.id.catgoryrecyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        catagoryrecyclerview.setLayoutManager(layoutManager);

        catagoryModelList = new ArrayList<CatagoryModel>();
        //catagoryModelList.add(new CatagoryModel("link","Home"));
        //catagoryModelList.add(new CatagoryModel("link","Brands"));
        //catagoryModelList.add(new CatagoryModel("link","Catagory"));
        //catagoryModelList.add(new CatagoryModel("link","Ancient"));
        //catagoryModelList.add(new CatagoryModel("link","Donation"));

        catagoryAdaptar=new CatagoryAdaptar(catagoryModelList);
        catagoryrecyclerview.setAdapter(catagoryAdaptar);

        firebaseFirestore=FirebaseFirestore.getInstance();
        firebaseFirestore.collection("category").orderBy("index").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            for(QueryDocumentSnapshot documentSnapshot: task.getResult()){
                                catagoryModelList.add(new CatagoryModel(documentSnapshot.get("icon").toString(),documentSnapshot.get("categoryName").toString()));
                            }catagoryAdaptar.notifyDataSetChanged();
                        }else{
                            String error=task.getException().getMessage();
                            Toast.makeText(getContext(),error,Toast.LENGTH_SHORT).show();
                        }
                    }
                });



        ///////////banner slider
        List<slider_model>slidermodelList = new ArrayList<slider_model>();


        //slidermodelList.add(new slider_model(R.drawable.bkash,"000000"));

        slidermodelList.add(new slider_model(R.drawable.asus,"#090202"));
        slidermodelList.add(new slider_model(R.drawable.dell, "#077AE4"));
        slidermodelList.add(new slider_model(R.drawable.bkash,"#077AE4"));

        slidermodelList.add(new slider_model(R.drawable.hp, "#077AE4"));
        slidermodelList.add(new slider_model(R.drawable.winteroffer,"#077AE4"));
        slidermodelList.add(new slider_model(R.drawable.winter, "#077AE4"));
        slidermodelList.add(new slider_model(R.drawable.hp, "#077AE4"));
        slidermodelList.add(new slider_model(R.drawable.winter, "#077AE4"));
        slidermodelList.add(new slider_model(R.drawable.asus,"000000"));

        slidermodelList.add(new slider_model(R.drawable.dell, "#077AE4"));
        slidermodelList.add(new slider_model(R.drawable.bkash,"#077AE4"));
        slidermodelList.add(new slider_model(R.drawable.hp, "#077AE4"));
        ////banner slider


        ////horizontal product
        List<horizontalscrollmodel>horizontalproductscrollmodellist=new ArrayList<>();

        horizontalproductscrollmodellist.add(new horizontalscrollmodel(R.drawable.phone,"Galaxy S22+","128GB 8GB RAM","Unofficial Price: ৳75,000"));
        horizontalproductscrollmodellist.add(new horizontalscrollmodel(R.drawable.samsung1,"Galaxy S22+","128GB 8GB RAM","Unofficial Price: ৳75,000"));
        horizontalproductscrollmodellist.add(new horizontalscrollmodel(R.drawable.samsung3,"Galaxy S22+","128GB 8GB RAM","Unofficial Price: ৳75,000"));
        horizontalproductscrollmodellist.add(new horizontalscrollmodel(R.drawable.samsung2,"Galaxy S22+","128GB 8GB RAM","Unofficial Price: ৳75,000"));
        horizontalproductscrollmodellist.add(new horizontalscrollmodel(R.drawable.samsung5,"Galaxy S22+","128GB 8GB RAM","Unofficial Price: ৳75,000"));
        horizontalproductscrollmodellist.add(new horizontalscrollmodel(R.drawable.samsung4,"Galaxy S22+","128GB 8GB RAM","Unofficial Price: ৳75,000"));
        horizontalproductscrollmodellist.add(new horizontalscrollmodel(R.drawable.samsung6,"Galaxy S22+","128GB 8GB RAM","Unofficial Price: ৳75,000"));
        horizontalproductscrollmodellist.add(new horizontalscrollmodel(R.drawable.hp_laptop,"Galaxy S22+","128GB 8GB RAM","Unofficial Price: ৳75,000"));
        /////horizontal product

        ///////////////////////////////
        testing=view.findViewById(R.id.home_page_recycler_view);
        LinearLayoutManager testingLayoutmanager=new LinearLayoutManager(getContext());
        testingLayoutmanager.setOrientation(LinearLayoutManager.VERTICAL);
        testing.setLayoutManager(testingLayoutmanager);

       List<homepafemodel>homepafemodelList=new ArrayList<>();
       homepafemodelList.add(new homepafemodel(0,slidermodelList));
       homepafemodelList.add(new homepafemodel(1,R.drawable.banner,"#00000000"));
       homepafemodelList.add(new homepafemodel(2,"Deals of the day!",horizontalproductscrollmodellist));
       homepafemodelList.add(new homepafemodel(3,"Trending!",horizontalproductscrollmodellist));

       homepageadaptar homepageadaptar=new homepageadaptar(homepafemodelList);
       testing.setAdapter(homepageadaptar);


        //////////////////

        return view;
    }
}