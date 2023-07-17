package com.example.gadgetstore;

import android.content.Intent;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.tabs.TabLayout;

import java.util.List;

public class wishlistadapter extends RecyclerView.Adapter<wishlistadapter.ViewHolder> {

    private List<wishlistmodel>wishlistmodelList;
    private boolean wishlist;

    public wishlistadapter(List<wishlistmodel> wishlistmodelList,Boolean wishlist) {
        this.wishlistmodelList = wishlistmodelList;
        this.wishlist=wishlist;
    }

    @NonNull
    @Override
    public wishlistadapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.wishlistitemlayout,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull wishlistadapter.ViewHolder viewHolder, int position) {
        int resources=wishlistmodelList.get(position).getProductimage();
        String title=wishlistmodelList.get(position).getProducttitle();
        String rating=wishlistmodelList.get(position).getRating();
        String productprize=wishlistmodelList.get(position).getProductprice();
        String paymentmehod=wishlistmodelList.get(position).getPaymentmethod();

        viewHolder.setData(resources,title,rating,productprize,paymentmehod);
    }

    @Override
    public int getItemCount() {
        return wishlistmodelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView productimage;
        private TextView producttitle;
        private TextView rating;
        private TextView productprize;
        private TextView paymentmehod;
        private ImageView deletebtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            productimage=itemView.findViewById(R.id.phone2);
            producttitle=itemView.findViewById(R.id.wishlist_product_title2);
            rating=itemView.findViewById(R.id.product_rating_miniview);
            productprize=itemView.findViewById(R.id.productprize);
            paymentmehod=itemView.findViewById(R.id.paymentmethod);
            deletebtn=itemView.findViewById(R.id.deletebtn);

        }
        private void setData(int resources,String title,String ratings,String prize,String payment){
            productimage.setImageResource(resources);
            producttitle.setText(title);
            rating.setText(ratings);
            productprize.setText(prize);
            paymentmehod.setText(payment);
            if(wishlist){
                deletebtn.setVisibility(View.VISIBLE);
            }
            else{
                deletebtn.setVisibility(View.GONE);
            }

            deletebtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(itemView.getContext(),"DELETE",Toast.LENGTH_SHORT).show();
                }
            });

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent productdetailIntent=new Intent(itemView.getContext(),productdetailActivity.class);
                    itemView.getContext().startActivity(productdetailIntent);
                }
            });
        }
    }
}
