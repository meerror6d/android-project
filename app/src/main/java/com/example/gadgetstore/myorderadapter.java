package com.example.gadgetstore;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class myorderadapter extends RecyclerView.Adapter<myorderadapter.ViewHolder> {

    private List<myorederitemmodel>myorederitemmodelList;

    public myorderadapter(List<myorederitemmodel> myorederitemmodelList) {
        this.myorederitemmodelList = myorederitemmodelList;
    }

    @NonNull
    @Override
    public myorderadapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.myorderitemlayout,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myorderadapter.ViewHolder viewHolder, int position) {
        int resource=myorederitemmodelList.get(position).getProductimage();
        int rating=myorederitemmodelList.get(position).getRating();
        String title=myorederitemmodelList.get(position).getProducttitle();
        String deliverydate=myorederitemmodelList.get(position).getDelivery_status();
        String productdescription=myorederitemmodelList.get(position).getProductdescription();
        viewHolder.setData(resource,title,deliverydate,rating,productdescription);
    }

    @Override
    public int getItemCount() {
        return myorederitemmodelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView productimage;
        private ImageView deliveryindicator;
        private TextView producttitle;
        private TextView productdescription;
        private TextView deliverystatus;
        private LinearLayout ratenowcontainer;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            productimage=itemView.findViewById(R.id.imageView);
            producttitle=itemView.findViewById(R.id.textView2);
            deliveryindicator=itemView.findViewById(R.id.imageView3);
            productdescription=itemView.findViewById(R.id.textView4);
            deliverystatus=itemView.findViewById(R.id.textView5);
            ratenowcontainer=itemView.findViewById(R.id.rate_now_container);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent orderdetailintent=new Intent(itemView.getContext(),orderdetailsactivity.class);
                    itemView.getContext().startActivity(orderdetailintent);
                }
            });

        }
        private void setData(int resources, String title, String status, int rating, String productsecrtption){
            productimage.setImageResource(resources);
            producttitle.setText(title);
            if(status.equals("CANCELLED")){
                deliveryindicator.setImageTintList(ColorStateList.valueOf(itemView.getContext().getResources().getColor(R.color.black)));
            }
            else{
                deliveryindicator.setImageTintList(ColorStateList.valueOf(itemView.getContext().getResources().getColor(R.color.teal_700)));

            }
            deliverystatus.setText(status);

            //rating layout
            setrating(rating);
            for(int x=0;x<ratenowcontainer.getChildCount();x++){
                final int starposition=x;
                ratenowcontainer.getChildAt(x).setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        setrating(starposition);
                    }
                });
            }
            //rating layout
        }

        private void setrating(int starposition){
            for(int x=0;x<ratenowcontainer.getChildCount();x++){
                ImageView starbtn= (ImageView) ratenowcontainer.getChildAt(x);
                starbtn.setImageTintList(ColorStateList.valueOf(Color.parseColor("#bebebe")));
                if(x<=starposition){
                    starbtn.setImageTintList(ColorStateList.valueOf(Color.parseColor("#ffbb00")));

                }
            }
        }
    }
}
