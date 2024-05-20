package com.example.caloriecalculator2

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.caloriecalculator2.databinding.ActivityMainBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.time.Instant
import java.time.LocalDate

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
     var lastChange : String = ""
     var date1 = "2024-01-01"
    var date2: String = ""

    val currentInstant = Instant.now()
    private val dataBaseIntake: DatabaseReference =
        FirebaseDatabase.getInstance("https://caloriecalculator2-2cb5c-default-rtdb.europe-west1.firebasedatabase.app/").getReference("CurrentIntake")
    private val dataBaseWater: DatabaseReference =
        FirebaseDatabase.getInstance("https://caloriecalculator2-2cb5c-default-rtdb.europe-west1.firebasedatabase.app/").getReference("Water")
    private val dataBaseDate: DatabaseReference =
        FirebaseDatabase.getInstance("https://caloriecalculator2-2cb5c-default-rtdb.europe-west1.firebasedatabase.app/").getReference("Dates")
     private val dataBaseHistory: DatabaseReference =
         FirebaseDatabase.getInstance("https://caloriecalculator2-2cb5c-default-rtdb.europe-west1.firebasedatabase.app/").getReference("IntakeHistory")
     private val dataBaseGoals: DatabaseReference =
         FirebaseDatabase.getInstance("https://caloriecalculator2-2cb5c-default-rtdb.europe-west1.firebasedatabase.app/").getReference("Goals").child("CalorieGoal")

     var dateNow = LocalDate.now()

     var calorieIntake : String = ""
     var calorieGoal : String = ""
     var dateOfIntake : String = ""
     val historyList = ArrayList<StatsModel>()
    var velicinaListe : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pozivanjeDate()
        pozivanjeIntake()
        pozivanjeHistory()

        binding.button.setOnClickListener {

            //brisanje iz baze
            if(dateNow.toString() != date1.toString()){
                var i = 0
                while (i <= velicinaListe){
                    historyList.add(i, StatsModel(calorieIntake, date1, calorieGoal))
                    i++
                }
                dataBaseHistory.child("Stats").setValue(historyList)
                //brise podatke iz baze
                dataBaseIntake.child("CalorieIntake").setValue(0)
                dataBaseIntake.child("ProteinIntake").setValue(0)
                dataBaseIntake.child("CarbIntake").setValue(0)
                dataBaseWater.child("CurrentWater").setValue(0)
                dataBaseDate.child("LastDateChange").setValue(dateNow.toString())
            }

            //kraj brisanja podataka (koda)

            intent = Intent(this@MainActivity,ProfileActivity::class.java)
            startActivity(intent)
        }

    }
    private fun pozivanjeDate(){
        //citanje datuma i brisanje podatak iz baze podataka
        dataBaseDate.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                try {
                    date1 = snapshot.child("LastDateChange").getValue() as String

                }catch (e:Exception){
                    Toast.makeText(this@MainActivity, "GRESKA U DATE BAZI", Toast.LENGTH_LONG).show()
                    val pomoc = e.toString()
                    println(pomoc)
                }

            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }
    private fun pozivanjeHistory(){
        dataBaseHistory.child("Stats").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                try {
                    val a : List<StatsModel> = snapshot.children.map { dataSnapshot -> dataSnapshot.getValue(StatsModel::class.java)!! }
                    historyList.addAll(a)
                    velicinaListe=historyList.size / 3
                 //   Toast.makeText(this@MainActivity,"Ocitalo je listu",Toast.LENGTH_SHORT).show()

                }catch (E:Exception){
                    Toast.makeText(this@MainActivity,"GRESKA U HISTORY BAZI",Toast.LENGTH_LONG).show()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@MainActivity,"CANCELED", Toast.LENGTH_SHORT).show()
            }
        })
    }
    private fun pozivanjeIntake(){
        dataBaseGoals.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                try {
                    calorieGoal = snapshot.child("CalorieGoal").getValue().toString()
                }catch (e:Exception){
                    Toast.makeText(this@MainActivity,"GRESKA U GOAL BAZI",Toast.LENGTH_LONG).show()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })

        dataBaseIntake.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                try {
                    calorieIntake = snapshot.child("CalorieIntake").getValue().toString()
                }catch (e:Exception){
                    Toast.makeText(this@MainActivity,"GRESKA U INTAKE BAZI",Toast.LENGTH_LONG).show()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }

 }
