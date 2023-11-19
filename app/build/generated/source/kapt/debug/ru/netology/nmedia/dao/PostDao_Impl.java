package ru.netology.nmedia.dao;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;
import ru.netology.nmedia.dto.Attachment;
import ru.netology.nmedia.dto.TypeAttachment;
import ru.netology.nmedia.entity.PostEntity;

@SuppressWarnings({"unchecked", "deprecation"})
public final class PostDao_Impl implements PostDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<PostEntity> __insertionAdapterOfPostEntity;

  private final SharedSQLiteStatement __preparedStmtOfHiddenPosts;

  private final SharedSQLiteStatement __preparedStmtOfUpdateContentById;

  private final SharedSQLiteStatement __preparedStmtOfLikeById;

  private final SharedSQLiteStatement __preparedStmtOfRemoveById;

  public PostDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfPostEntity = new EntityInsertionAdapter<PostEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `PostEntity` (`id`,`author`,`authorAvatar`,`published`,`content`,`likedByMe`,`likes`,`hidden`,`authorId`,`url`,`type`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PostEntity value) {
        stmt.bindLong(1, value.getId());
        if (value.getAuthor() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getAuthor());
        }
        if (value.getAuthorAvatar() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getAuthorAvatar());
        }
        if (value.getPublished() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getPublished());
        }
        if (value.getContent() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getContent());
        }
        final int _tmp = value.getLikedByMe() ? 1 : 0;
        stmt.bindLong(6, _tmp);
        stmt.bindLong(7, value.getLikes());
        final int _tmp_1 = value.getHidden() ? 1 : 0;
        stmt.bindLong(8, _tmp_1);
        stmt.bindLong(9, value.getAuthorId());
        final Attachment _tmpAttachment = value.getAttachment();
        if (_tmpAttachment != null) {
          if (_tmpAttachment.getUrl() == null) {
            stmt.bindNull(10);
          } else {
            stmt.bindString(10, _tmpAttachment.getUrl());
          }
          if (_tmpAttachment.getType() == null) {
            stmt.bindNull(11);
          } else {
            stmt.bindString(11, __TypeAttachment_enumToString(_tmpAttachment.getType()));
          }
        } else {
          stmt.bindNull(10);
          stmt.bindNull(11);
        }
      }
    };
    this.__preparedStmtOfHiddenPosts = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE PostEntity SET hidden = 1 WHERE hidden = 0";
        return _query;
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
    this.__preparedStmtOfRemoveById = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM PostEntity WHERE id = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insert(final PostEntity post, final Continuation<? super Unit> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfPostEntity.insert(post);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, arg1);
  }

  @Override
  public Object insert(final List<PostEntity> post, final Continuation<? super Unit> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfPostEntity.insert(post);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, arg1);
  }

  @Override
  public Object hiddenPosts(final Continuation<? super Unit> arg0) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfHiddenPosts.acquire();
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfHiddenPosts.release(_stmt);
        }
      }
    }, arg0);
  }

  @Override
  public Object updateContentById(final long id, final String text,
      final Continuation<? super Unit> arg2) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
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
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfUpdateContentById.release(_stmt);
        }
      }
    }, arg2);
  }

  @Override
  public Object likeById(final long id, final Continuation<? super Unit> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfLikeById.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, id);
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfLikeById.release(_stmt);
        }
      }
    }, arg1);
  }

  @Override
  public Object removeById(final long id, final Continuation<? super Unit> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfRemoveById.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, id);
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfRemoveById.release(_stmt);
        }
      }
    }, arg1);
  }

  @Override
  public Flow<List<PostEntity>> getAll() {
    final String _sql = "SELECT * FROM PostEntity WHERE hidden = 1 ORDER BY id DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"PostEntity"}, new Callable<List<PostEntity>>() {
      @Override
      public List<PostEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfAuthor = CursorUtil.getColumnIndexOrThrow(_cursor, "author");
          final int _cursorIndexOfAuthorAvatar = CursorUtil.getColumnIndexOrThrow(_cursor, "authorAvatar");
          final int _cursorIndexOfPublished = CursorUtil.getColumnIndexOrThrow(_cursor, "published");
          final int _cursorIndexOfContent = CursorUtil.getColumnIndexOrThrow(_cursor, "content");
          final int _cursorIndexOfLikedByMe = CursorUtil.getColumnIndexOrThrow(_cursor, "likedByMe");
          final int _cursorIndexOfLikes = CursorUtil.getColumnIndexOrThrow(_cursor, "likes");
          final int _cursorIndexOfHidden = CursorUtil.getColumnIndexOrThrow(_cursor, "hidden");
          final int _cursorIndexOfAuthorId = CursorUtil.getColumnIndexOrThrow(_cursor, "authorId");
          final int _cursorIndexOfUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "url");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
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
            final String _tmpAuthorAvatar;
            if (_cursor.isNull(_cursorIndexOfAuthorAvatar)) {
              _tmpAuthorAvatar = null;
            } else {
              _tmpAuthorAvatar = _cursor.getString(_cursorIndexOfAuthorAvatar);
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
            final boolean _tmpHidden;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfHidden);
            _tmpHidden = _tmp_1 != 0;
            final long _tmpAuthorId;
            _tmpAuthorId = _cursor.getLong(_cursorIndexOfAuthorId);
            final Attachment _tmpAttachment;
            if (!(_cursor.isNull(_cursorIndexOfUrl) && _cursor.isNull(_cursorIndexOfType))) {
              final String _tmpUrl;
              if (_cursor.isNull(_cursorIndexOfUrl)) {
                _tmpUrl = null;
              } else {
                _tmpUrl = _cursor.getString(_cursorIndexOfUrl);
              }
              final TypeAttachment _tmpType;
              _tmpType = __TypeAttachment_stringToEnum(_cursor.getString(_cursorIndexOfType));
              _tmpAttachment = new Attachment(_tmpUrl,_tmpType);
            } else {
              _tmpAttachment = null;
            }
            _item = new PostEntity(_tmpId,_tmpAuthor,_tmpAuthorAvatar,_tmpPublished,_tmpContent,_tmpLikedByMe,_tmpLikes,_tmpHidden,_tmpAttachment,_tmpAuthorId);
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
  public Object save(final PostEntity post, final Continuation<? super Unit> arg1) {
    return PostDao.DefaultImpls.save(PostDao_Impl.this, post, arg1);
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }

  private String __TypeAttachment_enumToString(final TypeAttachment _value) {
    if (_value == null) {
      return null;
    } switch (_value) {
      case IMAGE: return "IMAGE";
      default: throw new IllegalArgumentException("Can't convert enum to string, unknown enum value: " + _value);
    }
  }

  private TypeAttachment __TypeAttachment_stringToEnum(final String _value) {
    if (_value == null) {
      return null;
    } switch (_value) {
      case "IMAGE": return TypeAttachment.IMAGE;
      default: throw new IllegalArgumentException("Can't convert value to enum, unknown value: " + _value);
    }
  }
}
