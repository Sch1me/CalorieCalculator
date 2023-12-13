package com.example.caloriecalculator2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.caloriecalculator2.databinding.ActivityFoodBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class FoodActivity : AppCompatActivity() {
    lateinit var binding: ActivityFoodBinding
    private val dataBase: DatabaseReference = FirebaseDatabase.getInstance("https://caloriecalculator2-2cb5c-default-rtdb.europe-west1.firebasedatabase.app/").getReference("Food")
    val food = ArrayList<FoodITem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFoodBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.waterButtonIMG.setOnClickListener {

            intent = Intent(this, WaterActivity::class.java )
            startActivity(intent)

        }
        binding.homeButtonIMG.setOnClickListener {

            intent = Intent(this, PocetnaActivity::class.java )
            startActivity(intent)

        }
        binding.profileButtonIMG.setOnClickListener {

            intent = Intent(this, ProfileActivity::class.java )
            startActivity(intent)

        }





    }
}