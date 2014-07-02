package com.WhiteDessert.GraduateReference.Activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.whitedessert.graduatereference.R;

/**
 * Created by yazeed44 on 12/06/14.
 */
public class PercActivity extends Activity {

    private EditText trakmeUser,qdratUser,thseleUser;

    private EditText trakmeUniv,qdratUniv,thseleUniv;

    private TextView result;

    double trakmeUserInt,qdratUserInt ,thseleUserInt ,trakmeUnivInt ,qdratUnivInt ,thseleUnivInt ;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.perc_activity);

        //for user
        trakmeUser = (EditText)this.findViewById(R.id.trakmeUserEdit);
        qdratUser = (EditText)this.findViewById(R.id.qdratUserEdit);
        thseleUser = (EditText)this.findViewById(R.id.thseleUserEdit);


        //for univ

        trakmeUniv = (EditText)this.findViewById(R.id.trakmeUnivEdit);
        qdratUniv = (EditText)this.findViewById(R.id.qdratUnivEdit);
        thseleUniv = (EditText)this.findViewById(R.id.thseleUnivEdit);



        result = (TextView)this.findViewById(R.id.percResult);
    }





    public void onClickCalc(View view){



        try {
            trakmeUserInt = (double)Integer.parseInt(trakmeUser.getText().toString());
Log.i("PercActivity","inside try trakme user int = "+ trakmeUserInt);

            qdratUserInt =(double) Integer.parseInt(qdratUser.getText().toString());

            thseleUserInt = (double)Integer.parseInt(thseleUser.getText().toString());

            trakmeUnivInt = (double)Integer.parseInt(trakmeUniv.getText().toString());
            Log.i("PercActivity","inside try trakme univ int = "+ trakmeUnivInt);
            qdratUnivInt =(double) Integer.parseInt(qdratUniv.getText().toString());

            thseleUnivInt = (double)Integer.parseInt(thseleUniv.getText().toString());
        }
        catch(NumberFormatException e){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setTitle("هنالك خطأ");
            builder.setMessage("تأكد من كتابة البيانات الصحيحة !!");

            builder.create().show();
           return ;
        }

        if (trakmeUnivInt + qdratUnivInt + thseleUnivInt != 100){
                  AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setTitle("هنالك خطأ");
            builder.setMessage("مجموع نسب الجامعة لايساوي 100 !!");

            builder.create().show();
           return ;
        }
        else {
            double trakme = trakmeUserInt * (double)(trakmeUnivInt / 100);
            Log.i("PercActivity","trakme perc = " + trakme);

            double qdrat = (qdratUserInt) * (double)(qdratUnivInt/100);
            Log.i("PercActivity","qdrat perc = " + qdrat);

            double thsele =  (thseleUserInt) * (double)(thseleUnivInt / 100);
            Log.i("PercActivity","thsele perc = " + thsele);


            result.setText("النسبة المركبة = "  + (trakme + qdrat + thsele));
        }
    }
}
