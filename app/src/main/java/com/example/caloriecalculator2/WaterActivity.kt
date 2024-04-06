package com.example.caloriecalculator2

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Intent
import android.content.pm.PackageManager
import android.opengl.Visibility
import android.os.Build
import android.os.Build.VERSION_CODES
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.caloriecalculator2.databinding.ActivityWaterBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.getValue
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Suppress("UNUSED_EXPRESSION")
class WaterActivity : AppCompatActivity() {
    lateinit var binding: ActivityWaterBinding
    var waterAdded : String= ""
    var waterInLiters : Float = 0f
    var totalWaterAdded : Float = 0f
        private val dataBase: DatabaseReference =
        FirebaseDatabase.getInstance("https://caloriecalculator2-2cb5c-default-rtdb.europe-west1.firebasedatabase.app/").getReference("Water")


    var y1 : Float = 0.0f
    var y2 : Float =0.0f
    var x1 : Float =0.0f
    var x2 : Float =0.0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWaterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //upravljanje vidljivoscu loadinga progress bara
        Handler().postDelayed({
            // Postavljanje vidljivosti ProgressBar-a na false nakon 2 sekunde
            binding.determinateBar.visibility = View.GONE
        }, 1000)

//postavlja cardView kao nevidljiv
        binding.addWaterCardView.visibility = View.GONE


//postavlja pocetni tekst
        binding.hydrationText.text = "Current water intake: " + totalWaterAdded.toString() + " dcl"


//ucitava podatke iz baze podataka
        dataBase.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val waterInDataBase : String = snapshot.child("CurrentWater").getValue().toString()
                binding.hydrationText.text = "Current water intake: " + (waterInDataBase.toFloat() / 10f).toString() + " l"
                totalWaterAdded = waterInDataBase.toFloat()
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
                totalWaterAdded += waterAdded.toFloat()
                dataBase.child("CurrentWater").setValue(totalWaterAdded.toString())
                val brojZaIspis = String.format("%.2f",(totalWaterAdded/10f))
                binding.hydrationText.text =
                    "Current water intake: " + brojZaIspis + " l"
                binding.ammountOfWaterTxt.text = null
                binding.addWaterCardView.visibility = View.GONE
            }
        }

//button za resetiranje trenutnog unosa vode

        binding.resetWaterIntakeBtn.setOnClickListener{
            val oldWaterIntake : Float = totalWaterAdded
            totalWaterAdded = 0f
            binding.hydrationText.text =
                "Current water intake: " + totalWaterAdded.toString() + " dcl"
            dataBase.child("CurrentWater").setValue(totalWaterAdded)
            Toast.makeText(this@WaterActivity,"You just did a reset of your water intake!", Toast.LENGTH_SHORT).show()
            Toast.makeText(this@WaterActivity,"Your water intake was: " + oldWaterIntake / 10f + " l", Toast.LENGTH_SHORT).show()
        }

    }

    //funkcija za slajdanje lijevo-desno
    override fun onTouchEvent(touchEvent: MotionEvent): Boolean {
        when (touchEvent.action) {
            MotionEvent.ACTION_DOWN -> {
                x1 = touchEvent.x
                y1 = touchEvent.y
            }
            MotionEvent.ACTION_UP -> {
                x2 = touchEvent.x
                y2 = touchEvent.y
                if (x1 > x2) {
                    val i = Intent(this@WaterActivity, PocetnaActivity::class.java)
                    startActivity(i)
                }
            }
        }
        return false
    }

}