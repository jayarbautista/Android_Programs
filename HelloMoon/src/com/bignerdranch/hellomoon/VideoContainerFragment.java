package com.bignerdranch.hellomoon;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;

public class VideoContainerFragment extends Fragment {
	private MediaPlayer mPlayer;
	private SurfaceHolder mSurfaceHolder;
	private SurfaceView mSurfaceView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_hello_moon_video, container, false);

		mSurfaceView = (SurfaceView) v.findViewById(R.id.videoSurface);
		mSurfaceHolder = mSurfaceView.getHolder();
		mSurfaceHolder.addCallback(new Callback() {
			@Override
			public void surfaceCreated(SurfaceHolder surfaceHolder) {
				mPlayer = MediaPlayer.create(getActivity(), R.raw.apollo_17_stroll);
				mPlayer.setDisplay(mSurfaceHolder);
				mPlayer.setOnCompletionListener(new OnCompletionListener() {
					@Override
					public void onCompletion(MediaPlayer mediaPlayer) {
						getActivity().finish();
					}
				});
				mPlayer.setOnPreparedListener(new OnPreparedListener() {
					@Override
					public void onPrepared(MediaPlayer mediaPlayer) {
						mPlayer.start();
					}
				});
			}

			@Override
			public void surfaceChanged(SurfaceHolder surfaceHolder, int i,
					int i2, int i3) {

			}

			@Override
			public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

			}
		});

		return v;
	}
}
