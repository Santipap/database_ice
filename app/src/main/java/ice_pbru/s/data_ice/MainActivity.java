package ice_pbru.s.data_ice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText NEditText,UEditText;
    private String NString, UString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindwiget();
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
        startActivity(new Intent(MainActivity.this,SignUP.class));

    }


}
