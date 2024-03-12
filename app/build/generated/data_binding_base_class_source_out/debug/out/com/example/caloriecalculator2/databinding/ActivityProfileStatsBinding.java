// Generated by view binder compiler. Do not edit!
package com.example.caloriecalculator2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.caloriecalculator2.R;
import com.github.mikephil.charting.charts.BarChart;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityProfileStatsBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button backBtn;

  @NonNull
  public final ProgressBar determinateBar;

  @NonNull
  public final BarChart dijagram;

  @NonNull
  public final CardView profileStatsGore;

  @NonNull
  public final RecyclerView statsList;

  private ActivityProfileStatsBinding(@NonNull ConstraintLayout rootView, @NonNull Button backBtn,
      @NonNull ProgressBar determinateBar, @NonNull BarChart dijagram,
      @NonNull CardView profileStatsGore, @NonNull RecyclerView statsList) {
    this.rootView = rootView;
    this.backBtn = backBtn;
    this.determinateBar = determinateBar;
    this.dijagram = dijagram;
    this.profileStatsGore = profileStatsGore;
    this.statsList = statsList;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityProfileStatsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityProfileStatsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_profile_stats, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityProfileStatsBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.backBtn;
      Button backBtn = ViewBindings.findChildViewById(rootView, id);
      if (backBtn == null) {
        break missingId;
      }

      id = R.id.determinateBar;
      ProgressBar determinateBar = ViewBindings.findChildViewById(rootView, id);
      if (determinateBar == null) {
        break missingId;
      }

      id = R.id.dijagram;
      BarChart dijagram = ViewBindings.findChildViewById(rootView, id);
      if (dijagram == null) {
        break missingId;
      }

      id = R.id.profileStatsGore;
      CardView profileStatsGore = ViewBindings.findChildViewById(rootView, id);
      if (profileStatsGore == null) {
        break missingId;
      }

      id = R.id.statsList;
      RecyclerView statsList = ViewBindings.findChildViewById(rootView, id);
      if (statsList == null) {
        break missingId;
      }

      return new ActivityProfileStatsBinding((ConstraintLayout) rootView, backBtn, determinateBar,
          dijagram, profileStatsGore, statsList);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}