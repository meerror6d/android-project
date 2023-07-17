package com.example.gadgetstore;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class myordersfragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public myordersfragment() {

    }
    private RecyclerView myorderrecyclerview;

    public static myordersfragment newInstance(String param1, String param2) {
        myordersfragment fragment = new myordersfragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.myordersfragment, container, false);

        myorderrecyclerview=view.findViewById(R.id.my_orders_recyclerview);
        LinearLayoutManager LayoutManager=new LinearLayoutManager(getContext());
        LayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        myorderrecyclerview.setLayoutManager(LayoutManager);

        List<myorederitemmodel>myorederitemmodelList=new ArrayList<>();
        myorederitemmodelList.add(new myorederitemmodel(R.drawable.phone,2,"Samsung Galaxy S22+ 5G(black)","Delivered on monday, 15th jan, 2022", "128GB 8GB RAM"));
        myorederitemmodelList.add(new myorederitemmodel(R.drawable.hp_laptop,1,"HP 15s AMD Athlon FHD Laptop","Delivered on monday, 30th july, 2022", "Model: 15s-eq1548AU"));
        myorederitemmodelList.add(new myorederitemmodel(R.drawable.headphone,0,"KVIDIO Bluetooth Headphone","CANCELLED", "55 Hours Playtime Wireless Headphones with Microphone"));
        myorederitemmodelList.add(new myorederitemmodel(R.drawable.airpods,4,"Apple AirPods Pro 2021","Delivered on monday,25th fab,2022", "with Magsafe Charging Case, Apple International Warranty (Claim support)"));
        myorederitemmodelList.add(new myorederitemmodel(R.drawable.iphone,2,"iPhone 13","Delivered on monday,31 jan ,2022", "6.1-inch display1"));

        myorderadapter myorderadapter=new myorderadapter(myorederitemmodelList);
        myorderrecyclerview.setAdapter(myorderadapter);
        myorderadapter.notifyDataSetChanged();

        return  view;
    }
}