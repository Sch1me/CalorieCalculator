package com.example.caloriecalculator2;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\'H\u0014R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u001a\u0010\u0018\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001cX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\f\"\u0004\b \u0010\u000eR\u001a\u0010!\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0012\"\u0004\b#\u0010\u0014\u00a8\u0006("}, d2 = {"Lcom/example/caloriecalculator2/FoodDetailsActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/example/caloriecalculator2/databinding/ActivityFoodDetailsBinding;", "getBinding", "()Lcom/example/caloriecalculator2/databinding/ActivityFoodDetailsBinding;", "setBinding", "(Lcom/example/caloriecalculator2/databinding/ActivityFoodDetailsBinding;)V", "calorieGoal", "", "getCalorieGoal", "()I", "setCalorieGoal", "(I)V", "calorieIntake", "", "getCalorieIntake", "()F", "setCalorieIntake", "(F)V", "carbGoal", "getCarbGoal", "setCarbGoal", "carbIntake", "getCarbIntake", "setCarbIntake", "dataBaseGoals", "Lcom/google/firebase/database/DatabaseReference;", "dataBaseIntake", "proteinGoal", "getProteinGoal", "setProteinGoal", "proteinIntake", "getProteinIntake", "setProteinIntake", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"})
public final class FoodDetailsActivity extends androidx.appcompat.app.AppCompatActivity {
    public com.example.caloriecalculator2.databinding.ActivityFoodDetailsBinding binding;
    @org.jetbrains.annotations.NotNull
    private final com.google.firebase.database.DatabaseReference dataBaseGoals = null;
    @org.jetbrains.annotations.NotNull
    private final com.google.firebase.database.DatabaseReference dataBaseIntake = null;
    private float calorieIntake = 0.0F;
    private float proteinIntake = 0.0F;
    private float carbIntake = 0.0F;
    private int calorieGoal = 0;
    private int proteinGoal = 0;
    private int carbGoal = 0;
    
    public FoodDetailsActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.caloriecalculator2.databinding.ActivityFoodDetailsBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull
    com.example.caloriecalculator2.databinding.ActivityFoodDetailsBinding p0) {
    }
    
    public final float getCalorieIntake() {
        return 0.0F;
    }
    
    public final void setCalorieIntake(float p0) {
    }
    
    public final float getProteinIntake() {
        return 0.0F;
    }
    
    public final void setProteinIntake(float p0) {
    }
    
    public final float getCarbIntake() {
        return 0.0F;
    }
    
    public final void setCarbIntake(float p0) {
    }
    
    public final int getCalorieGoal() {
        return 0;
    }
    
    public final void setCalorieGoal(int p0) {
    }
    
    public final int getProteinGoal() {
        return 0;
    }
    
    public final void setProteinGoal(int p0) {
    }
    
    public final int getCarbGoal() {
        return 0;
    }
    
    public final void setCarbGoal(int p0) {
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
}