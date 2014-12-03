package com.example.tabswithswipe.adapter;

import com.example.tabswithswipe.GeoQuizFragment;
import com.example.tabswithswipe.ConverterFragment;
import com.example.tabswithswipe.WeatherFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


public class TabsPagerAdapter extends FragmentPagerAdapter{
	
	public TabsPagerAdapter(FragmentManager fm) {
		super(fm);
	}
	
	@Override
	public Fragment getItem(int index) {
		
		switch(index) {
		case 0:
			//GeoQuiz fragment activity
			return new GeoQuizFragment();
		case 1:
			//GeoQuiz fragment activity
			return new ConverterFragment();
		case 2:
			//GeoQuiz fragment activity
			return new WeatherFragment();
		}
		
		return null;
		
	}
	
	@Override
	public int getCount() {
		//number of tabs
		return 3;
	}
}
