package com.bignerdranch.draganddraw;

import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class DragAndDrawActivity extends SingleFragmentActivity {

	@Override
	public Fragment createFragment() {
		return new DragAndDrawFragment();
	}
}
