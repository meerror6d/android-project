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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link productspecificationfragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class productspecificationfragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private RecyclerView productspecificationrecyclerview;
    public productspecificationfragment() {
        // Required empty public constructor
    }


    public static productspecificationfragment newInstance(String param1, String param2) {
        productspecificationfragment fragment = new productspecificationfragment();
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
        View view= inflater.inflate(R.layout.fragment_productspecificationfragment, container, false);
        productspecificationrecyclerview =view.findViewById(R.id.productspecificationrecyclerview);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(view.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        List<productspecificationmodel>productspecificationmodelList=new ArrayList<>();
        productspecificationmodelList.add(new productspecificationmodel(0,"General"));
        productspecificationmodelList.add(new productspecificationmodel(1,"RAM","4GB"));
        productspecificationmodelList.add(new productspecificationmodel(2,"RAM","4GB"));
        productspecificationmodelList.add(new productspecificationmodel(3,"RAM","4GB"));
        productspecificationmodelList.add(new productspecificationmodel(4,"RAM","4GB"));
        productspecificationmodelList.add(new productspecificationmodel(5,"RAM","4GB"));
        productspecificationmodelList.add(new productspecificationmodel(6,"RAM","4GB"));
        productspecificationmodelList.add(new productspecificationmodel(7,"RAM","4GB"));
        productspecificationmodelList.add(new productspecificationmodel(0,"Display"));
        productspecificationmodelList.add(new productspecificationmodel(1,"RAM","4GB"));
        productspecificationmodelList.add(new productspecificationmodel(1,"RAM","4GB"));
        productspecificationmodelList.add(new productspecificationmodel(1,"RAM","4GB"));
        productspecificationmodelList.add(new productspecificationmodel(1,"RAM","4GB"));
        productspecificationmodelList.add(new productspecificationmodel(1,"RAM","4GB"));
        productspecificationmodelList.add(new productspecificationmodel(0,"General"));
        productspecificationmodelList.add(new productspecificationmodel(1,"RAM","4GB"));
        productspecificationmodelList.add(new productspecificationmodel(1,"RAM","4GB"));
        productspecificationmodelList.add(new productspecificationmodel(1,"RAM","4GB"));
        productspecificationmodelList.add(new productspecificationmodel(1,"RAM","4GB"));
        productspecificationmodelList.add(new productspecificationmodel(1,"RAM","4GB"));
        productspecificationmodelList.add(new productspecificationmodel(1,"RAM","4GB"));
        productspecificationmodelList.add(new productspecificationmodel(1,"RAM","4GB"));
        productspecificationmodelList.add(new productspecificationmodel(0,"Display"));
        productspecificationmodelList.add(new productspecificationmodel(1,"RAM","4GB"));
        productspecificationmodelList.add(new productspecificationmodel(1,"RAM","4GB"));
        productspecificationmodelList.add(new productspecificationmodel(1,"RAM","4GB"));
        productspecificationmodelList.add(new productspecificationmodel(1,"RAM","4GB"));
        productspecificationmodelList.add(new productspecificationmodel(1,"RAM","4GB"));


        productspecificationadapter productspecificationadapters=new productspecificationadapter(productspecificationmodelList);
        productspecificationrecyclerview.setAdapter(productspecificationadapters);
        productspecificationadapters.notifyDataSetChanged();

        return view;
    }
}