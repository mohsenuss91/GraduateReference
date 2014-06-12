package com.WhiteDessert.GraduateReference.Activities;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.WhiteDessert.GraduateReference.Adapters.UnivListViewAdapter;
import com.WhiteDessert.GraduateReference.DataBase.ReferenceDB;
import com.WhiteDessert.GraduateReference.Help.RefHlp;
import com.WhiteDessert.GraduateReference.Help.University;
import com.google.android.gms.ads.AdView;
import com.whitedessert.graduatereference.R;


public class UnivListActivity extends ListActivity {

   //  ListView listView;
    UnivListViewAdapter adapter;
    String univName;
    University univ;
    String url;
     ReferenceDB db;
    int clickMenuCount = 0;
    AdView adView;
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
      //  this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.setContentView(R.layout.univ_list);

        adView = RefHlp.getAdView(this);
        db = new ReferenceDB(UnivListActivity.this);
        db.open();
        adapter = new UnivListViewAdapter(UnivListActivity.this,db.getAllUnivs(),android.R.layout.simple_list_item_1);
        db.close();
      /*  Thread thread = new Thread(
          new Runnable() {
              @Override
              public void run() {
                  db = new ReferenceDB(UnivListActivity.this);
                  db.open();
                  adapter = new UnivListViewAdapter(UnivListActivity.this,db.getAllUnivs(),android.R.layout.simple_list_item_1);
                  db.close();
              }
          }
        );

thread.start();*/
        this.getListView().addHeaderView(adView);

        adView.loadAd(RefHlp.AD_REQUEST);
        this.setListAdapter(adapter);


}


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search, menu);

        return true;
    }

    @Override
    protected void onListItemClick(ListView listView,View view , int position,long id){
       int positionClone = position;
       positionClone++;
         univName = ((TextView)view.findViewById(R.id.univListName)).getText().toString();

        db.open();
        univ = db.getUniv(univName);


        db.close();

       /* Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                db.open();
                univ = db.getUniv(univName);


                db.close();
            }
        });
        thread.start();*/

        url = univ.getMainUrl();


        if (url != null&&!url.startsWith("http://") && !url.startsWith("https://"))
            url = "http://" + url;


        if (url == null || url.equals("")){
            univ.setMainUrl("لايوجد");
        }


            Intent i = new Intent(this, UnivActivity.class);
        i.putExtra("univ",univ);

            startActivity(i);




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

    @SuppressWarnings("NewApi")
    public void onClickMenu() {
clickMenuCount++;
   //     LinearLayout mCustomHeaders=new LinearLayout(this);
     //   mCustomHeaders.setOrientation(LinearLayout.VERTICAL);
       // mCustomHeaders.removeAllViews(); // will erase all headers
        if (clickMenuCount < 2){
       EditText view = new EditText(this);
        view.setHint("أكتب اسم الجامعة أو المنطقة");
            view.setMaxLines(1);

        view.requestFocus();

//mCustomHeaders.addView(view);
        initFilter(view);


        this.getListView().addHeaderView(view);}
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.searchMenuItem: onClickMenu();
                return true;

            default:return super.onOptionsItemSelected(item);
        }

    }

    public void initFilter(EditText editText){

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                 adapter.getFilter().filter(charSequence);

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}
