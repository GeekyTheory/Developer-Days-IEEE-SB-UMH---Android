package com.geekytheory.miguelcatalandev.developerdays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import com.geekytheory.miguelcatalandev.developerdays.adapters.Social_Adapter_Tweets;
import com.geekytheory.miguelcatalandev.developerdays.objects.Tweet;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

public class Main_Fragment_Social extends ListFragment {
	public ArrayList<Tweet> tweets;
	private Social_Adapter_Tweets adapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		inflater = (LayoutInflater) getActivity().getSystemService(
				Context.LAYOUT_INFLATER_SERVICE);

		LinearLayout layout = (LinearLayout) inflater.inflate(
				R.layout.main_fragment_social, null);

		tweets = new ArrayList<Tweet>();
		adapter = new Social_Adapter_Tweets(getActivity(), tweets);

		/** Setting the array adapter to the listview */
		setListAdapter(adapter);

		return layout;
	}

	@Override
	public void onStart() {
		super.onStart();

		String str_url = "http://search.twitter.com/search.json?rpp=50&q=%23DDIEEEUMH";
		new DowloadTweets(getActivity(), str_url, this).execute();
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		final Tweet tweet = tweets.get(position);
		String url = "https://twitter.com/"+tweet.getUserNick()+"/status/"+tweet.getTweetUrl();
		
		Intent intent = new Intent(Intent.ACTION_VIEW);
		intent.setData(Uri.parse(url));
		startActivity(intent);
	}

	private class DowloadTweets extends AsyncTask<String, Void, Boolean> {

		private ProgressDialog dialog;
		private String str_url_tweet;

		public DowloadTweets(Context c, String url,
				Main_Fragment_Social fragment) {
			dialog = new ProgressDialog(getActivity());
			this.str_url_tweet = url;
		}

		protected void onPreExecute() {
			// this.dialog.setMessage("Obteniendo Rutas");
			// this.dialog.show();
		}

		@Override
		protected void onPostExecute(final Boolean success) {
			if (dialog.isShowing()) {
				dialog.dismiss();
			}
			if (success) {
				adapter.notifyDataSetChanged();
			} else {
				Toast.makeText(getActivity(), "Error en la lectura",
						Toast.LENGTH_LONG).show();
			}
		}

		protected Boolean doInBackground(final String... args) {
			String read_hashtag = readTwitterFeed(this.str_url_tweet);
			try {
				JSONObject jsonObject = new JSONObject(read_hashtag);
				String strData = jsonObject.getString("results");
				JSONArray jsonContent = new JSONArray(strData);
				int numItems = jsonContent.length();

				tweets.clear();
				for (int i = 0; i < numItems; i++) {
					JSONObject itemjson = jsonContent.getJSONObject(i);
					Tweet tweet = new Tweet();
					tweet.setUserName(itemjson.getString("from_user_name"));
					tweet.setTweet(itemjson.getString("text").replace("&gt;",
							""));
					tweet.setUserNick(itemjson.getString("from_user"));
					DateFormat formatter = new SimpleDateFormat(
							"EEE, dd MMM yyyy kk:mm:ss Z", Locale.ENGLISH);
					tweet.setTweetTime(formatter.parse(""
							+ itemjson.getString("created_at")));
					tweet.setUserImageUrl(itemjson
							.getString("profile_image_url"));
					tweet.setTweetUrl(itemjson
							.getString("id_str"));
					tweets.add(tweet);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return true;
		}

		private String readTwitterFeed(String url) {
			StringBuilder builder = new StringBuilder();
			HttpClient client = new DefaultHttpClient();
			HttpGet httpGet = new HttpGet(url);
			try {
				HttpResponse response = client.execute(httpGet);
				StatusLine statusLine = response.getStatusLine();
				int statusCode = statusLine.getStatusCode();
				if (statusCode == 200) {
					HttpEntity entity = response.getEntity();
					InputStream content = entity.getContent();
					BufferedReader reader = new BufferedReader(
							new InputStreamReader(content));
					String line;
					while ((line = reader.readLine()) != null) {
						builder.append(line);
					}
				} else {
					Log.d("ERROR", "Error pidiendo JSON");
				}
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return builder.toString();
		}

	}

}
