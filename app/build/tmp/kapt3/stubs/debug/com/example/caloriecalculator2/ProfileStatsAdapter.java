package com.example.caloriecalculator2;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014B%\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000bH\u0016R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/example/caloriecalculator2/ProfileStatsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/caloriecalculator2/ProfileStatsAdapter$ViewHolder;", "calorieIntakeList", "Ljava/util/ArrayList;", "Lcom/example/caloriecalculator2/StatsModel;", "Lkotlin/collections/ArrayList;", "th", "Landroid/content/Context;", "(Ljava/util/ArrayList;Landroid/content/Context;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_debug"})
public final class ProfileStatsAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.caloriecalculator2.ProfileStatsAdapter.ViewHolder> {
    @org.jetbrains.annotations.NotNull
    private final java.util.ArrayList<com.example.caloriecalculator2.StatsModel> calorieIntakeList = null;
    @org.jetbrains.annotations.NotNull
    private final android.content.Context th = null;
    
    public ProfileStatsAdapter(@org.jetbrains.annotations.NotNull
    java.util.ArrayList<com.example.caloriecalculator2.StatsModel> calorieIntakeList, @org.jetbrains.annotations.NotNull
    android.content.Context th) {
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public com.example.caloriecalculator2.ProfileStatsAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.example.caloriecalculator2.ProfileStatsAdapter.ViewHolder holder, int position) {
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J.\u0010\u0005\u001a\u00020\u00062\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/example/caloriecalculator2/ProfileStatsAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemBinding", "Lcom/example/caloriecalculator2/databinding/ProfileStatsItemBinding;", "(Lcom/example/caloriecalculator2/databinding/ProfileStatsItemBinding;)V", "bindItem", "", "statsModel", "Ljava/util/ArrayList;", "Lcom/example/caloriecalculator2/StatsModel;", "Lkotlin/collections/ArrayList;", "th", "Landroid/content/Context;", "position", "", "app_debug"})
    public static final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private com.example.caloriecalculator2.databinding.ProfileStatsItemBinding itemBinding;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull
        com.example.caloriecalculator2.databinding.ProfileStatsItemBinding itemBinding) {
            super(null);
        }
        
        public final void bindItem(@org.jetbrains.annotations.NotNull
        java.util.ArrayList<com.example.caloriecalculator2.StatsModel> statsModel, @org.jetbrains.annotations.NotNull
        android.content.Context th, int position) {
        }
    }
}