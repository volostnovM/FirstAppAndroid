package ru.netology.nmedia.adapter;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u000b"}, d2 = {"Lru/netology/nmedia/adapter/OnInteractionListener;", "", "edit", "", "post", "Lru/netology/nmedia/dto/Post;", "like", "remove", "share", "video", "viewPost", "app_debug"})
public abstract interface OnInteractionListener {
    
    public abstract void like(@org.jetbrains.annotations.NotNull
    ru.netology.nmedia.dto.Post post);
    
    public abstract void share(@org.jetbrains.annotations.NotNull
    ru.netology.nmedia.dto.Post post);
    
    public abstract void remove(@org.jetbrains.annotations.NotNull
    ru.netology.nmedia.dto.Post post);
    
    public abstract void edit(@org.jetbrains.annotations.NotNull
    ru.netology.nmedia.dto.Post post);
    
    public abstract void video(@org.jetbrains.annotations.NotNull
    ru.netology.nmedia.dto.Post post);
    
    public abstract void viewPost(@org.jetbrains.annotations.NotNull
    ru.netology.nmedia.dto.Post post);
}