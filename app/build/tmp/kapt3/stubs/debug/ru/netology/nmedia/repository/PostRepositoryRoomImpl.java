package ru.netology.nmedia.repository;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006H\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\bH\u0016J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lru/netology/nmedia/repository/PostRepositoryRoomImpl;", "Lru/netology/nmedia/repository/PostRepository;", "dao", "Lru/netology/nmedia/dao/PostDao;", "(Lru/netology/nmedia/dao/PostDao;)V", "get", "Landroidx/lifecycle/LiveData;", "", "Lru/netology/nmedia/dto/Post;", "likeById", "", "id", "", "removeById", "save", "post", "share", "app_debug"})
public final class PostRepositoryRoomImpl implements ru.netology.nmedia.repository.PostRepository {
    @org.jetbrains.annotations.NotNull
    private final ru.netology.nmedia.dao.PostDao dao = null;
    
    public PostRepositoryRoomImpl(@org.jetbrains.annotations.NotNull
    ru.netology.nmedia.dao.PostDao dao) {
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public androidx.lifecycle.LiveData<java.util.List<ru.netology.nmedia.dto.Post>> get() {
        return null;
    }
    
    @java.lang.Override
    public void save(@org.jetbrains.annotations.NotNull
    ru.netology.nmedia.dto.Post post) {
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
}