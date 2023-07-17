package com.example.gadgetstore;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class productimageadapter extends PagerAdapter {

    private List<Integer>productimages;

    public productimageadapter(List<Integer> productimage) {
        this.productimages = productimage;
    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView productimage=new ImageView(container.getContext());
        productimage.setImageResource(productimages.get(position));
        container.addView(productimage,0);
        return productimage;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
       container.removeView((ImageView)object);
    }

    @Override
    public int getCount() {
        return productimages.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }
}
