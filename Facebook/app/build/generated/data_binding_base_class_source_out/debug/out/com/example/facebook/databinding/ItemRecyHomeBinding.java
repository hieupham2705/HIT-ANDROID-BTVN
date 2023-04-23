// Generated by view binder compiler. Do not edit!
package com.example.facebook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.facebook.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ItemRecyHomeBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final RecyclerView recyclerLayoutNews;

  @NonNull
  public final RecyclerView recyclerLayoutStories;

  private ItemRecyHomeBinding(@NonNull LinearLayout rootView,
      @NonNull RecyclerView recyclerLayoutNews, @NonNull RecyclerView recyclerLayoutStories) {
    this.rootView = rootView;
    this.recyclerLayoutNews = recyclerLayoutNews;
    this.recyclerLayoutStories = recyclerLayoutStories;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemRecyHomeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemRecyHomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_recy_home, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemRecyHomeBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.recycler_layout_news;
      RecyclerView recyclerLayoutNews = ViewBindings.findChildViewById(rootView, id);
      if (recyclerLayoutNews == null) {
        break missingId;
      }

      id = R.id.recycler_layout_stories;
      RecyclerView recyclerLayoutStories = ViewBindings.findChildViewById(rootView, id);
      if (recyclerLayoutStories == null) {
        break missingId;
      }

      return new ItemRecyHomeBinding((LinearLayout) rootView, recyclerLayoutNews,
          recyclerLayoutStories);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
