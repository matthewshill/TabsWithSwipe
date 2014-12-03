package com.example.tabswithswipe;

import com.example.tabswithswipe.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class ConverterFragment extends Fragment{
	
	//var
	private EditText Text;
	private RadioButton mileButton;
	private RadioButton kmhButton;
	private Button convert;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedINstanceState){
		
		View rootView = inflater.inflate(R.layout.fragment_converter, container, false);
		
		return rootView;
	}
	
	public void onViewCreated(View view, Bundle savedInstanceState){
		//set var
		Text = (EditText) view.findViewById(R.id.editText1);   
	    mileButton = (RadioButton) view.findViewById(R.id.radio0);  
	    kmhButton = (RadioButton) view.findViewById(R.id.radio1); 
	    convert = (Button) view.findViewById(R.id.button1);
	    convert.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				if (Text.getText().length() == 0) {   
		            Toast.makeText(getActivity(), "Please, enter a valid number", Toast.LENGTH_LONG)  
		                    .show();  
		        } else {   
		            double inputValue = Double.parseDouble(Text.getText().toString());    
		            if (mileButton.isChecked()) {  
		                Text.setText(String.valueOf(convertToMiles(inputValue)));  
		                // uncheck "to miles" Button  
		                mileButton.setChecked(false);  
		                // check "to km/h" Button  
		                kmhButton.setChecked(true);  
		            } else { /* if kmhButton isChecked() */  
		                Text.setText(String.valueOf(convertToKmh(inputValue)));  
		                // uncheck "to km/h" Button  
		                kmhButton.setChecked(false);  
		                // check "to miles" Button  
		                mileButton.setChecked(true);  
		            }  
		        }  
				
			}
		});
	}
	
    // default function  
    @Override
	public void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);   
    }  
    
  
    private double convertToMiles(double inputValue) {  
        return (inputValue * 1.609344);  
    }  
  
    private double convertToKmh(double inputValue) {  
        return (inputValue * 0.621372);  
    } 
}