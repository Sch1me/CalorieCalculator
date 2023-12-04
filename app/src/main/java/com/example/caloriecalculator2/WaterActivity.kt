package com.example.caloriecalculator2

import android.content.Intent
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.caloriecalculator2.databinding.ActivityWaterBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.getValue
import java.lang.Exception

class WaterActivity : AppCompatActivity() {
    lateinit var binding: ActivityWaterBinding
    var waterAdded : String= ""
    var waterInLiters : Int = 0
    var totalWaterAdded : Int = 0
        private val dataBase: DatabaseReference =
        FirebaseDatabase.getInstance("https://caloriecalculator2-2cb5c-default-rtdb.europe-west1.firebasedatabase.app/").getReference("Water")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWaterBinding.inflate(layoutInflater)
        setContentView(binding.root)

//postavlja cardView kao nevidljiv
        binding.addWaterCardView.visibility = View.GONE


//postavlja pocetni tekst
        binding.hydrationText.text = "Current water intake: " + totalWaterAdded.toString() + " dcl"



//ucitava podatke iz baze podataka
        dataBase.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val waterInDataBase : String = snapshot.child("CurrentWater").getValue().toString()
                binding.hydrationText.text = "Current water intake: " + waterInDataBase + " dcl"
                totalWaterAdded = waterInDataBase.toInt()
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

//buttoni za prebacivanje aktivnosti


        binding.foodButtonIMG.setOnClickListener {

            intent = Intent(this, FoodActivity::class.java)
            startActivity(intent)
        }

        binding.profileButtonIMG.setOnClickListener {

            intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }
        binding.homeButtonIMG.setOnClickListener {

            intent = Intent(this,PocetnaActivity::class.java)
            startActivity(intent)
        }


//pokazuje prikaz za dodavanje vode
        binding.addWaterButton.setOnClickListener{

            binding.addWaterCardView.visibility = View.VISIBLE

        }

//ADD BUTTON
        binding.addButton.setOnClickListener {
            waterAdded = binding.ammountOfWaterTxt.text.toString()
            if(waterAdded.isEmpty()){
                Toast.makeText(this@WaterActivity, "You didn't drink anything :((", Toast.LENGTH_SHORT).show()
                binding.addWaterCardView.visibility = View.GONE
            }else {
                totalWaterAdded += waterAdded.toInt()
                waterInLiters = (totalWaterAdded / 10)
                dataBase.child("CurrentWater").setValue(totalWaterAdded.toString())
                binding.hydrationText.text =
                    "Current water intake: " + totalWaterAdded.toString() + " dcl"
                binding.ammountOfWaterTxt.text = null
                binding.addWaterCardView.visibility = View.GONE
            }
        }

//button za resetiranje trenutnog unosa vode

        binding.resetWaterIntakeBtn.setOnClickListener{
            val oldWaterIntake : Int = totalWaterAdded
            totalWaterAdded = 0
            binding.hydrationText.text =
                "Current water intake: " + totalWaterAdded.toString() + " dcl"
            dataBase.child("CurrentWater").setValue(totalWaterAdded)
            Toast.makeText(this@WaterActivity,"You just did a reset of your water intake!", Toast.LENGTH_SHORT).show()
            Toast.makeText(this@WaterActivity,"Your water intake was: " + oldWaterIntake + " dcl", Toast.LENGTH_SHORT).show()
        }

    }
}