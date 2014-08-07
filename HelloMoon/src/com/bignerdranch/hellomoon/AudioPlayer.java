package com.bignerdranch.hellomoon;

import android.content.Context;
import android.media.MediaPlayer;

public class AudioPlayer {
	private MediaPlayer mPlayer;
	private int position=0;
	
	public void stop() {
		if (mPlayer != null) {
			mPlayer.release();
			mPlayer = null;
		}
		else {
			position=0;
		}
	}
	
	public void play(Context c) {
		stop();
		
		mPlayer = MediaPlayer.create(c, R.raw.one_small_step);
		
		mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
			public void onCompletion(MediaPlayer mp) {
				stop();
			}
		});
		
		// starts the mediaplayer and resumes it from where it left off.
		mPlayer.seekTo(position);
		
        mPlayer.start();
	}
	
	public void pause() {
		mPlayer.pause();
		position=mPlayer.getCurrentPosition();
	}
	
	public boolean isPlaying() {
        return mPlayer != null;
    }
}
