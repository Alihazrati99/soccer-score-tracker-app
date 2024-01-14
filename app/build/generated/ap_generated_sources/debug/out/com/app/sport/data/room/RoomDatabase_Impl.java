package com.app.sport.data.room;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import com.app.sport.data.room.dao.FavouriteDao;
import com.app.sport.data.room.dao.FavouriteDao_Impl;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class RoomDatabase_Impl extends RoomDatabase {
  private volatile FavouriteDao _favouriteDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(2) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `favourite_table` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `first_team_name` TEXT, `second_team_name` TEXT, `first_team_score` TEXT, `second_team_score` TEXT, `live_status` TEXT, `date_time` TEXT, `match_id` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '854989187f78a025ebbf4488ba3621af')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `favourite_table`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsFavouriteTable = new HashMap<String, TableInfo.Column>(8);
        _columnsFavouriteTable.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFavouriteTable.put("first_team_name", new TableInfo.Column("first_team_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFavouriteTable.put("second_team_name", new TableInfo.Column("second_team_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFavouriteTable.put("first_team_score", new TableInfo.Column("first_team_score", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFavouriteTable.put("second_team_score", new TableInfo.Column("second_team_score", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFavouriteTable.put("live_status", new TableInfo.Column("live_status", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFavouriteTable.put("date_time", new TableInfo.Column("date_time", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFavouriteTable.put("match_id", new TableInfo.Column("match_id", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysFavouriteTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesFavouriteTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoFavouriteTable = new TableInfo("favourite_table", _columnsFavouriteTable, _foreignKeysFavouriteTable, _indicesFavouriteTable);
        final TableInfo _existingFavouriteTable = TableInfo.read(_db, "favourite_table");
        if (! _infoFavouriteTable.equals(_existingFavouriteTable)) {
          return new RoomOpenHelper.ValidationResult(false, "favourite_table(com.app.sport.data.model.Favourite).\n"
                  + " Expected:\n" + _infoFavouriteTable + "\n"
                  + " Found:\n" + _existingFavouriteTable);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "854989187f78a025ebbf4488ba3621af", "174efab2822acc4fb2a9e21025299529");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "favourite_table");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `favourite_table`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public FavouriteDao favouriteDao() {
    if (_favouriteDao != null) {
      return _favouriteDao;
    } else {
      synchronized(this) {
        if(_favouriteDao == null) {
          _favouriteDao = new FavouriteDao_Impl(this);
        }
        return _favouriteDao;
      }
    }
  }
}
