// Generated by view binder compiler. Do not edit!
package com.example.caloriecalculator2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.caloriecalculator2.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityFoodBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final CardView cardViewHome;

  @NonNull
  public final ProgressBar determinateBar;

  @NonNull
  public final CardView foodGore;

  @NonNull
  public final RecyclerView foodLists;

  @NonNull
  public final ImageView homeButtonIMG;

  @NonNull
  public final ImageView profileButtonIMG;

  @NonNull
  public final CardView profilePod;

  @NonNull
  public final CardView view1;

  @NonNull
  public final CardView view2;

  @NonNull
  public final ImageView waterButtonIMG;

  private ActivityFoodBinding(@NonNull ConstraintLayout rootView, @NonNull CardView cardViewHome,
      @NonNull ProgressBar determinateBar, @NonNull CardView foodGore,
      @NonNull RecyclerView foodLists, @NonNull ImageView homeButtonIMG,
      @NonNull ImageView profileButtonIMG, @NonNull CardView profilePod, @NonNull CardView view1,
      @NonNull CardView view2, @NonNull ImageView waterButtonIMG) {
    this.rootView = rootView;
    this.cardViewHome = cardViewHome;
    this.determinateBar = determinateBar;
    this.foodGore = foodGore;
    this.foodLists = foodLists;
    this.homeButtonIMG = homeButtonIMG;
    this.profileButtonIMG = profileButtonIMG;
    this.profilePod = profilePod;
    this.view1 = view1;
    this.view2 = view2;
    this.waterButtonIMG = waterButtonIMG;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityFoodBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityFoodBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_food, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityFoodBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.cardViewHome;
      CardView cardViewHome = ViewBindings.findChildViewById(rootView, id);
      if (cardViewHome == null) {
        break missingId;
      }

      id = R.id.determinateBar;
      ProgressBar determinateBar = ViewBindings.findChildViewById(rootView, id);
      if (determinateBar == null) {
        break missingId;
      }

      id = R.id.foodGore;
      CardView foodGore = ViewBindings.findChildViewById(rootView, id);
      if (foodGore == null) {
        break missingId;
      }

      id = R.id.foodLists;
      RecyclerView foodLists = ViewBindings.findChildViewById(rootView, id);
      if (foodLists == null) {
        break missingId;
      }

      id = R.id.homeButtonIMG;
      ImageView homeButtonIMG = ViewBindings.findChildViewById(rootView, id);
      if (homeButtonIMG == null) {
        break missingId;
      }

      id = R.id.profileButtonIMG;
      ImageView profileButtonIMG = ViewBindings.findChildViewById(rootView, id);
      if (profileButtonIMG == null) {
        break missingId;
      }

      id = R.id.profilePod;
      CardView profilePod = ViewBindings.findChildViewById(rootView, id);
      if (profilePod == null) {
        break missingId;
      }

      id = R.id.view1;
      CardView view1 = ViewBindings.findChildViewById(rootView, id);
      if (view1 == null) {
        break missingId;
      }

      id = R.id.view2;
      CardView view2 = ViewBindings.findChildViewById(rootView, id);
      if (view2 == null) {
        break missingId;
      }

      id = R.id.waterButtonIMG;
      ImageView waterButtonIMG = ViewBindings.findChildViewById(rootView, id);
      if (waterButtonIMG == null) {
        break missingId;
      }

      return new ActivityFoodBinding((ConstraintLayout) rootView, cardViewHome, determinateBar,
          foodGore, foodLists, homeButtonIMG, profileButtonIMG, profilePod, view1, view2,
          waterButtonIMG);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
