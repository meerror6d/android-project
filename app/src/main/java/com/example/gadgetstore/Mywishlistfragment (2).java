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

public class Mywishlistfragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public Mywishlistfragment() {
        // Required empty public constructor
    }

    private RecyclerView wishlistrecyclerview;

    public static Mywishlistfragment newInstance(String param1, String param2) {
        Mywishlistfragment fragment = new Mywishlistfragment();
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
        View view= inflater.inflate(R.layout.mywishlistfragment, container, false);
        wishlistrecyclerview=view.findViewById(R.id.my_wishlist_recyclerview);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        wishlistrecyclerview.setLayoutManager(linearLayoutManager);

        List<wishlistmodel>wishlistmodelList=new ArrayList<>();
        wishlistmodelList.add(new wishlistmodel(R.drawable.phone,"Samsung Galaxy S22+ 5G","3","Rs. 75000/-","Cash on delivery available."));
        wishlistmodelList.add(new wishlistmodel(R.drawable.iphone,"Samsung Galaxy S22+ 5G","3","Rs. 75000/-","Cash on delivery available."));
        wishlistmodelList.add(new wishlistmodel(R.drawable.samsung3,"Samsung Galaxy S22+ 5G","3","Rs. 75000/-","Cash on delivery available."));
        wishlistmodelList.add(new wishlistmodel(R.drawable.samsung6,"Samsung Galaxy S22+ 5G","3","Rs. 75000/-","Cash on delivery available."));
        wishlistmodelList.add(new wishlistmodel(R.drawable.headphone,"Samsung Galaxy S22+ 5G","3","Rs. 75000/-","Cash on delivery available."));
        wishlistmodelList.add(new wishlistmodel(R.drawable.hp_laptop,"Samsung Galaxy S22+ 5G","3","Rs. 75000/-","Cash on delivery available."));

        wishlistadapter wishlistadapter=new wishlistadapter(wishlistmodelList,true);
        wishlistrecyclerview.setAdapter(wishlistadapter);
        wishlistadapter.notifyDataSetChanged();

        return view;
    }
}