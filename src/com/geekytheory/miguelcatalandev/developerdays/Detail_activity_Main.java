package com.geekytheory.miguelcatalandev.developerdays;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockActivity;

public class Detail_activity_Main extends SherlockActivity implements
		OnClickListener {
	
	Bundle extras;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detail_activity_detail);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		initialize();
	}

	private void initialize() {
		extras = getIntent().getExtras();
		if (extras != null) {

			setTitle(extras.getString("title"));

			TextView name = (TextView) findViewById(R.id.detail_textview_name);
			name.setText(extras.getString("name"));

			TextView buis = (TextView) findViewById(R.id.detail_textview_buis);
			buis.setText(extras.getString("buis"));

			TextView url = (TextView) findViewById(R.id.detail_textview_url);
			url.setText(extras.getString("url"));
			url.setOnClickListener(this);

			TextView des = (TextView) findViewById(R.id.detail_textview_des);
			des.setText(extras.getString("des"));

			TextView time = (TextView) findViewById(R.id.detail_textview_time);
			time.setText("Horario: " + extras.getString("time"));

			TextView loc = (TextView) findViewById(R.id.detail_textview_location);
			loc.setText("Localizaci—n: " + extras.getString("loc"));

			ImageView profile = (ImageView) findViewById(R.id.detail_imageview_profile);
			profile.setImageResource(extras.getInt("image",
					R.drawable.no_photo_circle));

		}

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case android.R.id.home:
			onBackPressed();
			break;
		case R.id.detail_textview_url:
			Intent intent = new Intent(Intent.ACTION_VIEW);
			intent.setData(Uri.parse(extras.getString("url")));
			startActivity(intent);
			break;
		case R.id.detail_imageview_location:
			break;
		}

	}

}
