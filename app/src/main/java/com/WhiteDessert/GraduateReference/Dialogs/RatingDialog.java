package com.WhiteDessert.GraduateReference.Dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.support.v4.app.DialogFragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.whitedessert.graduatereference.R;

/**
 * Created by yazeed44 on 02/06/14.
 */
@SuppressWarnings("NewApi")
public class RatingDialog extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();


        View view = inflater.inflate(R.layout.rating_dialog,null);

        assert view != null;
        Button exitButton = (Button)view.findViewById(R.id.exitRatingBtn);
        Button urlButton = (Button)view.findViewById(R.id.appUrl);

        urlButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=com.whitedessert.graduatereference");

                Intent i = new Intent(Intent.ACTION_VIEW,uri);

                startActivity(i);
            }
        });

        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();
                getDialog().dismiss();
            }
        });

        builder.setView(view);
        // Create the AlertDialog object and return it
        return builder.create();
    }


}
