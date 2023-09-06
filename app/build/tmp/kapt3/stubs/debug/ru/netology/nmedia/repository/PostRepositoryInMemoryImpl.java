package ru.netology.nmedia.repository;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0014\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\fH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\tH\u0016J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\tH\u0016J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0006H\u0016J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\tH\u0016R(\u0010\u0003\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0006 \u0007*\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00050\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lru/netology/nmedia/repository/PostRepositoryInMemoryImpl;", "Lru/netology/nmedia/repository/PostRepository;", "()V", "data", "Landroidx/lifecycle/MutableLiveData;", "", "Lru/netology/nmedia/dto/Post;", "kotlin.jvm.PlatformType", "nextId", "", "posts", "get", "Landroidx/lifecycle/LiveData;", "likeById", "", "id", "removeById", "save", "post", "share", "app_debug"})
public final class PostRepositoryInMemoryImpl implements ru.netology.nmedia.repository.PostRepository {
    private long nextId = 1L;
    @org.jetbrains.annotations.NotNull
    private java.util.List<ru.netology.nmedia.dto.Post> posts;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.util.List<ru.netology.nmedia.dto.Post>> data = null;
    
    public PostRepositoryInMemoryImpl() {
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public androidx.lifecycle.LiveData<java.util.List<ru.netology.nmedia.dto.Post>> get() {
        return null;
    }
    
    @java.lang.Override
    public void likeById(long id) {
    }
    
    @java.lang.Override
    public void share(long id) {
    }
    
    @java.lang.Override
    public void removeById(long id) {
    }
    
    @java.lang.Override
    public void save(@org.jetbrains.annotations.NotNull
    ru.netology.nmedia.dto.Post post) {
    }
}