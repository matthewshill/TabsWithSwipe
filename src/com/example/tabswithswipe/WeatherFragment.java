package com.example.tabswithswipe;

import com.example.tabswithswipe.R;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;


public class WeatherFragment extends Fragment {
	
	//var
	private Spinner cities;
	private TextView weatherText;
	private Button b;
	private Gson gson = new Gson();
	

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState){
		
		View rootView = inflater.inflate(R.layout.fragment_weather, container, false);
		
		return rootView;
	}

	public void onViewCreated(View view, Bundle savedInstanceState){
		super.onViewCreated(view, savedInstanceState);
		//set var
		cities = (Spinner) view.findViewById(R.id.spinner1);
		weatherText = (TextView) view.findViewById(R.id.textView1);
		b = (Button)view.findViewById(R.id.btnSubmit);
		b.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				//executes WeatherAsync Task
				new WeatherAsync().execute();
				
			}
		});
	}
	
	class WeatherAsync extends AsyncTask<Void, Void, String>{
		//stores default API URL for Restful API call
		static final String API_URL = "http://api.openweathermap.org/data/2.5/weather?q=";
		
		protected String get(HttpEntity entity) throws IllegalStateException, IOException {
			//Create new InputStream object
			InputStream in = entity.getContent();
			StringBuffer out = new StringBuffer();
			
			int n = 1;
			while(n>0) {
				byte[] b = new byte[4096];
				n = in.read(b);
				
				if(n>0) {
					out.append(new String(b, 0, n));
				}//if
				
			}//while

			return out.toString();
		}//get

		@Override
		protected String doInBackground(Void... params) {
			HttpClient httpClient = new DefaultHttpClient();
			HttpContext localContext = new BasicHttpContext();
			String url = API_URL + cities.getSelectedItem().toString();
			HttpGet httpGet = new HttpGet(url);
			String text = null;
			try{
				HttpResponse response = httpClient.execute(httpGet, localContext);
				HttpEntity entity = response.getEntity();
				text = get(entity);
			}catch(Exception e) {
				return e.getLocalizedMessage();
			}
			return text;
		}//doInBackground
		
		@Override
		protected void onPostExecute(String results){
			super.onPostExecute(results);
			WeatherResults info = gson.fromJson(results, WeatherResults.class);
			
			
			if(info != null){
				//Weather Info which will print to screen
				String s ="\nDescription: " + info.weather.get(0).description;
				s += "\nCurrent Temp: " + toFar(info.main.temp);
				s += " F\n (High: " + toFar(info.main.temp_max) + " F , Low: " + toFar(info.main.temp_min) + " F)";
				s += "\nLongitude: " + info.coord.lon;
				s += "\nLatitude: " + info.coord.lat;
				weatherText.setText(s);
			}//if
		}//onPostExecute
		
		//Convert temp from Kelvin, and format to two decimal places
		public String toFar(double x){
			double y = ((((x-273.15)/9)*5)+32.0);
			DecimalFormat df = new DecimalFormat("#.##");
			return df.format(y);
		}//toFar
	}//WeatherAsync
	
}//WeatherFragment

