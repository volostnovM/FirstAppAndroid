// Generated by view binder compiler. Do not edit!
package ru.netology.nmedia.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import ru.netology.nmedia.R;

public final class ActivityEditPostBinding implements ViewBinding {
  @NonNull
  private final CoordinatorLayout rootView;

  @NonNull
  public final BottomAppBar bottomAppBar;

  @NonNull
  public final FloatingActionButton cancelButton;

  @NonNull
  public final EditText editPost;

  @NonNull
  public final FloatingActionButton saveButton;

  private ActivityEditPostBinding(@NonNull CoordinatorLayout rootView,
      @NonNull BottomAppBar bottomAppBar, @NonNull FloatingActionButton cancelButton,
      @NonNull EditText editPost, @NonNull FloatingActionButton saveButton) {
    this.rootView = rootView;
    this.bottomAppBar = bottomAppBar;
    this.cancelButton = cancelButton;
    this.editPost = editPost;
    this.saveButton = saveButton;
  }

  @Override
  @NonNull
  public CoordinatorLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityEditPostBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityEditPostBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_edit_post, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityEditPostBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.bottomAppBar;
      BottomAppBar bottomAppBar = ViewBindings.findChildViewById(rootView, id);
      if (bottomAppBar == null) {
        break missingId;
      }

      id = R.id.cancelButton;
      FloatingActionButton cancelButton = ViewBindings.findChildViewById(rootView, id);
      if (cancelButton == null) {
        break missingId;
      }

      id = R.id.editPost;
      EditText editPost = ViewBindings.findChildViewById(rootView, id);
      if (editPost == null) {
        break missingId;
      }

      id = R.id.saveButton;
      FloatingActionButton saveButton = ViewBindings.findChildViewById(rootView, id);
      if (saveButton == null) {
        break missingId;
      }

      return new ActivityEditPostBinding((CoordinatorLayout) rootView, bottomAppBar, cancelButton,
          editPost, saveButton);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
