package com.geekytheory.miguelcatalandev.developerdays;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.geekytheory.miguelcatalandev.developerdays.maps.Maps_fragmentActivity;

public class Main_Fragment_Places extends Fragment implements OnClickListener{
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
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
		LinearLayout talks = (LinearLayout)getView().findViewById(R.id.places_linearlayout_talks);
		talks.setOnClickListener(this);
		
		
	}


	@Override
	public void onClick(View v) {
		startActivity(new Intent(getActivity(), Maps_fragmentActivity.class));
		
	}

}
