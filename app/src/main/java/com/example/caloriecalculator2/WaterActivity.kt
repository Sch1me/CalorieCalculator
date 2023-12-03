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
import java.lang.Exception

class WaterActivity : AppCompatActivity() {
    lateinit var binding: ActivityWaterBinding
    var waterAdded : Int = 0
    var waterInDatabase : Int = 0
    var totalWaterAdded : Int = 0
        private val dataBase: DatabaseReference =
        FirebaseDatabase.getInstance("https://caloriecalculator2-2cb5c-default-rtdb.europe-west1.firebasedatabase.app/").getReference("Water")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWaterBinding.inflate(layoutInflater)
        setContentView(binding.root)

//postavlja cardView kao nevidljiv
        binding.addWaterCardView.visibility = View.GONE



//buttoni za prebacivanje aktivnosti


        binding.foodButtonIMG.setOnClickListener {

            intent = Intent(this, FoodActivity::class.java)
            startActivity(intent)
        }

        binding.profileButtonIMG.setOnClickListener {

            intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }
//test test test
        binding.homeButtonIMG.setOnClickListener {

            intent = Intent(this,PocetnaActivity::class.java)
            startActivity(intent)
        }


//pokazuje prikaz za dodavanje vode
        binding.addWaterButton.setOnClickListener{

            binding.addWaterCardView.visibility = View.VISIBLE

    //cita podatke iz baze podataka
            dataBase.addValueEventListener(object :ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    try {
                //        waterInDatabase = snapshot.child("CurrentWater").getValue()

                        binding.hydrationText.text = totalWaterAdded.toString()
                    }catch (_:Exception){}
                }

                override fun onCancelled(error: DatabaseError) {
                    Toast.makeText(this@WaterActivity,"Failed to load data", Toast.LENGTH_SHORT).show()
                }

            })
        }

        binding.addButton.setOnClickListener {
           // waterAdded = binding.ammountOfWaterTxt as Int
            dataBase.child("CurrentWater").setValue(5)
            totalWaterAdded = waterAdded + waterInDatabase
            binding.hydrationText.text = totalWaterAdded.toString()
        }







    }
}