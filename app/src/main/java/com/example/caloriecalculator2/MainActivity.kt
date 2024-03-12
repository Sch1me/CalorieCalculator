package com.example.caloriecalculator2

import android.Manifest
import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.content.pm.PackageManager
import android.icu.util.Calendar
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.caloriecalculator2.databinding.ActivityMainBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.getValue
import java.text.SimpleDateFormat
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.Date
import java.util.Locale

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

//kemijanje
        dataBaseHistory.child("Stats").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                try {
                    val a : List<StatsModel> = snapshot.children.map { dataSnapshot -> dataSnapshot.getValue(StatsModel::class.java)!! }
                    historyList.addAll(a)
                    velicinaListe=historyList.size / 3


                }catch (E:Exception){
                    Toast.makeText(this@MainActivity,"GRESKA U HISTORY BAZI",Toast.LENGTH_LONG).show()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@MainActivity,"CANCELED", Toast.LENGTH_SHORT).show()
            }
        })


        binding.button.setOnClickListener {

            //brisanje iz baze
            if(dateNow.toString() != date1.toString()){

                //upisuje povijest podataka da imam praćenje unosa kalorija
                historyList.add(velicinaListe, StatsModel(calorieIntake,date1,calorieGoal))
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
 }




