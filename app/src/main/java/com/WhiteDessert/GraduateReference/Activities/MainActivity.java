package com.WhiteDessert.GraduateReference.Activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.WhiteDessert.GraduateReference.DataBase.ReferenceDB;
import com.WhiteDessert.GraduateReference.Dialogs.AboutAppDialog;
import com.WhiteDessert.GraduateReference.Dialogs.AboutUsDialog;
import com.WhiteDessert.GraduateReference.Dialogs.ExplainDialog;
import com.WhiteDessert.GraduateReference.Dialogs.RatingDialog;
import com.WhiteDessert.GraduateReference.Dialogs.ReferenceDialog;
import com.WhiteDessert.GraduateReference.Help.MuslimScientist;
import com.WhiteDessert.GraduateReference.Help.RefHlp;
import com.google.android.gms.ads.AdView;
import com.whitedessert.graduatereference.R;

import java.util.Random;


public class MainActivity extends android.support.v4.app.FragmentActivity {

    ReferenceDB db;

    int count = 0;

    /** The view to show the ad. */
    private AdView adView;


    @SuppressWarnings("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);


       final Button searchBtn = (Button) this.findViewById(R.id.searchBtn);
       final Button univListBtn = (Button) this.findViewById(R.id.univListBtn);
      final ImageView  scienImg = (ImageView)this.findViewById(R.id.scienImg);
       final TextView  scienName = (TextView)this.findViewById(R.id.scienName);
       final TextView  scienDesc = (TextView)this.findViewById(R.id.scienDesc);
       final LinearLayout adLayout = (LinearLayout) this.findViewById(R.id.adLayout);
       final LinearLayout scientistLayout = (LinearLayout)this.findViewById(R.id.scienLayout);


        db = new ReferenceDB(this);

        if(!db.dbHelper.checkDataBase()){
           final ExplainDialog dialog = new ExplainDialog();

            dialog.show(getSupportFragmentManager(),"ExplainDialog");
        }


                db.open();
                db.close();

                final MuslimScientist scientist = RefHlp.getScientists()[new Random().nextInt(RefHlp.getScientists().length )];



        scienImg.setImageResource(scientist.getImage());
        scienName.setText(scientist.getName());
        scienDesc.setText(scientist.getDesc());

        scientistLayout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse(scientist.getWikiUrl());
Intent i = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(i);
            }
        });



        searchBtn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent i = new Intent(getBaseContext(), MainSpecListActivity.class);
                startActivity(i);
            }

        });

        univListBtn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), UnivListActivity.class);
                startActivity(i);

            }

        });

        // Create an ad.
        adView = RefHlp.getAdView(this);


        adLayout.addView(adView);

        adView.loadAd(RefHlp.AD_REQUEST);



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
    }


    @Override
    public void finish(){

        count++;
        if (count <= 1){
        RatingDialog dialog = new RatingDialog();

        dialog.show(getSupportFragmentManager(),"RatingDialog");

        }


        else super.finish();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        inflater.inflate(R.menu.share,menu);
        menu.getItem(3).setTitle("مشاركة التطبيق");
        return true;
    }

    // when the user click the about icon

    private void onClickAboutUs() {

        AboutUsDialog dialog = new AboutUsDialog();

        dialog.show(getSupportFragmentManager(),"AboutUsDialog");
    }

    // when the user click the share icon
    private void onClickShare(){
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
       String share = "إنظر الى تطبيق مرجع المتخرج " + "\n" + "https://play.google.com/store/apps/details?id=com.whitedessert.graduatereference";
        sendIntent.putExtra(Intent.EXTRA_TEXT,share);
        sendIntent.setType("text/plain");
                startActivity(sendIntent);
    }

    // when the user click the Reference button

    private void onClickReference(){
        ReferenceDialog dialog = new ReferenceDialog();

        dialog.show(getSupportFragmentManager(),"ReferenceDialog");
    }

    private void onClickAppAbout(){
        AboutAppDialog dialog = new AboutAppDialog();

        dialog.show(getSupportFragmentManager(),"AboutAppDialog");
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
           switch(item.getItemId()){
               case R.id.about_us_menu: onClickAboutUs();
                   return true;
               case R.id.shareMenu:onClickShare();return true;

               case R.id.reference_menu:onClickReference();return true;

               case R.id.app_about_meun:onClickAppAbout();return true;
               default:return super.onOptionsItemSelected(item);
           }

    }

    private void openDataBaseAndInsert(){
                db = new ReferenceDB(MainActivity.this);
        boolean isFirst = db.isFirst;
                db.open();

                db.close();


    }


}