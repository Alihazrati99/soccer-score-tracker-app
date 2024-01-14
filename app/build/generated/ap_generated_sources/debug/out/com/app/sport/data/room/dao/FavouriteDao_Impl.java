package com.app.sport.data.room.dao;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.app.sport.data.model.Favourite;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class FavouriteDao_Impl implements FavouriteDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Favourite> __insertionAdapterOfFavourite;

  private final EntityDeletionOrUpdateAdapter<Favourite> __deletionAdapterOfFavourite;

  private final EntityDeletionOrUpdateAdapter<Favourite> __updateAdapterOfFavourite;

  public FavouriteDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfFavourite = new EntityInsertionAdapter<Favourite>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `favourite_table` (`id`,`first_team_name`,`second_team_name`,`first_team_score`,`second_team_score`,`live_status`,`date_time`,`match_id`) VALUES (nullif(?, 0),?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Favourite value) {
        stmt.bindLong(1, value.getId());
        if (value.getFirst_team_name() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getFirst_team_name());
        }
        if (value.getSecond_team_name() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getSecond_team_name());
        }
        if (value.getFirst_team_score() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getFirst_team_score());
        }
        if (value.getSecond_team_score() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getSecond_team_score());
        }
        if (value.getLive_status() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getLive_status());
        }
        if (value.getDate_time() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getDate_time());
        }
        if (value.getMatch_id() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getMatch_id());
        }
      }
    };
    this.__deletionAdapterOfFavourite = new EntityDeletionOrUpdateAdapter<Favourite>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `favourite_table` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Favourite value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfFavourite = new EntityDeletionOrUpdateAdapter<Favourite>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `favourite_table` SET `id` = ?,`first_team_name` = ?,`second_team_name` = ?,`first_team_score` = ?,`second_team_score` = ?,`live_status` = ?,`date_time` = ?,`match_id` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Favourite value) {
        stmt.bindLong(1, value.getId());
        if (value.getFirst_team_name() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getFirst_team_name());
        }
        if (value.getSecond_team_name() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getSecond_team_name());
        }
        if (value.getFirst_team_score() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getFirst_team_score());
        }
        if (value.getSecond_team_score() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getSecond_team_score());
        }
        if (value.getLive_status() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getLive_status());
        }
        if (value.getDate_time() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getDate_time());
        }
        if (value.getMatch_id() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getMatch_id());
        }
        stmt.bindLong(9, value.getId());
      }
    };
  }

  @Override
  public void insert(final Favourite favourite) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfFavourite.insert(favourite);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Favourite favourite) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfFavourite.handle(favourite);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final Favourite favourite) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfFavourite.handle(favourite);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LiveData<List<Favourite>> getAllFavouriteData() {
    final String _sql = "SELECT * FROM favourite_table ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"favourite_table"}, false, new Callable<List<Favourite>>() {
      @Override
      public List<Favourite> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfFirstTeamName = CursorUtil.getColumnIndexOrThrow(_cursor, "first_team_name");
          final int _cursorIndexOfSecondTeamName = CursorUtil.getColumnIndexOrThrow(_cursor, "second_team_name");
          final int _cursorIndexOfFirstTeamScore = CursorUtil.getColumnIndexOrThrow(_cursor, "first_team_score");
          final int _cursorIndexOfSecondTeamScore = CursorUtil.getColumnIndexOrThrow(_cursor, "second_team_score");
          final int _cursorIndexOfLiveStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "live_status");
          final int _cursorIndexOfDateTime = CursorUtil.getColumnIndexOrThrow(_cursor, "date_time");
          final int _cursorIndexOfMatchId = CursorUtil.getColumnIndexOrThrow(_cursor, "match_id");
          final List<Favourite> _result = new ArrayList<Favourite>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Favourite _item;
            final String _tmpFirst_team_name;
            _tmpFirst_team_name = _cursor.getString(_cursorIndexOfFirstTeamName);
            final String _tmpSecond_team_name;
            _tmpSecond_team_name = _cursor.getString(_cursorIndexOfSecondTeamName);
            final String _tmpFirst_team_score;
            _tmpFirst_team_score = _cursor.getString(_cursorIndexOfFirstTeamScore);
            final String _tmpSecond_team_score;
            _tmpSecond_team_score = _cursor.getString(_cursorIndexOfSecondTeamScore);
            final String _tmpLive_status;
            _tmpLive_status = _cursor.getString(_cursorIndexOfLiveStatus);
            final String _tmpDate_time;
            _tmpDate_time = _cursor.getString(_cursorIndexOfDateTime);
            final String _tmpMatch_id;
            _tmpMatch_id = _cursor.getString(_cursorIndexOfMatchId);
            _item = new Favourite(_tmpFirst_team_name,_tmpSecond_team_name,_tmpFirst_team_score,_tmpSecond_team_score,_tmpLive_status,_tmpDate_time,_tmpMatch_id);
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _item.setId(_tmpId);
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
}
