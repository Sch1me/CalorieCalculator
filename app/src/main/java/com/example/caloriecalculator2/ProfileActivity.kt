package com.example.caloriecalculator2

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import com.example.caloriecalculator2.databinding.ActivityProfileBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.getValue
import java.time.LocalDate
import kotlin.Exception

class ProfileActivity : AppCompatActivity() {
    lateinit var binding: ActivityProfileBinding
    private val dataBase1: DatabaseReference =
        FirebaseDatabase.getInstance("https://caloriecalculator2-2cb5c-default-rtdb.europe-west1.firebasedatabase.app/").getReference("Goals").child("WaterGoal")
    private val dataBase2: DatabaseReference =
        FirebaseDatabase.getInstance("https://caloriecalculator2-2cb5c-default-rtdb.europe-west1.firebasedatabase.app/").getReference("Goals").child("CalorieGoal")
    private val dataBase: DatabaseReference =
        FirebaseDatabase.getInstance("https://caloriecalculator2-2cb5c-default-rtdb.europe-west1.firebasedatabase.app/").getReference("Goals")
    private val dataBaseDates: DatabaseReference =
        FirebaseDatabase.getInstance("https://caloriecalculator2-2cb5c-default-rtdb.europe-west1.firebasedatabase.app/").getReference("Dates")
    private val dataBaseIntake: DatabaseReference =
        FirebaseDatabase.getInstance("https://caloriecalculator2-2cb5c-default-rtdb.europe-west1.firebasedatabase.app/").getReference("CurrentIntake")
    private val dataBaseWaterIntake: DatabaseReference =
        FirebaseDatabase.getInstance("https://caloriecalculator2-2cb5c-default-rtdb.europe-west1.firebasedatabase.app/").getReference("Water")

    var date = LocalDate.parse("2024-01-01")
    var changeStats : Boolean = false //ako je false, onda se ne prikazuje

    companion object {
        var proteinArrayList = ArrayList<String>()
        var carbsArrayList = ArrayList<String>()
        var waterArrayList = ArrayList<String>()
        var caloriesArrayList = ArrayList<String>()
        var waterGoal = String()
    }

    var y1 : Float = 0.0f
    var y2 : Float =0.0f
    var x1 : Float =0.0f
    var x2 : Float =0.0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val cardViewChange = binding.CardViewChange
       val cardViewShow = binding.CardViewShow

        //values za text koji se sam mjenja
        val textViewCalorie = binding.calorieGoalNumTxt
        val textViewProtein = binding.proteinGoalNumTxt
        val textViewWater = binding.waterGoalNumTxt
        val textViewCarb = binding.carbGoalNumTxt
        //values za text koji user mijenja
        val textViewCalorieShow = binding.calorieGoalTxtNumShow
        val textViewProteinShow = binding.proteinTxtNumShow
        val textViewCarbsShow = binding.carbsTxtNumShow
        val textViewWaterShow = binding.waterGoalTxtNumShow


        //upravljanje vidljivoscu loadinga progress bara
        Handler().postDelayed({
            // Postavljanje vidljivosti ProgressBar-a na false nakon 2 sekunde
            binding.determinateBar.visibility = View.GONE
        }, 1000)

        //kemijanje
        if(waterArrayList.isEmpty() || proteinArrayList.isEmpty() || carbsArrayList.isEmpty() ||caloriesArrayList.isEmpty()){


            textViewCalorieShow.text = " kcal"
            textViewWaterShow.text = " liter"
            textViewProteinShow.text = " grams"
            textViewCarbsShow.text = " grams"


        }else{
            textViewCalorieShow.text = caloriesArrayList.last().toString() + " kcal"
            textViewWaterShow.text = waterArrayList.last().toString() + " liter"
            textViewProteinShow.text = proteinArrayList.last().toString() + " grams"
            textViewCarbsShow.text = carbsArrayList.last().toString() + " grams"
        }

//funkcionira s bazom za proteine
        dataBase.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                try {
                    val currentProteinGoal : String = snapshot.child("ProteinGoal").getValue().toString()
                    binding.proteinTxtNumShow.text = currentProteinGoal + " grams"
                    val currentCarbsGoal : String = snapshot.child("CarbGoal").getValue().toString()
                    binding.carbsTxtNumShow.text = currentCarbsGoal + " grams"
                    
                }catch (_:Exception){}
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

//funkcionira sa bazom podataka za KALORIJE
        dataBase2.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                try {
                    val currentCalorieGoal: String = snapshot.child("CalorieGoal").getValue().toString()

                    binding.calorieGoalTxtNumShow.text = currentCalorieGoal + " kcal"
                }catch (_:Exception){}
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@ProfileActivity,"Failed with calories",Toast.LENGTH_SHORT).show()
            }

        })

//funkcionira sa bazom podataka za VODU
        dataBase1.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                try {
                    val currentWaterGoal: String = snapshot.child("WaterGoal").getValue().toString()

                    binding.waterGoalTxtNumShow.text = currentWaterGoal + " liter"
                }catch (_:Exception){}
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@ProfileActivity,"Failed with water",Toast.LENGTH_SHORT).show()
            }

        })

//buttoni za ici u nove aktivnosti
        binding.waterButtonIMG.setOnClickListener {

            intent = Intent(this,WaterActivity::class.java)
            startActivity(intent)
        }

        binding.foodButtonIMG.setOnClickListener {

            intent = Intent(this,FoodActivity::class.java)
            startActivity(intent)
        }

        binding.homeButtonIMG.setOnClickListener {

            intent = Intent(this,PocetnaActivity::class.java)
            startActivity(intent)
        }

        binding.profileStatBtn.setOnClickListener{
            intent = Intent(this@ProfileActivity,ProfileStatsActivity::class.java)
            startActivity(intent)
        }

//kraj buttona za aktivnosti
        if(changeStats == false){
            cardViewChange.visibility = View.GONE
            changeStats = false
            cardViewShow.visibility = View.VISIBLE
            binding.changeStatsBtnFAKE.visibility = View.GONE
        }



            binding.changeStatsBtn.setOnClickListener{

                if(!changeStats){
                    changeStats = true //kad klikne upali ovaj za promjeniti
                    cardViewChange.visibility = View.VISIBLE
                    cardViewShow.visibility = View.GONE
                 //   binding.goToProgressBtn.visibility = View.GONE
                    binding.changeStatsBtn.visibility = View.GONE
                    binding.changeStatsBtnFAKE.visibility = View.VISIBLE
                }
            binding.changeStatsBtnFAKE.setOnClickListener {
                if(changeStats) {

                        textViewCalorieShow.text = textViewCalorie.text.toString() + " kcal"
                        textViewWaterShow.text = textViewWater.text.toString() + " liter"
                        textViewProteinShow.text = textViewProtein.text.toString() + " grams"
                        textViewCarbsShow.text = textViewCarb.text.toString() + " grams"

                        waterArrayList.add(textViewWater.text.toString())
                        proteinArrayList.add(textViewProtein.text.toString())
                        caloriesArrayList.add(textViewCalorie.text.toString())
                        carbsArrayList.add(textViewCarb.text.toString())
                        dataBase1.child("WaterGoal").setValue(waterArrayList.last())            //mijenja vrijednost unutar baze podataka
                        dataBase2.child("CalorieGoal").setValue(caloriesArrayList.last())       //  -----||----
                        dataBase.child("ProteinGoal").setValue(proteinArrayList.last())       //   ------||----
                        dataBase.child("CarbGoal").setValue(carbsArrayList.last())

                        //gasi ovaj za promjeniti i pali normalan

                        changeStats = false
                        cardViewChange.visibility = View.GONE
                        cardViewShow.visibility = View.VISIBLE
                      //  binding.goToProgressBtn.visibility = View.VISIBLE
                        binding.changeStatsBtn.visibility = View.VISIBLE
                        binding.changeStatsBtnFAKE.visibility = View.GONE

                    }
                }

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
                    val i = Intent(this@ProfileActivity, PocetnaActivity::class.java)
                    startActivity(i)
                }
                if(x1 == 0.0f){
                    val i = Intent(this@ProfileActivity,WaterActivity::class.java)
                    startActivity(i)
                }
            }
        }
        return false
    }

}

