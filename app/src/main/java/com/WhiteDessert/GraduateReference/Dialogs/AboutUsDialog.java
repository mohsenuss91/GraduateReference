package com.WhiteDessert.GraduateReference.Dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;

import com.whitedessert.graduatereference.R;


@SuppressWarnings("NewApi")
public class AboutUsDialog extends DialogFragment {


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();


        builder.setView(inflater.inflate(R.layout.about_us_dialog,null));
        // Create the AlertDialog object and return it
        return builder.create();
    }

}
