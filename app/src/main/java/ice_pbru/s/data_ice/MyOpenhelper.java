package ice_pbru.s.data_ice;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by hibiki on 4/29/2016.
 */
public class MyOpenhelper extends SQLiteOpenHelper{


    // ค่าที่ไม่สามารถ แก้ได้แล้ว
    public static final String databass_name = "MyDatabass.db";
    private static final int databass_version = 1;

    private static final String create_user_table = "create table userTABLE (" +
            "_id integer primary key, " +
            "Name text, " +
            "Surname text, " +
            "User text, " +
            "Password text, " +
            "Email text); ";


    public MyOpenhelper(Context context) {
        super(context,databass_name,null,databass_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(create_user_table);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}


