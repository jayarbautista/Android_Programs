package com.bignerdranch.criminalintent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

public abstract class SingleFragmentActivity extends FragmentActivity {
	protected abstract Fragment createFragment();
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fragment);
		
		FragmentManager fm = getSupportFragmentManager();
		
		//creates and commits fragment transaction
		Fragment fragment = fm.findFragmentById(R.id.fragmentContainer);
		if (fragment == null) {
			fragment = new CrimeFragment();
			fm.beginTransaction().add(R.id.fragmentContainer, fragment).commit();
		}
	}
}
