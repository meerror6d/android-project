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

public class horizontalscrolladaptar extends RecyclerView.Adapter<horizontalscrolladaptar.ViewHolder> {

    private List<horizontalscrollmodel>horizontalscrollmodelList;

    public horizontalscrolladaptar(List<horizontalscrollmodel> horizontalscrollmodelList) {
        this.horizontalscrollmodelList = horizontalscrollmodelList;
    }

    @NonNull
    @Override
    public horizontalscrolladaptar.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.horizontalscrollitemlayout,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull horizontalscrolladaptar.ViewHolder viewHolder, int position) {
        String resource=horizontalscrollmodelList.get(position).getProductimage();
        String title=horizontalscrollmodelList.get(position).getProducttitle();
        String description=horizontalscrollmodelList.get(position).getProductdescription();
        String price=horizontalscrollmodelList.get(position).getProductprice();

        viewHolder.setProductImage(resource);
        viewHolder.setProducttitle(title);
        viewHolder.setproductdescription(description);
        viewHolder.setProductprice(price);

    }

    @Override
    public int getItemCount() {
        if(horizontalscrollmodelList.size()>8){
            return 8;
        }
        else {
            return horizontalscrollmodelList.size();
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView productimage;
        private TextView producttitle,productdescription,productprice;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            productimage=itemView.findViewById(R.id.phone);
            producttitle=itemView.findViewById(R.id.phone_name);
            productdescription=itemView.findViewById(R.id.ram);
            productprice=itemView.findViewById(R.id.prize);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent productdetailsintent=new Intent(itemView.getContext(),productdetailActivity.class);
                    itemView.getContext().startActivity(productdetailsintent);
                }
            });
        }

        private void setProductImage(String resource){
            //Glide.with(itemView.getContext()).load(resource).apply(new RequestOptions().placeholder(R.drawable.home)).into(productimage);
        }
        private void setProducttitle(String title){
            producttitle.setText(title);
        }
        private void setproductdescription(String description){
            productdescription.setText(description);
        }
        private void setProductprice(String prize){
            productprice.setText(prize);
        }
    }
}
