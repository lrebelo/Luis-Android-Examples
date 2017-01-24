package lrebelo.examples.android;

/*NOTES************************************************
 *			   SQLite and UI additions
 *				 **UIexamples.java**
 * 
 * 				  Luis Rebelo
 * 
 * 			Kingston University London
 * 					 2014/2015
 * 
 *****************************************************/

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import lrebelo.examples.android.ui.*;
import lrebelo.examples.android.ui.listview.*;
/*NOTES
 *	The import above helps to connect this class to the classes stored within
 *	 the '.ui' package.
 *	With out it we wouldn't be able to call the classes stored within that
 *	 package, even if they are declared on the manifest.
 */


public class UIexamples extends Activity{
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_example);
        
        Button relaLay_button = (Button) findViewById(R.id.ui_relative_layout_button);
        relaLay_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	
            	goToUIrelativeLayout();
            	
            }
        });
        
        Button linearLay_button = (Button) findViewById(R.id.ui_linear_layout_button);
        linearLay_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	
            	goToUIlinearLayout();
            	
            }
        });
        
        Button tableLay_button = (Button) findViewById(R.id.ui_table_layout_button);
        tableLay_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	
            	goToUItableLayout();
            	
            }
        });
        
        Button frameLay_button = (Button) findViewById(R.id.ui_frame_layout_button);
        frameLay_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	
            	goToUIframeLayout();
            	
            }
        });
        
        Button gridLay_button = (Button) findViewById(R.id.ui_grid_layout_button);
        gridLay_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	
            	goToUIgridLayout();
            	
            }
        });
        
        Button listView_button = (Button) findViewById(R.id.ui_list_view_button);
        listView_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	
            	goToUIlistView();
            	
            }
        });
        
        Button menutoastEx_button = (Button) findViewById(R.id.ui_menu_toast_example_button);
        menutoastEx_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	
            	goToUImenuExample();
            	
            }
        });
        
        Button widgetsEx_button = (Button) findViewById(R.id.ui_widgets_example_button);
        widgetsEx_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	
            	goToUIwidgetsExample();
            	
            }
        });
        
	}
	
	
	//*NOTES -> All call functions bellow
	
	public void goToUIrelativeLayout(){
		
		Intent intUIrelLay = new Intent(this, RelativeLayout_UIex.class);
    	/*NOTES
    	 * To create an intent we need to specify the class which we want to call
    	 * 	Afterwards we call the 'startActivity()' and the intent starts the activity on the class
    	 * 	specified.
    	 */
		startActivity(intUIrelLay);
		
	}
	
	public void goToUIlinearLayout(){
		
		Intent intUIlinLay = new Intent(this, LinearLayout_UIex.class);
    	/*NOTES
    	 * To create an intent we need to specify the class which we want to call
    	 * 	Afterwards we call the 'startActivity()' and the intent starts the activity on the class
    	 * 	specified.
    	 */
		startActivity(intUIlinLay);
		
	}

	public void goToUItableLayout(){
		
		Intent intUItableLay = new Intent(this, TableLayout_UIex.class);
    	/*NOTES
    	 * To create an intent we need to specify the class which we want to call
    	 * 	Afterwards we call the 'startActivity()' and the intent starts the activity on the class
    	 * 	specified.
    	 */
		startActivity(intUItableLay);
	
	}
	
	public void goToUIframeLayout(){
		
		Intent intUIframeLay = new Intent(this, FrameLayout_UIex.class);
    	/*NOTES
    	 * To create an intent we need to specify the class which we want to call
    	 * 	Afterwards we call the 'startActivity()' and the intent starts the activity on the class
    	 * 	specified.
    	 */
		startActivity(intUIframeLay);
		
	}
	
	public void goToUIgridLayout(){
		
		Intent intUIgridLay = new Intent(this, GridLayout_UIex.class);
    	/*NOTES
    	 * To create an intent we need to specify the class which we want to call
    	 * 	Afterwards we call the 'startActivity()' and the intent starts the activity on the class
    	 * 	specified.
    	 */
		startActivity(intUIgridLay);
		
	}
	
	public void goToUIlistView(){
		
		Intent intUIlistView = new Intent(this, ListViewMenu_UI.class);
    	/*NOTES
    	 * To create an intent we need to specify the class which we want to call
    	 * 	Afterwards we call the 'startActivity()' and the intent starts the activity on the class
    	 * 	specified.
    	 */
		startActivity(intUIlistView);
		
	}
	
	
	public void goToUImenuExample(){
		
		Intent intUImenuExample = new Intent(this, Menu_Toast_UIex.class);
    	/*NOTES
    	 * To create an intent we need to specify the class which we want to call
    	 * 	Afterwards we call the 'startActivity()' and the intent starts the activity on the class
    	 * 	specified.
    	 */
		startActivity(intUImenuExample);
		
	}
	
	public void goToUIwidgetsExample(){
		
		Intent intUIwidgetsExample = new Intent(this, Widgets_UIex.class);
    	/*NOTES
    	 * To create an intent we need to specify the class which we want to call
    	 * 	Afterwards we call the 'startActivity()' and the intent starts the activity on the class
    	 * 	specified.
    	 */
		startActivity(intUIwidgetsExample);
		
	}

}
