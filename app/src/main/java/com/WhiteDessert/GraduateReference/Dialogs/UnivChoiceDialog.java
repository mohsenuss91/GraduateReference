package com.WhiteDessert.GraduateReference.Dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.support.v4.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.WhiteDessert.GraduateReference.Activities.UnivActivity;
import com.WhiteDessert.GraduateReference.DataBase.ReferenceDB;
import com.WhiteDessert.GraduateReference.Help.University;
import com.whitedessert.graduatereference.R;

import java.util.ArrayList;

/**
 * Created by yazeed44 on 31/05/14.
 */
@SuppressWarnings("NewApi")
public class UnivChoiceDialog extends DialogFragment {

    public ArrayList<String> univNames;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){

        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();

        View view = inflater.inflate(R.layout.univ_choice_dialog,null);

        assert view != null;
        ListView listView = (ListView)view.findViewById(R.id.univ_choice_list);
        listView.setAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,univNames));

       final ReferenceDB db = new ReferenceDB(getActivity());

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                db.open();
                    University univ = db.getUniv(univNames.get(position));
                db.close();
                Intent i = new Intent(getActivity(), UnivActivity.class);
                i.putExtra("univ",univ);
                startActivity(i);

            }
        });
        builder.setView(view);

        builder.setTitle("أختر الجامعة");
        // Create the AlertDialog object and return it
        return builder.create();
    }
}
