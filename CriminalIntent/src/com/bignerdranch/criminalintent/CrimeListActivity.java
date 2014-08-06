package com.bignerdranch.criminalintent;

import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

public class CrimeListActivity extends SingleFragmentActivity {
	
	@Override
	protected Fragment createFragment() {
		return new CrimeListFragment();
	}
}
