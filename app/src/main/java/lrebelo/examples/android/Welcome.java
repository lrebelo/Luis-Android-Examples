package lrebelo.examples.android;

/*NOTES************************************************
 *
 *				 **Welcome.java**
 * 
 * 				  Luis Rebelo
 * 
 * 			Kingston University London
 * 					 2014/2015
 * 
 *****************************************************/

/*CHANGELOG
 * 2015-10-31	Luis Rebelo :: Update for latest android sdk
 *
 * 2014-02-23	Luis Rebelo :: Re-organised the classes into packages, to separate each topic
 *		
 */


import lrebelo.examples.android.misc.*;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;


public class Welcome extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        /*NOTES
         * setContentView() serves the important function of connecting this
         * 	java file to a specific xml UI
         * 	Without it the program just wouldn't show the XML user interface, it would
         * 	just be a blank screen on the mobile/tablet
         */

        Button page1Button1 = (Button) findViewById(R.id.page1button1);
        /*NOTES
         * The declaration "Button button = (Button) findViewById(R.id.page1button1);"
         * 	creates a connection between the code and the xml user interface.
         * 	When declaring the usage of a new button in the code
         * 	(besides assigning a unique variable to its name) we have to always
         * 	specify which button we mean to connect to, this is accomplished by
         *  findViewById(R.id.page1button1)
         */
        
        page1Button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	/*Notes
            	 * The two lines above handle the process of waiting for the button to be pressed
            	 * 	and executing the appropriate code
            	 */
            	
            	goToIntentExample();
            	
            }
        });
        
        Button page1Button2 = (Button) findViewById(R.id.page1button2);
        page1Button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	
            	goToUIexamples();
            	
            }
        });
        
        Button page1Button3 = (Button) findViewById(R.id.page1button3);
        page1Button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	
            	goToExampleSQL();
            	
            }
        });
        
        Button gotoMiscButton = (Button) findViewById(R.id.welcome_gotomisc_button);
        gotoMiscButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	
            	goToMisc();
            	
            }
        });
        
               
    }
    
    //NOTES -> bellow are all the different functions that call other classes
    
    public void goToIntentExample(){
    	//NOTES -> Week 1 Example
    	
    	Intent intExamp = new Intent(this, Intentexamples.class);
    	/*NOTES
    	 * To create an intent we need to specify the class which we want to call
    	 * 	Afterwards we call the 'startActivity()' and the intent starts the activity on the class
    	 * 	specified.
    	 */
		startActivity(intExamp);
		
    }
    
    public void goToExampleSQL(){
    	//NOTES -> Week 2 SQL Example
    	
    	Intent intSQLExpl = new Intent(this, SQLexamples.class);
    	/*NOTES
    	 * To create an intent we need to specify the class which we want to call
    	 * 	Afterwards we call the 'startActivity()' and the intent starts the activity on the class
    	 * 	specified.
    	 */
		startActivity(intSQLExpl);
		
    }
    
    public void goToUIexamples(){
    	//NOTES -> Week 2 UI example
    	
    	Intent intUIExpl = new Intent(this, UIexamples.class);
    	/*NOTES
    	 * To create an intent we need to specify the class which we want to call
    	 * 	Afterwards we call the 'startActivity()' and the intent starts the activity on the class
    	 * 	specified.
    	 */
		startActivity(intUIExpl);
		
    }
    
    public void goToMisc(){
    	Intent intUIMisc = new Intent(this, MiscExamplesMenu.class);
    	startActivity(intUIMisc);
    }
    
}
