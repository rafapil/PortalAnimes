package com.rafaelfilgueiras.portalanimes.activity;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.rafaelfilgueiras.portalanimes.R;

public class AnimeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime);


        // esconder a actionBar pelo java
        getSupportActionBar().hide();

        // Receber informacoes
        String name = getIntent().getExtras().getString("anime_name");
        String description = getIntent().getExtras().getString("anime_description");
        String studio = getIntent().getExtras().getString("anime_studio");
        String category = getIntent().getExtras().getString("anime_category");
        int nb_episode = getIntent().getExtras().getInt("anime_nb_episode");
        String rating = getIntent().getExtras().getString("anime_rating");
        String image_url = getIntent().getExtras().getString("anime_img");

        // iniciar as Views
        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsingtoolbar_id);
        collapsingToolbarLayout.setTitleEnabled(true);

        TextView tv_name = findViewById(R.id.aa_anime_name);
        TextView tv_studio = findViewById(R.id.aa_studio);
        TextView tv_categorie = findViewById(R.id.aa_categoria);
        TextView tv_description = findViewById(R.id.aa_description);
        TextView tv_rating = findViewById(R.id.aa_rating);
        ImageView img = findViewById(R.id.aa_thumbnail);

        // carregar o nome do anime ao descer a barra do collapse
        collapsingToolbarLayout.setTitle(name);

        // setando valores obtidos

        tv_name.setText(name);
        tv_categorie.setText(category);
        tv_description.setText(description);
        tv_rating.setText(rating);
        tv_studio.setText(studio);

        // Definicoes imagem
        RequestOptions requestOptions = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);


        // Definicoes para imagem com o Glide
        Glide.with(this).load(image_url).apply(requestOptions).into(img);


    }
}
