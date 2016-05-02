package ice_pbru.s.data_ice;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private EditText NEditText,UEditText;
    private String NString, UString;
    private MySQLite mySQLite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindwiget();

        // ทำ databass ในตัวโทรศัพท์
        mySQLite = new MySQLite(this);
        synAndDelete();


    }//1

    private void synAndDelete() {
        SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenhelper.databass_name, MODE_PRIVATE, null);
        sqLiteDatabase.delete(MySQLite.user_table, null, null);
        MySynJSON mySynJSON = new MySynJSON();
        mySynJSON.execute();


    }

    private void bindwiget() {
        NEditText = (EditText) findViewById(R.id.editText6);
        UEditText = (EditText) findViewById(R.id.editText7);



    }

    public void click_1(View view) {
        NString = NEditText.getText().toString().trim();
        UString = UEditText.getText().toString().trim();
        ///

        if (checkspace_1()) {
            //have space
            MyAlert myAlert = new MyAlert();
            myAlert.myDialog(this,"ใส่ไม่ครบ","กรอกใหม่");

        } else {
            // no space

        }

    }

    private boolean checkspace_1() {


        return NString.equals("") || UString.equals("");
    }

    public void sinUp(View view) {
        startActivity(new Intent(MainActivity.this, SignUP.class));

    }





















    public class MySynJSON extends AsyncTask<Void, Void, String> {



        @Override
        protected String doInBackground(Void... params) {
            try {
                String strURL = "http://ice.pbru.ac.th/ICE56/Santipap/php_get_user.php";
                OkHttpClient okHttpClient = new OkHttpClient();
                Request.Builder builder = new Request.Builder();
                Request request = builder.url(strURL).build();
                Response response = okHttpClient.newCall(request).execute();
                return response.body().string();

            } catch (Exception e) {
                Log.d("santipap -->", "doInback -->");
                return null;
            }

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Log.d("santipap -->", "doInback -->" + s);
            try {

                JSONArray jsonArray = new JSONArray(s);
                Log.d("santipap -->", "doInback -->" + s);
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    String strName = jsonObject.getString(MySQLite.colum_Name);
                    String strSurname = jsonObject.getString(MySQLite.colum_Surname);
                    String strUser = jsonObject.getString(MySQLite.colum_User);
                    String strPassword = jsonObject.getString(MySQLite.colum_Password);
                    String strEmail = jsonObject.getString(MySQLite.colum_Email);

                    mySQLite.addNewUser(strName, strSurname, strUser, strPassword, strEmail);
                    Log.d("santipap -->", "doInback -->" + strName.toString());

                }
                Toast.makeText(MainActivity.this, "Synchonize mySQL to SQLite Finish", Toast.LENGTH_LONG).show();

            } catch (Exception e){

                Log.d("santipap -->", "doInback -->" + e.toString());

            }

        }
    }




// end do






























}//2



























