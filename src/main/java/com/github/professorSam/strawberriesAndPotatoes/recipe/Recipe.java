package com.github.professorSam.strawberriesAndPotatoes.recipe;

import java.util.List;

public class Recipe {

    private String id;
    private String title;
    private String shortDescription;
    private String longDescription;
    private List<String> ingredients;
    private List<String> utensils;

    public List<String> getUtensils() {
        return utensils;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getTitle() {
        return title;
    }

    public String getId(){
        return id;
    }
}
