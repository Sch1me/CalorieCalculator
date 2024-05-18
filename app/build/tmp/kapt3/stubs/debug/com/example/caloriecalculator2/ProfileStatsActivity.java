package com.example.caloriecalculator2;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u000105H\u0014R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R*\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00170\u0004j\b\u0012\u0004\u0012\u00020\u0017`\u0018X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0007\"\u0004\b\u001a\u0010\tR\u001a\u0010\u001b\u001a\u00020\u001cX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\"X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010#\u001a\u00020$X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b\'\u0010(R\u001a\u0010)\u001a\u00020$X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010&\"\u0004\b+\u0010(R\u0017\u0010,\u001a\b\u0012\u0004\u0012\u00020-0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010\u0007R\u0017\u0010/\u001a\b\u0012\u0004\u0012\u0002000\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u0010\u0007\u00a8\u00066"}, d2 = {"Lcom/example/caloriecalculator2/ProfileStatsActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "StatsList", "Ljava/util/ArrayList;", "Lcom/example/caloriecalculator2/StatsModel;", "getStatsList", "()Ljava/util/ArrayList;", "setStatsList", "(Ljava/util/ArrayList;)V", "barData", "Lcom/github/mikephil/charting/data/BarData;", "getBarData", "()Lcom/github/mikephil/charting/data/BarData;", "setBarData", "(Lcom/github/mikephil/charting/data/BarData;)V", "barDataSet", "Lcom/github/mikephil/charting/data/BarDataSet;", "getBarDataSet", "()Lcom/github/mikephil/charting/data/BarDataSet;", "setBarDataSet", "(Lcom/github/mikephil/charting/data/BarDataSet;)V", "barList", "Lcom/github/mikephil/charting/data/BarEntry;", "Lkotlin/collections/ArrayList;", "getBarList", "setBarList", "binding", "Lcom/example/caloriecalculator2/databinding/ActivityProfileStatsBinding;", "getBinding", "()Lcom/example/caloriecalculator2/databinding/ActivityProfileStatsBinding;", "setBinding", "(Lcom/example/caloriecalculator2/databinding/ActivityProfileStatsBinding;)V", "dataBase", "Lcom/google/firebase/database/DatabaseReference;", "i", "", "getI", "()I", "setI", "(I)V", "index", "getIndex", "setIndex", "xValues", "", "getXValues", "yValues", "", "getYValues", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"})
public final class ProfileStatsActivity extends androidx.appcompat.app.AppCompatActivity {
    public com.example.caloriecalculator2.databinding.ActivityProfileStatsBinding binding;
    @org.jetbrains.annotations.NotNull
    private final com.google.firebase.database.DatabaseReference dataBase = null;
    @org.jetbrains.annotations.NotNull
    private java.util.ArrayList<com.example.caloriecalculator2.StatsModel> StatsList;
    @org.jetbrains.annotations.NotNull
    private final java.util.ArrayList<java.lang.String> xValues = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.ArrayList<java.lang.Float> yValues = null;
    public java.util.ArrayList<com.github.mikephil.charting.data.BarEntry> barList;
    public com.github.mikephil.charting.data.BarDataSet barDataSet;
    public com.github.mikephil.charting.data.BarData barData;
    private int index = 0;
    private int i = 0;
    
    public ProfileStatsActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.example.caloriecalculator2.databinding.ActivityProfileStatsBinding getBinding() {
        return null;
    }
    
    public final void setBinding(@org.jetbrains.annotations.NotNull
    com.example.caloriecalculator2.databinding.ActivityProfileStatsBinding p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.ArrayList<com.example.caloriecalculator2.StatsModel> getStatsList() {
        return null;
    }
    
    public final void setStatsList(@org.jetbrains.annotations.NotNull
    java.util.ArrayList<com.example.caloriecalculator2.StatsModel> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.ArrayList<java.lang.String> getXValues() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.ArrayList<java.lang.Float> getYValues() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.ArrayList<com.github.mikephil.charting.data.BarEntry> getBarList() {
        return null;
    }
    
    public final void setBarList(@org.jetbrains.annotations.NotNull
    java.util.ArrayList<com.github.mikephil.charting.data.BarEntry> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.github.mikephil.charting.data.BarDataSet getBarDataSet() {
        return null;
    }
    
    public final void setBarDataSet(@org.jetbrains.annotations.NotNull
    com.github.mikephil.charting.data.BarDataSet p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.github.mikephil.charting.data.BarData getBarData() {
        return null;
    }
    
    public final void setBarData(@org.jetbrains.annotations.NotNull
    com.github.mikephil.charting.data.BarData p0) {
    }
    
    public final int getIndex() {
        return 0;
    }
    
    public final void setIndex(int p0) {
    }
    
    public final int getI() {
        return 0;
    }
    
    public final void setI(int p0) {
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
}