package controller;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

import model.CardDraw;
import nyc.c4q.androidretake.R;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardViewHolder> {

     List<String> newCard;


    public CardAdapter(List<String> newcard) {
        this.newCard = newcard;
    }


    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View childView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent, false);
        //context = parent.getContext();
        return new CardViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(CardViewHolder holder, int position) {
        String cards = newCard.get(position);
        holder.bindImage(newCard.get(position));

    }

    @Override
    public int getItemCount() {
        return newCard.size();
    }

    public void addAll(List<CardDraw> newCard) {
        newCard.addAll(newCard);
        notifyDataSetChanged();
    }

    static class CardViewHolder extends RecyclerView.ViewHolder {

        private ImageView image1;


        CardViewHolder(View itemView) {
            super(itemView);

            image1 = itemView.findViewById(R.id.image1);

        }

        void bindImage(String newCard) {
            Picasso.with(image1.getContext()).load(newCard).into(image1);
        }
    }

}
