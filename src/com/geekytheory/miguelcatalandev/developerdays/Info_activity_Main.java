package com.geekytheory.miguelcatalandev.developerdays;

import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.MenuItem;
import com.google.analytics.tracking.android.EasyTracker;

public class Info_activity_Main extends SherlockActivity implements
		OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.info_activity);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		initialize();
	}

	@Override
	public void onStart() {
		super.onStart();
		EasyTracker.getInstance().activityStart(this);

	}

	@Override
	public void onStop() {
		super.onStop();
		EasyTracker.getInstance().activityStop(this);
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		if (item.getItemId() == android.R.id.home) {
			onBackPressed();
		}
		return super.onMenuItemSelected(featureId, item);
	}

	private void initialize() {
		TextView version = (TextView) findViewById(R.id.info_texview_version);
		TextView mail = (TextView) findViewById(R.id.info_textview_url);
		mail.setOnClickListener(this);
		ImageView geeky = (ImageView) findViewById(R.id.info_imageview_geeky);
		geeky.setOnClickListener(this);

		String versionName = null;
		try {
			versionName = getPackageManager().getPackageInfo(getPackageName(),
					0).versionName;
		} catch (NameNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (versionName != null) {
			version.setText("Version: " + versionName);
		}

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.info_textview_url:
			Intent emailIntent = new Intent(Intent.ACTION_SENDTO,
					Uri.fromParts("mailto", "miguel@geekytheory.com", null));
			startActivity(Intent.createChooser(emailIntent, "Send email..."));
			break;
		case R.id.info_imageview_geeky:
			Intent intent = new Intent(Intent.ACTION_VIEW);
			intent.setData(Uri.parse("http://geekytheory.com"));
			startActivity(intent);
			break;
		}

	}

}
