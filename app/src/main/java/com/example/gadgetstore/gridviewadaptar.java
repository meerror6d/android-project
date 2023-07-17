package com.example.gadgetstore;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import org.w3c.dom.Text;

import java.util.List;

public class gridviewadaptar extends BaseAdapter {

    List<horizontalscrollmodel>horizontalscrollmodelList;

    public gridviewadaptar(List<horizontalscrollmodel>horizontalscrollmodelList) {
        this.horizontalscrollmodelList=horizontalscrollmodelList;
    }

    @Override
    public int getCount() {
        return horizontalscrollmodelList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view ;
        if(convertView==null){
            view= LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontalscrollitemlayout,null);
            view.setElevation(0);
            view.setBackgroundColor(Color.parseColor("#ffffff"));
            ImageView productimage=view.findViewById(R.id.phone);
            TextView producttitle=view.findViewById(R.id.phone_name);
            TextView productdescription=view.findViewById(R.id.ram);
            TextView productprize=view.findViewById(R.id.prize);

            Glide.with(parent.getContext()).load(horizontalscrollmodelList.get(position).getProductimage()).
                    apply(new RequestOptions().placeholder(R.drawable.home)).into(productimage);
            //productimage.setImageResource(horizontalscrollmodelList.get(position).getProductimage());
            producttitle.setText(horizontalscrollmodelList.get(position).getProducttitle());
            productdescription.setText(horizontalscrollmodelList.get(position).getProductdescription());
            productprize.setText(horizontalscrollmodelList.get(position).getProductprice());
        }
        else{
            view=convertView;
        }return view;
    }
}
