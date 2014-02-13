import ca.ualberta.cs.lonelytwitter.IntentReaderActivity;
import ca.ualberta.cs.lonelytwitter.R;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ViewAsserts;
import android.view.View;
import android.widget.TextView;


@SuppressLint("NewApi")
public class IntentReaderActivityTests extends
		ActivityInstrumentationTestCase2<IntentReaderActivity> {

	public IntentReaderActivityTests() {
		super(IntentReaderActivity.class);
	}
	
	public void testSendText() {
		Intent intent = new Intent();
		String text = "hello";
		intent.putExtra(IntentReaderActivity.TEXT_KEY, text);
		
		setActivityIntent(intent);
		IntentReaderActivity activity = getActivity();
		
		assertEquals("IntentReaderActivity should get text from intent", text, activity.getText());
	}
	
	public void testDoubleText() {
		Intent intent = new Intent();
		String text = "hello";
		intent.putExtra(IntentReaderActivity.TEXT_KEY, text);
		intent.putExtra(IntentReaderActivity.TRANSFORM_KEY, IntentReaderActivity.DOUBLE);
		
		setActivityIntent(intent);
		IntentReaderActivity activity = getActivity();
		
		assertEquals("IntentReaderActivity should double the text", "hellohello", activity.getText());
	}
	
	public void testDisplayText() {
		Intent intent = new Intent();
		String text = "hello";
		intent.putExtra(IntentReaderActivity.TEXT_KEY, text);
		
		setActivityIntent(intent);
		IntentReaderActivity activity = getActivity();
		
		TextView textview = (TextView) activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.intentText);
		
		assertEquals("text should be displayed", text, textview.getText());
	}
	
	public void testReverseText() {
		Intent intent = new Intent();
		String text = "hello";
		intent.putExtra(IntentReaderActivity.TEXT_KEY, text);
		intent.putExtra(IntentReaderActivity.TRANSFORM_KEY, IntentReaderActivity.REVERSE);
		
		setActivityIntent(intent);
		IntentReaderActivity activity = getActivity();
		
		assertEquals("IntentReaderActivity should reverse the text", "olleh", activity.getText());
	}
	
	public void testDefaultText() {
		Intent intent = new Intent();
		
		setActivityIntent(intent);
		IntentReaderActivity activity = getActivity();
		
		TextView textview = (TextView) activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.intentText);
		
		assertEquals("text should be displayed", "Default:NoText", textview.getText());
	}
	
	public void testTextViewIsVisable() throws Throwable {
		IntentReaderActivity activity = getActivity();
		View view = activity.getWindow().getDecorView();
		ViewAsserts.assertOnScreen(view, activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.intentText));
	}

}
