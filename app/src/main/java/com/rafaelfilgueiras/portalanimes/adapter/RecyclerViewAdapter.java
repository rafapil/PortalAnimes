package com.rafaelfilgueiras.portalanimes.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.rafaelfilgueiras.portalanimes.R;
import com.rafaelfilgueiras.portalanimes.activity.AnimeActivity;
import com.rafaelfilgueiras.portalanimes.model.Anime;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>{

    private Context mContext;
    private List<Anime> mData;
    RequestOptions option;

    public RecyclerViewAdapter(Context mContext, List<Anime> mData) {
        this.mContext = mContext;
        this.mData = mData;

        // Requisiçao para o Glide option
        option = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);

    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.anime_row_item, viewGroup,false);

        // direcionada a activity de detalhes do Anime/Post
        final MyViewHolder viewHolder = new MyViewHolder(view);
        viewHolder.view_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext, AnimeActivity.class);
                i.putExtra("anime_name", mData.get(viewHolder.getAdapterPosition()).getName());
                i.putExtra("anime_description", mData.get(viewHolder.getAdapterPosition()).getDescription());
                i.putExtra("anime_studio", mData.get(viewHolder.getAdapterPosition()).getStudio());
                i.putExtra("anime_category", mData.get(viewHolder.getAdapterPosition()).getCategorie());
                i.putExtra("anime_nb_episode", mData.get(viewHolder.getAdapterPosition()).getNb_episode());
                i.putExtra("anime_rating", mData.get(viewHolder.getAdapterPosition()).getRating());
                i.putExtra("anime_img", mData.get(viewHolder.getAdapterPosition()).getImg_url());

                mContext.startActivity(i);

            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        myViewHolder.txtName.setText(mData.get(i).getName());
        myViewHolder.txtStudio.setText(mData.get(i).getStudio());
        myViewHolder.txtRating.setText(mData.get(i).getRating());
        myViewHolder.txtCategory.setText(mData.get(i).getCategorie());

        // Carregar a imagem da internet dentro do imageview

        Glide.with(mContext).load(mData.get(i).getImg_url()).apply(option).into(myViewHolder.imgThumbnail);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public  static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView txtName;
        TextView txtRating;
        TextView txtStudio;
        TextView txtCategory;
        ImageView imgThumbnail;
        LinearLayout view_container;


        public MyViewHolder(View itemView){
            super(itemView);

            view_container = itemView.findViewById(R.id.container_anime);
            txtName = itemView.findViewById(R.id.anime_name);
            txtCategory = itemView.findViewById(R.id.categoria);
            txtRating = itemView.findViewById(R.id.rating);
            txtStudio = itemView.findViewById(R.id.studio);
            imgThumbnail = itemView.findViewById(R.id.thumbnail);

        }




    }

}
