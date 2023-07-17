package com.example.gadgetstore;

import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class cartadaptar extends RecyclerView.Adapter {

    private List<cartitemmodel>cartitrmmodellist;

    public cartadaptar(List<cartitemmodel> cartitrmmodellist) {
        this.cartitrmmodellist = cartitrmmodellist;
    }

    @Override
    public int getItemViewType(int position) {
        switch (cartitrmmodellist.get(position).getType()){
            case 0:
                return cartitemmodel.cart_item;
            case 1:
                return cartitemmodel.cart_amount;
            default:
                return -1;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        switch (viewType) {
            case cartitemmodel.cart_item:
                View cartitemview = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cart_item_layout,viewGroup,false);
                return new cartitemviewholder(cartitemview);
            case cartitemmodel.cart_amount:
                View carttotalview = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cart_total_amount_layout,viewGroup,false);
                return new carttotalamountviewholder(carttotalview);
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        switch (cartitrmmodellist.get(position).getType()){
                case cartitemmodel.cart_item:
                    int resource=cartitrmmodellist.get(position).getProductimage();
                    String title=cartitrmmodellist.get(position).getProducttitle();
                    String productprice=cartitrmmodellist.get(position).getProductprice();

                    ((cartitemviewholder)viewHolder).setitemdetails(resource,title,productprice);
                    break;
                case cartitemmodel.cart_amount:
                    String totalitems= cartitrmmodellist.get(position).getTotalitems();
                    String totalamount= cartitrmmodellist.get(position).getTotalamount();
                    String deliveryprice= cartitrmmodellist.get(position).getDeliveryprice();
                    String TotalAmount= cartitrmmodellist.get(position).getTotalAmount();

                    ((carttotalamountviewholder)viewHolder).setTotalamount(totalitems,totalamount,deliveryprice,TotalAmount);

            default:
                    return;
        }

    }

    @Override
    public int getItemCount() {
        return cartitrmmodellist.size();
    }

    class cartitemviewholder extends RecyclerView.ViewHolder{
        private ImageView productimage;
        private TextView producttitle;
        private TextView productprice;
        private TextView productquantity;


        public cartitemviewholder(@NonNull View itemView) {
            super(itemView);
            productimage=itemView.findViewById(R.id.product_image);
            producttitle=itemView.findViewById(R.id.product_title2);
            productprice=itemView.findViewById(R.id.product_price);
            productquantity=itemView.findViewById(R.id.product_quantity);
        }
        private void setitemdetails(int resource,String title,String price){
            productimage.setImageResource(resource);
            producttitle.setText(title);
            productprice.setText(price);
            //productquantity.setText(quantity);

            productquantity.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Dialog quantitydialog=new Dialog(itemView.getContext());
                    quantitydialog.setContentView(R.layout.quantity_dialog);
                    quantitydialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
                    quantitydialog.setCancelable(false);
                    EditText quantityno=quantitydialog.findViewById(R.id.quantity);
                    Button cancelbtn=quantitydialog.findViewById(R.id.cancelbtn);
                    Button okbtn=quantitydialog.findViewById(R.id.okbtn);

                    cancelbtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            quantitydialog.dismiss();
                        }
                    });

                    okbtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            productquantity.setText("Qty :"+ quantityno.getText());
                            quantitydialog.dismiss();
                        }
                    });
                    quantitydialog.show();
                }
            });
        }
    }

    class carttotalamountviewholder extends RecyclerView.ViewHolder{

        private TextView totalitems;
        private TextView totalprice;
        private TextView deliveryprice;
        private TextView totalamount;

        public carttotalamountviewholder(@NonNull View itemView) {
            super(itemView);

            totalitems=itemView.findViewById(R.id.total_items);
            totalprice=itemView.findViewById(R.id.total_items_price);
            deliveryprice=itemView.findViewById(R.id.delivery_charge);
            totalamount=itemView.findViewById(R.id.total_price);
        }

        private void setTotalamount(String totalitemtext,String totalitempricetext,String deliverypricetext,String totalamounttext){
            totalitems.setText(totalitemtext);
            totalprice.setText(totalitempricetext);
            totalamount.setText(totalamounttext);
            deliveryprice.setText(deliverypricetext);
        }
    }
}
