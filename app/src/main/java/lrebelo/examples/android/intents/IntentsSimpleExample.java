package lrebelo.examples.android.intents;

/*NOTES************************************************
 *		   Intents and XML UI example
 *			**IntentsSimpleExample.java**
 * 
 * 				  Luis Rebelo
 * 
 * 			Kingston University London
 * 					2014/2015
 * 
 *****************************************************/

/* CHANGELOG
 * 	*changed from 'ExampleWeek1.java' to 'IntentsSimpleExample.java'
 */

import lrebelo.examples.android.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class IntentsSimpleExample extends Activity{
	
	public final static String INTENT_VALUE = "lrebelo.example.hellomap2.intent.MESSAGE";
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intent_simple_example_layout);
        
        Button intent_example1_button = (Button) findViewById(R.id.intent_ex_send_button);
        intent_example1_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	
            	EditText nameBox = (EditText) findViewById(R.id.intent_ex_editText);
            	String gValue = nameBox.getText().toString();
            	goToSendIntent(gValue);
            	
            }
        });
        
        
        
	}
	
	public void goToSendIntent(String senValue){
    	//NOTES -> Week 1 Example
    	
    	Intent intExamp = new Intent(this, IntentExtraReader.class);
    	intExamp.putExtra(INTENT_VALUE, senValue);
    	/*NOTES
    	 * Intents can also be used to carry information from one activity to another.
    	 *  the line above shows how this is done. The first value 'INTENT_VALUE' works as
    	 *  a unique identifier that helps to maintain a basic security and by assuring that 
    	 *  only the class with the unique identifier can read this message.
    	 *  As you can see, the variable is declared as public allowing access from other classes.
    	 */
		startActivity(intExamp);
		
    }

}
