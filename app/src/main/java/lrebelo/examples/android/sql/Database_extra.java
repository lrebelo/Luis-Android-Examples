package lrebelo.examples.android.sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/*NOTES************************************************
 *			 **Database_extra.java**
 *
 * 				  Luis Rebelo
 *
 * 			Kingston University London
 * 					2014/2105
 *
 *****************************************************/


/*NOTES
 *
 * Use this as base for exercise
 *
 */


public class Database_extra extends SQLiteOpenHelper {
	
	private static final String DATABASE_NAME = "species.db";
	/*NOTES
	 *	The string above defines the name of the database
	 */
	private static final int DATABASE_VERSION = 2;
	/*NOTES
	 *	The string above specifies the version of the database.
	 *	This is very useful for when updating your application code.
	 *	In this file the function 'onUpgrade()' uses the db version to 
	 *	 make sure that data incompatibilities don't happen.
	 */
	
    public static final String CANINE_TABLE = "Canine";
    public static final String FELINE_TABLE = "Feline";
    public static final String PRIMATES_TABLE = "Primates";
    /*NOTES
	 *	The strings above defines the name of the tables.
	 */
    
    public static final String ID = "ID";
    public static final String TYPE = "Type";
    public static final String LATIN_NAME = "Latin_Name";
    /*NOTES
	 *	The strings above defines the attributes of the database table.
	 */

    public Database_extra(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        /*NOTES
    	 *	The this function is the main constructor it allows us to 
    	 *	 call(access) this specific database from any class. 
    	 */
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    	
        db.execSQL("CREATE TABLE " + CANINE_TABLE + " (" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+ TYPE +" TEXT, " + LATIN_NAME +" TEXT);");
        db.execSQL("CREATE TABLE " + FELINE_TABLE + " (" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+ TYPE +" TEXT, " + LATIN_NAME +" TEXT);");
        db.execSQL("CREATE TABLE " + PRIMATES_TABLE + " (" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+ TYPE +" TEXT, " + LATIN_NAME +" TEXT);");
    }

	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
		db.execSQL("DROP TABLE IF EXISTS " + CANINE_TABLE);
		db.execSQL("DROP TABLE IF EXISTS " + FELINE_TABLE);
		db.execSQL("DROP TABLE IF EXISTS " + PRIMATES_TABLE);
		onCreate(db);
		
	}
	

}
