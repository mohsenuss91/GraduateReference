package com.WhiteDessert.GraduateReference.Dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.support.v4.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;

import com.whitedessert.graduatereference.R;


/**
 * Created by yazeed44 on 17/05/14.
 */
@SuppressWarnings("NewApi")
public class ReferenceDialog extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();


        builder.setView(inflater.inflate(R.layout.reference_dialog,null));
        // Create the AlertDialog object and return it
        return builder.create();
    }
}
