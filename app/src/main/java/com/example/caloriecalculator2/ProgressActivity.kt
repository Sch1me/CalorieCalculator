package com.example.caloriecalculator2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.caloriecalculator2.databinding.ActivityProgressBinding

class ProgressActivity : AppCompatActivity() {
    lateinit var binding : ActivityProgressBinding
    var weightArrayListProgress: ArrayList<String> = ArrayList()
    var waterArrayListProgress: ArrayList<String> = ArrayList()
    var caloriesArrayListProgress: ArrayList<String> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProgressBinding.inflate(layoutInflater)
        setContentView(binding.root)

/*
        //popunice samo ako sam dodao promjene u profile
    if(ProfileActivity.weightArrayList.isNotEmpty()){

        weightArrayListProgress.add(ProfileActivity.weightArrayList.toString())
        weightArrayListProgress.forEach() {

        }
    }
    if(ProfileActivity.waterArrayList.isNotEmpty()){

            waterArrayListProgress.add(ProfileActivity.waterArrayList.toString())

        waterArrayListProgress.forEach {
            binding.waterHistoryTxt.text = waterArrayListProgress.toString()

        }

       // binding.waterHistoryTxt.text = waterArrayListProgress.toString() + "kg, "

    }
    if(ProfileActivity.caloriesArrayList.isNotEmpty()){

            caloriesArrayListProgress.add(ProfileActivity.caloriesArrayList.toString())
            binding.caloriesHistoryTxt.text = caloriesArrayListProgress.toString() + "kcal, "

    }

        binding.backButton.setOnClickListener{
            intent = Intent(this, ProfileActivity::class.java)

            startActivity(intent)
        }

        binding.clearHistoryBtn.setOnClickListener{
            weightArrayListProgress.clear()
            waterArrayListProgress.clear()
            caloriesArrayListProgress.clear()
            Toast.makeText(this, "You just cleared your history!!", Toast.LENGTH_SHORT).show()
            binding.weightHistoryTxt.text = ""
            binding.waterHistoryTxt.text = ""
            binding.caloriesHistoryTxt.text = ""
            intent.putExtra("calories", ProfileActivity.caloriesArrayList.clear().toString())
            intent.putExtra("weight", ProfileActivity.weightArrayList.clear().toString())
            intent.putExtra("water", ProfileActivity.waterArrayList.clear().toString())
            startActivity(intent)

        }

*/
    }
}