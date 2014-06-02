package com.futureworks.hototwenty;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.RelativeLayout;

public class SocialMedia extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.socialmedia);

		((Button) findViewById(R.id.button1))
				.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						finish();
					}
				});
		((RelativeLayout) findViewById(R.id.relativeLayout1))
				.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub

						Intent in = new Intent(SocialMedia.this, Facebook.class);
						startActivity(in);
					}
				});

		((RelativeLayout) findViewById(R.id.relativeLayout2))
				.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent in = new Intent(SocialMedia.this, Twitter.class);
						startActivity(in);
					}
				});

		((RelativeLayout) findViewById(R.id.relativeLayout3))
				.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent in = new Intent(SocialMedia.this,
								Instagram.class);
						startActivity(in);
					}
				});

		((RelativeLayout) findViewById(R.id.relativeLayout4))
				.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent in = new Intent(SocialMedia.this, Youtube.class);
						startActivity(in);
					}
				});

	}
}
