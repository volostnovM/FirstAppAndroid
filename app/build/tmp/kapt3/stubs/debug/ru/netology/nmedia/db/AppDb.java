package ru.netology.nmedia.db;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\'\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005\u00a2\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\b"}, d2 = {"Lru/netology/nmedia/db/AppDb;", "Landroidx/room/RoomDatabase;", "()V", "postDao", "Lru/netology/nmedia/dao/PostDao;", "getPostDao", "()Lru/netology/nmedia/dao/PostDao;", "Companion", "app_debug"})
@androidx.room.Database(entities = {ru.netology.nmedia.entity.PostEntity.class}, version = 4)
public abstract class AppDb extends androidx.room.RoomDatabase {
    @kotlin.jvm.Volatile
    @org.jetbrains.annotations.Nullable
    private static volatile ru.netology.nmedia.db.AppDb instance;
    @org.jetbrains.annotations.NotNull
    public static final ru.netology.nmedia.db.AppDb.Companion Companion = null;
    
    public AppDb() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public abstract ru.netology.nmedia.dao.PostDao getPostDao();
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lru/netology/nmedia/db/AppDb$Companion;", "", "()V", "instance", "Lru/netology/nmedia/db/AppDb;", "buildDatabase", "context", "Landroid/content/Context;", "getInstance", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final ru.netology.nmedia.db.AppDb getInstance(@org.jetbrains.annotations.NotNull
        android.content.Context context) {
            return null;
        }
        
        private final ru.netology.nmedia.db.AppDb buildDatabase(android.content.Context context) {
            return null;
        }
    }
}