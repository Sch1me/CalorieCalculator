package com.example.caloriecalculator2;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B=\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u00a2\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\fH\u0016J\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\fH\u0016R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/example/caloriecalculator2/FoodAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/caloriecalculator2/FoodAdapter$ViewHolder;", "foodList", "Ljava/util/ArrayList;", "Lcom/example/caloriecalculator2/FoodsModel;", "Lkotlin/collections/ArrayList;", "th", "Landroid/content/Context;", "tempFood", "(Ljava/util/ArrayList;Landroid/content/Context;Ljava/util/ArrayList;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_debug"})
public final class FoodAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.caloriecalculator2.FoodAdapter.ViewHolder> {
    @org.jetbrains.annotations.NotNull
    private final java.util.ArrayList<com.example.caloriecalculator2.FoodsModel> foodList = null;
    @org.jetbrains.annotations.NotNull
    private final android.content.Context th = null;
    @org.jetbrains.annotations.NotNull
    private java.util.ArrayList<com.example.caloriecalculator2.FoodsModel> tempFood;
    
    public FoodAdapter(@org.jetbrains.annotations.NotNull
    java.util.ArrayList<com.example.caloriecalculator2.FoodsModel> foodList, @org.jetbrains.annotations.NotNull
    android.content.Context th, @org.jetbrains.annotations.NotNull
    java.util.ArrayList<com.example.caloriecalculator2.FoodsModel> tempFood) {
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public com.example.caloriecalculator2.FoodAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.example.caloriecalculator2.FoodAdapter.ViewHolder holder, int position) {
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J.\u0010\u0005\u001a\u00020\u00062\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/example/caloriecalculator2/FoodAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemBinding", "Lcom/example/caloriecalculator2/databinding/FoodItemBinding;", "(Lcom/example/caloriecalculator2/databinding/FoodItemBinding;)V", "bindItem", "", "foodsModels", "Ljava/util/ArrayList;", "Lcom/example/caloriecalculator2/FoodsModel;", "Lkotlin/collections/ArrayList;", "th", "Landroid/content/Context;", "position", "", "app_debug"})
    public static final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private com.example.caloriecalculator2.databinding.FoodItemBinding itemBinding;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull
        com.example.caloriecalculator2.databinding.FoodItemBinding itemBinding) {
            super(null);
        }
        
        public final void bindItem(@org.jetbrains.annotations.NotNull
        java.util.ArrayList<com.example.caloriecalculator2.FoodsModel> foodsModels, @org.jetbrains.annotations.NotNull
        android.content.Context th, int position) {
        }
    }
}