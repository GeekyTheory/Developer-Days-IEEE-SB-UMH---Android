package com.geekytheory.miguelcatalandev.developerdays.adapters;

import java.util.ArrayList;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class Main_Adapter_ViewPager extends FragmentPagerAdapter {

	private static String[] TITLES;

	private final ArrayList<Fragment> mFragments = new ArrayList<Fragment>();

	public Main_Adapter_ViewPager(FragmentManager fm) {
		super(fm);
	}

	public void addFragment(Fragment fragment) {
		mFragments.add(fragment);
		notifyDataSetChanged();
	}

	public void setTitles(String[] titles) {
		TITLES = titles;
	}

	@Override
	public Fragment getItem(int position) {
		return mFragments.get(position);
	}

	@Override
	public int getCount() {
		return mFragments.size();
	}

	@Override
	public String getPageTitle(int position) {
		return TITLES[position];
	}

}
