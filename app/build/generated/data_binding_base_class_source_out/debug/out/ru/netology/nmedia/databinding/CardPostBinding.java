// Generated by view binder compiler. Do not edit!
package ru.netology.nmedia.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import ru.netology.nmedia.R;

public final class CardPostBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView author;

  @NonNull
  public final ImageView avatar;

  @NonNull
  public final Barrier barrierBottomContent;

  @NonNull
  public final Barrier barrierTop;

  @NonNull
  public final TextView content;

  @NonNull
  public final MaterialButton likeButton;

  @NonNull
  public final MaterialButton menu;

  @NonNull
  public final ImageButton play;

  @NonNull
  public final Group playVideoGroup;

  @NonNull
  public final TextView published;

  @NonNull
  public final MaterialButton shareButton;

  @NonNull
  public final ImageView video;

  @NonNull
  public final ImageButton viewButton;

  @NonNull
  public final TextView viewText;

  private CardPostBinding(@NonNull ConstraintLayout rootView, @NonNull TextView author,
      @NonNull ImageView avatar, @NonNull Barrier barrierBottomContent, @NonNull Barrier barrierTop,
      @NonNull TextView content, @NonNull MaterialButton likeButton, @NonNull MaterialButton menu,
      @NonNull ImageButton play, @NonNull Group playVideoGroup, @NonNull TextView published,
      @NonNull MaterialButton shareButton, @NonNull ImageView video,
      @NonNull ImageButton viewButton, @NonNull TextView viewText) {
    this.rootView = rootView;
    this.author = author;
    this.avatar = avatar;
    this.barrierBottomContent = barrierBottomContent;
    this.barrierTop = barrierTop;
    this.content = content;
    this.likeButton = likeButton;
    this.menu = menu;
    this.play = play;
    this.playVideoGroup = playVideoGroup;
    this.published = published;
    this.shareButton = shareButton;
    this.video = video;
    this.viewButton = viewButton;
    this.viewText = viewText;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static CardPostBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static CardPostBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.card_post, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static CardPostBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.author;
      TextView author = ViewBindings.findChildViewById(rootView, id);
      if (author == null) {
        break missingId;
      }

      id = R.id.avatar;
      ImageView avatar = ViewBindings.findChildViewById(rootView, id);
      if (avatar == null) {
        break missingId;
      }

      id = R.id.barrierBottomContent;
      Barrier barrierBottomContent = ViewBindings.findChildViewById(rootView, id);
      if (barrierBottomContent == null) {
        break missingId;
      }

      id = R.id.barrierTop;
      Barrier barrierTop = ViewBindings.findChildViewById(rootView, id);
      if (barrierTop == null) {
        break missingId;
      }

      id = R.id.content;
      TextView content = ViewBindings.findChildViewById(rootView, id);
      if (content == null) {
        break missingId;
      }

      id = R.id.likeButton;
      MaterialButton likeButton = ViewBindings.findChildViewById(rootView, id);
      if (likeButton == null) {
        break missingId;
      }

      id = R.id.menu;
      MaterialButton menu = ViewBindings.findChildViewById(rootView, id);
      if (menu == null) {
        break missingId;
      }

      id = R.id.play;
      ImageButton play = ViewBindings.findChildViewById(rootView, id);
      if (play == null) {
        break missingId;
      }

      id = R.id.playVideoGroup;
      Group playVideoGroup = ViewBindings.findChildViewById(rootView, id);
      if (playVideoGroup == null) {
        break missingId;
      }

      id = R.id.published;
      TextView published = ViewBindings.findChildViewById(rootView, id);
      if (published == null) {
        break missingId;
      }

      id = R.id.shareButton;
      MaterialButton shareButton = ViewBindings.findChildViewById(rootView, id);
      if (shareButton == null) {
        break missingId;
      }

      id = R.id.video;
      ImageView video = ViewBindings.findChildViewById(rootView, id);
      if (video == null) {
        break missingId;
      }

      id = R.id.viewButton;
      ImageButton viewButton = ViewBindings.findChildViewById(rootView, id);
      if (viewButton == null) {
        break missingId;
      }

      id = R.id.viewText;
      TextView viewText = ViewBindings.findChildViewById(rootView, id);
      if (viewText == null) {
        break missingId;
      }

      return new CardPostBinding((ConstraintLayout) rootView, author, avatar, barrierBottomContent,
          barrierTop, content, likeButton, menu, play, playVideoGroup, published, shareButton,
          video, viewButton, viewText);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}