package ru.netology.nmedia.viewmodel;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0019\u001a\u00020\nJ\u000e\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u0011J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"J\u0006\u0010#\u001a\u00020 J\u0006\u0010$\u001a\u00020 J\u000e\u0010%\u001a\u00020 2\u0006\u0010!\u001a\u00020\"J\u000e\u0010&\u001a\u00020 2\u0006\u0010!\u001a\u00020\"R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0010\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00110\u00110\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\f8F\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u000fR\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\f8F\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u000f\u00a8\u0006\'"}, d2 = {"Lru/netology/nmedia/viewmodel/PostViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "_dataState", "Landroidx/lifecycle/MutableLiveData;", "Lru/netology/nmedia/model/FeedModelState;", "_postCreated", "Lru/netology/nmedia/util/SingleLiveEvent;", "", "data", "Landroidx/lifecycle/LiveData;", "Lru/netology/nmedia/model/FeedModel;", "getData", "()Landroidx/lifecycle/LiveData;", "edited", "Lru/netology/nmedia/dto/Post;", "kotlin.jvm.PlatformType", "postCreated", "getPostCreated", "repository", "Lru/netology/nmedia/repository/PostRepository;", "state", "getState", "cancelEditing", "changeContentAndSave", "content", "", "edit", "post", "likeById", "Lkotlinx/coroutines/Job;", "id", "", "loadPosts", "refreshPosts", "removeById", "unlikeById", "app_debug"})
public final class PostViewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.NotNull
    private final ru.netology.nmedia.repository.PostRepository repository = null;
    @org.jetbrains.annotations.NotNull
    private final ru.netology.nmedia.util.SingleLiveEvent<kotlin.Unit> _postCreated = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<ru.netology.nmedia.model.FeedModel> data = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<ru.netology.nmedia.dto.Post> edited = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<ru.netology.nmedia.model.FeedModelState> _dataState = null;
    
    public PostViewModel(@org.jetbrains.annotations.NotNull
    android.app.Application application) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<kotlin.Unit> getPostCreated() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<ru.netology.nmedia.model.FeedModel> getData() {
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
}