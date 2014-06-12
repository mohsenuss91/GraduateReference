package com.WhiteDessert.GraduateReference.Dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.whitedessert.graduatereference.R;

/**
 * Created by yazeed44 on 07/06/14.
 */
public class AboutAppDialog extends DialogFragment {


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();

        View view = inflater.inflate(R.layout.about_app_dialog,null);

        assert view != null;
        TextView aboutText = (TextView)view.findViewById(R.id.aboutAppText);

        aboutText.setText("صمم هذا التطبيق بغاية تسهيل اختيار الجامعة والتخصص على الطالب المتخرج\n" +
                "\n" +
                "وينقسم الى قسمين\n" +
                "\n" +
                "القسم الاول\n" +
                "\n" +
                "قائمة الجامعات : تضم جميع الجامعات في السعودية وبعض المعلومات عنها\n" +
                "\n" +
                "القسم الثاني\n" +
                "\n" +
                "قائمة التخصصات : وتضم التخصصات الموجودة في سوق العمل , وتشرح كل تخصص وماله من تخصصات فرعية , وأين يدرس هذا التخصص");
        builder.setView(view);

        return builder.create();
    }
}
