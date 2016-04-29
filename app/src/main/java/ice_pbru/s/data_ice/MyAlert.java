package ice_pbru.s.data_ice;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Created by hibiki on 4/26/2016.
 */
public class MyAlert {

    public void myDialog(Context context, String strTitle, String strMessage) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setIcon(R.drawable.kongou);
        builder.setTitle(strTitle);
        builder.setMessage(strMessage);
        builder.setCancelable(false); // ไม่สามารถ กดกลับไปได้เมื่อ fail
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                dialog.dismiss(); // กดและหายไป
            }
        });

        builder.show();
    }
}
