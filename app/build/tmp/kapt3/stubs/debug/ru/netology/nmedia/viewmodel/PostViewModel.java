package ru.netology.nmedia.viewmodel;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\bJ\u000e\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001bR\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001f\u0010\u000b\u001a\u0010\u0012\f\u0012\n \r*\u0004\u0018\u00010\b0\b0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lru/netology/nmedia/viewmodel/PostViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "data", "Landroidx/lifecycle/LiveData;", "", "Lru/netology/nmedia/dto/Post;", "getData", "()Landroidx/lifecycle/LiveData;", "edited", "Landroidx/lifecycle/MutableLiveData;", "kotlin.jvm.PlatformType", "getEdited", "()Landroidx/lifecycle/MutableLiveData;", "repository", "Lru/netology/nmedia/repository/PostRepository;", "cancelEditing", "", "changeContentAndSave", "content", "", "edit", "post", "likeById", "id", "", "removeById", "share", "app_debug"})
public final class PostViewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.NotNull
    private final ru.netology.nmedia.repository.PostRepository repository = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<java.util.List<ru.netology.nmedia.dto.Post>> data = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<ru.netology.nmedia.dto.Post> edited = null;
    
    public PostViewModel(@org.jetbrains.annotations.NotNull
    android.app.Application application) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<java.util.List<ru.netology.nmedia.dto.Post>> getData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<ru.netology.nmedia.dto.Post> getEdited() {
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
    
    public final void likeById(long id) {
    }
    
    public final void share(long id) {
    }
    
    public final void removeById(long id) {
    }
}