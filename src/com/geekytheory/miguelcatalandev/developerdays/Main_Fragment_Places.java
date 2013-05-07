package com.geekytheory.miguelcatalandev.developerdays;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.geekytheory.miguelcatalandev.developerdays.maps.Maps_fragmentActivity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;

public class Main_Fragment_Places extends Fragment implements OnClickListener {

	private int result;

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		result = GooglePlayServicesUtil
				.isGooglePlayServicesAvailable(getActivity());
		initialize();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.main_fragment_places, container,
				false);
		return view;
	}

	private void initialize() {
		LinearLayout talks = (LinearLayout) getView().findViewById(
				R.id.places_linearlayout_talks);
		talks.setOnClickListener(this);
		LinearLayout hack = (LinearLayout) getView().findViewById(
				R.id.places_linearlayout_hackathon);
		hack.setOnClickListener(this);
		LinearLayout lunch = (LinearLayout) getView().findViewById(
				R.id.places_linearlayout_lunch);
		lunch.setOnClickListener(this);
		LinearLayout parking = (LinearLayout) getView().findViewById(
				R.id.places_linearlayout_parking);
		parking.setOnClickListener(this);
		ImageView image = (ImageView) getView().findViewById(
				R.id.places_imageview_map);
		image.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {

		if (result == ConnectionResult.SUCCESS) {
			Intent intent = new Intent(getActivity(),
					Maps_fragmentActivity.class);
			switch (v.getId()) {
			case R.id.places_linearlayout_talks:
				intent.putExtra("type", 1);
				break;
			case R.id.places_linearlayout_hackathon:
				intent.putExtra("type", 2);
				break;
			case R.id.places_linearlayout_lunch:
				intent.putExtra("type", 3);
				break;
			case R.id.places_linearlayout_parking:
				intent.putExtra("type", 4);
				break;
			case R.id.places_imageview_map:
				intent.putExtra("type", 0);
				break;
			}
			startActivity(intent);
		} else {
			GooglePlayServicesUtil.getErrorDialog(result, getActivity(), 32)
					.show();

		}

	}

}
