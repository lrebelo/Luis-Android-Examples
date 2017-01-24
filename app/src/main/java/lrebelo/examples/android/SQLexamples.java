package lrebelo.examples.android;

/*NOTES************************************************			
 *			SQLite and UI additions
 *			  **SQLexamples.java**
 * 
 * 				  Luis Rebelo
 * 
 * 			Kingston University London
 * 				   2014/2015
 * 
 *****************************************************/

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import lrebelo.examples.android.sql.*;

public class SQLexamples extends Activity{
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sql_examples);
        
        Button sqlsimple_button = (Button) findViewById(R.id.sql_examples_simpleex_button);
        sqlsimple_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	
            	goToSQLsimpleExample();
            	
            }
        });
        
        Button sqlexample_button = (Button) findViewById(R.id.sql_examples_mex_button);
        sqlexample_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	
            	goToSQLExample();
            	
            }
        });
        
	}
	
	
	public void goToSQLsimpleExample(){
    	//NOTES -> Week 2 SQL simple example
    	
    	Intent intSQLsEx = new Intent(this, SQLSimpleExample.class);
    	/*NOTES
    	 * To create an intent we need to specify the class which we want to call
    	 * 	Afterwards we call the 'startActivity()' and the intent starts the activity on the class
    	 * 	specified.
    	 */
		startActivity(intSQLsEx);
		
    }
	
	public void goToSQLExample(){
    	//NOTES -> Week 2 SQL example
    	
    	Intent intSQLEx = new Intent(this, UIexamples.class);
    	/*NOTES
    	 * To create an intent we need to specify the class which we want to call
    	 * 	Afterwards we call the 'startActivity()' and the intent starts the activity on the class
    	 * 	specified.
    	 */
		startActivity(intSQLEx);
		
    }

}
