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
   Author: Miguel Catalan Bañuls <miguel@geekytheory.com>
*/

package com.geekytheory.miguelcatalandev.developerdays;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.geekytheory.miguelcatalandev.developerdays.adapters.Main_Adapter_ViewPager;
import com.google.analytics.tracking.android.EasyTracker;
import com.google.analytics.tracking.android.GoogleAnalytics;
import com.google.analytics.tracking.android.Tracker;
import com.viewpagerindicator.TabPageIndicator;

public class Main_Activity_Main extends SherlockFragmentActivity {

	ViewPager mViewPager;
	EasyTracker tracker;

	private Tracker mGaTracker;
	private GoogleAnalytics mGaInstance;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity_main);
		boolean isResponsive = (findViewById(R.id.main_responsive_main) != null);
		if (isResponsive) {
			getSupportFragmentManager()
					.beginTransaction()
					.replace(R.id.main_responsive_fragment_places,
							new Main_Fragment_Places()).addToBackStack(null)
					.commit();

			getSupportFragmentManager()
					.beginTransaction()
					.replace(R.id.main_responsive_fragment_timetable,
							new Main_Fragment_Timetable()).addToBackStack(null)
					.commit();

			getSupportFragmentManager()
					.beginTransaction()
					.replace(R.id.main_responsive_fragment_social,
							new Main_Fragment_Social()).addToBackStack(null)
					.commit();
		} else {
			initializePaging();
		}

	}

	@Override
	public void onStart() {
		super.onStart();
		tracker = EasyTracker.getInstance();
		tracker.activityStart(this);

		mGaInstance = GoogleAnalytics.getInstance(this);
		mGaTracker = mGaInstance.getDefaultTracker();
	}

	@Override
	public void onStop() {
		super.onStop();
		tracker.activityStop(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getSupportMenuInflater();
		inflater.inflate(R.menu.main_activity_main, menu);
		return true;
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		switch (item.getItemId()) {
		case R.id.action_about:
			startActivity(new Intent(this, Info_activity_Main.class));
			break;
		}
		return super.onMenuItemSelected(featureId, item);
	}

	private void initializePaging() {
		Main_Fragment_Timetable mfragmentOne = new Main_Fragment_Timetable();
		Main_Fragment_Places mfragmentTwo = new Main_Fragment_Places();
		Main_Fragment_Social mfragmentThree = new Main_Fragment_Social();

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
		mViewPager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int position) {
				switch (position) {
				case 0:
					mGaTracker.sendView("/Main_Timetable");
					break;
				case 1:
					mGaTracker.sendView("/Main_Places");
					break;
				case 2:
					mGaTracker.sendView("/Main_Social");
					break;
				}

			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub

			}
		});

		TabPageIndicator mTabIndicator = (TabPageIndicator) findViewById(R.id.main_indicator);
		mTabIndicator.setViewPager(mViewPager);
	}

	@Override
	public void onBackPressed() {
		finish();
	}
}
