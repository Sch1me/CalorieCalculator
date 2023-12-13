package com.example.caloriecalculator2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.caloriecalculator2.databinding.ActivityFoodDetailsBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.lang.Exception

class FoodDetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityFoodDetailsBinding
    private val dataBaseCalories: DatabaseReference =
        FirebaseDatabase.getInstance("https://caloriecalculator2-2cb5c-default-rtdb.europe-west1.firebasedatabase.app/").getReference("Goals").child("CalorieGoal")
    private val dataBaseProtein: DatabaseReference =
        FirebaseDatabase.getInstance("https://caloriecalculator2-2cb5c-default-rtdb.europe-west1.firebasedatabase.app/").getReference("Goals").child("ProteinGoal")
    private val dataBaseCarbs: DatabaseReference =
        FirebaseDatabase.getInstance("https://caloriecalculator2-2cb5c-default-rtdb.europe-west1.firebasedatabase.app/").getReference("Goals").child("CarbGoal")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFoodDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

//postavlja pocetne prikaze za dodavanje da se ne vide
        binding.addCaloriesCardView.visibility = View.GONE
        binding.addProteinCardView.visibility = View.GONE
        binding.addCarbsCardView.visibility = View.GONE


//postavlja prikaze za dodavanje da se vide
        binding.addCalories.setOnClickListener {
            binding.addCaloriesCardView.visibility = View.VISIBLE
        }
        binding.addProtein.setOnClickListener {
            binding.addProteinCardView.visibility = View.VISIBLE
        }
        binding.addCarbs.setOnClickListener {
            binding.addCarbsCardView.visibility = View.VISIBLE
        }
        
//prikazi za dodavanje

        binding.addButtonCalories.setOnClickListener {
            dataBaseCalories.setValue(binding.addCaloriesTxt.text.toString())

            binding.addCaloriesCardView.visibility = View.GONE
        }
        binding.addButtonProtein.setOnClickListener {
            dataBaseProtein.setValue(binding.addProteinTxt.text.toString())
            binding.addProteinCardView.visibility = View.GONE
        }
        binding.addButtonCarbs.setOnClickListener {
            dataBaseCarbs.setValue(binding.addCarbsTxt.text.toString())
            binding.addCarbsCardView.visibility = View.GONE
        }

//prikaz ciljeva
        dataBaseCalories.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                try {
                    binding.calorieGoalText.text = snapshot.child("CalorieGoal").getValue().toString()
                }catch (_:Exception){}
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })




    }
}