package com.futureworks.hototwenty;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class ShowList extends Activity {

	ListView listView;
	String arr[] = new String[] { "The Show", "Hot Politics",
			"Good, Bad And Sexy", "Next Generation", "Aries En Zn Tickets",
			"020 Avenue", "Hard Voor Weinig", "Trill", "Savage", "Miracles" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.showlist);
		listView = (ListView) findViewById(R.id.listview);
		listView.setAdapter(new CustomAdapter());
		((Button) findViewById(R.id.button1))
				.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						finish();
					}
				});
	}

	public class CustomAdapter extends BaseAdapter {

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return arr.length;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(final int position, View convertView,
				ViewGroup parent) {
			// TODO Auto-generated method stub
			LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);

			View rowview = inflater.inflate(R.layout.listview_items, null);
			TextView textView = (TextView) rowview.findViewById(R.id.textView1);
			textView.setText(arr[position]);
			rowview.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent it = new Intent(ShowList.this, ShowDetails.class);
					it.putExtra("url_1", position + "");
					Log.e("TAG_POSITION CLICKED", position + "");
					startActivity(it);
				}
			});
			return rowview;
		}

	}
}