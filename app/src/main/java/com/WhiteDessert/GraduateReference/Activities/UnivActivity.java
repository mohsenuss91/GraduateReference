package com.WhiteDessert.GraduateReference.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.WhiteDessert.GraduateReference.Help.RefHlp;
import com.WhiteDessert.GraduateReference.Help.University;
import com.google.android.gms.ads.AdView;
import com.whitedessert.graduatereference.R;

/**
 * Created by yazeed44 on 31/05/14.
 */
public class UnivActivity extends Activity {

    ImageView univImg;
    TextView univName,univRegion,univRank,univMainUrl;

    AdView adView;
    public void onCreate(Bundle savedInstanceState){
super.onCreate(savedInstanceState);
        this.setContentView(R.layout.univ_activity);

        adView = RefHlp.getAdView(this);
         univImg = (ImageView)this.findViewById(R.id.univImg);
         univName = (TextView)this.findViewById(R.id.univName);
         univRegion = (TextView)this.findViewById(R.id.univRegion);
         univRank = (TextView)this.findViewById(R.id.univRank);
         univMainUrl = (TextView)this.findViewById(R.id.univMainUrl);

Intent i = this.getIntent();

        Bundle bundle = i.getExtras();

        University univ =(University) i.getSerializableExtra("univ");

        assert univ != null;
        univImg.setImageResource(this.getResources().getIdentifier(univ.getImage(),"drawable",getPackageName()));

        univName.setText(univ.getName());

        univRegion.setText("المنطقة : "+univ.getRegions());

        String rank;

        if (univ.getRank() == 99999)
            rank = "لايوجد";

                    else rank = univ.getRank() + "";

        univRank.setText("التقييم العالمي : "+rank);


        univMainUrl.setText("الموقع الرسمي : " + univ.getMainUrl());

        LinearLayout adLayout = (LinearLayout)this.findViewById(R.id.univAdLayout);

        adLayout.addView(adView);

        adView.loadAd(RefHlp.AD_REQUEST);
    }

    @SuppressWarnings("NewApi")
    @Override
    public boolean onCreateOptionsMenu(Menu menu){

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.share,menu);
        menu.getItem(0).setTitle("مشاركة الجامعة");
        return true;
    }

    // when the user click the share icon
    private void onClickShare(){
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
       String share = univName.getText() + "\n\n"+  univRegion.getText() +"\n\n"+ univRank.getText() +
               "\n\n" +univMainUrl.getText() + "\n\n"+ "تمت المشاركة بواسطة تطبيق مرجع المتخرج"+ "\n" + "https://play.google.com/store/apps/details?id=com.whitedessert.graduatereference";
        sendIntent.putExtra(Intent.EXTRA_TEXT,share);
        sendIntent.setType("text/plain");
        startActivity(sendIntent);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem menu){

        switch(menu.getItemId()){

            case R.id.shareMenu:onClickShare();

            default:return true;
        }


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
}
