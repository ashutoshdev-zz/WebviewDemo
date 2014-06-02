package com.futureworks.hototwenty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpResponse;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ShowDetails extends Activity {
	ImageView imageView, imageview_small;

	TextView text_desc, text_title, txt_image, txt_cmnt, pubdate, date, cmt;
	String url_1, url, imageurl;
	ArrayList<HashMap<String, String>> al = new ArrayList<HashMap<String, String>>();
	XMLParser parser;
	Bundle bundle;

	RelativeLayout rel1, rel2, rel3;

	@Override
	protected void onCreate(Bundle bundle) {
		// TODO Auto-generated method stub
		super.onCreate(bundle);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.showdetails);
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
				.permitAll().build();
		StrictMode.setThreadPolicy(policy);

		((Button) findViewById(R.id.button1))
				.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						finish();
					}
				});
		bundle = getIntent().getExtras();
		url_1 = bundle.getString("url_1");
		findId();

		detail();

	}

	private void findId() {
		// TODO Auto-generated method stub
		imageView = (ImageView) findViewById(R.id.imageView_detail);
		imageview_small = (ImageView) findViewById(R.id.imageView2);
		text_desc = (TextView) findViewById(R.id.text_desc);
		text_title = (TextView) findViewById(R.id.text_title);
		txt_image = (TextView) findViewById(R.id.txt_image);
		txt_cmnt = (TextView) findViewById(R.id.txt_cmnt);
		pubdate = (TextView) findViewById(R.id.pubdate);

		cmt = (TextView) findViewById(R.id.coment);
		date = (TextView) findViewById(R.id.date);

		rel1 = (RelativeLayout) findViewById(R.id.rel1);
		rel2 = (RelativeLayout) findViewById(R.id.relative);
		rel3 = (RelativeLayout) findViewById(R.id.tyu);
	}

	public static String getMatch(String patternString, String text,
			int groupIndex) {
		Pattern pattern = Pattern.compile(patternString,
				Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
		return getMatch(pattern, text, groupIndex);
	}

	public static String getMatch(Pattern pattern, String text, int groupIndex) {
		if (text != null) {
			Matcher matcher = pattern.matcher(text);
			String match = null;
			while (matcher.find()) {
				match = matcher.group(groupIndex);
				break;
			}
			return match;
		} else {
			return null;
		}
	}

	protected void detail() {

		// TODO Auto-generated method stub

		AsyncTask<Void, Void, Void> updateTask = new AsyncTask<Void, Void, Void>() {
			ProgressDialog dialog = new ProgressDialog(ShowDetails.this);
			String s = null;
			HttpResponse response = null;

			@Override
			protected void onPreExecute() {
				// what to do before background task
				dialog.setMessage("Validating... ");
				dialog.setIndeterminate(true);
				dialog.show();
			}

			@Override
			protected Void doInBackground(Void... params) {

				parser = new XMLParser();

				if (url_1.equals("0")) {
					url = "http://www.hototwenty.nl/radio/category/020avenue/feed/";
				} else if (url_1.equals("1")) {
					url = "http://www.hototwenty.nl/radio/hot-politics/feed/";
				} else if (url_1.equals("2")) {
					url = "http://www.hototwenty.nl/radio/good-bad-and-sexy/feed/";
				} else if (url_1.equals("3")) {
					url = "http://www.hototwenty.nl/radio/category/hot-o-twenty-radio/next-generation/feed/";
				} else if (url_1.equals("4")) {
					url = "http://www.hototwenty.nl/radio/category/aries-en-zn-tickets/feed/";
				} else if (url_1.equals("5")) {
					url = "http://www.hototwenty.nl/radio/category/020avenue/feed/";
				} else if (url_1.equals("6")) {
					url = "http://www.hototwenty.nl/radio/hard-voor-weinig/feed/";
				} else if (url_1.equals("7")) {
					url = "http://www.hototwenty.nl/radio/category/trill/feed/";
				} else if (url_1.equals("8")) {
					url = "http://www.hototwenty.nl/radio/savage/feed/";
				} else if (url_1.equals("9")) {
					url = "http://www.hototwenty.nl/radio/miracles/feed/";
				}

				rel2.setVisibility(View.GONE);
				rel1.setVisibility(View.GONE);
				rel3.setVisibility(View.VISIBLE);
				return null;
			}

			@SuppressWarnings("unused")
			@Override
			protected void onPostExecute(Void result) {
				// what to do when background task is completed

				// photoDetail();

				dialog.cancel();

				Display display = getWindowManager().getDefaultDisplay();
				String xml = parser.getXmlFromUrl(url);
				Document doc = parser.getDomElement(xml);
				NodeList nl = doc.getElementsByTagName("item");

				// looping through all item nodes <item>
				for (int i = 0; i < nl.getLength(); i++) {
					// creating new HashMap
					HashMap<String, String> map = new HashMap<String, String>();
					Element e = (Element) nl.item(0);
					String imageSource = parser.getValue(e, "content:encoded");
					String desc = parser.getValue(e, "description");
					String date1 = parser.getValue(e, "pubDate");
					String cmnt = parser.getValue(e, "slash:comments");
					String title = parser.getValue(e, "title");
					imageurl = getMatch(
							"<\\s*img\\s*[^>]+src\\s*=\\s*(['\"]?)(.*?)\\1",
							imageSource, 2);
					// Log.e("TAG VALUE", date + ",," + title + ">>>>" + cmnt);
					map.put("imageurl", imageurl);
					text_desc.setText(desc);
					text_title.setText(title);
					txt_image.setText(title);
					txt_cmnt.setText(cmnt);
					pubdate.setText(date1);
					cmt.setText(cmnt);
					date.setText(date1);

					int height = display.getHeight();
					ImageLoader imageLoader = new ImageLoader(ShowDetails.this);
					imageLoader.DisplayImage(imageurl, imageView);
					imageLoader.DisplayImage(imageurl, imageview_small);
					imageView.getLayoutParams().height = height / 4;
					Log.i("urlvvv", imageurl);
					rel2.setVisibility(View.VISIBLE);
					rel1.setVisibility(View.VISIBLE);
					rel3.setVisibility(View.GONE);
				}

			}

		};

		updateTask.execute((Void[]) null);

	}

}
