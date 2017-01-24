package lrebelo.examples.android.sql;

/*NOTES************************************************
 *		      SQLite and UI additions
 *			**SQLviewSimpleValues.java**
 * 
 * 				  Luis Rebelo
 * 
 * 			Kingston University London
 * 					2014/2015
 * 
 *****************************************************/

import lrebelo.examples.android.R;
import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

public class SQLviewSimpleValues extends Activity{
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sql_db_view_values_layout);
        
        String values = getValues();
        
        TextView valuesList = (TextView) findViewById(R.id.sql_view_values_TextView);
        valuesList.append("your animals are: \n" +values);
        
	}
	
	public String getValues(){
		
		String values = "";
		
		String[] FROM = {Database_simple.ANIMAL_NAME};
		
		Context context = getApplicationContext();
		Database_simple valuesDB = new Database_simple(context);
		/*NOTES
		 *  We call our simple database class and initialise it with the context of the application.
		 *  Notice the different way to obtain the context in this example.
		 *  
		 */
		
		SQLiteDatabase animalDB = valuesDB.getReadableDatabase();
		/*NOTES
		 *	Since all we want is to execute a query and get the results all we need is a
		 *	 Database that is readable hence we use the 'getReadableDatabase()' function.
		 *
		 */
		
		Cursor cursor = animalDB.query(Database_simple.TABLE_NAME, FROM, null, null, null, null, null);

		/*NOTES
		 * 	In this line we initialise the Cursor. This class allows us to read the results from the query
		 * 	 in a comprehensive way, it gives us the tools to return the results in a organised way.
		 * 	Its organised as an multidimensional array (aka a matrix).
		 */
		
		if (cursor.moveToFirst()) {
			/*NOTES
			 * 	The condition checks to see if the cursor is empty.
			 */
			
            do {
            	String animal = cursor.getString(0);
            	/*NOTES
            	 * 	The 'getString()' function just returns the value in the current 'row'
            	 * 	 the number specified within the brackets represents the column number, 
            	 * 	 in this case since the database only has one column ('animal_name') the 
            	 * 	 value is zero (the starting value is always zero).
            	 * 
            	 */
            	
            	values += animal;
                values += "\n";
            	
            } while (cursor.moveToNext());
            /*NOTES
             * 	This while loop keeps on running until the cursor reaches the end.
             */
            
            cursor.close();
        }
		
		return values;
	}

}
