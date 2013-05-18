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
