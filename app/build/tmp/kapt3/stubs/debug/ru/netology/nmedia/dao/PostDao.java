package ru.netology.nmedia.dao;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\'J\u0011\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ\u001f\u0010\t\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ\u0019\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ\u0019\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J\u0019\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J\u0019\u0010\u0012\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0005H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ!\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0017"}, d2 = {"Lru/netology/nmedia/dao/PostDao;", "", "getAll", "Lkotlinx/coroutines/flow/Flow;", "", "Lru/netology/nmedia/entity/PostEntity;", "hiddenPosts", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insert", "post", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lru/netology/nmedia/entity/PostEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "likeById", "id", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeById", "save", "updateContentById", "text", "", "(JLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@androidx.room.Dao
public abstract interface PostDao {
    
    @androidx.room.Query(value = "SELECT * FROM PostEntity WHERE hidden = 1 ORDER BY id DESC")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<ru.netology.nmedia.entity.PostEntity>> getAll();
    
    @androidx.room.Query(value = "UPDATE PostEntity SET hidden = 1 WHERE hidden = 0")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object hiddenPosts(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insert(@org.jetbrains.annotations.NotNull
    ru.netology.nmedia.entity.PostEntity post, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insert(@org.jetbrains.annotations.NotNull
    java.util.List<ru.netology.nmedia.entity.PostEntity> post, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE PostEntity SET content = :text WHERE id = :id")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateContentById(long id, @org.jetbrains.annotations.NotNull
    java.lang.String text, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object save(@org.jetbrains.annotations.NotNull
    ru.netology.nmedia.entity.PostEntity post, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "\n        UPDATE PostEntity SET\n        likes = likes + CASE WHEN likedByMe THEN -1 ELSE 1 END,\n        likedByMe = CASE WHEN likedByMe THEN 0 ELSE 1 END\n        WHERE id = :id\n        ")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object likeById(long id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM PostEntity WHERE id = :id")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object removeById(long id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
        
        @org.jetbrains.annotations.Nullable
        public static java.lang.Object save(@org.jetbrains.annotations.NotNull
        ru.netology.nmedia.dao.PostDao $this, @org.jetbrains.annotations.NotNull
        ru.netology.nmedia.entity.PostEntity post, @org.jetbrains.annotations.NotNull
        kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
            return null;
        }
    }
}