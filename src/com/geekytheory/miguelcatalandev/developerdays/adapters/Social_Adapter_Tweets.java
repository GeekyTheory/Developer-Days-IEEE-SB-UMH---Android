package com.geekytheory.miguelcatalandev.developerdays.adapters;

import java.util.ArrayList;
import java.util.Date;

import com.geekytheory.miguelcatalandev.developerdays.R;
import com.geekytheory.miguelcatalandev.developerdays.objects.Tweet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class Social_Adapter_Tweets extends ArrayAdapter<Object> {
	Context context;
	private ArrayList<Tweet> tweets;
	Date todayTime = new Date();
	final long MILLSECS_PER_MIN = 60 * 1000;

	public Social_Adapter_Tweets(Context context, ArrayList<Tweet> tweets) {
		super(context, R.layout.item_tweet);
		this.context = context;
		this.tweets = tweets;
	}

	@Override
	public int getCount() {
		return tweets.size();
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		View item = inflater.inflate(R.layout.item_tweet, null);

		TextView lblUserName = (TextView) item
				.findViewById(R.id.social_itemtweet_textview_name);
		lblUserName.setText(tweets.get(position).getUserName());

		TextView lblUserNick = (TextView) item
				.findViewById(R.id.social_itemtweet_textview_user);
		lblUserNick.setText("@" + tweets.get(position).getUserNick());

		TextView lbltime = (TextView) item
				.findViewById(R.id.social_itemtweet_textview_time);
		lbltime.setText(getDiferenceTimeString(tweets.get(position)
				.getTweetTime()));

		TextView lblTweet = (TextView) item
				.findViewById(R.id.social_itemtweet_textview_content);
		lblTweet.setText(tweets.get(position).getTweet());
		return (item);
	}

	private String getDiferenceTimeString(Date tweetDate) {
		String diferenceString = null;
		long diferenceDate = (todayTime.getTime() - tweetDate.getTime())
				/ MILLSECS_PER_MIN;
		if (diferenceDate > (60 * 24)) {
			diferenceString = "" + tweetDate.getDate()
					+ getMonth(tweetDate.getMonth()); // Not know why need -1
		} else if (diferenceDate >= 60) {
			diferenceString = diferenceDate / 60 + "h";
		} else if (diferenceDate > 0) {
			diferenceString = diferenceDate / 60 + "m";
		}
		return diferenceString;
	}

	private String getMonth(int month_int) {
		switch (month_int) {
		case 0:
			return "ene";
		case 1:
			return "feb";
		case 2:
			return "mar";
		case 3:
			return "abr";
		case 4:
			return "may";
		case 5:
			return "jun";
		case 6:
			return "jul";
		case 7:
			return "ago";
		case 8:
			return "sep";
		case 9:
			return "oct";
		case 10:
			return "nov";
		case 11:
			return "dic";
		default:
			return null;

		}
	}
}
