package com.WhiteDessert.GraduateReference.Activities;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.WhiteDessert.GraduateReference.Dialogs.UnivChoiceDialog;
import com.WhiteDessert.GraduateReference.Help.RefHlp;
import com.WhiteDessert.GraduateReference.Help.Spec;
import com.google.android.gms.ads.AdView;
import com.whitedessert.graduatereference.R;

import java.util.ArrayList;

/**
 * Created by yazeed on 17/04/14.
 */
public class SpecActivity extends android.support.v4.app.FragmentActivity {


    Spec spec;
    //ListView listView;
    TextView specName;
    TextView specDesc;
    TextView specSubSpecs;
    TextView specWhereToStudy;
    String specNameString,specDescString,specSubSpecsString,specWhereToStudyString;


    AdView adView;

    @Override
    public void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);

        this.setContentView(R.layout.spec_activity);
adView = RefHlp.getAdView(this);
        Intent i = this.getIntent();

        Bundle bundle = i.getExtras();

        assert bundle != null;
        spec = (Spec)bundle.getSerializable("spec");

         specName = (TextView)this.findViewById(R.id.specNameText);
         specDesc = (TextView)this.findViewById(R.id.specDescText);
         specSubSpecs = (TextView)this.findViewById(R.id.subSpecsText);
         specWhereToStudy = (TextView)this.findViewById(R.id.specWhereToStudyText);
         LinearLayout adLayout = (LinearLayout)this.findViewById(R.id.specAdLayout);


         specNameString = spec.getName()  ;
         specDescString = spec.getDesc() ;
         specSubSpecsString = spec.getSubSpecsString()  ;
         specWhereToStudyString = spec.getWhereToStudy();

        if(specDescString == null||specDescString.equals("")){specDescString = "لاتوجد أية معلومات";}
        if (specSubSpecsString == null||specSubSpecsString.equals("")){specSubSpecsString = "لاتوجد أية معلومات";}
        if(specWhereToStudyString == null||specWhereToStudyString.equals("")){specWhereToStudyString = "لاتوجد أية معلومات";}


        specName.setText(spec.getName());
        specDesc.setText( "نبذة عن التخصص : "  + "\n"+specDescString);
        specSubSpecs.setText( "التخصصات الفرعية : "+ "\n"+specSubSpecsString);
        specWhereToStudy.setText( "أين يمكنك دراسة هذا التخصص : "  + "\n"+specWhereToStudyString);
        initWhereToStudy();

        adLayout.addView(adView);

        adView.loadAd(RefHlp.AD_REQUEST);

    }

    @SuppressWarnings("NewApi")
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.share,menu);

        menu.getItem(0).setTitle("مشاركة التخصص");
        return true;
    }
    // when the user click the share icon
    private void onClickShare(){
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        String share = specName.getText().toString() + "\n\n" + "نبذة عن التخصص : "+"\n" +specDescString + "\n\n" + "التخصصات الفرعية : "  + "\n\n"+specSubSpecsString + "\n\n"
                + "أين يمكنك دراسة هذا التخصص : "+ "\n\n"
                + specWhereToStudyString + "\n\n"+"تمت المشاركة بواسطة تطبيق مرجع المتخرج"+ "\n" + "https://play.google.com/store/apps/details?id=com.whitedessert.graduatereference";
        sendIntent.putExtra(Intent.EXTRA_TEXT,share);
        sendIntent.setType("text/plain");
        startActivity(sendIntent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.shareMenu:
                onClickShare();
                return true;


            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private ArrayList<String> getUnivsFromText(){

        ArrayList<String> selectedUnivsNames = new ArrayList<String>();
        ArrayList<String> univNames = RefHlp.getUnivsNames(this);

        String whereToStudy4Compare = specWhereToStudy.getText().toString();


       if (!whereToStudy4Compare.equals("لاتوجد أية معلومات")){
           int i = 0;
           for(String name : univNames){

               if (whereToStudy4Compare.contains(univNames.get(i))){

                   selectedUnivsNames.add(univNames.get(i));
               }
               i++;
           }


       }

        return selectedUnivsNames;
    }


    //set up the listener
    private void initWhereToStudy(){
       final ArrayList<String> univsFromText = getUnivsFromText();
        if (univsFromText.size() > 0){

            specWhereToStudy.setOnClickListener(new View.OnClickListener() {
                @SuppressWarnings("NewApi")
                @Override
                public void onClick(View view) {
                   UnivChoiceDialog dialog = new UnivChoiceDialog();
                    dialog.univNames = univsFromText;
                    dialog.show(getSupportFragmentManager(),"UnivChoiceDialog");
                }
            });
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
