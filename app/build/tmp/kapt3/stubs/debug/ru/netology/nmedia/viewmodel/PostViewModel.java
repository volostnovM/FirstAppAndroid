package ru.netology.nmedia.viewmodel;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\"\u001a\u00020\u000eJ\u000e\u0010#\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020%J\u0006\u0010&\u001a\u00020\u000eJ\u000e\u0010\'\u001a\u00020\u000e2\u0006\u0010(\u001a\u00020\u0017J\u000e\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,J\u0006\u0010-\u001a\u00020*J\u0006\u0010.\u001a\u00020*J\u0006\u0010/\u001a\u00020*J\u000e\u00100\u001a\u00020*2\u0006\u0010+\u001a\u00020,J\u0006\u00101\u001a\u00020\u000eJ\u0016\u00102\u001a\u00020\u000e2\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000206J\u000e\u00107\u001a\u00020*2\u0006\u0010+\u001a\u00020,R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0010\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\u00170\u00170\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0019\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u00108F\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u0015R\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00108F\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\t0\u00108F\u00a2\u0006\u0006\u001a\u0004\b!\u0010\u0015\u00a8\u00068"}, d2 = {"Lru/netology/nmedia/viewmodel/PostViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lru/netology/nmedia/repository/PostRepository;", "appAuth", "Lru/netology/nmedia/auth/AppAuth;", "(Lru/netology/nmedia/repository/PostRepository;Lru/netology/nmedia/auth/AppAuth;)V", "_dataState", "Landroidx/lifecycle/MutableLiveData;", "Lru/netology/nmedia/model/FeedModelState;", "_photo", "Lru/netology/nmedia/model/PhotoModel;", "_postCreated", "Lru/netology/nmedia/util/SingleLiveEvent;", "", "data", "Landroidx/lifecycle/LiveData;", "Lru/netology/nmedia/model/FeedModel;", "getData$annotations", "()V", "getData", "()Landroidx/lifecycle/LiveData;", "edited", "Lru/netology/nmedia/dto/Post;", "kotlin.jvm.PlatformType", "newerCount", "", "getNewerCount", "photo", "getPhoto", "postCreated", "getPostCreated", "state", "getState", "cancelEditing", "changeContentAndSave", "content", "", "clearPhoto", "edit", "post", "likeById", "Lkotlinx/coroutines/Job;", "id", "", "loadNewPosts", "loadPosts", "refreshPosts", "removeById", "removePhoto", "setPhoto", "uri", "Landroid/net/Uri;", "file", "Ljava/io/File;", "unlikeById", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class PostViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final ru.netology.nmedia.repository.PostRepository repository = null;
    @org.jetbrains.annotations.NotNull
    private final ru.netology.nmedia.util.SingleLiveEvent<kotlin.Unit> _postCreated = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<ru.netology.nmedia.model.FeedModel> data = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<ru.netology.nmedia.model.PhotoModel> _photo = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<java.lang.Integer> newerCount = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<ru.netology.nmedia.dto.Post> edited = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<ru.netology.nmedia.model.FeedModelState> _dataState = null;
    
    @javax.inject.Inject
    public PostViewModel(@org.jetbrains.annotations.NotNull
    ru.netology.nmedia.repository.PostRepository repository, @org.jetbrains.annotations.NotNull
    ru.netology.nmedia.auth.AppAuth appAuth) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<kotlin.Unit> getPostCreated() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<ru.netology.nmedia.model.FeedModel> getData() {
        return null;
    }
    
    @kotlin.OptIn(markerClass = {kotlinx.coroutines.ExperimentalCoroutinesApi.class})
    @java.lang.Deprecated
    public static void getData$annotations() {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<ru.netology.nmedia.model.PhotoModel> getPhoto() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.lang.Integer> getNewerCount() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<ru.netology.nmedia.model.FeedModelState> getState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job loadPosts() {
        return null;
    }
    
    public final void setPhoto(@org.jetbrains.annotations.NotNull
    android.net.Uri uri, @org.jetbrains.annotations.NotNull
    java.io.File file) {
    }
    
    public final void removePhoto() {
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job loadNewPosts() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job refreshPosts() {
        return null;
    }
    
    public final void changeContentAndSave(@org.jetbrains.annotations.NotNull
    java.lang.String content) {
    }
    
    public final void edit(@org.jetbrains.annotations.NotNull
    ru.netology.nmedia.dto.Post post) {
    }
    
    public final void cancelEditing() {
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job likeById(long id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job unlikeById(long id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job removeById(long id) {
        return null;
    }
    
    public final void clearPhoto() {
    }
}