package com.WhiteDessert.GraduateReference.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.WhiteDessert.GraduateReference.Help.MainSpec;
import com.WhiteDessert.GraduateReference.Help.RefHlp;
import com.WhiteDessert.GraduateReference.Help.Spec;
import com.google.android.gms.ads.AdView;
import com.whitedessert.graduatereference.R;

import java.util.ArrayList;

/**
 * Created by yazeed on 16/04/14.
 */
public class MainSpecListActivity extends RootActivity {


    //ListView listView;
    private MainSpec specs[] = new MainSpec[12];

    private AdView adView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.setContentView(R.layout.main_spec_list);
        adView = RefHlp.getAdView(this);
        //adView.setAdSize(AdSize.BANNER);

       // adView.setAdUnitId(RefHlp.AD_UNIT_ID);


      /*  Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                specs = RefHlp.getMainSpecs();

                 mainSpecsStrings = new String[specs.length];

                for (int i = 0; i < specs.length;i++){
                    mainSpecsStrings[i] = specs[i].getName();
                }
                 adapter = new ArrayAdapter<String>(MainSpecListActivity.this,
                        android.R.layout.simple_list_item_2, android.R.id.text1, mainSpecsStrings);



            }
        });*/

        specs = RefHlp.getMainSpecs();

        String[] mainSpecsStrings = new String[specs.length];

        for (int i = 0; i < specs.length;i++){
            mainSpecsStrings[i] = specs[i].getName();
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainSpecListActivity.this,
                android.R.layout.simple_list_item_2, android.R.id.text1, mainSpecsStrings);


       // thread.start();
       // thread.run();

        this.getListView().addHeaderView(adView);
        adView.loadAd(RefHlp.AD_REQUEST);

        this.setListAdapter(adapter);





        //RefHlp.setListViewHeightBasedOnChildren(listView);
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

        setListAdapter(null);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search, menu);


        return true;
    }

    private void onClickSearch(){
        Intent i = new Intent(this,SpecListNonOrganizedActivity.class);
        startActivity(i);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.searchMenuItem:
                onClickSearch();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }

    @Override
    public void onListItemClick(ListView listView,View view , final int position,long id ){
        Intent i = new Intent(getBaseContext(),SpecListOrganizedActivity.class);

       final ArrayList<Spec> specsList = new ArrayList<Spec>();
        MainSpec selectedSpec = specs[position-1];



        for (int j = 0 ; j < selectedSpec.getSpecs().length;j++){

            specsList.add(selectedSpec.getSpecs()[j]);
        }
       /* Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                MainSpec selectedSpec = specs[position];



                for (int j = 0 ; j < selectedSpec.getSpecs().length;j++){

                    specsList.add(selectedSpec.getSpecs()[j]);
                }
            }
        });thread.start();*/


        Bundle bundle = new Bundle();

        bundle.putSerializable("specs", specsList);
        i.putExtras(bundle);

        startActivity(i);
       // overridePendingTransition(R.anim.animation_leave, R.anim.animation_enter);
    }


}
