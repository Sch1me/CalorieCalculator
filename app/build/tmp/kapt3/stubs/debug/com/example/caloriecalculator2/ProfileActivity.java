package com.example.caloriecalculator2;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 32\u00020\u0001:\u00013B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/H\u0014J\u0010\u00100\u001a\u00020\n2\u0006\u00101\u001a\u000202H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\"\u0010\u0016\u001a\n \u0018*\u0004\u0018\u00010\u00170\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\u001eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010 \"\u0004\b%\u0010\"R\u001a\u0010&\u001a\u00020\u001eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010 \"\u0004\b(\u0010\"R\u001a\u0010)\u001a\u00020\u001eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010 \"\u0004\b+\u0010\"\u00a8\u00064"}, d2 = {"Lcom/example/caloriecalculator2/ProfileActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/example/caloriecalculator2/databinding/ActivityProfileBinding;", "getBinding", "()Lcom/example/caloriecalculator2/databinding/ActivityProfileBinding;", "setBinding", "(Lcom/example/caloriecalculator2/databinding/ActivityProfileBinding;)V", "changeStats", "", "getChangeStats", "()Z", "setChangeStats", "(Z)V", "dataBase", "Lcom/google/firebase/database/DatabaseReference;", "dataBase1", "dataBase2", "dataBaseDates", "dataBaseIntake", "dataBaseWaterIntake", "date", "Ljava/time/LocalDate;", "kotlin.jvm.PlatformType", "getDate", "()Ljava/time/LocalDate;", "setDate", "(Ljava/time/LocalDate;)V", "x1", "", "getX1", "()F", "setX1", "(F)V", "x2", "getX2", "setX2", "y1", "getY1", "setY1", "y2", "getY2", "setY2", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onTouchEvent", "touchEvent", "Landroid/view/MotionEvent;", "Companion", "app_debug"})
public final class ProfileActivity extends androidx.appcompat.app.AppCompatActivity {
    public com.example.caloriecalculator2.databinding.ActivityProfileBinding binding;
    @org.jetbrains.annotations.NotNull
    private final com.google.firebase.database.DatabaseReference dataBase1 = null;
    @org.jetbrains.annotations.NotNull
    private final com.google.firebase.database.DatabaseReference dataBase2 = null;
    @org.jetbrains.annotations.NotNull
    private final com.google.firebase.database.DatabaseReference dataBase = null;
    @org.jetbrains.annotations.NotNull
    private final com.google.firebase.database.DatabaseReference dataBaseDates = null;
    @org.jetbrains.annotations.NotNull
    private final com.google.firebase.database.DatabaseReference dataBaseIntake = null;
    @org.jetbrains.annotations.NotNull
    private final com.google.firebase.database.DatabaseReference dataBaseWaterIntake = null;
    private java.time.LocalDate date;
    private boolean changeStats = false;
    @org.jetbrains.annotations.NotNull
    private static java.util.ArrayList<java.lang.String> proteinArrayList;
    @org.jetbrains.annotations.NotNull
    private static java.util.ArrayList<java.lang.String> carbsArrayList;
    @org.jetbrains.annotations.NotNull
    private static java.util.ArrayList<java.lang.String> waterArrayList;
    @org.jetbrains.annotations.NotNull
    private static java.util.ArrayList<java.lang.String> caloriesArrayList;
    @org.jetbrains.annotations.NotNull
    private static java.lang.String waterGoal;
    private float y1 = 0.0F;
    private float y2 = 0.0F;
    private float x1 = 0.0F;
    private float x2 = 0.0F;
    @org.jetbrains.annotations.NotNull
    public static final com.example.caloriecalculator2.ProfileActivity.Companion Companion = null;
    
    public ProfileActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.caloriecalculator2.databinding.ActivityProfileBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull
    com.example.caloriecalculator2.databinding.ActivityProfileBinding p0) {
    }
    
    public final java.time.LocalDate getDate() {
        return null;
    }
    
    public final void setDate(java.time.LocalDate p0) {
    }
    
    public final boolean getChangeStats() {
        return false;
    }
    
    public final void setChangeStats(boolean p0) {
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
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001a\u0010\u0013\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006\u0018"}, d2 = {"Lcom/example/caloriecalculator2/ProfileActivity$Companion;", "", "()V", "caloriesArrayList", "Ljava/util/ArrayList;", "", "getCaloriesArrayList", "()Ljava/util/ArrayList;", "setCaloriesArrayList", "(Ljava/util/ArrayList;)V", "carbsArrayList", "getCarbsArrayList", "setCarbsArrayList", "proteinArrayList", "getProteinArrayList", "setProteinArrayList", "waterArrayList", "getWaterArrayList", "setWaterArrayList", "waterGoal", "getWaterGoal", "()Ljava/lang/String;", "setWaterGoal", "(Ljava/lang/String;)V", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.util.ArrayList<java.lang.String> getProteinArrayList() {
            return null;
        }
        
        public final void setProteinArrayList(@org.jetbrains.annotations.NotNull
        java.util.ArrayList<java.lang.String> p0) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.util.ArrayList<java.lang.String> getCarbsArrayList() {
            return null;
        }
        
        public final void setCarbsArrayList(@org.jetbrains.annotations.NotNull
        java.util.ArrayList<java.lang.String> p0) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.util.ArrayList<java.lang.String> getWaterArrayList() {
            return null;
        }
        
        public final void setWaterArrayList(@org.jetbrains.annotations.NotNull
        java.util.ArrayList<java.lang.String> p0) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.util.ArrayList<java.lang.String> getCaloriesArrayList() {
            return null;
        }
        
        public final void setCaloriesArrayList(@org.jetbrains.annotations.NotNull
        java.util.ArrayList<java.lang.String> p0) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getWaterGoal() {
            return null;
        }
        
        public final void setWaterGoal(@org.jetbrains.annotations.NotNull
        java.lang.String p0) {
        }
    }
}