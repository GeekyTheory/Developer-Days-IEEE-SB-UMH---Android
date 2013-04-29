package com.geekytheory.miguelcatalandev.developerdays.objects;

import java.util.Date;

public class Tweet {
	private String userName;
	private String userNick;
	private String tweetContent;
	private String imageUrl;
	private Date postedTime;
	
	public void setUserName(String u){
		this.userName=u;
	}
	
	public void setTweet(String t){
		this.tweetContent=t;
	}

	public void setUserNick(String nick) {
		this.userNick = nick;
	}
	
	public void setUserImageUrl(String url) {
		this.imageUrl = url;
	}
	
	public void setTweetTime(Date time) {
		this.postedTime = time;
	}
	
	public String getUserName(){
		return this.userName;
	}
	
	public String getTweet(){
		return this.tweetContent;
	}

	public String getUserNick() {
		return this.userNick;
	}
	
	public String getUserImageUrl(){
		return this.imageUrl;
	}
	
	public Date getTweetTime(){
		return this.postedTime;
	}
}
