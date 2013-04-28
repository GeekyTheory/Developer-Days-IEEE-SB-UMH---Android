package com.geekytheory.miguelcatalandev.developerdays;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.geekytheory.miguelcatalandev.developerdays.adapters.Main_Adapter_ViewPager;
import com.viewpagerindicator.TabPageIndicator;

import android.os.Bundle;
import android.support.v4.view.ViewPager;

public class Main_Activity_Main extends SherlockFragmentActivity {

	ViewPager mViewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity_main);
		initializePaging();
	}

	private void initializePaging() {
		Main_Fragment_Places mfragmentOne = new Main_Fragment_Places();
		Main_Fragment_Places mfragmentTwo = new Main_Fragment_Places();
		Main_Fragment_Places mfragmentThree = new Main_Fragment_Places();

		Main_Adapter_ViewPager mPagerAdapter = new Main_Adapter_ViewPager(
				getSupportFragmentManager());
		mPagerAdapter.setTitles(getResources().getStringArray(
				R.array.Main_Titles));
		mPagerAdapter.addFragment(mfragmentOne);
		mPagerAdapter.addFragment(mfragmentTwo);
		mPagerAdapter.addFragment(mfragmentThree);

		mViewPager = (ViewPager) findViewById(R.id.main_viewpager);
		mViewPager.setAdapter(mPagerAdapter);
		mViewPager.setOffscreenPageLimit(2);
		mViewPager.setCurrentItem(0);

		TabPageIndicator mTabIndicator = (TabPageIndicator) findViewById(R.id.main_indicator);
		mTabIndicator.setViewPager(mViewPager);
	}

}
