package com.example.caloriecalculator2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.caloriecalculator2.databinding.ActivityPocetnaBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.getValue
import java.lang.Exception
import kotlin.random.Random


class PocetnaActivity : AppCompatActivity() {
    lateinit var binding: ActivityPocetnaBinding
     var randomIndex: Int = 0
    private val dataBase: DatabaseReference =
        FirebaseDatabase.getInstance("https://caloriecalculator2-2cb5c-default-rtdb.europe-west1.firebasedatabase.app/").getReference("Quotes")
    private val dataBase1: DatabaseReference =
        FirebaseDatabase.getInstance("https://caloriecalculator2-2cb5c-default-rtdb.europe-west1.firebasedatabase.app/").getReference("Goals").child("CalorieGoal")
    private val dataBase2: DatabaseReference =
        FirebaseDatabase.getInstance("https://caloriecalculator2-2cb5c-default-rtdb.europe-west1.firebasedatabase.app/").getReference("Goals").child("WaterGoal")
    private val dataBaseWater: DatabaseReference =
        FirebaseDatabase.getInstance("https://caloriecalculator2-2cb5c-default-rtdb.europe-west1.firebasedatabase.app/").getReference("Water")

    var consumedWater : String = ""
    var waterGoal : String = ""
    var Quotes = ArrayList<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPocetnaBinding.inflate(layoutInflater)
        setContentView(binding.root)


//ucitava podatke o popijenoj vodi
        dataBaseWater.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                consumedWater = snapshot.child("CurrentWater").getValue().toString()
        //postavlja pocetni tekst o unesenoj vodi
                binding.waterConsumedTextView.text = consumedWater + " / " + waterGoal + "0 dcl"
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

//prati promjenu podataka unutar baze podataka koja sadrzava Quotes
        dataBase.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
            try {
                val a: List<String> = snapshot.children.map {
                        dataSnapshot -> dataSnapshot.getValue(String::class.java)!!
                }

                Quotes.addAll(a)
              //  Toast.makeText(this@PocetnaActivity, Quotes.size.toString(), Toast.LENGTH_SHORT).show()
                randomIndex = Random.nextInt(0,Quotes.size)
                binding.quotesTxt.text = Quotes[randomIndex]

            }catch (_: Exception){ }

            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@PocetnaActivity,"Failed to update database",Toast.LENGTH_SHORT).show()
            }
        })

//prati promjenu podataka unutar baze podataka koja prati caloriegoal i watergoal
        dataBase1.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                try {
                    val calorieGoal: String = snapshot.child("CalorieGoal").getValue().toString()

                    binding.calorieNumberTextView.text ="trenutno"+"/" + calorieGoal + "kcal"

                }catch (_: Exception){ }
                }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@PocetnaActivity,"Failed to update database",Toast.LENGTH_SHORT).show()

            }
            })
        dataBase2.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                try {
                    waterGoal = snapshot.child("WaterGoal").getValue().toString()
                    binding.waterConsumedTextView.text = consumedWater + " / " + waterGoal+"0" + " dcl"
                }catch (_:Exception){}
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }


        })


//gumbovi za slajdanje dalje
        binding.waterButtonIMG.setOnClickListener {

            intent = Intent(this, WaterActivity::class.java)

            startActivity(intent)
        }

        binding.foodButtonIMG.setOnClickListener {

            intent = Intent(this, FoodActivity::class.java)
            startActivity(intent)
        }

        binding.profileButtonIMG.setOnClickListener {

            intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }


    }


}