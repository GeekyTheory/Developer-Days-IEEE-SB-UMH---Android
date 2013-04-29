package com.geekytheory.miguelcatalandev.developerdays.adapters;

import java.util.ArrayList;
import java.util.Date;

import com.geekytheory.miguelcatalandev.developerdays.R;
import com.geekytheory.miguelcatalandev.developerdays.images.ImageLoader;
import com.geekytheory.miguelcatalandev.developerdays.objects.Tweet;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Social_Adapter_Tweets extends ArrayAdapter<Object> {
	Context context;
	private ArrayList<Tweet> tweets;
	ImageLoader imgLoader;
	Date todayTime = new Date();
	final long MILLSECS_PER_MIN = 60 * 1000;

	public Social_Adapter_Tweets(Context context, ArrayList<Tweet> tweets) {
		super(context, R.layout.item_tweet);
		this.context = context;
		this.tweets = tweets;
		this.imgLoader = new ImageLoader(context);
	}

	@Override
	public int getCount() {
		return tweets.size();
	}

	private static class PlaceHolder {

		TextView name;
		TextView nick;
		TextView time;
		TextView content;
		ImageView image;

		public static PlaceHolder generate(View convertView) {
			PlaceHolder placeHolder = new PlaceHolder();
			placeHolder.name = (TextView) convertView
					.findViewById(R.id.social_itemtweet_textview_name);
			placeHolder.nick = (TextView) convertView
					.findViewById(R.id.social_itemtweet_textview_user);
			placeHolder.time = (TextView) convertView
					.findViewById(R.id.social_itemtweet_textview_time);
			placeHolder.content = (TextView) convertView
					.findViewById(R.id.social_itemtweet_textview_content);
			placeHolder.image = (ImageView) convertView
					.findViewById(R.id.social_itemtweet_imageView_user);
			return placeHolder;
		}

	}

	public View getView(int position, View convertView, ViewGroup parent) {
		PlaceHolder placeHolder;
		if (convertView == null) {
			convertView = View.inflate(context, R.layout.item_tweet, null);
			placeHolder = PlaceHolder.generate(convertView);
			convertView.setTag(placeHolder);
		} else {
			placeHolder = (PlaceHolder) convertView.getTag();
		}
		placeHolder.name.setText(tweets.get(position).getUserName());
		placeHolder.nick.setText("@" + tweets.get(position).getUserNick());
		placeHolder.time.setText(getDiferenceTimeString(tweets.get(position)
				.getTweetTime()));
		placeHolder.content.setText(tweets.get(position).getTweet());

		placeHolder.image.setImageResource(R.drawable.person_image_empty);
		imgLoader.DisplayImage(tweets.get(position).getUserImageUrl(),
				placeHolder.image);
		return (convertView);
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
