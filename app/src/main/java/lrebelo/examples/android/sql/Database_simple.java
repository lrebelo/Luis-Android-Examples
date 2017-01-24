package lrebelo.examples.android.sql;

/*NOTES************************************************
 *			   SQLite and UI additions
 *				 **Database_simple.java**
 * 
 * 				  Luis Rebelo
 * 
 * 			Kingston University London
 * 					 2014/2015
 *
 *****************************************************/

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database_simple extends SQLiteOpenHelper {
	
	private static final String DATABASE_NAME = "animals.db";
	/*NOTES
	 *	The string above defines the name of the database
	 */
	private static final int DATABASE_VERSION = 1;
	/*NOTES
	 *	The string above specifies the version of the database.
	 *	This is very useful for when updating your application code.
	 *	In this file the function 'onUpgrade()' uses the db version to 
	 *	 make sure that data incompatibilities don't happen.
	 */
	
    public static final String TABLE_NAME = "Animals";
    /*NOTES
	 *	The string above defines the name of the table.
	 *	(Of course we can have multiple tables within a database)
	 */
    
    public static final String ANIMAL_NAME = "animal_name";
    /*NOTES
	 *	The string above defines one attribute of the database table.
	 *	(Of course we can have multiple tables within a database)
	 */

    Database_simple(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        /*NOTES
    	 *	The this function is the main constructor it allows us to 
    	 *	 call(access) this specific database from any class. 
    	 */
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " + TABLE_NAME + " (" + ANIMAL_NAME + " TEXT);");

        /*NOTES
    	 *	The 'onCreate()' function is in charge of creating the tables
    	 *	While there are other ways of creating the tables in android
    	 *	 the '.execSQL()' allows for the clear visualisation and input of SQL code
    	 *	 in to the database
    	 */
    }

	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
		onCreate(db);
		
	}
	

}
