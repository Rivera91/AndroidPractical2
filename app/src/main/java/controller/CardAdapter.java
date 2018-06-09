package controller;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import model.CardDraw;
import model.CardDrawImage;
import nyc.c4q.androidretake.R;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardViewHolder> {

    List<CardDrawImage> newCard = new ArrayList<>();
    private Context context;

    public CardAdapter(List<CardDrawImage> newcard) {
        newcard = new ArrayList<>();
        this.newCard = newcard;
    }


    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View childView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent,false);
        context = parent.getContext();
        return new CardViewHolder(childView);
    }

    @Override
    public void onBindViewHolder( CardViewHolder holder, int position) {
        //CardDraw cardDraw = newCard.get(position);
        final String thumbnail = newCard.get(position).getCards().toString();

        Picasso.with(context)
                .load(thumbnail)
                .into(holder.image1);
        Picasso.with(context)
                .load(thumbnail)
                .into(holder.image2);
        Picasso.with(context)
                .load(thumbnail)
                .into(holder.image3);
        Picasso.with(context)
                .load(thumbnail)
                .into(holder.image4);

    }

    @Override
    public int getItemCount() {
        return newCard.size();
    }

    class CardViewHolder extends RecyclerView.ViewHolder{

        private ImageView image1;
        private ImageView image2;
        private ImageView image3;
        private ImageView image4;

        CardViewHolder(View itemView) {
            super(itemView);

            image1 = itemView.findViewById(R.id.image1);
            image2 = itemView.findViewById(R.id.image2);
            image3 = itemView.findViewById(R.id.image3);
            image4 = itemView.findViewById(R.id.image4);
        }
    }


}
