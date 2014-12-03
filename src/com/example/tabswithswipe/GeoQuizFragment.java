package com.example.tabswithswipe;

import com.example.tabswithswipe.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class GeoQuizFragment extends Fragment{
	//var
	private Button mTrueButton;
	private Button mFalseButton;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedINstanceState){
		
		View rootView = inflater.inflate(R.layout.fragment_geoquiz, container, false);
		setHasOptionsMenu(true);
		return rootView;
	}
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    
	public void onViewCreated(View view, Bundle savedInstanceState){
		//set var
		mTrueButton = (Button)view.findViewById(R.id.true_button);
        mFalseButton = (Button)view.findViewById(R.id.false_button);
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Toast.makeText(getActivity(), R.string.incorrect_toast, Toast.LENGTH_SHORT).show();
            }
        });

        mFalseButton.setOnClickListener(new View.OnClickListener() {
            
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), R.string.correct_toast, Toast.LENGTH_SHORT).show();
            }
        });
	}
	
}
