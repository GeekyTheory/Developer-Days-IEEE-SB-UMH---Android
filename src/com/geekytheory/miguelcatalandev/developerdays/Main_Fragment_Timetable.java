package com.geekytheory.miguelcatalandev.developerdays;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class Main_Fragment_Timetable extends Fragment implements OnClickListener{
	
	Button button_1,button_2,button_3,button_4,button_5,button_6,button_7,button_8,button_9,button_10,button_11,button_12,button_13;

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		initialize();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.main_fragment_timetable,
				container, false);
		return view;
	}

	private void initialize() {
		button_1=(Button)getView().findViewById(R.id.timetable_button_tecnical);
		button_1.setOnClickListener(this);
		
		button_2=(Button)getView().findViewById(R.id.timetable_button_linux);
		button_2.setOnClickListener(this);
		
		button_3=(Button)getView().findViewById(R.id.timetable_button_wp);
		button_3.setOnClickListener(this);
		
		button_4=(Button)getView().findViewById(R.id.timetable_button_otp);
		button_4.setOnClickListener(this);
		
		button_5=(Button)getView().findViewById(R.id.timetable_button_opencv);
		button_5.setOnClickListener(this);
		
		button_6=(Button)getView().findViewById(R.id.timetable_button_wp2);
		button_6.setOnClickListener(this);
		
		button_7=(Button)getView().findViewById(R.id.timetable_button_arduino);
		button_7.setOnClickListener(this);
		
		button_8=(Button)getView().findViewById(R.id.timetable_button_node);
		button_8.setOnClickListener(this);
		
		button_9=(Button)getView().findViewById(R.id.timetable_button_money);
		button_9.setOnClickListener(this);
		
		button_10=(Button)getView().findViewById(R.id.timetable_button_ieee);
		button_10.setOnClickListener(this);
		
		button_11=(Button)getView().findViewById(R.id.timetable_button_intelec);
		button_11.setOnClickListener(this);
		
		button_12=(Button)getView().findViewById(R.id.timetable_button_chat);
		button_12.setOnClickListener(this);
		
		button_13=(Button)getView().findViewById(R.id.timetable_button_microsoft);
		button_13.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		Intent intent = new Intent(getActivity(), Detail_activity_Main.class);
		switch(v.getId()){
		case R.id.timetable_button_arduino:
			break;
		case R.id.timetable_button_chat:
			break;
		case R.id.timetable_button_ieee:
			break;
		case R.id.timetable_button_intelec:
			break;
		case R.id.timetable_button_linux:
			break;
		case R.id.timetable_button_microsoft:
			break;
		case R.id.timetable_button_money:
			break;
		case R.id.timetable_button_node:
			break;
		case R.id.timetable_button_opencv:
			break;
		case R.id.timetable_button_otp:
			break;
		case R.id.timetable_button_tecnical:
			break;
		case R.id.timetable_button_wp:
			break;
		case R.id.timetable_button_wp2:
			break;
		}
		startActivity(intent);
	}

}
