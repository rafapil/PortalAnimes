package com.rafaelfilgueiras.portalanimes.model;

public class Anime {

    private String name;
    private String description;
    private String Rating;
    private int nb_episode;
    private String categorie;
    private String studio;
    private String img_url;

    public Anime() {
    }

    public Anime(String name, String description, String rating, int nb_episode, String categorie, String studio, String img_url) {
        this.name = name;
        this.description = description;
        Rating = rating;
        this.nb_episode = nb_episode;
        this.categorie = categorie;
        this.studio = studio;
        this.img_url = img_url;
    }


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getRating() {
        return Rating;
    }

    public int getNb_episode() {
        return nb_episode;
    }

    public String getCategorie() {
        return categorie;
    }

    public String getStudio() {
        return studio;
    }

    public String getImg_url() {
        return img_url;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRating(String rating) {
        Rating = rating;
    }

    public void setNb_episode(int nb_episode) {
        this.nb_episode = nb_episode;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }
}
