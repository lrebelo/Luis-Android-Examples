package lrebelo.examples.android.sql;

/*NOTES************************************************
 *			   SQLite and UI additions
 *				 **ExampleWeek2.java**
 * 
 * 				  Luis Rebelo
 * 
 * 			Kingston University London
 * 					2014/2015
 * 
 *****************************************************/

import lrebelo.examples.android.R;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/*NOTES************************************************
 *			 **SQLSimpleExample.java**
 *
 * 				  Luis Rebelo
 *
 * 			Kingston University London
 * 					2014/2105
 *
 *****************************************************/

public class SQLSimpleExample extends Activity{
	
	Context localContext = this;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sql_db_input_layout);
        
        
        Button addToDBbutton = (Button) findViewById(R.id.sql_insert_Button);
        addToDBbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	
            	EditText nameBox = (EditText) findViewById(R.id.sql_insert_EditText);
            	String stName = nameBox.getText().toString();
            	addToDB(localContext, stName);
            	
            }
        });
        
        Button viewValuesDBbutton = (Button) findViewById(R.id.sql_view_values_Button);
        viewValuesDBbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	
            	viewValuesinDB();
            	
            }
        });
        
	}
	
	public static void addToDB(Context con, String name){
		
		Database_simple values = new Database_simple(con);
		/*NOTES
		 *  We call our simple database class and initialise it with the context of the application.
		 */
		
	    SQLiteDatabase db = values.getWritableDatabase();
	    /*NOTES
	     * 	Then we use the 'SQLiteDatabase' function, as it allows us to manipulate
	     * 	 our database at will (add, remove, query data, etc)
	     */
	    
	    ContentValues new_name = new ContentValues();
	    new_name.put(Database_simple.ANIMAL_NAME, name);
	    /*NOTES
	     *	The 'ContentValues' is class that allows for the organisation of large set of date
	     *	 just a an array it allow us to put ordered data into a variable
	     */
	    
	    db.insertOrThrow(Database_simple.TABLE_NAME, null, new_name);
	    /*NOTES
	     *	As the name implies 'insertOrThrow()' inserts data in to the specified database
	     *	 or it 'throws' an error..
	     *	The first argument is the table name (in this case it has the value of 'Animals')
	     *	The second argument is used in the case that your input values are empty.
	     *	The third argument is the all important 'ContentValues' variable, that hold all the
	     *	 strings to be inserted in to the database
	     */
	}
	
	public void viewValuesinDB(){
		
		Intent intSQLviewValues = new Intent(this, SQLviewSimpleValues.class);
    	/*NOTES
    	 * To create an intent we need to specify the class which we want to call
    	 * 	Afterwards we call the 'startActivity()' and the intent starts the activity on the class
    	 * 	specified.
    	 */
		startActivity(intSQLviewValues);
		
	}

}
