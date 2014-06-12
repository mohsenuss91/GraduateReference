package com.WhiteDessert.GraduateReference.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.WhiteDessert.GraduateReference.Help.University;
import com.whitedessert.graduatereference.R;

import java.util.ArrayList;

/**
 * Created by yazeed on 04/04/14.
 */
public class UnivListViewAdapter extends ArrayAdapter<University> implements Filterable {


    private ArrayList<University> universities,univs;
    private UnivFilter filter;
   private Activity activity;
    private static LayoutInflater inflater=null;

    public UnivListViewAdapter(Activity a, ArrayList<University> universities,int resource) {
        super(a,resource,universities);
         activity = a;

        this.universities = universities;

this.univs = this.universities;
       // setImagesAgain();
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


   /* private void setImagesAgain(){

        for(int i = 0 ; i < universities.size();i++){
              universities.get(i).setImage(RefHlp.getUnivsImage().get(i));
            univs.get(i).setImage(RefHlp.getUnivsImage().get(i));
        }
    }*/
    public int getCount() {
        return universities.size();
    }

    @Override
    public University getItem(int i) {
        return null;
    }


    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
     //   setImagesAgain();
        View vi=convertView;

        if(convertView==null)
            vi = inflater.inflate(R.layout.univ_list_multi_layer, null);

        assert vi != null;
        TextView name=(TextView)vi.findViewById(R.id.univListName);

        ImageView image = (ImageView) vi.findViewById(R.id.univListImage);

        TextView rank = (TextView)vi.findViewById(R.id.univListRank);

        TextView region = (TextView)vi.findViewById(R.id.univListRegion);
     //   name.setText(universities.get(position).getName());
name.setText(universities.get(position).name);

     //   image.setBackgroundResource(universities.get(position).getImage());
        int resId = activity.getResources().getIdentifier(universities.get(position).image,"drawable",activity.getPackageName());
       // RefHlp.toastMessageShort(activity,"path to drawable = " + universities.get(position).image + "\n");
        image.setBackgroundResource(resId);

String rankS;

        if (universities.get(position).getRank() == 99999){
            rankS = "لايوجد تقييم";
        }

        else { rankS = "الترتيب العالمي : "+/* universities.get(position).getRank();*/ universities.get(position).rank;}

        rank.setText(rankS);



       // region.setText("" + universities.get(position).getRegions());
        region.setText("" + universities.get(position).region);
        return vi;
    }

    @Override
    public Filter getFilter() {


        if (filter == null) {
            filter = new UnivFilter();
        }

        return filter;
    }
  private class UnivFilter extends Filter {

      @Override
      protected FilterResults performFiltering(CharSequence constraint) {
          FilterResults results = new FilterResults();

          // We implement here the filter logic
          if (constraint == null || constraint.length() == 0) {
              // No filter implemented we return all the list
              results.values = univs;
              results.count = univs.size();
          }
          else {
              // We perform filtering operation
              ArrayList<University> filterUnivs = new ArrayList<University>();

              for (University u : univs) {
                  if (u.getName().contains(constraint)||u.getRegions().contains(constraint))
                      filterUnivs.add(u);

              }

              results.values = filterUnivs;
              results.count = filterUnivs.size();
          //    RefHlp.toastMessageShort(activity,"size of results = " + results.count);
          }


          return results;
      }

      @Override
      protected void publishResults(CharSequence charSequence, FilterResults results) {


          // Now we have to inform the adapter about the new list filtered
          if (results.count == 0) {
              notifyDataSetInvalidated();
            //  universities.clear();
          }
          else {
              universities = (ArrayList<University>) results.values;
              notifyDataSetChanged();
              //RefHlp.toastMessageShort(activity,"univs size = " + universities.size());
          }

     //     RefHlp.toastMessageShort(getContext(),"in publicResults");

      }
  }



}
