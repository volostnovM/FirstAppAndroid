package ru.netology.nmedia.activity;

@dagger.hilt.android.AndroidEntryPoint
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\u0012\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0014J\b\u0010 \u001a\u00020\u001cH\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0015\u001a\u00020\u00168FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006!"}, d2 = {"Lru/netology/nmedia/activity/AppActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "appAuth", "Lru/netology/nmedia/auth/AppAuth;", "getAppAuth", "()Lru/netology/nmedia/auth/AppAuth;", "setAppAuth", "(Lru/netology/nmedia/auth/AppAuth;)V", "firebaseMessaging", "Lcom/google/firebase/messaging/FirebaseMessaging;", "getFirebaseMessaging", "()Lcom/google/firebase/messaging/FirebaseMessaging;", "setFirebaseMessaging", "(Lcom/google/firebase/messaging/FirebaseMessaging;)V", "googleApiAvailability", "Lcom/google/android/gms/common/GoogleApiAvailability;", "getGoogleApiAvailability", "()Lcom/google/android/gms/common/GoogleApiAvailability;", "setGoogleApiAvailability", "(Lcom/google/android/gms/common/GoogleApiAvailability;)V", "viewModel", "Lru/netology/nmedia/viewmodel/AuthViewModel;", "getViewModel", "()Lru/netology/nmedia/viewmodel/AuthViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "checkGoogleApiAvailability", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "requestNotificationsPermission", "app_debug"})
public final class AppActivity extends androidx.appcompat.app.AppCompatActivity {
    @javax.inject.Inject
    public ru.netology.nmedia.auth.AppAuth appAuth;
    @javax.inject.Inject
    public com.google.firebase.messaging.FirebaseMessaging firebaseMessaging;
    @javax.inject.Inject
    public com.google.android.gms.common.GoogleApiAvailability googleApiAvailability;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy viewModel$delegate = null;
    
    public AppActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final ru.netology.nmedia.auth.AppAuth getAppAuth() {
        return null;
    }
    
    public final void setAppAuth(@org.jetbrains.annotations.NotNull
    ru.netology.nmedia.auth.AppAuth p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.google.firebase.messaging.FirebaseMessaging getFirebaseMessaging() {
        return null;
    }
    
    public final void setFirebaseMessaging(@org.jetbrains.annotations.NotNull
    com.google.firebase.messaging.FirebaseMessaging p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.google.android.gms.common.GoogleApiAvailability getGoogleApiAvailability() {
        return null;
    }
    
    public final void setGoogleApiAvailability(@org.jetbrains.annotations.NotNull
    com.google.android.gms.common.GoogleApiAvailability p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final ru.netology.nmedia.viewmodel.AuthViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void checkGoogleApiAvailability() {
    }
    
    private final void requestNotificationsPermission() {
    }
}