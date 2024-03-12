package com.example.caloriecalculator2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.caloriecalculator2.databinding.FoodItemBinding
import com.example.caloriecalculator2.databinding.ProfileStatsItemBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ProfileStatsAdapter (
    private val calorieIntakeList: ArrayList<StatsModel>,
    private val th : Context
):

    RecyclerView.Adapter<ProfileStatsAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileStatsAdapter.ViewHolder {
        val v = ProfileStatsItemBinding.inflate(LayoutInflater.from(th),parent,false)
        return ProfileStatsAdapter.ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ProfileStatsAdapter.ViewHolder, position: Int) {
        val lista = ArrayList<StatsModel>()
        lista.clear()
        lista.add(calorieIntakeList[position])
        lista.add(calorieIntakeList[position])
        lista.add(calorieIntakeList[position])
        holder.bindItem(lista,th,position)
    }

    override fun getItemCount(): Int {
        return calorieIntakeList.size
    }

    class ViewHolder(private var itemBinding: ProfileStatsItemBinding):
        RecyclerView.ViewHolder(itemBinding.root){
        fun bindItem(statsModel: ArrayList<StatsModel>, th: Context,position: Int){

            if(statsModel[0].calorieIntake.toInt() != 0 ){
                itemBinding.calorieIntakeTxt.text = statsModel[0].calorieIntake + " / " + statsModel[0].calorieGoal
                itemBinding.dateOfIntakeTxt.text = statsModel[0].dateOfIntake
            }else{
                itemBinding.calorieIntakeTxt.text = "0 / " + statsModel[0].calorieGoal
                itemBinding.dateOfIntakeTxt.text = statsModel[0].dateOfIntake
            }


        }
    }

}