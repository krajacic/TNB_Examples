package cawabanga.com.tnb_examples;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.SQLException;

/**
 * Created by croatan on 5.3.2016. TNB_Examples.
 */
public class HotOrNot {

    public static final String KEY_ROWID = "_id"; // public means other class can access it static we don't wanna change Final-that never gonna change
    public static final String KEY_NAME = "persons_name";
    public static final String KEY_HOTNESS = "persons_hotness";

    private static final String DATABASE_NAME = "HotOrNotdb";
    private static final String DATABASE_TABLE = "peopleTable";
    private static final int DATABASE_VERSION = 1;


    private DbHelper ourHelper;
    private final Context ourContext;
    private SQLiteDatabase ourDatabase;

    private static class DbHelper extends SQLiteOpenHelper {

        public DbHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE " + DATABASE_TABLE + " (" +
                            KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                            KEY_NAME + " TEXT NOT NULL, " +
                            KEY_HOTNESS + " TEXT NOT NULL);"
            );
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
            onCreate(db);
        }
    }

    public HotOrNot(Context c) {
        ourContext = c;
    }

    public HotOrNot open() throws SQLException {
        ourHelper = new DbHelper(ourContext);
        ourDatabase = ourHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        ourHelper.close();
    }

    public long createEntry(String name, String hotness) {
        ContentValues cv = new ContentValues();
        cv.put(KEY_NAME, name);
        cv.put(KEY_HOTNESS, hotness);
        return ourDatabase.insert(DATABASE_TABLE, null, cv);
    }

    public String getData() {
        String[] columns = new String[]{KEY_ROWID, KEY_NAME, KEY_HOTNESS};
        Cursor c = ourDatabase.query(DATABASE_TABLE, columns, null, null, null, null, null);
        String result = "";

        int iRow = c.getColumnIndex(KEY_ROWID); //position 0
        int iName = c.getColumnIndex(KEY_NAME); //position 1
        int iHotness = c.getColumnIndex(KEY_HOTNESS); //position 2

        for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
            result = result + c.getString(iRow) + " " + c.getString(iName) + " " + c.getString(iHotness) + "\n";
        }
        return result;
    }

    public String getName(long l) throws SQLException {
        String[] columns = new String[]{KEY_ROWID, KEY_NAME, KEY_HOTNESS};
        Cursor c = ourDatabase.query(DATABASE_TABLE, columns, KEY_ROWID + "=" + l, null, null, null, null);
        if (c != null) {
            c.moveToFirst();
            String name = c.getString(1); //position 1 Line 78
            return name;
        }
        return null;
    }

    public String getHotness(long l) throws SQLException {
        String[] columns = new String[]{KEY_ROWID, KEY_NAME, KEY_HOTNESS};
        Cursor c = ourDatabase.query(DATABASE_TABLE, columns, KEY_ROWID + "=" + l, null, null, null, null);
        if (c != null) {
            c.moveToFirst();
            String hotness = c.getString(2); //position 2 Line 79
            return hotness;
        }
        return null;
    }

    public void updateEntry(long lRow, String mName, String mHotness) throws SQLException {
        ContentValues cvUpdate = new ContentValues();
        cvUpdate.put(KEY_NAME, mName);
        cvUpdate.put(KEY_HOTNESS, mHotness);
        ourDatabase.update(DATABASE_TABLE, cvUpdate, KEY_ROWID + "=" + lRow, null);
    }

    public void deleteEntry(long lRow1) throws SQLException {
        ourDatabase.delete(DATABASE_TABLE, KEY_ROWID + "=" + lRow1, null);
    }

}