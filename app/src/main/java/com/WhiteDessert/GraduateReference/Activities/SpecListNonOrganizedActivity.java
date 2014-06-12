package com.WhiteDessert.GraduateReference.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.WhiteDessert.GraduateReference.DataBase.ReferenceDB;
import com.WhiteDessert.GraduateReference.Help.RefHlp;
import com.WhiteDessert.GraduateReference.Help.Spec;
import com.google.android.gms.ads.AdView;
import com.whitedessert.graduatereference.R;

import java.util.ArrayList;

/**
 * Created by yazeed44 on 19/05/14.
 */
public class SpecListNonOrganizedActivity extends RootActivity {
ReferenceDB db;

    ArrayAdapter<String> adapter;
    ArrayList<String> specsString;
Spec spec;

    AdView adView;

    boolean loadingMore;
    @SuppressWarnings("NewApi")
    @Override
    public void onCreate(Bundle savedInstance) {
        specsString = new ArrayList<String>();
        super.onCreate(savedInstance);
     //   this.requestWindowFeature(Window.FEATURE_NO_TITLE);
this.setContentView(R.layout.spec_list_non_organized);

        adView = RefHlp.getAdView(this);
       /* Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                db = new ReferenceDB(SpecListNonOrganizedActivity.this);

                db.open();

                for(Spec spec:db.getAllSpecs()){
                    specsString.add(spec.getName());
                }
               db.close();
            }
        });
thread.start();*/

        db = new ReferenceDB(SpecListNonOrganizedActivity.this);

        db.open();

        for(Spec spec:db.getAllSpecs()){
            specsString.add(spec.getName());
        }
        db.close();


         adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1, specsString);

        EditText searchText = new EditText(this);
        searchText.setMaxLines(1);
        searchText.setHint("اكتب اسم التخصص");
        searchText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                SpecListNonOrganizedActivity.this.adapter.getFilter().filter(charSequence);

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        searchText.requestFocus();

        this.getListView().addHeaderView(adView);
        this.getListView().addHeaderView(searchText);

        adView.loadAd(RefHlp.AD_REQUEST);
        this.setListAdapter(adapter);




    }

       @Override
      public void onListItemClick(ListView listView,View view , int position,long id){
          final String specName = (String) listView.getItemAtPosition(position);
           db.open();
           spec = db.getSpec(specName);
           db.close();
          /* Thread thread = new Thread(new Runnable() {
               @Override
               public void run() {
                   db.open();
                   spec = db.getSpec(specName);
                   db.close();
               }
           });
thread.start();*/
           Intent i = new Intent(this,SpecActivity.class);
           Bundle bundle = new Bundle();

           bundle.putSerializable("spec",spec);
           i.putExtras(bundle);
           this.startActivity(i);
       }

    @Override
    public void onResume() {
        super.onResume();
        if (adView != null) {
            adView.resume();
        }
    }

    @Override
    public void onPause() {
        if (adView != null) {
            adView.pause();
        }
        super.onPause();
    }

    /** Called before the activity is destroyed. */
    @Override
    public void onDestroy() {
        // Destroy the AdView.
        if (adView != null) {
            adView.destroy();
        }
        super.onDestroy();

        this.setListAdapter(null);
    }


    }
