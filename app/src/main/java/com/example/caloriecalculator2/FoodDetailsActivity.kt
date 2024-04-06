package com.example.caloriecalculator2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Toast
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.caloriecalculator2.databinding.ActivityFoodDetailsBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.getValue
import java.lang.Exception

class FoodDetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityFoodDetailsBinding
    private val dataBaseGoals: DatabaseReference =
        FirebaseDatabase.getInstance("https://caloriecalculator2-2cb5c-default-rtdb.europe-west1.firebasedatabase.app/").getReference("Goals")
    private val dataBaseIntake: DatabaseReference =
        FirebaseDatabase.getInstance("https://caloriecalculator2-2cb5c-default-rtdb.europe-west1.firebasedatabase.app/").getReference("CurrentIntake")

    var calorieIntake : Float = 0f
    var proteinIntake : Float = 0f
    var carbIntake : Float = 0f
    //goals
    var calorieGoal: Int = 0
    var proteinGoal: Int = 0
    var carbGoal: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFoodDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

//postavlja pocetne prikaze za dodavanje da se ne vide
        binding.addCaloriesCardView.visibility = View.GONE
        binding.addProteinCardView.visibility = View.GONE
        binding.addCarbsCardView.visibility = View.GONE

        //upravljanje vidljivoscu loadinga progress bara
        Handler().postDelayed({
            // Postavljanje vidljivosti ProgressBar-a na false nakon 2 sekunde
            binding.determinateBar.visibility = View.GONE
        }, 1000)

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

//back button
        binding.backBtn.setOnClickListener {
            intent= Intent(this,PocetnaActivity::class.java)
            startActivity(intent)
        }

//cita podatke iz baze podataka za GOALS
        dataBaseGoals.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                try {
                    val calorieGoal2:String = snapshot.child("CalorieGoal").child("CalorieGoal").getValue().toString()
                    val proteinGoal2:String = snapshot.child("ProteinGoal").getValue().toString()
                    val carbGoal2:String=snapshot.child("CarbGoal").getValue().toString()
                    calorieGoal = calorieGoal2.toInt()
                    proteinGoal = proteinGoal2.toInt()
                    carbGoal = carbGoal2.toInt()
                }catch (_:Exception){}
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })

//cita podatke iz baze podataka za INTAKE i sprema ih u varijablu
        dataBaseIntake.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                try {
                    calorieIntake = snapshot.child("CalorieIntake").getValue().toString().toFloat()
                    proteinIntake = snapshot.child("ProteinIntake").getValue().toString().toFloat()
                    carbIntake = snapshot.child("CarbIntake").getValue().toString().toFloat()
                }catch (_:Exception){}
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })


//prikazi za dodavanje i mehanizam za dodavanje

        binding.addButtonCalories.setOnClickListener {
            try {
                val calorieIntake2 : Float = binding.addCaloriesTxt.text.toString().toFloat()
                calorieIntake += calorieIntake2
                dataBaseIntake.child("CalorieIntake").setValue(calorieIntake)
            }catch (_:Exception){
                Toast.makeText(this@FoodDetailsActivity,"Unesi podatke",Toast.LENGTH_SHORT).show()
            }
            binding.addCaloriesTxt.text = null
            binding.addCaloriesCardView.visibility = View.GONE
        }
        binding.addButtonProtein.setOnClickListener {
            try {
                val proteinIntake2 : Float = binding.addProteinTxt.text.toString().toFloat()
                proteinIntake += proteinIntake2
                dataBaseIntake.child("ProteinIntake").setValue(proteinIntake)
            }catch (_:Exception){
                Toast.makeText(this@FoodDetailsActivity,"Unesi podatke",Toast.LENGTH_SHORT).show()
            }
            binding.addProteinTxt.text = null
            binding.addProteinCardView.visibility = View.GONE
        }
        binding.addButtonCarbs.setOnClickListener {

            try {
                val carbsIntake2 : Float = binding.addCarbsTxt.text.toString().toFloat()
                carbIntake += carbsIntake2
                dataBaseIntake.child("CarbIntake").setValue(carbIntake)
            }catch (_:Exception){
                Toast.makeText(this@FoodDetailsActivity,"Unesi podatke",Toast.LENGTH_SHORT).show()
            }
            binding.addCarbsTxt.text = null
            binding.addCarbsCardView.visibility = View.GONE

        }

//prati jesu li se podatci u bazi podataka promjenili, ako jesu postavlja tekst na novu vrijednost
        dataBaseIntake.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                try {
                    binding.calorieIntakeText.text = snapshot.child("CalorieIntake").getValue().toString() + " / " + calorieGoal.toString()
                    binding.proteinIntakeText.text = snapshot.child("ProteinIntake").getValue().toString()+ " / " + proteinGoal.toString()
                    binding.carbIntakeText.text = snapshot.child("CarbIntake").getValue().toString()+ " / " + carbGoal.toString()

                }catch (_:Exception){}
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

//buttoni za gasenje prikaza za dodavanje
        binding.BackButtonCalories.setOnClickListener {

            binding.addCaloriesCardView.visibility = View.GONE
        }

        binding.BackButtonProtein.setOnClickListener {

            binding.addProteinCardView.visibility = View.GONE
        }

        binding.BackButtonCarbs.setOnClickListener {

            binding.addCarbsCardView.visibility = View.GONE
        }


    }
}