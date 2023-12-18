package com.example.foodapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MealPlanAdapter(private val mealPlanEntries: List<MealPlanEntry>) : RecyclerView.Adapter<MealPlanAdapter.MealPlanViewHolder>() {

    class MealPlanViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val dateView: TextView = view.findViewById(R.id.meal_date)
        val mealTypeView: TextView = view.findViewById(R.id.meal_type)
        val mealDescriptionView: TextView = view.findViewById(R.id.meal_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealPlanViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_meal_plan, parent, false)
        return MealPlanViewHolder(view)
    }

    override fun onBindViewHolder(holder: MealPlanViewHolder, position: Int) {
        val entry = mealPlanEntries[position]
        holder.dateView.text = entry.date
        holder.mealTypeView.text = entry.mealType
        holder.mealDescriptionView.text = entry.mealDescription
    }

    override fun getItemCount() = mealPlanEntries.size
}
