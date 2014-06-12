package com.WhiteDessert.GraduateReference.Adapters;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;

import java.util.ArrayList;

/**
 * Created by yazeed on 12/04/14.
 */
public class SpecListAdapter extends ArrayAdapter<String> implements Filterable {

   //unused class

    public SpecListFilter filter;
    public ArrayList<String> specs,specsClone;
    public SpecListAdapter(Context context,int resource ,int resourceTextView, ArrayList<String> specs) {
        super(context,resource,resourceTextView, specs);
        this.specs = specs;
        specsClone = specs;
    }



    public int getCount() {
        return specs.size();
    }
    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public String getItem(int i) {
        return null;
    }


    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public Filter getFilter(){

        if (filter == null){
            filter = new SpecListFilter();

        }
        return filter;
    }

    private class SpecListFilter extends Filter{

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults filterResults = new FilterResults();

            if (constraint.length() == 0 || constraint == null){
                filterResults.values = specsClone;
                filterResults.count = specsClone.size();
            }

            else {
                ArrayList<String> specsFiltered = new ArrayList<String>();

                for(String spec : specsClone){
                    if (spec.contains(constraint)){
                        specsFiltered.add(spec);
                    }
                }

                filterResults.values = specsFiltered;
                filterResults.count = specsFiltered.size();
            }

            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults results) {

            if (results.count == 0 ){
                notifyDataSetInvalidated();
            }

            else {
            specs = (ArrayList<String>)  results.values;
                notifyDataSetChanged();
            }
        }
    }
}
