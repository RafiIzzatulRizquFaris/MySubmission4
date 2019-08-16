package com.example.mysubmission4;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static android.provider.BaseColumns._ID;
import static com.example.mysubmission4.DatabaseContract.MovieColumns.JUDUL;
import static com.example.mysubmission4.DatabaseContract.MovieColumns.MOVIE_ID;
import static com.example.mysubmission4.DatabaseContract.MovieColumns.OVERVIEW;
import static com.example.mysubmission4.DatabaseContract.MovieColumns.POSTER;
import static com.example.mysubmission4.DatabaseContract.MovieColumns.RELEASE;
import static com.example.mysubmission4.DatabaseContract.MovieColumns.VOTE;
import static com.example.mysubmission4.DatabaseContract.TABEL;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static String DATABASE_NAME = "dbmovie";
    private static final int DATABASE_VERSION = 1;
    private static final String SQL_CREATE_TABEL = String.format("CREATE TABLE %s"+
                    "(%s INTEGER PRIMARY KEY AUTOINCREMENT,"+
                    "%s TEXT NOT NULL,"+
                    "%s TEXT,"+
                    "%s TEXT NOT NULL,"+
                    "%s TEXT NOT NULL,"+
                    "%s TEXT NOT NULL,"+
                    "%s TEXT NOT NULL)",
                    TABEL,
            _ID,
            MOVIE_ID,
            JUDUL,
            OVERVIEW,
            RELEASE,
            VOTE,
            POSTER
    );

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABEL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABEL);
        onCreate(db);
    }

    DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
}
