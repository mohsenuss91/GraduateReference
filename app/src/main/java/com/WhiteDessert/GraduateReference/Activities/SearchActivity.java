package com.WhiteDessert.GraduateReference.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.whitedessert.graduatereference.R;


public class SearchActivity extends Activity {

	
	private Spinner thssSpinner;
	private Spinner locationSpinner;
	private Spinner sexSpinner;
	private Spinner thssThanoeSpinner;
private EditText trakmeEdit;

 String numberString;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        // /EditText qdratEdit;
        // //EditText thseleEdit;
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.search);
                trakmeEdit = (EditText)this.findViewById(R.id.searchUnivList);
      //  qdratEdit = (EditText)this.findViewById(R.id.qdratEdit);
       // thseleEdit = (EditText)this.findViewById(R.id.thseleeEdit);
        
        trakmeEdit.setOnFocusChangeListener(new OnFocusChangeListener(){

			@Override
			public void onFocusChange(View arg0, boolean arg1) {
                //noinspection ConstantConditions
                numberString = trakmeEdit.getText().toString();
				
				if (!trakmeEdit.isFocused()&&!numberString.contains(".")){
	 	        	Toast.makeText(getBaseContext(), "يستحسن استعمال النقطة العشرية في النسبة التراكمية", Toast.LENGTH_LONG).show();
	 	        }
				
			}
        	
        });
        
        trakmeEdit.addTextChangedListener(new TextWatcher(){

        	
        	
			@Override
			public void afterTextChanged(Editable arg0) {
				
	       
				
			}

			 public void beforeTextChanged(CharSequence s, int start, int count, int after){
				 
				 
			 }
		        public void onTextChanged(CharSequence s, int start, int before, int count){
		        	
		        	
		        	 
		        		/*if (!numberString.contains(".")){
		        			Toast.makeText(getBaseContext(), "لاتحتوي نقطة", Toast.LENGTH_SHORT).show();
		        		}*/
		        	
		        				        		
		        	
		        }
        	
        });
        
        
         thssSpinner = (Spinner)this.findViewById(R.id.thssSpinner);
        
         locationSpinner = (Spinner)this.findViewById(R.id.locationSpinner);
       
         sexSpinner = (Spinner)this.findViewById(R.id.sexSpinner);
        
         thssThanoeSpinner = (Spinner)this.findViewById(R.id.thssThanoeSpinner);
         
        attachAdaptersToSpinners();

        
        
	}
	
	private void attachAdaptersToSpinners(){
		ArrayAdapter<CharSequence> thssAdapter = ArrayAdapter.createFromResource(this, R.array.thssat, android.R.layout.simple_spinner_item);
		thssAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		thssSpinner.setAdapter(thssAdapter);
		
		
		ArrayAdapter<CharSequence> locationadapter = ArrayAdapter.createFromResource(this,
                R.array.locations_array, android.R.layout.simple_spinner_item);
        locationadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); 
        locationSpinner.setAdapter(locationadapter);
        
        ArrayAdapter<CharSequence> sexAdapter = ArrayAdapter.createFromResource(this, R.array.sex, android.R.layout.simple_spinner_item);
        sexAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sexSpinner.setAdapter(sexAdapter);
        
        
        ArrayAdapter<CharSequence> thssThanoeAdapter = ArrayAdapter.createFromResource(this, R.array.thssThanoe, android.R.layout.simple_spinner_item);
        thssThanoeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        thssThanoeSpinner.setAdapter(thssThanoeAdapter);
	}
}
