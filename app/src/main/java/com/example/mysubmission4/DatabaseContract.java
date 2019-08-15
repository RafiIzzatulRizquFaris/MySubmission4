package com.example.mysubmission4;

import android.database.Cursor;
import android.net.Uri;
import android.provider.BaseColumns;

public class DatabaseContract {
    public static String TABEL = "movie";

    public static final class MovieColumns implements BaseColumns {
        public static String JUDUL = "title";
        public static String OVERVIEW = "overview";
        public static String POSTER = "poster_path";
        public static String RELEASE = "release_date";
        public static String VOTE = "vote_average";

    }
    public static final String AUTHORITY = "com.example.mysubmission4";
    public static final Uri CONTENT_URI = new Uri.Builder().scheme("content")
            .authority(AUTHORITY)
            .appendPath(TABEL)
            .build();
    public static long getColumnLong(Cursor cursor, String columnName) {
        return cursor.getLong(cursor.getColumnIndex(columnName));
    }

    public static String getColumnString(Cursor cursor, String columnName) {
        return cursor.getString(cursor.getColumnIndex(columnName));
    }

    public static int getColumnInt(Cursor cursor, String columnName) {
        return cursor.getInt(cursor.getColumnIndex(columnName));
    }

    public static Double getColumnDouble(Cursor cursor, String columnName){
        return cursor.getDouble(cursor.getColumnIndex(columnName));
    }
}
