package ru.netology.nmedia.viewmodel;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\"\u001a\u00020\u000eJ\u000e\u0010#\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020%J\u0006\u0010&\u001a\u00020\u000eJ\u000e\u0010\'\u001a\u00020\u000e2\u0006\u0010(\u001a\u00020\u0018J\u000e\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,J\u0006\u0010-\u001a\u00020*J\u000e\u0010.\u001a\u00020*2\u0006\u0010+\u001a\u00020,J\u0006\u0010/\u001a\u00020\u000eJ\u0016\u00100\u001a\u00020\u000e2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u000204J\u000e\u00105\u001a\u00020*2\u0006\u0010+\u001a\u00020,R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R#\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u0010\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0010\u0012\f\u0012\n \u0019*\u0004\u0018\u00010\u00180\u00180\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u001b8F\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001b8F\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010\u001dR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\t0\u001b8F\u00a2\u0006\u0006\u001a\u0004\b!\u0010\u001d\u00a8\u00066"}, d2 = {"Lru/netology/nmedia/viewmodel/PostViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lru/netology/nmedia/repository/PostRepository;", "appAuth", "Lru/netology/nmedia/auth/AppAuth;", "(Lru/netology/nmedia/repository/PostRepository;Lru/netology/nmedia/auth/AppAuth;)V", "_dataState", "Landroidx/lifecycle/MutableLiveData;", "Lru/netology/nmedia/model/FeedModelState;", "_photo", "Lru/netology/nmedia/model/PhotoModel;", "_postCreated", "Lru/netology/nmedia/util/SingleLiveEvent;", "", "data", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/PagingData;", "Lru/netology/nmedia/dto/FeedItem;", "getData$annotations", "()V", "getData", "()Lkotlinx/coroutines/flow/Flow;", "edited", "Lru/netology/nmedia/dto/Post;", "kotlin.jvm.PlatformType", "photo", "Landroidx/lifecycle/LiveData;", "getPhoto", "()Landroidx/lifecycle/LiveData;", "postCreated", "getPostCreated", "state", "getState", "cancelEditing", "changeContentAndSave", "content", "", "clearPhoto", "edit", "post", "likeById", "Lkotlinx/coroutines/Job;", "id", "", "loadPosts", "removeById", "removePhoto", "setPhoto", "uri", "Landroid/net/Uri;", "file", "Ljava/io/File;", "unlikeById", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class PostViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final ru.netology.nmedia.repository.PostRepository repository = null;
    @org.jetbrains.annotations.NotNull
    private final ru.netology.nmedia.util.SingleLiveEvent<kotlin.Unit> _postCreated = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.Flow<androidx.paging.PagingData<ru.netology.nmedia.dto.FeedItem>> data = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<ru.netology.nmedia.model.PhotoModel> _photo = null;
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
    public final kotlinx.coroutines.flow.Flow<androidx.paging.PagingData<ru.netology.nmedia.dto.FeedItem>> getData() {
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