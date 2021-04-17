package com.niteroomcreation.mvvmvanila.model.repository.remote.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.niteroomcreation.mvvmvanila.model.Recipe;

/**
 * Created by Septian Adi Wijaya on 17/04/2021.
 * please be sure to add credential if you use people's code
 */
public class RecipeResponse {
    @SerializedName("recipe")
    @Expose()
    private Recipe recipe;

    public Recipe getRecipe() {
        return recipe;
    }

    @Override
    public String toString() {
        return "RecipeResponse{" +
                "recipe=" + recipe +
                '}';
    }
}
