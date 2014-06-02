package com.futureworks.hototwenty;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.main);

		((ImageView) findViewById(R.id.imageView1))
				.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						 Intent in=new Intent(MainActivity.this,ShowList.class);
						 startActivity(in);
					}
				});

		((ImageView) findViewById(R.id.imageView2))
				.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						Intent in = new Intent(MainActivity.this, News.class);
						startActivity(in);
					}
				});

		((ImageView) findViewById(R.id.imageView3))
				.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						Intent in = new Intent(MainActivity.this,
								SocialMedia.class);
						startActivity(in);
					}
				});

		((ImageView) findViewById(R.id.imageView5))
				.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						 Intent in=new Intent(MainActivity.this,Agenda.class);
						 startActivity(in);
					}
				});

		((ImageView) findViewById(R.id.imageView6))
				.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						 Intent in=new Intent(MainActivity.this,LiveStream.class);
						 startActivity(in);
					}
				});

		((ImageView) findViewById(R.id.imageView7))
				.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						Intent in = new Intent(MainActivity.this,
								Prijsvraag.class);
						startActivity(in);
					}
				});

		((ImageView) findViewById(R.id.imageView8))
				.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						Intent in = new Intent(MainActivity.this, Video.class);
						startActivity(in);
					}
				});

		((ImageView) findViewById(R.id.imageView9))
				.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						Intent in = new Intent(MainActivity.this,
								SoundCloud.class);
						startActivity(in);
					}
				});

		((ImageView) findViewById(R.id.imageView10))
				.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						Intent in = new Intent(MainActivity.this, Contact.class);
						startActivity(in);
					}
				});
	}

}
