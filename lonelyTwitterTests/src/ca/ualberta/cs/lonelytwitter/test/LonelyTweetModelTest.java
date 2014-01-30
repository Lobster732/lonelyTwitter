package ca.ualberta.cs.lonelytwitter.test;

import java.util.Date;

import junit.framework.Assert;

import ca.ualberta.cs.lonelytwitter.ImportantTweetModel;
import ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity;
import ca.ualberta.cs.lonelytwitter.NormalTweetModel;
import ca.ualberta.cs.lonelytwitter.TweetSetModel;
import android.test.ActivityInstrumentationTestCase2;

public class LonelyTweetModelTest extends ActivityInstrumentationTestCase2<LonelyTwitterActivity> {

	public LonelyTweetModelTest() {
		super(LonelyTwitterActivity.class);
	}
	
	public void testEquals() {
		Date date = new Date();
		NormalTweetModel normal = new NormalTweetModel("test", date);
		NormalTweetModel otherNormal = new NormalTweetModel("different text", date);
		
		assertFalse("different tweets are not equal", normal.equals(otherNormal));
		
		ImportantTweetModel important = new ImportantTweetModel("test", date);
		
		assertFalse("should not be equal", important.equals(normal));
		assertFalse("should not be equal", normal.equals(important));
		
		TweetSetModel model = new TweetSetModel();
		
		assertEquals("should be 0", 0, model.countTweets());
		
		model.addTweet(normal);
		assertEquals("should be 1", 1, model.countTweets());
		assertNotNull("should not be null", model.getTweets());
		
		try {
			model.addTweet(normal);
			Assert.fail("should have thown IllegalArgumentException");
		} 
		catch(IllegalArgumentException e) {
			// success
		}
	}
}
