package com.example.caloriecalculator2;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010&\u001a\u00020\'2\b\u0010(\u001a\u0004\u0018\u00010)H\u0014J\u0010\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010R\u001a\u0010\u001a\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0010R\u001a\u0010\u001d\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000e\"\u0004\b\u001f\u0010\u0010R\u001a\u0010 \u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u000e\"\u0004\b\"\u0010\u0010R\u001a\u0010#\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u000e\"\u0004\b%\u0010\u0010\u00a8\u0006."}, d2 = {"Lcom/example/caloriecalculator2/WaterActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/example/caloriecalculator2/databinding/ActivityWaterBinding;", "getBinding", "()Lcom/example/caloriecalculator2/databinding/ActivityWaterBinding;", "setBinding", "(Lcom/example/caloriecalculator2/databinding/ActivityWaterBinding;)V", "dataBase", "Lcom/google/firebase/database/DatabaseReference;", "totalWaterAdded", "", "getTotalWaterAdded", "()F", "setTotalWaterAdded", "(F)V", "waterAdded", "", "getWaterAdded", "()Ljava/lang/String;", "setWaterAdded", "(Ljava/lang/String;)V", "waterInLiters", "getWaterInLiters", "setWaterInLiters", "x1", "getX1", "setX1", "x2", "getX2", "setX2", "y1", "getY1", "setY1", "y2", "getY2", "setY2", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onTouchEvent", "", "touchEvent", "Landroid/view/MotionEvent;", "app_debug"})
@kotlin.Suppress(names = {"UNUSED_EXPRESSION"})
public final class WaterActivity extends androidx.appcompat.app.AppCompatActivity {
    public com.example.caloriecalculator2.databinding.ActivityWaterBinding binding;
    @org.jetbrains.annotations.NotNull
    private java.lang.String waterAdded = "";
    private float waterInLiters = 0.0F;
    private float totalWaterAdded = 0.0F;
    @org.jetbrains.annotations.NotNull
    private final com.google.firebase.database.DatabaseReference dataBase = null;
    private float y1 = 0.0F;
    private float y2 = 0.0F;
    private float x1 = 0.0F;
    private float x2 = 0.0F;
    
    public WaterActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.caloriecalculator2.databinding.ActivityWaterBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull
    com.example.caloriecalculator2.databinding.ActivityWaterBinding p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getWaterAdded() {
        return null;
    }
    
    public final void setWaterAdded(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    public final float getWaterInLiters() {
        return 0.0F;
    }
    
    public final void setWaterInLiters(float p0) {
    }
    
    public final float getTotalWaterAdded() {
        return 0.0F;
    }
    
    public final void setTotalWaterAdded(float p0) {
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