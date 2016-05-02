package ice_pbru.s.data_ice;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by hibiki on 4/29/2016.
 */
public class MySQLite {
    private MyOpenhelper myOpenhelper;
    private SQLiteDatabase sqLiteDatabase;
    public static final String user_table = "userTable";
    public static final String colum_id = "_id";
    public static final String colum_Name = "Name";
    public static final String colum_Surname = "Surname";
    public static final String colum_User = "User";
    public static final String colum_Password = "Password";
    public static final String colum_Email = "Email";

    public MySQLite(Context context) {
        myOpenhelper = new MyOpenhelper(context);
        sqLiteDatabase = myOpenhelper.getWritableDatabase();


    }

    public long addNewUser(String strName,
                           String strSurname,
                           String strUser,
                           String strPassword,
                           String strEmail) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(colum_Name, strName);
        contentValues.put(colum_Surname,strSurname);
        contentValues.put(colum_User, strUser);
        contentValues.put(colum_Password, strPassword);
        contentValues.put(colum_Email, strEmail);

        return sqLiteDatabase.insert(user_table, null, contentValues);
    }

}//1
