package com.delevry.resto;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


public class RestoAdapter extends RecyclerView.Adapter<RestoAdapter.ViewHolder> {


    List<RestoData> itemResto1;

    public RestoAdapter(List<RestoData> itemResto1) {
        this.itemResto1 = itemResto1;
    }

    @NonNull
    @Override
    public RestoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_row_resto,parent,false);

        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

        /*ajouter1*/
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(),DetailResto.class);
                v.getContext().startActivity(i);
            }
        });
        /*fin ajouter 1*/

        holder.itemImageResto.setImageResource(itemResto1.get(position).getImage());
        holder.itemTitleResto.setText(itemResto1.get(position).getrTitle());
        holder.itemSubtitleResto.setText(itemResto1.get(position).getrSubTitle());
        holder.itemCityResto.setText(itemResto1.get(position).getrVille());

      /*
        holder.itemCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), DetailActivity.class);
                i.putExtra("Title",holder.itemTitleResto.getText().toString());
                i.putExtra("SubTitle",holder.itemSubtitleResto.getText().toString());
                v.getContext().startActivity(i);
            }
        });
*/
        /*fin ajouter*/
      //  holder.itemRatinResto.setRating(itemResto1.get(position).getrRating());



    }

    @Override
    public int getItemCount() {
        return itemResto1.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView itemImageResto;
        TextView itemTitleResto, itemSubtitleResto,itemCityResto;
        RatingBar itemRatinResto;
        CardView itemCardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemImageResto=itemView.findViewById(R.id.ivresto);
            itemTitleResto=itemView.findViewById(R.id.tvTitleResto);
            itemSubtitleResto=itemView.findViewById(R.id.tvSubtitleResto);
            itemCityResto=itemView.findViewById(R.id.tvcity);
            itemRatinResto= itemView.findViewById(R.id.restoRateBar);
            itemCardView=itemView.findViewById(R.id.rCardview);

        }
    }
}
/*
public class  RestoAdapter extends RecyclerView.Adapter<RestoViewHolder> {

private Context rContext;
private List<RestoData> rRestoList;

    public RestoAdapter(Context rContext, List<RestoData> rRestoList) {
        this.rContext = rContext;
        this.rRestoList = rRestoList;
    }

    public RestoAdapter(List<RestoData> initData) {

    }

    @Override
    public RestoViewHolder  onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View rView= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_row_resto,viewGroup,false);
        return new RestoViewHolder(rView);
    }

    @Override
    public void onBindViewHolder(@NonNull final RestoViewHolder restoViewHolder, int i) {

        restoViewHolder.itemImageResto.setImageResource(rRestoList.get(i).getImage());
        restoViewHolder.itemTitleResto.setText(rRestoList.get(i).getrTitle());
       restoViewHolder.itemSubtitleResto.setText(rRestoList.get(i).getrSubTitle());
        restoViewHolder.itemCityResto.setText(rRestoList.get(i).getrVille());

        restoViewHolder.itemCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(rContext,DetailResto.class);
                intent.putExtra


                        ("image",rRestoList.get(restoViewHolder.getAdapterPosition()).getImage());
                intent.putExtra("Description",rRestoList.get(restoViewHolder.getAdapterPosition()).getrTitle());
                rContext.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return rRestoList.size();
    }
}

class RestoViewHolder extends RecyclerView.ViewHolder {

    ImageView itemImageResto;
    TextView itemTitleResto, itemSubtitleResto,itemCityResto;
    RatingBar itemRatinResto;
    CardView itemCardView;
    public RestoViewHolder(@NonNull View itemView) {
        super(itemView);

        itemImageResto=itemView.findViewById(R.id.ivresto);
        itemTitleResto=itemView.findViewById(R.id.tvTitleResto);
        itemSubtitleResto=itemView.findViewById(R.id.tvSubtitleResto);
        itemCityResto=itemView.findViewById(R.id.tvcity);
        itemRatinResto= itemView.findViewById(R.id.restoRateBar);
        itemCardView=itemView.findViewById(R.id.rCardview);
    }
}

 */