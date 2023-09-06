package ru.netology.nmedia.dto;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u001d\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\tH\u00c6\u0003J\t\u0010 \u001a\u00020\u000bH\u00c6\u0003J\t\u0010!\u001a\u00020\u000bH\u00c6\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J[\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001J\u0013\u0010$\u001a\u00020\t2\b\u0010%\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010&\u001a\u00020\u000bH\u00d6\u0001J\t\u0010\'\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0011\u0010\f\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010\u00a8\u0006("}, d2 = {"Lru/netology/nmedia/dto/Post;", "", "id", "", "author", "", "published", "content", "likedByMe", "", "likes", "", "shared", "video", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZIILjava/lang/String;)V", "getAuthor", "()Ljava/lang/String;", "getContent", "getId", "()J", "getLikedByMe", "()Z", "getLikes", "()I", "getPublished", "getShared", "getVideo", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "app_debug"})
public final class Post {
    private final long id = 0L;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String author = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String published = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String content = null;
    private final boolean likedByMe = false;
    private final int likes = 0;
    private final int shared = 0;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String video = null;
    
    public Post(long id, @org.jetbrains.annotations.NotNull
    java.lang.String author, @org.jetbrains.annotations.NotNull
    java.lang.String published, @org.jetbrains.annotations.NotNull
    java.lang.String content, boolean likedByMe, int likes, int shared, @org.jetbrains.annotations.Nullable
    java.lang.String video) {
        super();
    }
    
    public final long getId() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getAuthor() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getPublished() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getContent() {
        return null;
    }
    
    public final boolean getLikedByMe() {
        return false;
    }
    
    public final int getLikes() {
        return 0;
    }
    
    public final int getShared() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getVideo() {
        return null;
    }
    
    public final long component1() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component4() {
        return null;
    }
    
    public final boolean component5() {
        return false;
    }
    
    public final int component6() {
        return 0;
    }
    
    public final int component7() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final ru.netology.nmedia.dto.Post copy(long id, @org.jetbrains.annotations.NotNull
    java.lang.String author, @org.jetbrains.annotations.NotNull
    java.lang.String published, @org.jetbrains.annotations.NotNull
    java.lang.String content, boolean likedByMe, int likes, int shared, @org.jetbrains.annotations.Nullable
    java.lang.String video) {
        return null;
    }
    
    @java.lang.Override
    public boolean equals(@org.jetbrains.annotations.Nullable
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        return null;
    }
}