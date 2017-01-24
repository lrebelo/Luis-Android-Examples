package lrebelo.examples.android;

/*NOTES************************************************
 *			   Intents and XML UI example
 *				 **Intentexamples.java**
 * 
 * 				  Luis Rebelo
 * 
 * 			Kingston University London
 * 					  2014/2015
 * 
 *****************************************************/

import lrebelo.examples.android.intents.*;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Intentexamples extends Activity{
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intent_examples_layout);
        
        Button intent_example1_button = (Button) findViewById(R.id.intent_example_1_button);
        intent_example1_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	
            	goToINTENTexample1();
            	
            }
        });
        
        Button intent_example2_button = (Button) findViewById(R.id.intent_example_2_button);
        intent_example2_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	
            	goToINTENTexample2();
            	
            }
        });
        
	}
	
	public void goToINTENTexample1(){
		
		Intent intINTENTexample1 = new Intent(this, IntentsSimpleExample.class);
    	/*NOTES
    	 * To create an intent we need to specify the class which we want to call
    	 * 	Afterwards we call the 'startActivity()' and the intent starts the activity on the class
    	 * 	specified.
    	 */
		startActivity(intINTENTexample1);
		
	}
	
	public void goToINTENTexample2(){
		
		Intent intINTENTexample2 = new Intent(this, IntentsAPPExample.class);
    	/*NOTES
    	 * To create an intent we need to specify the class which we want to call
    	 * 	Afterwards we call the 'startActivity()' and the intent starts the activity on the class
    	 * 	specified.
    	 */
		startActivity(intINTENTexample2);
		
	}


}
