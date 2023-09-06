package ru.netology.nmedia.repository;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0005H&J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&\u00a8\u0006\u000e"}, d2 = {"Lru/netology/nmedia/repository/PostRepository;", "", "get", "Landroidx/lifecycle/LiveData;", "", "Lru/netology/nmedia/dto/Post;", "likeById", "", "id", "", "removeById", "save", "post", "share", "app_debug"})
public abstract interface PostRepository {
    
    @org.jetbrains.annotations.NotNull
    public abstract androidx.lifecycle.LiveData<java.util.List<ru.netology.nmedia.dto.Post>> get();
    
    public abstract void likeById(long id);
    
    public abstract void share(long id);
    
    public abstract void removeById(long id);
    
    public abstract void save(@org.jetbrains.annotations.NotNull
    ru.netology.nmedia.dto.Post post);
}