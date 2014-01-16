package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

public class NormalTweetModel extends AbstractTweetModel {

	public NormalTweetModel(String text) {
		super(text);
	}

	@Override
	public Date getTimestamp() {
		return timestamp;
	}
	
	@Override
	public boolean isImportant() {
		return true;
	}
}
