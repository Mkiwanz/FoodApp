package com.example.foodapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecipesAdapter(private val recipes: List<Recipe>) :
    RecyclerView.Adapter<RecipesAdapter.RecipeViewHolder>() {

    class RecipeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.recipe_image)
        val titleView: TextView = view.findViewById(R.id.recipe_title)
        val cookingTimeView: TextView = view.findViewById(R.id.cooking_time)
        val ratingBar: RatingBar = view.findViewById(R.id.rating_bar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recipe, parent, false)
        return RecipeViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val recipe = recipes[position]
        holder.imageView.setImageResource(recipe.image)
        holder.titleView.text = recipe.title
        holder.cookingTimeView.text = recipe.cookingTime
        holder.ratingBar.rating = recipe.rating
    }

    override fun getItemCount() = recipes.size
}
