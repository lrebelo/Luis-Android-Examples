package lrebelo.examples.android.ui.listview;

import lrebelo.examples.android.Intentexamples;
import lrebelo.examples.android.R;
import lrebelo.examples.android.SQLexamples;
import lrebelo.examples.android.UIexamples;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/*NOTES************************************************
 *			 **ListViewMenu_UI.java**
 *
 * 				  Luis Rebelo
 *
 * 			Kingston University London
 * 					2014/2105
 *
 *****************************************************/

public class ListViewMenu_UI extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_listview_menu);
        

        Button simpleListViewButton = (Button) findViewById(R.id.ui_listview_simple_button);
        /*NOTES
         * The declaration "Button button = (Button) findViewById(R.id.page1button1);"
         * 	creates a connection between the code and the xml user interface.
         * 	When declaring the usage of a new button in the code
         * 	(besides assigning a unique variable to its name) we have to always
         * 	specify which button we mean to connect to, this is accomplished by
         *  findViewById(R.id.page1button1)
         */
        
        simpleListViewButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            	
            	goToSimpleListView();
            	
            }
        });
        
        Button sqlListViewButton = (Button) findViewById(R.id.ui_listview_sql_button);
        sqlListViewButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	
            	goToSQLListView();
            	
            }
        });
        
        Button sqlListViewRadioButton = (Button) findViewById(R.id.ui_listview_sql_radio);
        sqlListViewRadioButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	
            	goToSQLRadioListView();
            	
            }
        });
               
    }
    

    public void goToSimpleListView(){
    	
    	Intent intSListV = new Intent(this, ListViewSimple_UIex.class);
		startActivity(intSListV);
		
    }
    
    public void goToSQLListView(){
    	
    	Intent intSQLListV = new Intent(this, ListViewSQL_UIex.class);
		startActivity(intSQLListV);
		
    }
    
    public void goToSQLRadioListView(){
    	
    	Intent intSQLListV = new Intent(this, ListViewSQLRadio_UIex.class);
		startActivity(intSQLListV);
		
    }
    
}
