package lrebelo.examples.android.intents;

/*NOTES************************************************
 *		  Intents and XML UI example
 *		  **Intent_extra_reader.java**
 * 
 * 				  Luis Rebelo
 * 
 * 			Kingston University London
 * 					2014/2015
 * 
 *****************************************************/

/*TODO
 * Write the code that allows the activity to call the XML UI
 *  and a TextBox.
 *  Don't forget to create a TextBox in the 'connect_to_me_layout.xml'
 *  Also be aware that you need to declare the activity in the AndroidManifest.xml
 * 
 */

import lrebelo.examples.android.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class IntentExtraReader extends Activity{
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intent_extra_reader_activity);

		Intent intentString = getIntent();
	    String message = intentString.getStringExtra(IntentsSimpleExample.INTENT_VALUE);
	    /*NOTES
	     * The two lines above are responsible for receiving the message that the
	     * 	'Welcome' class sent trough the intent.
	     * 	The first line simply declares it and captures any active intents.
	     * 	The second line 'taps' into the intent and using the variable that 
	     * 	was defined as a (sort of) unique identifier in the Welcome.java file
	     * 	it retrieves the string value that was sent.
	     * 	This value is then appended on to the EditText box below.
	     */
	    
	    TextView box = (TextView) findViewById(R.id.intent_extra_output_textview);
	    box.append(message);
    
	}
}
