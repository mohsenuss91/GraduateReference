package com.WhiteDessert.GraduateReference.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.WhiteDessert.GraduateReference.Help.SubSpec;
import com.whitedessert.graduatereference.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yazeed on 17/04/14.
 */
public class SubSpecAdapter extends BaseAdapter {


    private List<SubSpec> subSpecs;


    private static LayoutInflater inflater=null;

    public SubSpecAdapter(Activity activity,ArrayList<SubSpec> subSpecs){
        Activity activity1 = activity;

this.subSpecs = subSpecs;

        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return subSpecs.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;

        if (convertView == null){
            vi = inflater.inflate(R.layout.sub_spec_multi_layer,null);

            assert vi != null;
            TextView name = (TextView)vi.findViewById(R.id.subSpecName);

            TextView hint = (TextView)vi.findViewById(R.id.subSpecHint);

         //   name.setText(subSpecs.get(position).getName());
               name.setText(subSpecs.get(position).name);
           // hint.setText(subSpecs.get(position).getHint());
            hint.setText(subSpecs.get(position).hint);
        }

        return vi;
    }
}
