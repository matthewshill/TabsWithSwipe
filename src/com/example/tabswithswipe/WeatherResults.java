package com.example.tabswithswipe;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class WeatherResults{

	//to store info
	public ArrayList<Weather> weather;
	
	//create instance of each class
	public Coord coord;
	public Sys sys;
	public Main main;
	public Wind wind;
	
	public class Coord{
		public double lon;
		public double lat;
	}
	
	public class Sys{
		public double message;
		public String country;
		public long sunrise;
		public long sunset;
	}
	
	public class Weather{
		public int id;
		public String main;
		public String description;
		public String icon;
	}
	
	public class Main{
		public double temp;
		public double temp_min;
		public double temp_max;
		public double pressure;
		public double sea_level;
		public double grnd_level;
		public int humidity;
	}
	
	public class Wind{
		public double speed;
		public double deg;
	}
	

	public class WeatherInfo{
		
		//same format as JSON string
		@SerializedName("description")
		public String description;
		
		@SerializedName("temp")
		public String temp;
		
		@SerializedName("temp_max")
		public double tempMax;
		
		@SerializedName("temp_min")
		public double tempMin;
		
		@SerializedName("humidity")
		public double humidity;
		
		@SerializedName("speed")
		public double windSpeed;
		
	}//weatherInfo
	
}