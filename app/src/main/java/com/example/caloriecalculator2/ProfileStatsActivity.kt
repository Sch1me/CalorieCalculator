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
    val StatsList = ArrayList<StatsModel>()
    val xValues = ArrayList<String>()
    val yValues = ArrayList<String>()
     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileStatsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        for (i in StatsList){
             xValues.add(StatsModel().dateOfIntake)
             yValues.add(((StatsModel().calorieIntake.toInt() / StatsModel().calorieGoal.toInt()) * 100).toString() + " %")
        }
        val entries = ArrayList<BarEntry>()
        for (i in yValues.indices) {
            entries.add(BarEntry(xValues[i].toFloat(),yValues[i].toFloat()))
        }

        val dataSet = BarDataSet(entries, "LEGENDA") // Label predstavlja legendu grafikona

        val data = BarData(dataSet)
        // Postavljanje vrijednosti X osi
        binding.dijagram.xAxis.valueFormatter = IndexAxisValueFormatter()
        binding.dijagram.xAxis.position = XAxis.XAxisPosition.BOTTOM
        binding.dijagram.data = data
        binding.dijagram.invalidate()

        //upravljanje vidljivoscu loadinga progress bara
        Handler().postDelayed({
            // Postavljanje vidljivosti ProgressBar-a na false nakon 2 sekunde
            binding.determinateBar.visibility = View.GONE
        }, 1000)

        binding.backBtn.setOnClickListener {
            intent = Intent(this@ProfileStatsActivity,ProfileActivity::class.java)
            startActivity(intent)
        }

        dataBase.child("Stats").addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                try {
                    val a : List<StatsModel> = snapshot.children.map { dataSnapshot -> dataSnapshot.getValue(StatsModel::class.java)!! }
                    StatsList.addAll(a)

                }catch (e:Exception){
                    Toast.makeText(this@ProfileStatsActivity,"$e",Toast.LENGTH_LONG).show()
                }
                val emptyAdapter = ProfileStatsAdapter(StatsList,this@ProfileStatsActivity)
                binding.statsList.apply {
                    layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
                    adapter = ProfileStatsAdapter(StatsList, this@ProfileStatsActivity)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })



    }

}