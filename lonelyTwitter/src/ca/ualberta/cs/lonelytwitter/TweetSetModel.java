package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;

public class TweetSetModel {

	private int count = 0;
	private ArrayList<NormalTweetModel> tweets = new ArrayList<NormalTweetModel>();
	
	public int countTweets() {
		return count;
	}

	public void addTweet(NormalTweetModel normalTweetModel) throws IllegalArgumentException {
		if (tweets.contains(normalTweetModel)) {
			throw new IllegalArgumentException();
		}
		
		count++;
		tweets.add(normalTweetModel);
	}
	
	public NormalTweetModel[] getTweets() {
		return tweets.toArray(new NormalTweetModel[0]);
	}

}
