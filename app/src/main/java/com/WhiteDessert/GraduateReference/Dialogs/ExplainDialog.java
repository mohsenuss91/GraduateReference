package com.WhiteDessert.GraduateReference.Dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.support.v4.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.whitedessert.graduatereference.R;

/**
 * Created by yazeed44 on 03/06/14.
 */
@SuppressWarnings("NewApi")
public class ExplainDialog extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();


        View view = inflater.inflate(R.layout.explain_dialog,null);

        assert view != null;
        Button continueBtn = (Button)view.findViewById(R.id.continueExplain);
        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               getDialog().dismiss();
            }
        });
        builder.setView(view);
        // Create the AlertDialog object and return it
        return builder.create();
    }
}
