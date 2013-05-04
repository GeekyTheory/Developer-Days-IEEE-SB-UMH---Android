package com.geekytheory.miguelcatalandev.developerdays.maps;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NavUtils;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.MenuItem;
import com.geekytheory.miguelcatalandev.developerdays.Main_Activity_Main;
import com.geekytheory.miguelcatalandev.developerdays.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class Maps_fragmentActivity extends SherlockFragmentActivity implements
		OnInfoWindowClickListener {

	private GoogleMap map;

	Marker parking_altabix;

	static final LatLng PARKING_ALTABIX = new LatLng(0, 0);

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.map_fragment);

		prepareActionBar();

		map = ((SupportMapFragment) getSupportFragmentManager()
				.findFragmentById(R.id.map)).getMap();

		drawMarkers();

		map.setMapType(2);
		map.setOnInfoWindowClickListener(this);
		UiSettings uiSettings = map.getUiSettings();
		uiSettings.setCompassEnabled(false);

		// TODO: Tener encuenta el edifico metido como parametro y navegar hasta
		// el.

		map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(38.276988,
				-0.688751), 15));
		map.animateCamera(CameraUpdateFactory.zoomTo(15), 2000, null);

	}

	private void prepareActionBar() {

		getSupportActionBar().setHomeButtonEnabled(true);
	}

	private void drawMarkers() {

		parking_altabix = map.addMarker(new MarkerOptions().position(
				PARKING_ALTABIX).title("Alcudia"));

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			NavUtils.navigateUpTo(this, new Intent(this,
					Main_Activity_Main.class));
			break;
		}
		return true;
	}

	@Override
	public void onInfoWindowClick(Marker marker) {
		startActivity(new Intent(Intent.ACTION_VIEW,
				Uri.parse("google.navigation:q="
						+ marker.getPosition().latitude + ","
						+ marker.getPosition().longitude)));
	}

}