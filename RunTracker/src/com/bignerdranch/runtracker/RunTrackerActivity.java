package com.bignerdranch.runtracker;

import android.support.v4.app.Fragment;

public class RunTrackerActivity extends SingleFragmentActivity {

	@Override
	protected Fragment createFragment() {
		return new RunTrackerFragment();
	}
}
