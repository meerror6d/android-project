package com.example.gadgetstore;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class CatagoryAdaptar extends RecyclerView.Adapter<CatagoryAdaptar.ViewHolder>{

    private List<CatagoryModel> catagoryModelList;

    public CatagoryAdaptar(List<CatagoryModel> catagoryModelList) {
        this.catagoryModelList = catagoryModelList;
    }

    @NonNull
    @Override
    public CatagoryAdaptar.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.catagory_item,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CatagoryAdaptar.ViewHolder viewHolder, int i) {
        String icon=catagoryModelList.get(i).getCatagoryiconlink();
        String name=catagoryModelList.get(i).getCatagoryname();
        viewHolder.setCatagory(name,i);
        viewHolder.setCatagoryicon(icon);
    }

    @Override
    public int getItemCount() {
        return catagoryModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView catagoryicon;
        private TextView catagory;

         public ViewHolder(@NonNull View itemView) {
            super(itemView);
            catagoryicon=itemView.findViewById(R.id.home);
            catagory=itemView.findViewById(R.id.home2);
        }

        private void setCatagoryicon(String iconurl){
             if(!iconurl.equals("null")) {
                 Glide.with(itemView.getContext()).load(iconurl).apply(new RequestOptions().placeholder(R.drawable.home)).into(catagoryicon);
             }
        }
        private void setCatagory(final String name,final int position){
             catagory.setText(name);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(position !=0) {
                        Intent catagoryIntent = new Intent(itemView.getContext(), catagoryActivity.class);
                        catagoryIntent.putExtra("catagory", name);
                        itemView.getContext().startActivity(catagoryIntent);
                    }
                }
            });
        }

    }
}