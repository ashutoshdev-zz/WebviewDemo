package com.futureworks.hototwenty;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ProgressBar;

public class Agenda extends Activity{

	WebView web;
	private ProgressBar progress;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.news);

		((Button) findViewById(R.id.button1))
				.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						finish();
					}
				});
		progress = (ProgressBar) findViewById(R.id.progressBar1);
		progress.setVisibility(View.GONE);
		web = (WebView) findViewById(R.id.webview01);
		WebSettings webSettings = web.getSettings();
		final Activity activity = this;
		web.setWebChromeClient(new WebChromeClient() {
			public void onProgressChanged(WebView view, int progress) {

				activity.setProgress(progress * 1000);
			}
		});

		web.setWebViewClient(new myWebClient());
		web.getSettings().setJavaScriptEnabled(true);
		
		web.loadUrl("http://my.dudamobile.com/site/hototwentyradio/agenda?url=http%3A%2F%2Fwww.hototwenty.nl%2Fradio%2Fevents-2&preview=true&nee=true&showOriginal=true&dm_checkSync=1&dm_try_mode=true&dm_device=mobile");

		webSettings.setLoadWithOverviewMode(true);

	}

	public class myWebClient extends WebViewClient {
		public void onPageStarted(WebView view, String url, Bitmap favicon) {
			// TODO Auto-generated method stub

			progress.setVisibility(View.VISIBLE);
			Agenda.this.progress.setProgress(0);
			super.onPageStarted(view, url, favicon);
		}

		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			// TODO Auto-generated method stub

			view.loadUrl(url);
			return true;

		}

		public void onPageFinished(WebView view, String url) {
			progress.setVisibility(View.GONE);
			progress.setProgress(100);
			super.onPageFinished(view, url);
		}
	}

	// To handle "Back" key press event for WebView to go back to previous
	// screen.
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if ((keyCode == KeyEvent.KEYCODE_BACK) && web.canGoBack()) {
			web.goBack();
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

	public void setValue(int progress) {
		this.progress.setProgress(progress);
	}

}
