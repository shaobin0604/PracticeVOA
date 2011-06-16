package com.example.practicevoa;

import java.util.List;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;

import com.example.practicevoa.RssParser.Entry;

public class MainActivity extends Activity {
	
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        new ParseRssTask().execute("http://www.51voa.com/voa.xml");
    }
    
    private class ParseRssTask extends AsyncTask<String, Void, List<Entry>> {

		@Override
		protected List<Entry> doInBackground(String... params) {
			List<Entry> list = RssParser.parse(params[0]);
			
			
			for (Entry entry : list) {
				Logger.d(entry.toString());
			}
			
			return list;
		}
    	
		
    }
}