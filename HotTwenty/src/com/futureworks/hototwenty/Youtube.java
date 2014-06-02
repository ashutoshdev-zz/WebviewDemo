package com.futureworks.hototwenty;

import com.futureworks.hototwenty.R;

import android.app.Activity;
import android.content.Intent;
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

public class Youtube extends Activity {

	WebView mWebView = null;
	private ProgressBar progress;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.news);

		((Button)findViewById(R.id.button1)).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		progress = (ProgressBar) findViewById(R.id.progressBar1);
		progress.setVisibility(View.GONE);
		mWebView = (WebView) findViewById(R.id.webview01);
		mWebView.getSettings().setJavaScriptEnabled(true);

		final Activity activity = this;
		mWebView.setWebChromeClient(new WebChromeClient() {
			public void onProgressChanged(WebView view, int progress) {

				activity.setProgress(progress * 1000);
			}
		});

		mWebView.setWebViewClient(new MyOwnWebViewClient());

		mWebView.loadUrl("http://www.youtube.com/user/HOTOTWENTY");
		mWebView.setWebViewClient(new MyOwnWebViewClient());
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if ((keyCode == KeyEvent.KEYCODE_BACK) && mWebView.canGoBack()) {
			mWebView.goBack();
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

	public class MyOwnWebViewClient extends WebViewClient {
		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			view.loadUrl(url);
			return true;
		}

		public void onPageStarted(WebView view, String url, Bitmap favicon) {
			// TODO Auto-generated method stub

			progress.setVisibility(View.VISIBLE);
			progress.setProgress(0);
			super.onPageStarted(view, url, favicon);
		}

		public void onPageFinished(WebView view, String url) {
			progress.setVisibility(View.GONE);
			progress.setProgress(100);
			super.onPageFinished(view, url);
		}
	}
	
	
	public void setValue(int progress) {
		this.progress.setProgress(progress);
	}
}