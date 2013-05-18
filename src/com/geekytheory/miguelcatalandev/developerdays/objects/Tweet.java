/**
   Copyright GeekyTheory 2013 (@GeekyTheory)

   Licensed under the GPL General Public License, Version 3.0 (the "License"),  
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.gnu.org/licenses/gpl.html

   Unless required by applicable law or agreed to in writing, software 
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
   
   Website: http://geekytheory.com
   Author: Miguel Catalan Bañuls <miguel@geekytheory.com>
*/

package com.geekytheory.miguelcatalandev.developerdays.objects;

import java.util.Date;

public class Tweet {
	private String userName;
	private String userNick;
	private String tweetContent;
	private String imageUrl;
	private String tweetUrl;
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
	
	public void setTweetUrl(String url) {
		this.tweetUrl = url;
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
	
	public String getTweetUrl(){
		return this.tweetUrl;
	}
	
	public Date getTweetTime(){
		return this.postedTime;
	}
}
