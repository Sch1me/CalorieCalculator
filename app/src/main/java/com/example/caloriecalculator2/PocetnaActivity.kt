package com.example.caloriecalculator2

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import com.example.caloriecalculator2.databinding.ActivityPocetnaBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.getValue
import java.lang.Exception
import java.util.Calendar
import java.util.Date
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
    private val dataBaseIntake: DatabaseReference =
        FirebaseDatabase.getInstance("https://caloriecalculator2-2cb5c-default-rtdb.europe-west1.firebasedatabase.app/").getReference("CurrentIntake")

    var consumedCalories: String = ""
    var calorieGoal: String = ""
    var consumedWater : String = ""
    var waterGoal : String = ""
    var Quotes = ArrayList<String>()

    var y1 : Float = 0.0f
    var y2 : Float =0.0f
    var x1 : Float =0.0f
    var x2 : Float =0.0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPocetnaBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //upravljanje vidljivoscu loadinga progress bara
        Handler().postDelayed({
            // Postavljanje vidljivosti ProgressBar-a na false nakon 2 sekunde
            binding.determinateBar.visibility = View.GONE
        }, 1000)

//prati promjenu podataka unutar baze podataka koja prati caloriegoal i watergoal
        dataBase1.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                try {
                    calorieGoal = snapshot.child("CalorieGoal").getValue().toString()

                }catch (_: Exception){ }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@PocetnaActivity,"Failed to update database",Toast.LENGTH_SHORT).show()

            }
        })

//ucitava podatke o kalorijama
        dataBaseIntake.addValueEventListener(object:ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                try {
                    consumedCalories = snapshot.child("CalorieIntake").getValue().toString()
                    binding.calorieNumberTextView.text = consumedCalories +" / " + calorieGoal + "kcal"
                }catch (_:Exception){
                    Toast.makeText(this@PocetnaActivity,"Pogreška",Toast.LENGTH_SHORT).show()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })

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

        binding.foodDetailsBtn.setOnClickListener{
            intent=Intent(this,FoodDetailsActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onTouchEvent(touchEvent: MotionEvent): Boolean {
        when (touchEvent.action) {
            MotionEvent.ACTION_DOWN -> {
                x1 = touchEvent.x
                y1 = touchEvent.y
            }
            MotionEvent.ACTION_UP -> {
                x2 = touchEvent.x
                y2 = touchEvent.y
                if (x1 < x2) {
                    val i = Intent(this@PocetnaActivity, WaterActivity::class.java)
                    startActivity(i)
                } else if (x1 > x2) {
                    val i = Intent(this@PocetnaActivity, ProfileActivity::class.java)
                    startActivity(i)
                }
            }
        }
        return false
    }

}