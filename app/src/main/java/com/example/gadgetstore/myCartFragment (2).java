package com.example.gadgetstore;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class myCartFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public myCartFragment() {
        // Required empty public constructor
    }
    private RecyclerView cartitemrecyclerview;
    private Button continuebtn;



    public static myCartFragment newInstance(String param1, String param2) {
        myCartFragment fragment = new myCartFragment();
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
        // Inflate the layout for this fragment
        View view=  inflater.inflate(R.layout.my_cart_fragment, container, false);
        cartitemrecyclerview=view.findViewById(R.id.cart_items_recyclerview);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        cartitemrecyclerview.setLayoutManager(layoutManager);
        continuebtn=view.findViewById(R.id.cart_continue_button);

        List<cartitemmodel>cartitemmodelList= new ArrayList<>();
        cartitemmodelList.add(new cartitemmodel(0,R.drawable.phone,"Galaxy S22+","75,000/- ONLY",1));
        cartitemmodelList.add(new cartitemmodel(0,R.drawable.phone,"Galaxy S22+","75,000/- ONLY",1));
        cartitemmodelList.add(new cartitemmodel(0,R.drawable.phone,"Galaxy S22+","75,000/- ONLY",1));
        cartitemmodelList.add(new cartitemmodel(1,"price (3 items)","Rs 75000","Free","RS 75000"));

        cartadaptar cartadaptar=new cartadaptar(cartitemmodelList);
        cartitemrecyclerview.setAdapter(cartadaptar);
        cartadaptar.notifyDataSetChanged();

        continuebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent deliveryIntent=new Intent(continuebtn.getContext(),deliveryActivity.class);
                continuebtn.getContext().startActivity(deliveryIntent);
            }
        });

        return view;
    }
}