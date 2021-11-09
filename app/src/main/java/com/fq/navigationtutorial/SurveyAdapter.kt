package com.fq.navigationtutorial

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fq.navigationtutorial.databinding.SurveyItemViewBinding

class SurveyAdapter(val survey : ArrayList<SurveyItem>) :  RecyclerView.Adapter<SurveyAdapter.ViewHolder>()  {

    inner class ViewHolder(var itemBinding : SurveyItemViewBinding) :  RecyclerView.ViewHolder(itemBinding.root){
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : SurveyAdapter.ViewHolder {
        val itemBinding = SurveyItemViewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: SurveyAdapter.ViewHolder, position: Int) {
        val surveyItem = survey[position]
        holder.itemBinding.nameTextView.text = surveyItem.name
        holder.itemBinding.surveyRatingBar.rating = surveyItem.rating
        holder.itemBinding.surveyImage.setImageResource(surveyItem.image)
    }

    override fun getItemCount() : Int {
        return survey.size
    }
}