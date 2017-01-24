package lrebelo.examples.android.ui;

/*NOTES************************************************
 *			 **Menu_Toast_UIex.java**
 * 
 * 				  Luis Rebelo
 * 
 * 			Kingston University London
 * 					2014/2105
 * 
 *****************************************************/

import lrebelo.examples.android.R;
import lrebelo.examples.android.*;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Menu_Toast_UIex extends Activity{
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_menu_toast_layout);
        
        
        Button simpleToastEx_button = (Button) findViewById(R.id.ui_simple_toast_button);
        simpleToastEx_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	
            	Context context = getApplicationContext();
            	CharSequence message = "This is a simple Toast  :D";
            	int duration = Toast.LENGTH_LONG;

            	Toast simpleToast = Toast.makeText(context, message, duration);
            	simpleToast.show();
            	
            }
        });
        
        
        Button textToastEx_button = (Button) findViewById(R.id.ui_text_toast_button);
        textToastEx_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	
            	EditText textToastBox = (EditText) findViewById(R.id.ui_text_toast_editText);
            	String stText = textToastBox.getText().toString();
            	
            	if(textToastBox.isDirty() == false){stText="LOIC is locked on you :P";}
            	
            	Context context = getApplicationContext();
            	CharSequence message = "Your custom message is: " +stText +"";
            	int duration = Toast.LENGTH_LONG;

            	Toast textToast = Toast.makeText(context, message, duration);
            	textToast.show();
            	
            }
        });
        
	}
	
	
	public boolean onCreateOptionsMenu(Menu menu) {
		
		getMenuInflater().inflate(R.menu.ui_menu_example, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    
	    switch (item.getItemId()) {
	        case R.id.ui_menu_example_i1:
	            menuExample1();
	            return true;
	        case R.id.ui_menu_example_i2:
	        	menuExample2();
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}

	public void menuExample1(){
		
		Intent intUImenuInt = new Intent(this, Welcome.class);
    	/*NOTES
    	 * To create an intent we need to specify the class which we want to call
    	 * 	Afterwards we call the 'startActivity()' and the intent starts the activity on the class
    	 * 	specified.
    	 */
		startActivity(intUImenuInt);
		
	}
	
	public void menuExample2(){
		
		Context context = getApplicationContext();
		CharSequence message = "I Herd U Liek Mudkips";
    	int duration = Toast.LENGTH_LONG;

    	Toast simpleToast = Toast.makeText(context, message, duration);
    	simpleToast.show();
    	
	}
}
