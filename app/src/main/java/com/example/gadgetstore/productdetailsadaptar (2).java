package com.example.gadgetstore;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class productdetailsadaptar extends FragmentPagerAdapter{
    private int tabcount;

    public productdetailsadaptar(@NonNull FragmentManager fm, int tabcounts) {
        super(fm);
        this.tabcount=tabcounts;
    }


    @NonNull
    @Override
    public Fragment getItem(int i) {
        switch (i){
            case 0:
                productdescriptionfragment productdescriptionfragment1=new productdescriptionfragment();
                return productdescriptionfragment1;
            case 1:
                productspecificationfragment productspecificationfragment=new productspecificationfragment();
                return productspecificationfragment;
            case 2:
                productdescriptionfragment productdescriptionfragment2=new productdescriptionfragment();
                return productdescriptionfragment2;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabcount;
    }
}
