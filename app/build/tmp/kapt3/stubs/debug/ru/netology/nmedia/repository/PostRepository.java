package ru.netology.nmedia.repository;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H&J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\u000e"}, d2 = {"Lru/netology/nmedia/repository/PostRepository;", "", "get", "", "Lru/netology/nmedia/dto/Post;", "likeById", "id", "", "removeById", "", "save", "post", "share", "unlikeById", "app_debug"})
public abstract interface PostRepository {
    
    @org.jetbrains.annotations.NotNull
    public abstract java.util.List<ru.netology.nmedia.dto.Post> get();
    
    @org.jetbrains.annotations.NotNull
    public abstract ru.netology.nmedia.dto.Post likeById(long id);
    
    @org.jetbrains.annotations.NotNull
    public abstract ru.netology.nmedia.dto.Post unlikeById(long id);
    
    public abstract void share(long id);
    
    public abstract void removeById(long id);
    
    @org.jetbrains.annotations.NotNull
    public abstract ru.netology.nmedia.dto.Post save(@org.jetbrains.annotations.NotNull
    ru.netology.nmedia.dto.Post post);
}