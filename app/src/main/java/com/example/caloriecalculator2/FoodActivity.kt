package com.example.caloriecalculator2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.MotionEvent
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.caloriecalculator2.databinding.ActivityFoodBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener



class FoodActivity : AppCompatActivity() {
    lateinit var binding: ActivityFoodBinding
    private val dataBase: DatabaseReference =
        FirebaseDatabase.getInstance("https://caloriecalculator2-2cb5c-default-rtdb.europe-west1.firebasedatabase.app/").getReference("Food")
    private val dataBaseIngrediants: DatabaseReference =
        FirebaseDatabase.getInstance("https://caloriecalculator2-2cb5c-default-rtdb.europe-west1.firebasedatabase.app/").getReference("Food").child("Ingrediants")
    private val dataBaseMeal: DatabaseReference =
        FirebaseDatabase.getInstance("https://caloriecalculator2-2cb5c-default-rtdb.europe-west1.firebasedatabase.app/").getReference("Food").child("Meals")
    val foodList = ArrayList<FoodsModel>()
    var y1 : Float = 0.0f
    var y2 : Float =0.0f
    var x1 : Float =0.0f
    var x2 : Float =0.0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFoodBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.waterButtonIMG.setOnClickListener {

            intent = Intent(this, WaterActivity::class.java )
            startActivity(intent)

        }
        binding.homeButtonIMG.setOnClickListener {

            intent = Intent(this, PocetnaActivity::class.java )
            startActivity(intent)

        }
        binding.profileButtonIMG.setOnClickListener {

            intent = Intent(this, ProfileActivity::class.java )
            startActivity(intent)

        }

//upravljanje vidljivoscu loadinga progress bara
        Handler().postDelayed({
            // Postavljanje vidljivosti ProgressBar-a na false nakon 2 sekunde
            binding.determinateBar.visibility = View.GONE
        }, 1000)

//RECYCLER VIEW mehanika za dodavanje u food item
    //recyclerView za ingrediants
        dataBase.child("ing2").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                try {
                    val a : List<FoodsModel> = snapshot.children.map { dataSnapshot -> dataSnapshot.getValue(FoodsModel::class.java)!! }
                    val c=a.size
                    println(c)
                    foodList.addAll(a)

                }catch (E:Exception){
                    Toast.makeText(this@FoodActivity,E.toString(),Toast.LENGTH_LONG).show()
                }

                val emptyAdapter = FoodAdapter(foodList,this@FoodActivity,foodList)
                binding.foodLists.apply {
                    layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
                    adapter = FoodAdapter(foodList, this@FoodActivity,foodList)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@FoodActivity,"Failed With DatabaseIngrediant", Toast.LENGTH_SHORT).show()
            }
        })

    //recyclerView za meals
        dataBase.child("Meals").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                try {
                    val a : List<FoodsModel> = snapshot.children.map { dataSnapshot -> dataSnapshot.getValue(FoodsModel::class.java)!! }
                    val c=a.size

                    println(c)
                    foodList.addAll(a)

                }catch (E:Exception){
                    Toast.makeText(this@FoodActivity,E.toString(),Toast.LENGTH_LONG).show()
                }

                val emptyAdapter = FoodAdapter(foodList,this@FoodActivity,foodList)
                binding.foodLists.apply {
                    layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
                    adapter = FoodAdapter(foodList, this@FoodActivity,foodList)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@FoodActivity,"Failed With DatabaseIngrediant", Toast.LENGTH_SHORT).show()
            }
        })

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
                    val i = Intent(this@FoodActivity, WaterActivity::class.java)
                    startActivity(i)
                } else if (x1 > x2) {
                    val i = Intent(this@FoodActivity, ProfileActivity::class.java)
                    startActivity(i)
                }
            }
        }
        return false
    }

}