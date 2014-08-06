package com.bignerdranch.geoquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends Activity {

	public static final String EXTRA_ANSWER_IS_TRUE = "com.bignerdranch.geoquiz.answer_is_true";
	public static final String EXTRA_ANSWER_IS_SHOWN = "com.bignerdranch.geoquiz.answer_shown";
	private boolean mAnswerIsTrue;
	private TextView mAnswerTextView;
	private Button mShowAnswer;
	
	//setting a result
	private void setAnswerShownResult(boolean isAnswerShown) {
		Intent data = new Intent();
		data.putExtra(EXTRA_ANSWER_IS_SHOWN, isAnswerShown);
		setResult(RESULT_OK, data);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cheat);
		
		mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);
		
		//sending back an intent
		setAnswerShownResult(false);

		mAnswerTextView = (TextView)findViewById(R.id.answerTextView);
		mShowAnswer = (Button)findViewById(R.id.showAnswerButton);
		
		mShowAnswer.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if(mAnswerIsTrue)
					mAnswerTextView.setText(R.string.true_button);
				else
					mAnswerTextView.setText(R.string.false_button);
				
				//sending back an intent
				setAnswerShownResult(true);
			}
		});
	}
}
