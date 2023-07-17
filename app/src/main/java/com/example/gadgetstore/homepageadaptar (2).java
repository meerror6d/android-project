package com.example.gadgetstore;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class homepageadaptar extends RecyclerView.Adapter {

    private List<homepafemodel>homepafemodelList;
    private RecyclerView.RecycledViewPool recyclerviewpool;

    public homepageadaptar(List<homepafemodel>homepafemodelList){
        this.homepafemodelList=homepafemodelList;
        recyclerviewpool=new RecyclerView.RecycledViewPool();
    }

    @Override
    public int getItemViewType(int position) {
        switch (homepafemodelList.get(position).getType()) {
            case 0:
                return homepafemodel.BANNER_SLIDER;
            case 1:
                return homepafemodel.STRIP_ADD_SLIDER;
            case 2:
                return homepafemodel.HORIZONTAL_VIEW;
            case 3:
                return homepafemodel.gridproductview;
            default:
                return -1;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        switch (viewType) {
            case homepafemodel.BANNER_SLIDER:
                View Bannersliderview = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sliding_add_banner, viewGroup, false);
                return new Bannersliderviewholder(Bannersliderview);
            case homepafemodel.STRIP_ADD_SLIDER:
                View Stripadview = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.strip_ad_layout, viewGroup, false);
                return new stripaddbannerviewholdwer(Stripadview);
            case homepafemodel.HORIZONTAL_VIEW:
                View Horizontalview = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.horizontalscrolllayout, viewGroup, false);
                return new horizontalviewholder(Horizontalview);
            case homepafemodel.gridproductview:
                View gridproductview = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.grid_product_view, viewGroup, false);
                return new gridproductviewholder(gridproductview);
            default:
                return null;
        }
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        switch (homepafemodelList.get(position).getType()){
            case homepafemodel.BANNER_SLIDER:
                List<slider_model>slidermodelList = homepafemodelList.get(position).getSlidermodelList();
                ((Bannersliderviewholder)viewHolder).setBannersliderviewpager(slidermodelList);
                break;
            case homepafemodel.STRIP_ADD_SLIDER:
                int resource=homepafemodelList.get(position).getResource();
                String color=homepafemodelList.get(position).getBackgroundcolor();
                ((stripaddbannerviewholdwer)viewHolder).stripadd(resource,color);
                break;
            case homepafemodel.HORIZONTAL_VIEW:
                    String horizontaltitle=homepafemodelList.get(position).getTitle();
                    List<horizontalscrollmodel>horizontalscrollmodelList=homepafemodelList.get(position).getHorizontalscrollmodelList();
                ((horizontalviewholder)viewHolder).horizontalproductLayout(horizontalscrollmodelList,horizontaltitle);
                break;
            case homepafemodel.gridproductview:
                String gridtitle=homepafemodelList.get(position).getTitle();
                List<horizontalscrollmodel>gridlmodelList=homepafemodelList.get(position).getHorizontalscrollmodelList();
                ((gridproductviewholder)viewHolder).setGridlayout(gridlmodelList,gridtitle);
                break;
            default:
                return ;
        }
    }

    @Override
    public int getItemCount() {
        return homepafemodelList.size();
    }

    public class Bannersliderviewholder extends RecyclerView.ViewHolder {
        private ViewPager bannersliderviewpager;
        private int currentpage;
        private Timer timer;
        final private long Delay_time=3000;
        final private long Period_time=3000;

        public Bannersliderviewholder(@NonNull View itemView) {
            super(itemView);
            bannersliderviewpager=itemView.findViewById(R.id.banner_slider_viewpager);

            bannersliderviewpager.setCurrentItem(currentpage);
        }

        private void setBannersliderviewpager(final List<slider_model>slidermodelList){
            currentpage=2;
            if(timer!=null){
                timer.cancel();
            }

            slider_adaptar sliderAdaptar=new slider_adaptar(slidermodelList);
            bannersliderviewpager.setAdapter(sliderAdaptar);
            bannersliderviewpager.setClipToPadding(false);
            bannersliderviewpager.setPageMargin(20);

            bannersliderviewpager.setCurrentItem(currentpage);

            ViewPager.OnPageChangeListener onPageChangeListener=new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }
                @Override
                public void onPageSelected(int position) {
                    currentpage=position;
                }

                @Override
                public void onPageScrollStateChanged(int state) {
                    if(state==ViewPager.SCROLL_STATE_IDLE){
                        pageLooper(slidermodelList);
                    }
                }
            };
            bannersliderviewpager.addOnPageChangeListener(onPageChangeListener);
            startBannerSliderShow(slidermodelList);

            bannersliderviewpager.setOnTouchListener((v, event) -> {
                pageLooper(slidermodelList);
                stopBannerSlideShow();
                if(event.getAction()== MotionEvent.ACTION_UP){
                    startBannerSliderShow(slidermodelList);
                }return false;
            });
        }

        private void pageLooper(List<slider_model>slidermodelList){
            if(currentpage==slidermodelList.size()-2){
                currentpage=2;
                bannersliderviewpager.setCurrentItem(currentpage,false);
            }
            if(currentpage==1){
                currentpage=slidermodelList.size()-3;
                bannersliderviewpager.setCurrentItem(currentpage,false);
            }
        }

        private void startBannerSliderShow(List<slider_model>slidermodelList){
            Handler handler=new Handler();
            Runnable update=new Runnable() {
                @Override
                public void run() {
                    if(currentpage>=slidermodelList.size()){
                        currentpage=1;
                    }
                    bannersliderviewpager.setCurrentItem(currentpage++,true);
                }
            };
            timer=new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    handler.post(update);
                }
            },Delay_time,Period_time);
        }

        private void stopBannerSlideShow(){
            timer.cancel();
        }
    }

    public class stripaddbannerviewholdwer extends RecyclerView.ViewHolder{

        private ImageView stripimage;
        private ConstraintLayout strpadcontainer;
         public stripaddbannerviewholdwer(@NonNull View itemView) {
            super(itemView);
             stripimage=itemView.findViewById(R.id.strip_ad_image);
             strpadcontainer=itemView.findViewById(R.id.strip_ad_container);
        }

        private void stripadd(int resource,String color ){
            stripimage.setImageResource(resource);
            stripimage.setBackgroundColor(Color.parseColor(color));
        }
    }

    public class horizontalviewholder extends RecyclerView.ViewHolder{

        private TextView horizontalLayouttitle;
        private Button horizontalLayoutbtn;
        private RecyclerView horizontalrecyclerview;

        public horizontalviewholder(@NonNull View itemView) {
            super(itemView);

            horizontalLayouttitle=itemView.findViewById(R.id.horizontal_scrolllayout_ttile);
            horizontalLayoutbtn=itemView.findViewById(R.id.horizontal_scroll_layout_btn);
            horizontalrecyclerview=itemView.findViewById(R.id.horizontal_recyclerview);
            horizontalrecyclerview.setRecycledViewPool(recyclerviewpool);

        }
        public void horizontalproductLayout(@NonNull List<horizontalscrollmodel>horizontalscrollmodelList, String title){
            horizontalLayouttitle.setText(title);
            if(horizontalscrollmodelList.size()>8){
                horizontalLayoutbtn.setVisibility(View.VISIBLE);
                horizontalLayoutbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent viewallIntent=new Intent(itemView.getContext(),vieallactivity.class);
                        viewallIntent.putExtra("layout_code",0);
                        itemView.getContext().startActivity(viewallIntent);
                    }
                });
            }

           horizontalscrolladaptar horizontalscrolladaptar =new horizontalscrolladaptar(horizontalscrollmodelList);
            LinearLayoutManager linearLayoutManager=new LinearLayoutManager(itemView.getContext());
            linearLayoutManager.setOrientation(linearLayoutManager.HORIZONTAL);
            horizontalrecyclerview.setLayoutManager(linearLayoutManager);

            horizontalrecyclerview.setAdapter(horizontalscrolladaptar);
            horizontalscrolladaptar.notifyDataSetChanged();

        }
    }

    public class gridproductviewholder extends RecyclerView.ViewHolder{
        private TextView gridlayouttitle;
        private Button gridlayoutbtn;
        private GridView gridView;

        public gridproductviewholder(@NonNull View itemView) {
            super(itemView);

            gridlayouttitle=itemView.findViewById(R.id.grid_layout_title);
            gridlayoutbtn=itemView.findViewById(R.id.grid_layout_viewall);
            gridView=itemView.findViewById(R.id.grid_layout_gridview);

        }
        private void setGridlayout(List<horizontalscrollmodel>horizontalscrollmodelList,String title){
            gridlayouttitle.setText(title);
            gridView.setAdapter(new gridviewadaptar(horizontalscrollmodelList));

            gridlayoutbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent viewallIntent=new Intent(itemView.getContext(),vieallactivity.class);
                    viewallIntent.putExtra("layout_code",1);
                    itemView.getContext().startActivity(viewallIntent);
                }
            });
        }
    }
}
