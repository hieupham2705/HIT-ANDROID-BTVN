// Generated by view binder compiler. Do not edit!
package com.example.facebook.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.facebook.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ItemRecyNewsBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final ImageView erase;

  @NonNull
  public final TextView texthome;

  private ItemRecyNewsBinding(@NonNull LinearLayout rootView, @NonNull ImageView erase,
      @NonNull TextView texthome) {
    this.rootView = rootView;
    this.erase = erase;
    this.texthome = texthome;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemRecyNewsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemRecyNewsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_recy_news, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemRecyNewsBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.erase;
      ImageView erase = ViewBindings.findChildViewById(rootView, id);
      if (erase == null) {
        break missingId;
      }

      id = R.id.texthome;
      TextView texthome = ViewBindings.findChildViewById(rootView, id);
      if (texthome == null) {
        break missingId;
      }

      return new ItemRecyNewsBinding((LinearLayout) rootView, erase, texthome);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
