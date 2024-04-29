package com.example.caloriecalculator2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.caloriecalculator2.databinding.ActivityProfileStatsBinding
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.getValue

class ProfileStatsActivity : AppCompatActivity() {
    lateinit var binding : ActivityProfileStatsBinding
    private val dataBase: DatabaseReference =
        FirebaseDatabase.getInstance("https://caloriecalculator2-2cb5c-default-rtdb.europe-west1.firebasedatabase.app/").getReference("IntakeHistory")
    var StatsList = ArrayList<StatsModel>()
    val xValues = ArrayList<String>()
    val yValues = ArrayList<Float>()
    lateinit var barList:ArrayList<BarEntry>
    lateinit var barDataSet:BarDataSet
    lateinit var barData : BarData
    var index = 0
    //kemijanje
    var i = 0
     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileStatsBinding.inflate(layoutInflater)
        setContentView(binding.root)

         barList = ArrayList()
         //očitava bazu podataka
         dataBase.child("Stats").addValueEventListener(object :ValueEventListener{
             override fun onDataChange(snapshot: DataSnapshot) {
                 try {
                     //dodava sve elemente u listu
                     val a : List<StatsModel> = snapshot.children.map { dataSnapshot -> dataSnapshot.getValue(StatsModel::class.java)!! }
                     StatsList.addAll(a)

                 }catch (e:Exception){
                     Toast.makeText(this@ProfileStatsActivity,"$e",Toast.LENGTH_LONG).show()
                 }
                 //provjerava ako je empty string da stavi 0, jer znaci da korisnik nije unio nista taj dan
                 while (i < StatsList.size){
                     if(StatsList[i].calorieIntake.isEmpty()){
                         StatsList[i].calorieIntake = "0"
                     }
                     if(StatsList[i].calorieGoal.isEmpty()){
                         StatsList[i].calorieGoal = "2500"
                     }
                     i++
                 }
                 //postavlja podatke za dijagram
                 while(index < StatsList.size){
                     barList.add(BarEntry(index.toFloat(),((StatsList[index].calorieIntake.toFloat() / StatsList[index].calorieGoal.toFloat())*100)))
                     index++
                 }
                 val emptyAdapter = ProfileStatsAdapter(StatsList,this@ProfileStatsActivity)
                 binding.statsList.apply {
                     layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
                     adapter = ProfileStatsAdapter(StatsList, this@ProfileStatsActivity)
                 }

                 //postavlja graf na neke vrijednosti
                 barDataSet= BarDataSet(barList,"Naslov")
                 barData = BarData(barDataSet)
                 binding.dijagram.data = BarData(BarDataSet(barList,"Calorie intake history in %"))
                 binding.dijagram.data.barWidth = 1F

                 binding.dijagram.invalidate()
             }

             override fun onCancelled(error: DatabaseError) {
                 TODO("Not yet implemented")
             }
         })
        //upravljanje vidljivoscu loadinga progress bara
        Handler().postDelayed({
            // Postavljanje vidljivosti ProgressBar-a na false nakon 2 sekunde
            binding.determinateBar.visibility = View.GONE
        }, 1000)

        binding.backBtn.setOnClickListener {
            intent = Intent(this@ProfileStatsActivity,ProfileActivity::class.java)
            startActivity(intent)
        }

    }
}