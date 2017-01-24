package lrebelo.examples.android.pref_storage;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import lrebelo.examples.android.R;

/*NOTES************************************************
 *			**Save_pref_Simple.java**
 *
 * 				  Luis Rebelo
 *
 * 			Kingston University London
 * 					  2015
 *
 *****************************************************/


public class Save_pref_Simple extends Activity {

    public static final String PREFS_NAME = "PrefsFile";

    /*NOTES
     * The string PREFS_NAME identifies the specific SharedPreferences we will be using.
     * In essence is like labeling a box, we can have multiple boxes but this is the one being used
     * in this activity.
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pref_save_layout);


        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        /*NOTES
         *	SharedPreferences above initialises the local storage. it is being defined by PREFS_NAME,
         *	so any prefs saved under this name will only be accessible when invoking that name.
         *	This means of course that is possible to have multiple SharedPreferences instances per application.
         */

        String tobox = settings.getString("onbutton", "Nothing yet!");
        String totv = settings.getString("onstop", "Nothing yet!");

        /*NOTES
         * In these two lines we see the function ’getString()’ we can use it to retrieve any
         * values stored within the SharedPreferences
         */

        EditText sendtoBox = (EditText) findViewById(R.id.pref_edit_text);
        sendtoBox.setText(tobox);

        TextView sendtoTV = (TextView) findViewById(R.id.pref_text_view);
        sendtoTV.append(totv);

        Button addToDBbutton = (Button) findViewById(R.id.pref_save_button);
        addToDBbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                EditText nameBox = (EditText) findViewById(R.id.pref_edit_text);
                String stName = nameBox.getText().toString();

                SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
                SharedPreferences.Editor editor = settings.edit();

                /*NOTES
                 * When it comes to saving data onto a SharedPreferences we must first set
                 * the data to 'alterable' if we dont then the SharedPreferences will be
                 * as read only not allowing us to store/overwrite any data on to it.
                 */

                editor.putString("onbutton", "from the Button click! "+stName);

                /*NOTES
                 * In these two lines we see the function ’putString()’ we can use it to save any
                 * values on to the SharedPreferences
                 */

                editor.commit();

                /*NOTES
                 * The 'commit()' function is the one responsible for the actual saving of data.
                 * If this is not executed the data entered through the 'putString()'
                 * will NOT be saved.
                 */

            }
        });



    }


    protected void onStop(){
        super.onStop();

        /*NOTES
         * By executing the SharedPreferences at this stage we ensure that any data gets saved
         * even in case the applications gets turned off.
         */

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();


        editor.putString("onstop", "from the onStop()");


        editor.commit();
    }


}
