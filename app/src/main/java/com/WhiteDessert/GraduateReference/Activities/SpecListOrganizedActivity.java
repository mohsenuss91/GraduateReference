package com.WhiteDessert.GraduateReference.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.WhiteDessert.GraduateReference.DataBase.ReferenceDB;
import com.WhiteDessert.GraduateReference.Help.RefHlp;
import com.WhiteDessert.GraduateReference.Help.Spec;
import com.google.android.gms.ads.AdView;
import com.whitedessert.graduatereference.R;

import java.util.ArrayList;
/**
 * Created by yazeed on 16/04/14.
 */
public class SpecListOrganizedActivity extends RootActivity {

    //ListView listView;
    ArrayList<Spec> specs;
    @SuppressWarnings("NewApi")
    ReferenceDB db;
    String specsString[];
    Spec spec;

    AdView adView;
    @Override
    public void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
      //  this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        this.setContentView(R.layout.spec_list_organized);
        Intent i = this.getIntent();

        adView = RefHlp.getAdView(this);
        Bundle bundle = i.getExtras();
        assert bundle != null;
        specs = (ArrayList<Spec>) bundle.getSerializable("specs");

        assert specs != null;
        specsString = new String[specs.size()];

        int g = 0;
        for(Spec spec : specs){

            specsString[g] = spec.getName();
            g++;
        }
       /* Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int g = 0;
                for(Spec spec : specs){

                    specsString[g] = spec.getName();
                    g++;
                }
            }
        });*/



        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, specsString);

        this.getListView().addHeaderView(adView);


        adView.loadAd(RefHlp.AD_REQUEST);
            this.setListAdapter(adapter);




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


    @SuppressWarnings("NewApi")
    @Override
    public void onListItemClick(ListView listView,View view , final int position,long id ){
            Intent intent = new Intent(getBaseContext(),SpecActivity.class);
            Bundle bundle = new Bundle();
        final String specName = (String) listView.getItemAtPosition(position);

        Log.i("SpecListOrganizedActivity","spec Name : " + specName);
        db = new ReferenceDB(this);
        db.open();
        //only contain name and sub specs
      //  Spec selectedSpec = specs.get(position);

        // to get the full spec with desc , and subspecs, and where to study
        spec =  db.getSpec(specName);
        db.close();
     /*   Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                db = new ReferenceDB(SpecListOrganizedActivity.this);
                db.open();
                //only contain name and sub specs
                Spec selectedSpec = specs.get(position);

                // to get the full spec with desc , and subspecs, and where to study
                spec =  db.getSpec(selectedSpec.getName());
                db.close();
            }
        });*/


            bundle.putSerializable("spec",spec);

            intent.putExtras(bundle);


                startActivity(intent);
               // this.overridePendingTransition(R.anim.animation_leave,R.anim.animation_enter);


        }
    }

