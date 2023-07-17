package com.example.gadgetstore;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class scrolladaptar extends RecyclerView.Adapter<scrolladaptar.ViewHolder> {

    private List<scrollmodel>horizontalscrollmodellist;

    public scrolladaptar(List<scrollmodel> horizontalscrollmodellist) {
        this.horizontalscrollmodellist = this.horizontalscrollmodellist;
    }

    @NonNull
    @Override
    public scrolladaptar.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.horizontalscrollitemlayout,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull scrolladaptar.ViewHolder holder, int position) {

        int resource=horizontalscrollmodellist.get(position).getProductimage();
        String title=horizontalscrollmodellist.get(position).getProducttitle();
        String description=horizontalscrollmodellist.get(position).getProductdescription();
        String prize=horizontalscrollmodellist.get(position).getProductprize();

        holder.setProductimage(resource);
        holder.setProducttitle(title);
        holder.setProductdescription(description);
        holder.setProductprize(prize);
    }

    @Override
    public int getItemCount() {
        return horizontalscrollmodellist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView productimage;
        private TextView producttitle,productdescription,productprize;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            productimage=itemView.findViewById(R.id.phone);
            producttitle=itemView.findViewById(R.id.phone_name);
            productdescription=itemView.findViewById(R.id.ram);
            productprize=itemView.findViewById(R.id.prize);
        }


        private void setProductimage(int resource)
        {
            productimage.setImageResource(resource);
        }
        private void setProducttitle(String title)
        {
            producttitle.setText(title);
        }
        private void setProductdescription(String description)
        {
            productdescription.setText(description);
        }
        private void setProductprize(String prize)
        {
            productprize.setText(prize);
        }
    }
}
