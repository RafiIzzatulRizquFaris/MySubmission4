package com.example.mysubmission4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import static android.provider.BaseColumns._ID;
import static com.example.mysubmission4.DatabaseContract.MovieColumns.MOVIE_ID;
import static com.example.mysubmission4.DatabaseContract.TABEL;

public class MovieHelper {
    private static String DATABASE_TABLE = TABEL;
    private Context mContext;
    private DatabaseHelper mDatabaseHelper;
    private SQLiteDatabase mDatabase;

    public MovieHelper(Context mContext){
        this.mContext = mContext;
    }

    public MovieHelper open() throws SQLException {
        mDatabaseHelper = new DatabaseHelper(mContext);
        mDatabase = mDatabaseHelper.getWritableDatabase();
        return this;
    }

    public long insertProvider(ContentValues contentValues){
        return mDatabase.insert(DATABASE_TABLE, null, contentValues);
    }

    public void close(){
        mDatabaseHelper.close();
        if (mDatabase.isOpen()) mDatabase.close();
    }

    public Cursor queryByIdProvider(String id){
        return mDatabase.query(DATABASE_TABLE,null,MOVIE_ID+"=?",new String[]{id},null,null,null,null);
    }

    public int updateProvider(String id, ContentValues contentValues){
        return mDatabase.update(DATABASE_TABLE, contentValues,MOVIE_ID+"=?",new String[]{id});
    }

    public int deleteProvider(String id){
        return mDatabase.delete(DATABASE_TABLE,MOVIE_ID+"=?",new String[]{id});
    }

    public Cursor queryProvider(){
        return mDatabase.query(DATABASE_TABLE, null,null,null,null,null,_ID+" DESC");
    }
}
