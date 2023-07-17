package com.example.gadgetstore;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class slider_adaptar extends PagerAdapter {

    private List<slider_model>slidermodelList;

    public slider_adaptar(List<slider_model> slidermodelList) {
        this.slidermodelList = slidermodelList;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.slider_layout,container,false);
        //ConstraintLayout bannarcontainer =view.findViewById(R.id.banner_container);
        //bannarcontainer.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(slidermodelList.get(position).getBackgroundcolor())));

        ImageView banner=view.findViewById(R.id.banner_slide);
        banner.setImageResource(slidermodelList.get(position).getBanner());
        container.addView(view,0);
        return view;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object){
        return view==object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return slidermodelList.size();

    }
}
