package ru.netology.nmedia.dao;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import ru.netology.nmedia.entity.PostEntity;

@SuppressWarnings({"unchecked", "deprecation"})
public final class PostDao_Impl implements PostDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<PostEntity> __insertionAdapterOfPostEntity;

  private final SharedSQLiteStatement __preparedStmtOfUpdateContentById;

  private final SharedSQLiteStatement __preparedStmtOfLikeById;

  private final SharedSQLiteStatement __preparedStmtOfShareById;

  private final SharedSQLiteStatement __preparedStmtOfRemoveById;

  public PostDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfPostEntity = new EntityInsertionAdapter<PostEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `PostEntity` (`id`,`author`,`published`,`content`,`likedByMe`,`likes`,`shared`,`video`) VALUES (nullif(?, 0),?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PostEntity value) {
        stmt.bindLong(1, value.getId());
        if (value.getAuthor() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getAuthor());
        }
        if (value.getPublished() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getPublished());
        }
        if (value.getContent() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getContent());
        }
        final int _tmp = value.getLikedByMe() ? 1 : 0;
        stmt.bindLong(5, _tmp);
        stmt.bindLong(6, value.getLikes());
        stmt.bindLong(7, value.getShared());
        if (value.getVideo() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getVideo());
        }
      }
    };
    this.__preparedStmtOfUpdateContentById = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE PostEntity SET content = ? WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfLikeById = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "\n"
                + "        UPDATE PostEntity SET\n"
                + "        likes = likes + CASE WHEN likedByMe THEN -1 ELSE 1 END,\n"
                + "        likedByMe = CASE WHEN likedByMe THEN 0 ELSE 1 END\n"
                + "        WHERE id = ?\n"
                + "        ";
        return _query;
      }
    };
    this.__preparedStmtOfShareById = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "\n"
                + "        UPDATE PostEntity SET\n"
                + "                shared = shared + 1\n"
                + "                WHERE id = ?\n"
                + "        ";
        return _query;
      }
    };
    this.__preparedStmtOfRemoveById = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM PostEntity WHERE id = ?";
        return _query;
      }
    };
  }

  @Override
  public void insert(final PostEntity post) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfPostEntity.insert(post);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateContentById(final long id, final String text) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateContentById.acquire();
    int _argIndex = 1;
    if (text == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, text);
    }
    _argIndex = 2;
    _stmt.bindLong(_argIndex, id);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateContentById.release(_stmt);
    }
  }

  @Override
  public void likeById(final long id) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfLikeById.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, id);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfLikeById.release(_stmt);
    }
  }

  @Override
  public void shareById(final long id) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfShareById.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, id);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfShareById.release(_stmt);
    }
  }

  @Override
  public void removeById(final long id) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfRemoveById.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, id);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfRemoveById.release(_stmt);
    }
  }

  @Override
  public LiveData<List<PostEntity>> getAll() {
    final String _sql = "SELECT * FROM PostEntity ORDER BY id DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"PostEntity"}, false, new Callable<List<PostEntity>>() {
      @Override
      public List<PostEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfAuthor = CursorUtil.getColumnIndexOrThrow(_cursor, "author");
          final int _cursorIndexOfPublished = CursorUtil.getColumnIndexOrThrow(_cursor, "published");
          final int _cursorIndexOfContent = CursorUtil.getColumnIndexOrThrow(_cursor, "content");
          final int _cursorIndexOfLikedByMe = CursorUtil.getColumnIndexOrThrow(_cursor, "likedByMe");
          final int _cursorIndexOfLikes = CursorUtil.getColumnIndexOrThrow(_cursor, "likes");
          final int _cursorIndexOfShared = CursorUtil.getColumnIndexOrThrow(_cursor, "shared");
          final int _cursorIndexOfVideo = CursorUtil.getColumnIndexOrThrow(_cursor, "video");
          final List<PostEntity> _result = new ArrayList<PostEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final PostEntity _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpAuthor;
            if (_cursor.isNull(_cursorIndexOfAuthor)) {
              _tmpAuthor = null;
            } else {
              _tmpAuthor = _cursor.getString(_cursorIndexOfAuthor);
            }
            final String _tmpPublished;
            if (_cursor.isNull(_cursorIndexOfPublished)) {
              _tmpPublished = null;
            } else {
              _tmpPublished = _cursor.getString(_cursorIndexOfPublished);
            }
            final String _tmpContent;
            if (_cursor.isNull(_cursorIndexOfContent)) {
              _tmpContent = null;
            } else {
              _tmpContent = _cursor.getString(_cursorIndexOfContent);
            }
            final boolean _tmpLikedByMe;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfLikedByMe);
            _tmpLikedByMe = _tmp != 0;
            final int _tmpLikes;
            _tmpLikes = _cursor.getInt(_cursorIndexOfLikes);
            final int _tmpShared;
            _tmpShared = _cursor.getInt(_cursorIndexOfShared);
            final String _tmpVideo;
            if (_cursor.isNull(_cursorIndexOfVideo)) {
              _tmpVideo = null;
            } else {
              _tmpVideo = _cursor.getString(_cursorIndexOfVideo);
            }
            _item = new PostEntity(_tmpId,_tmpAuthor,_tmpPublished,_tmpContent,_tmpLikedByMe,_tmpLikes,_tmpShared,_tmpVideo);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public void save(final PostEntity post) {
    PostDao.DefaultImpls.save(PostDao_Impl.this, post);
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
