package com.example.caloriecalculator2;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0014J\u0010\u0010%\u001a\u00020&2\u0006\u0010\'\u001a\u00020(H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\u001a\u0010\u001b\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017R\u001a\u0010\u001e\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0015\"\u0004\b \u0010\u0017\u00a8\u0006)"}, d2 = {"Lcom/example/caloriecalculator2/FoodActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/example/caloriecalculator2/databinding/ActivityFoodBinding;", "getBinding", "()Lcom/example/caloriecalculator2/databinding/ActivityFoodBinding;", "setBinding", "(Lcom/example/caloriecalculator2/databinding/ActivityFoodBinding;)V", "dataBase", "Lcom/google/firebase/database/DatabaseReference;", "dataBaseIngrediants", "dataBaseMeal", "foodList", "Ljava/util/ArrayList;", "Lcom/example/caloriecalculator2/FoodsModel;", "getFoodList", "()Ljava/util/ArrayList;", "x1", "", "getX1", "()F", "setX1", "(F)V", "x2", "getX2", "setX2", "y1", "getY1", "setY1", "y2", "getY2", "setY2", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onTouchEvent", "", "touchEvent", "Landroid/view/MotionEvent;", "app_debug"})
public final class FoodActivity extends androidx.appcompat.app.AppCompatActivity {
    public com.example.caloriecalculator2.databinding.ActivityFoodBinding binding;
    @org.jetbrains.annotations.NotNull
    private final com.google.firebase.database.DatabaseReference dataBase = null;
    @org.jetbrains.annotations.NotNull
    private final com.google.firebase.database.DatabaseReference dataBaseIngrediants = null;
    @org.jetbrains.annotations.NotNull
    private final com.google.firebase.database.DatabaseReference dataBaseMeal = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.ArrayList<com.example.caloriecalculator2.FoodsModel> foodList = null;
    private float y1 = 0.0F;
    private float y2 = 0.0F;
    private float x1 = 0.0F;
    private float x2 = 0.0F;
    
    public FoodActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.caloriecalculator2.databinding.ActivityFoodBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull
    com.example.caloriecalculator2.databinding.ActivityFoodBinding p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.ArrayList<com.example.caloriecalculator2.FoodsModel> getFoodList() {
        return null;
    }
    
    public final float getY1() {
        return 0.0F;
    }
    
    public final void setY1(float p0) {
    }
    
    public final float getY2() {
        return 0.0F;
    }
    
    public final void setY2(float p0) {
    }
    
    public final float getX1() {
        return 0.0F;
    }
    
    public final void setX1(float p0) {
    }
    
    public final float getX2() {
        return 0.0F;
    }
    
    public final void setX2(float p0) {
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override
    public boolean onTouchEvent(@org.jetbrains.annotations.NotNull
    android.view.MotionEvent touchEvent) {
        return false;
    }
}