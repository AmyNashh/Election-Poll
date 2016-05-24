package com.example.amynashamy.electionpoll;

/**
 * Created by amynashAmy on 15/03/16.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.RowId;
import java.sql.SQLException;

public class MyDBManager {


    private static final String DATABASE_NAME = "Polling";
    private static final String DATABASE_TABLE = "Polling_Details";
    private static final int DATABASE_VERSION = 1;

    public static final String KEY_ROWID = "_id";
    public static final String KEY_CHOICE = "choice";
    public static final String KEY_GENDER = "gender";
    public static final String KEY_KIDS = "kids";
    public static final String KEY_MARITAL = "married";
    public static final String KEY_FIRST_TIME_VOTER = "first_time_voter";
    public static final String KEY_PARTY_MEMBER = "party_member";
    public static final String KEY_AGE = "age";
    public static final String KEY_EMPLOYMENT = "employment";
    public static final String KEY_INCOME = "income";
    public static final String KEY_REASON_FOR_CANDIDATE = "reason_for_candidate";
    public static final String KEY_LOCALITY = "locality";

    //////

    private static final String DATABASE_CREATE = "create table Polling_Details " +
            "(_id integer primary key autoincrement, " + "choice text not null," +
            "gender text not null, " + "kids text not null, " + "married text not null, " +
            "first_time_voter text not null, " + "party_member text not null, " + "age text not null, " +
            "employment text not null, " + "income text not null, " + "reason_for_candidate text not null, " +
            "locality text not null);";

    private final Context context;
    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;

    //////
    public MyDBManager(Context ctx) {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }


    /////
    private static class DatabaseHelper extends SQLiteOpenHelper {
        DatabaseHelper(Context context) {
            super(context, DATABASE_NAME,
                    null, DATABASE_VERSION);
        }


        @Override
        //
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(DATABASE_CREATE);
        }

        @Override

        //
        public void onUpgrade(SQLiteDatabase db, int oldVersion,
                              int newVersion) {
            // whatever is to be changed on dB structure

        }
    }


    //////
    public MyDBManager open() throws SQLException {
        db = DBHelper.getWritableDatabase();
        return this;
    }

    //
    public void close() {
        DBHelper.close();
    }

    //
    public long insertPoll(String choice, String gender, String kids, String married, String first_time_voter,
                           String party_member, String age, String employment, String income, String reason_for_candidate,
                           String locality) {
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_CHOICE, choice);
        initialValues.put(KEY_GENDER, gender);
        initialValues.put(KEY_KIDS, kids);
        initialValues.put(KEY_MARITAL, married);
        initialValues.put(KEY_FIRST_TIME_VOTER, first_time_voter);
        initialValues.put(KEY_PARTY_MEMBER, party_member);
        initialValues.put(KEY_AGE, age);
        initialValues.put(KEY_EMPLOYMENT, employment);
        initialValues.put(KEY_INCOME, income);
        initialValues.put(KEY_REASON_FOR_CANDIDATE, reason_for_candidate);
        initialValues.put(KEY_LOCALITY, locality);


        return db.insert(DATABASE_TABLE, null, initialValues);
    }

    /////// Get everyones info //////

    public Cursor getAllPolled() {
        return db.query(DATABASE_TABLE, new String[]{
                        KEY_ROWID,
                        KEY_CHOICE,
                        KEY_GENDER,
                        KEY_KIDS,
                        KEY_MARITAL,
                        KEY_FIRST_TIME_VOTER,
                        KEY_PARTY_MEMBER,
                        KEY_AGE,
                        KEY_EMPLOYMENT,
                        KEY_INCOME,
                        KEY_REASON_FOR_CANDIDATE,
                        KEY_LOCALITY

                },
                null,
                null,
                null,
                null,
                null);
    }

    /////// Get everyones info //////
    public Cursor getRows(long RowId) throws android.database.SQLException {
        Cursor mCursor =
                db.query(true, DATABASE_TABLE, new String[]{
                                KEY_ROWID,
                                KEY_CHOICE,
                                KEY_GENDER,
                                KEY_KIDS,
                                KEY_MARITAL,
                                KEY_FIRST_TIME_VOTER,
                                KEY_PARTY_MEMBER,
                                KEY_AGE,
                                KEY_EMPLOYMENT,
                                KEY_INCOME,
                                KEY_REASON_FOR_CANDIDATE,
                                KEY_LOCALITY
                        },

                        KEY_ROWID + "=" + RowId,
                        null,
                        null,
                        null,
                        null,
                        null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    /////// Get all gender, age and locality //////

    public Cursor getAverage(String gender, String age, String locality) throws android.database.SQLException {
        Cursor mCursor =
                db.query(true, DATABASE_TABLE, new String[]{
                                KEY_ROWID,
                                KEY_CHOICE,
                                KEY_GENDER,
                                KEY_KIDS,
                                KEY_MARITAL,
                                KEY_FIRST_TIME_VOTER,
                                KEY_PARTY_MEMBER,
                                KEY_AGE,
                                KEY_EMPLOYMENT,
                                KEY_INCOME,
                                KEY_REASON_FOR_CANDIDATE,
                                KEY_LOCALITY
                        },
                        KEY_GENDER + "=\"" + gender + "\"" + " AND " + KEY_AGE + "=\"" + age + "\"" + " AND " + KEY_LOCALITY + "=\"" + locality + "\"",
                        null,
                        null,
                        null,
                        null,
                        null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    /////// Get specific locality //////
    public Cursor getgenderage(String locality) throws android.database.SQLException {
        Cursor mCursor =
                db.query(true, DATABASE_TABLE, new String[]{
                                KEY_ROWID,
                                KEY_CHOICE,
                                KEY_GENDER,
                                KEY_KIDS,
                                KEY_MARITAL,
                                KEY_FIRST_TIME_VOTER,
                                KEY_PARTY_MEMBER,
                                KEY_AGE,
                                KEY_EMPLOYMENT,
                                KEY_INCOME,
                                KEY_REASON_FOR_CANDIDATE,
                                KEY_LOCALITY
                        },
                        KEY_LOCALITY + "=\"" + locality + "\"",
                        null,
                        null,
                        null,
                        null,
                        null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    /////// Get specific gender //////
public Cursor getAllAgeLoc(String gender) throws android.database.SQLException {
    Cursor mCursor =
            db.query(true, DATABASE_TABLE, new String[]{
                            KEY_ROWID,
                            KEY_CHOICE,
                            KEY_GENDER,
                            KEY_KIDS,
                            KEY_MARITAL,
                            KEY_FIRST_TIME_VOTER,
                            KEY_PARTY_MEMBER,
                            KEY_AGE,
                            KEY_EMPLOYMENT,
                            KEY_INCOME,
                            KEY_REASON_FOR_CANDIDATE,
                            KEY_LOCALITY
                    },
                    KEY_GENDER + "=\"" + gender + "\"",
                    null,
                    null,
                    null,
                    null,
                    null);
    if (mCursor != null) {
        mCursor.moveToFirst();
    }
    return mCursor;
}
    /////// Get specific age //////
    public Cursor getAllGenderLoc(String age) throws android.database.SQLException {
        Cursor mCursor =
                db.query(true, DATABASE_TABLE, new String[]{
                                KEY_ROWID,
                                KEY_CHOICE,
                                KEY_GENDER,
                                KEY_KIDS,
                                KEY_MARITAL,
                                KEY_FIRST_TIME_VOTER,
                                KEY_PARTY_MEMBER,
                                KEY_AGE,
                                KEY_EMPLOYMENT,
                                KEY_INCOME,
                                KEY_REASON_FOR_CANDIDATE,
                                KEY_LOCALITY
                        },
                        KEY_AGE + "=\"" + age + "\"",
                        null,
                        null,
                        null,
                        null,
                        null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }


    /////// Get specific gender and age //////
    public Cursor getAllLoc(String gender, String age) throws android.database.SQLException {
        Cursor mCursor =
                db.query(true, DATABASE_TABLE, new String[]{
                                KEY_ROWID,
                                KEY_CHOICE,
                                KEY_GENDER,
                                KEY_KIDS,
                                KEY_MARITAL,
                                KEY_FIRST_TIME_VOTER,
                                KEY_PARTY_MEMBER,
                                KEY_AGE,
                                KEY_EMPLOYMENT,
                                KEY_INCOME,
                                KEY_REASON_FOR_CANDIDATE,
                                KEY_LOCALITY
                        },
                        KEY_GENDER + "=\"" + gender + "\"" + " AND " + KEY_AGE + "=\"" + age + "\"",
                        null,
                        null,
                        null,
                        null,
                        null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }


    /////// Get specific gender and locality //////
    public Cursor getAllAge(String gender, String locality) throws android.database.SQLException {
        Cursor mCursor =
                db.query(true, DATABASE_TABLE, new String[]{
                                KEY_ROWID,
                                KEY_CHOICE,
                                KEY_GENDER,
                                KEY_KIDS,
                                KEY_MARITAL,
                                KEY_FIRST_TIME_VOTER,
                                KEY_PARTY_MEMBER,
                                KEY_AGE,
                                KEY_EMPLOYMENT,
                                KEY_INCOME,
                                KEY_REASON_FOR_CANDIDATE,
                                KEY_LOCALITY
                        },
                        KEY_GENDER + "=\"" + gender + "\"" + " AND " + KEY_LOCALITY + "=\"" + locality + "\"",
                        null,
                        null,
                        null,
                        null,
                        null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    /////// Get specific age and locality //////
    public Cursor getAllGender(String age, String locality) throws android.database.SQLException {
        Cursor mCursor =
                db.query(true, DATABASE_TABLE, new String[]{
                                KEY_ROWID,
                                KEY_CHOICE,
                                KEY_GENDER,
                                KEY_KIDS,
                                KEY_MARITAL,
                                KEY_FIRST_TIME_VOTER,
                                KEY_PARTY_MEMBER,
                                KEY_AGE,
                                KEY_EMPLOYMENT,
                                KEY_INCOME,
                                KEY_REASON_FOR_CANDIDATE,
                                KEY_LOCALITY
                        },
                        KEY_AGE + "=\"" + age + "\"" + " AND " + KEY_LOCALITY + "=\"" + locality + "\"",
                        null,
                        null,
                        null,
                        null,
                        null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }
    /////// Get Candidate choice //////
    public Cursor rawQuery(String choice) throws android.database.SQLException {
        Cursor mCursor =
                db.query(true, DATABASE_TABLE, new String[]{
                                KEY_ROWID,
                                KEY_CHOICE,
                                KEY_GENDER,
                                KEY_KIDS,
                                KEY_MARITAL,
                                KEY_FIRST_TIME_VOTER,
                                KEY_PARTY_MEMBER,
                                KEY_AGE,
                                KEY_EMPLOYMENT,
                                KEY_INCOME,
                                KEY_REASON_FOR_CANDIDATE,
                                KEY_LOCALITY
                        },
                        KEY_CHOICE + "=\"" + choice + "\"",
                        null,
                        null,
                        null,
                        null,
                        null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    /////// Get Candidate choice //////
    public Cursor getVotes(String choice)
    {
        return db.query(DATABASE_TABLE, new String[] {
                        KEY_CHOICE
                },
                KEY_CHOICE + "=\"" + choice + "\"",
                null,
                null,
                null,
                null);
    }
}