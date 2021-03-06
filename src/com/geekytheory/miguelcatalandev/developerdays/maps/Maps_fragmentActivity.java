/**
   Copyright GeekyTheory 2013 (@GeekyTheory)

   Licensed under the GPL General Public License, Version 3.0 (the "License"),  
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.gnu.org/licenses/gpl.html

   Unless required by applicable law or agreed to in writing, software 
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
   
   Website: http://geekytheory.com
   Author: Miguel Catalan Ba�uls <miguel@geekytheory.com>
*/

package com.geekytheory.miguelcatalandev.developerdays.maps;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NavUtils;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.MenuItem;
import com.geekytheory.miguelcatalandev.developerdays.Main_Activity_Main;
import com.geekytheory.miguelcatalandev.developerdays.R;
import com.google.analytics.tracking.android.EasyTracker;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class Maps_fragmentActivity extends SherlockFragmentActivity implements
		OnInfoWindowClickListener {

	private GoogleMap map;

	Marker parking_altabix, parking_galia, parking_rectorado, building_altabix,
			building_altet, building_quorumv, lunch_rectorado, lunch_altabix;

	static final LatLng PARKING_ALTABIX = new LatLng(38.277517, -0.692226);

	static final LatLng PARKING_GALIA = new LatLng(38.274156, -0.692408);

	static final LatLng PARKING_RECTORADO = new LatLng(38.275158, -0.684319);

	static final LatLng BUILDING_ALTABIX = new LatLng(38.276632, -0.690874);

	static final LatLng BUILDING_ALTET = new LatLng(38.27723, -0.687623);

	static final LatLng BUILDING_QUORUMV = new LatLng(38.275007, -0.686218);

	static final LatLng LUNCH_RECTORADO = new LatLng(38.274889, -0.684168);

	static final LatLng LUNCH_ALTABIX = new LatLng(38.276287, -0.691925);

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.map_fragment);

		prepareActionBar();

		map = ((SupportMapFragment) getSupportFragmentManager()
				.findFragmentById(R.id.map)).getMap();

		map.setMapType(2);
		map.setOnInfoWindowClickListener(this);

		map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(38.276988,
				-0.688751), 14));
		map.animateCamera(CameraUpdateFactory.zoomTo(15), 2000, null);

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

	private void initialize() {
		int type = 0;
		try {
			type = getIntent().getExtras().getInt("type", 0);
		} catch (Exception e) {
			e.printStackTrace();
		}

		switch (type) {
		case 0:
			drawAllMarkers();
			map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(
					38.276988, -0.688751), 14));
			map.animateCamera(CameraUpdateFactory.zoomTo(15), 2000, null);
			break;
		case 1:
			drawTalksMarkers();
			map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(
					38.276988, -0.688751), 14));
			map.animateCamera(CameraUpdateFactory.zoomTo(16), 2000, null);
			break;
		case 2:
			drawHackathonMarkers();
			map.moveCamera(CameraUpdateFactory.newLatLngZoom(BUILDING_QUORUMV,
					14));
			map.animateCamera(CameraUpdateFactory.zoomTo(16), 2000, null);
			building_quorumv.showInfoWindow();
			break;
		case 3:
			drawLunchMarkers();
			map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(
					38.276988, -0.688751), 14));
			map.animateCamera(CameraUpdateFactory.zoomTo(15), 2000, null);
			lunch_altabix.showInfoWindow();
			break;
		case 4:
			drawParkingMarkers();
			map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(
					38.276988, -0.688751), 14));
			map.animateCamera(CameraUpdateFactory.zoomTo(15), 2000, null);
			break;
		case 5:
			drawAltabixMarker();
			map.moveCamera(CameraUpdateFactory.newLatLngZoom(BUILDING_ALTABIX,
					14));
			map.animateCamera(CameraUpdateFactory.zoomTo(17), 2000, null);
			building_altabix.showInfoWindow();
			break;
		case 6:
			drawAltetMarker();
			map.moveCamera(CameraUpdateFactory
					.newLatLngZoom(BUILDING_ALTET, 14));
			map.animateCamera(CameraUpdateFactory.zoomTo(17), 2000, null);
			building_altet.showInfoWindow();
			break;
		}
	}

	private void prepareActionBar() {
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
	}

	private void drawAltabixMarker() {
		building_altabix = map.addMarker(new MarkerOptions()
				.position(BUILDING_ALTABIX)
				.title("Edificio Altabix")
				.snippet("Charlas y talleres")
				.icon(BitmapDescriptorFactory
						.fromResource(R.drawable.ic_marker_red)));
	}

	private void drawAltetMarker() {
		building_altet = map.addMarker(new MarkerOptions()
				.position(BUILDING_ALTET)
				.title("Edificio Altet")
				.snippet("Charlas y talleres")
				.icon(BitmapDescriptorFactory
						.fromResource(R.drawable.ic_marker_red)));
	}

	private void drawAllMarkers() {
		drawHackathonMarkers();
		drawLunchMarkers();
		drawParkingMarkers();
		drawTalksMarkers();
	}

	private void drawLunchMarkers() {

		lunch_altabix = map.addMarker(new MarkerOptions()
				.position(LUNCH_ALTABIX)
				.title("Cafeter�a Altabix")
				.icon(BitmapDescriptorFactory
						.fromResource(R.drawable.ic_marker_blue)));

		lunch_rectorado = map.addMarker(new MarkerOptions()
				.position(LUNCH_RECTORADO)
				.title("Restaurante Rectorado")
				.icon(BitmapDescriptorFactory
						.fromResource(R.drawable.ic_marker_blue)));

	}

	private void drawParkingMarkers() {

		parking_altabix = map.addMarker(new MarkerOptions()
				.position(PARKING_ALTABIX)
				.title("Aparcamiento (Altabix)")
				.icon(BitmapDescriptorFactory
						.fromResource(R.drawable.ic_marker_orange)));

		parking_galia = map.addMarker(new MarkerOptions()
				.position(PARKING_GALIA)
				.title("Aparcamiento (Galia)")
				.icon(BitmapDescriptorFactory
						.fromResource(R.drawable.ic_marker_orange)));

		parking_rectorado = map.addMarker(new MarkerOptions()
				.position(PARKING_RECTORADO)
				.title("Aparcamiento (Rectorado)")
				.snippet("Hackathon")
				.icon(BitmapDescriptorFactory
						.fromResource(R.drawable.ic_marker_orange)));

	}

	private void drawHackathonMarkers() {

		building_quorumv = map.addMarker(new MarkerOptions()
				.position(BUILDING_QUORUMV)
				.title("Edificio Quorum V")
				.snippet("Hackathon")
				.icon(BitmapDescriptorFactory
						.fromResource(R.drawable.ic_marker_green)));

		parking_rectorado = map.addMarker(new MarkerOptions()
				.position(PARKING_RECTORADO)
				.title("Aparcamiento (Rectorado)")
				.snippet("Hackathon")
				.icon(BitmapDescriptorFactory
						.fromResource(R.drawable.ic_marker_orange)));

	}

	private void drawTalksMarkers() {

		building_altabix = map.addMarker(new MarkerOptions()
				.position(BUILDING_ALTABIX)
				.title("Edificio Altabix")
				.snippet("Charlas y talleres")
				.icon(BitmapDescriptorFactory
						.fromResource(R.drawable.ic_marker_red)));

		building_altet = map.addMarker(new MarkerOptions()
				.position(BUILDING_ALTET)
				.title("Edificio Altet")
				.snippet("Charlas y talleres")
				.icon(BitmapDescriptorFactory
						.fromResource(R.drawable.ic_marker_red)));

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