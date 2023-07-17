package com.example.gadgetstore;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class productspecificationadapter extends RecyclerView.Adapter<productspecificationadapter.ViewHolder> {
    private List<productspecificationmodel>productspecificationmodelList;

    public productspecificationadapter(List<productspecificationmodel> productspecificationmodelList) {
        this.productspecificationmodelList = productspecificationmodelList;
    }

    @Override
    public int getItemViewType(int position) {
        switch (productspecificationmodelList.get(position).getType()){
            case 0:
                return productspecificationmodel.specification_title;
            case 1:
                return productspecificationmodel.specification_body;
            default:
                return -1;
        }
    }

    @NonNull
    @Override
    public productspecificationadapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        switch (viewType){
            case productspecificationmodel.specification_title:
                TextView title=new TextView(viewGroup.getContext());
                title.setTypeface(null, Typeface.BOLD);
                title.setTextColor(Color.parseColor("#000000"));
                LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
                layoutParams.setMargins(setDp(16,viewGroup.getContext())
                        ,setDp(16,viewGroup.getContext()),
                        setDp(16,viewGroup.getContext()),
                        setDp(8,viewGroup.getContext()));

                title.setLayoutParams(layoutParams);
                return new ViewHolder(title);

            case productspecificationmodel.specification_body:
                View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.productspecificationitemlayout,viewGroup,false);
                return new ViewHolder(view);
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull productspecificationadapter.ViewHolder viewHolder, int position){
       switch (productspecificationmodelList.get(position).getType()){
           case productspecificationmodel.specification_title:
               viewHolder.setTitle(productspecificationmodelList.get(position).getTitle());
               break;
           case productspecificationmodel.specification_body:
               String featureTitle=productspecificationmodelList.get(position).getFeaturename();
               String featureDetail=productspecificationmodelList.get(position).getFeaturevalue();
               break;
           default:
               return;

       }
    }

    @Override
    public int getItemCount() {
        return productspecificationmodelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView featurename;
        private TextView featurevalue;
        private TextView title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        private void setTitle(String titleText){
            title = (TextView) itemView;
            title.setText(titleText);
        }
    }

    private int setDp(int dp,Context context){
         return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,dp,context.getResources().getDisplayMetrics());
    }
}
