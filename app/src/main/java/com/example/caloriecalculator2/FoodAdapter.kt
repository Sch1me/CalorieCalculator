package com.example.caloriecalculator2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.caloriecalculator2.databinding.FoodItemBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.getValue
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference

private val dataBase: DatabaseReference =
    FirebaseDatabase.getInstance("https://caloriecalculator2-2cb5c-default-rtdb.europe-west1.firebasedatabase.app/").getReference("Food").child("Ingredients")
private val dataBaseIntake: DatabaseReference =
    FirebaseDatabase.getInstance("https://caloriecalculator2-2cb5c-default-rtdb.europe-west1.firebasedatabase.app/").getReference("CurrentIntake")

private var calorieIntake : String = ""
private var proteinIntake : String = ""
private var carbIntake: String = ""
private var ammountEaten : String = ""
//kemijanje
private var currentCalorieValue : Int = 0
private var currentProteinValue : Int = 0
private var currentCarbValue : Int = 0

class FoodAdapter  (
    private val foodList: ArrayList<FoodsModel>,
    private val th : Context,
    private var tempFood: ArrayList<FoodsModel>
):
        RecyclerView.Adapter<FoodAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodAdapter.ViewHolder {

        val v = FoodItemBinding.inflate(LayoutInflater.from(th),parent,false)
        return ViewHolder(v)
    }
    override fun onBindViewHolder(holder: FoodAdapter.ViewHolder, position: Int) {
        var list=ArrayList<FoodsModel>()
        list.clear()
        list.add(foodList[position*3])
        list.add(foodList[position*3+1])
        list.add(foodList[position*3+2])

        holder.bindItem(list, th, position)
    }
    override fun getItemCount(): Int {
        return foodList.size / 3
    }
    class ViewHolder(private var itemBinding: FoodItemBinding):
        RecyclerView.ViewHolder(itemBinding.root){
        fun bindItem(foodsModels: ArrayList<FoodsModel>, th: Context,position: Int){

//postavlja pocetni newScreenCardView na nevidiljvo
            itemBinding.newScreenCardViewID.visibility = View.GONE


//cita iz baze podataka TRENUTNE VRIJEDNOSTI UNESENIH KALORIJA PROTEIN I CARBS-a
            dataBaseIntake.addValueEventListener(object : ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    try {
                        calorieIntake = snapshot.child("CalorieIntake").getValue().toString()
                        proteinIntake = snapshot.child("ProteinIntake").getValue().toString()
                        carbIntake = snapshot.child("CarbIntake").getValue().toString()
                    }catch (e:Exception){
                        println(e)
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }

            })

//button u svakom newScreenCardView
            itemBinding.enterButtonID.setOnClickListener {
                ammountEaten = itemBinding.ammountEatenEditText.text.toString()
                if(ammountEaten.isEmpty()){
                    Toast.makeText(th,"Enter Ammount Eaten",Toast.LENGTH_SHORT).show()

                }else if(ammountEaten.toInt() >= 100) {
                    //ako user unese da je pojeo necega vise ili jednako 100g
                    calorieIntake =
                        (calorieIntake.toInt() + currentCalorieValue * (ammountEaten.toInt() / 100)).toString()
                    carbIntake =
                        (carbIntake.toInt() + currentCarbValue * (ammountEaten.toInt() / 100)).toString()
                    proteinIntake =
                        (proteinIntake.toInt() + currentProteinValue * (ammountEaten.toInt() / 100)).toString()

                    dataBaseIntake.child("CalorieIntake").setValue(calorieIntake)
                    dataBaseIntake.child("CarbIntake").setValue(carbIntake)
                    dataBaseIntake.child("ProteinIntake").setValue(proteinIntake)
                    itemBinding.newScreenCardViewID.visibility = View.GONE

                }else{
                    calorieIntake =(calorieIntake.toInt() + (currentCalorieValue/10) * (ammountEaten.toInt()/10)).toString()
                    carbIntake =(carbIntake.toInt() + (currentCarbValue/10) * (ammountEaten.toInt()/10)).toString()
                    proteinIntake =(proteinIntake.toInt() + (currentProteinValue/10) * (ammountEaten.toInt()/10)).toString()

                    dataBaseIntake.child("CalorieIntake").setValue((calorieIntake))
                    dataBaseIntake.child("CarbIntake").setValue(carbIntake)
                    dataBaseIntake.child("ProteinIntake").setValue(proteinIntake)
                    itemBinding.newScreenCardViewID.visibility = View.GONE
                }
                itemBinding.ammountEatenEditText.text = null
            }

            //back button, samo gasi cardView
            itemBinding.backButtonID.setOnClickListener {
                itemBinding.ammountEatenEditText.text = null
                itemBinding.newScreenCardViewID.visibility = View.GONE
            }

//prikazi za racunanje kalorija
            //za foods u prvom redu
            itemBinding.foodImageView.setOnClickListener{
                itemBinding.newScreenCardViewID.visibility = View.VISIBLE
                itemBinding.calorieTextView.text = "calories: " + foodsModels[0].Calories.toString() + " kcal"
                itemBinding.carbsTextView.text = "carbs: "+foodsModels[0].Carbs.toString() + " grams"
                itemBinding.proteinTextView.text = "protein: "+foodsModels[0].Protein.toString() + " grams"
                currentProteinValue = foodsModels[0].Protein
                currentCarbValue = foodsModels[0].Carbs
                currentCalorieValue = foodsModels[0].Calories
            }
            //za foods u drugom redu
            itemBinding.foodImageView2.setOnClickListener {
                itemBinding.newScreenCardViewID.visibility = View.VISIBLE
                itemBinding.calorieTextView.text = "calories: "+foodsModels[1].Calories.toString() + " kcal"
                itemBinding.carbsTextView.text = "carbs: "+foodsModels[1].Carbs.toString() + " grams"
                itemBinding.proteinTextView.text = "protein: "+foodsModels[1].Protein.toString() + " grams"
                currentProteinValue = foodsModels[1].Protein
                currentCarbValue = foodsModels[1].Carbs
                currentCalorieValue = foodsModels[1].Calories
            }
            //za foods u trecem redu
            itemBinding.foodImageView3.setOnClickListener {
                itemBinding.newScreenCardViewID.visibility = View.VISIBLE
                itemBinding.calorieTextView.text = "calories: "+foodsModels[2].Calories.toString() + " kcal"
                itemBinding.carbsTextView.text = "carbs: "+foodsModels[2].Carbs.toString() + " grams"
                itemBinding.proteinTextView.text = "protein: "+foodsModels[2].Protein.toString() + " grams"
                currentProteinValue = foodsModels[2].Protein
                currentCarbValue = foodsModels[2].Carbs
                currentCalorieValue = foodsModels[2].Calories
            }
//kraj prikaza za racunanje kalorija

            //postavlja ime hrane u itemu
            itemBinding.foodNameTextView.text=foodsModels[0].Name
            itemBinding.foodNameTextView2.text=foodsModels[1].Name
            itemBinding.foodNameTextView3.text=foodsModels[2].Name

            //NAPRAVIT KOD ZA UVRSTAVANJE SLIKA

        }
    }

}

