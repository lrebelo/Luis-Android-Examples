package lrebelo.examples.android.ui.listview;

	/*NOTES************************************************
	 *		   **ListViewSQL_UIex.java**
	 * 
	 * 				  Luis Rebelo
	 * 
	 * 			Kingston University London
	 * 					 2014/2015
	 * 
	 *****************************************************/


import lrebelo.examples.android.R;
import lrebelo.examples.android.sql.Database_extra;
import lrebelo.examples.android.sql.Database_simple;

import android.app.ExpandableListActivity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ExpandableListView.OnChildClickListener;

	public class ListViewSQLRadio_UIex extends ExpandableListActivity implements OnChildClickListener {
		
		ExpandableListAdapter eListAdapter;
		
		RadioGroup rGone;
		RadioGroup rGtwo;
		RadioGroup rGthree;
		
		 @Override
		 public void onCreate(Bundle savedInstanceState) {
			 super.onCreate(savedInstanceState);

			 /* NOTES :: As you might have noticed on this Activity we dont call an xml layout
			  * 		 as you will see we will create our own layout from within this activity and
			  * 		 all of it through the use of java.
			  */
			 
			 eListAdapter = new AnimalListAdapter();
			 setListAdapter(eListAdapter);
			 
		    /* NOTES :: So to create a ListView we need a List adaptor, this adaptor will help
		     * 		    organise the data in to groups and their children
		     */

			 firstRun(); //function to add three values to each table in case that the db is empty
			 
			 
		     registerForContextMenu(getExpandableListView());
		    }
		 
		 /* NOTES :: The function bellow works in a similar way to the Button click listeners,
		  * 		but once clicked it returns the location of that click within the hierarchy
		  * 		of the ListView
		  */
		 public boolean onChildClick( ExpandableListView parent, View v, int groupPosition,int childPosition,long id) {
			 //Toast.makeText(this,"It's a " + children[groupPosition][childPosition] + " from the " + groups[groupPosition] +" family.", Toast.LENGTH_SHORT).show();
			 return true;
		   }
		 
		    
		    public class AnimalListAdapter extends BaseExpandableListAdapter {
		        
		        
		        public Object getChild(int groupPosition, int childPosition) {
		            return getValues(groupPosition, childPosition);
		        }

		        public long getChildId(int groupPosition, int childPosition) {
		            return childPosition;
		        }

		        public int getChildrenCount(int groupPosition) {
		            return getValuesl(groupPosition);
		        }

		        
		        public RadioGroup getRadioGroupView() {
		        	
		        	// Layout parameters for the ExpandableListView
		            AbsListView.LayoutParams lp = new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 64);

		            RadioGroup rG = new RadioGroup(ListViewSQLRadio_UIex.this);
		            rG.setLayoutParams(lp);
		            
		            // Center the text vertically and 'stuck' to the left side of the layout
		            rG.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
		            
		            return rG;
		        }
		        
		        public TextView getGenericTextView() {
		        	
		            // Layout parameters for the ExpandableListView
		            AbsListView.LayoutParams lp = new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 64);

		            TextView tv = new TextView(ListViewSQLRadio_UIex.this);
		            tv.setLayoutParams(lp);
		            
		            // Center the text vertically and 'stuck' to the left side of the layout
		            tv.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
		            
		            // Set the text starting position, 
		            tv.setPaddingRelative(45, 0, 0, 0);
		            
		            return tv;
		        }
		        
		        public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
		        	RadioGroup lRG = getRadioGroupView();
		        	
		        	RadioButton localRadioButton = new RadioButton(getApplicationContext());
		        	localRadioButton.setTextColor(Color.BLACK);
		        	localRadioButton.setText(getChild(groupPosition, childPosition).toString());
		            
		        	lRG.addView(localRadioButton);

		        	return lRG;
		        }

		        public Object getGroup(int groupPosition) {
		            return getValues(groupPosition);
		        }

		        public int getGroupCount() {
		            return 3;
		        }

		        public long getGroupId(int groupPosition) {
		            return groupPosition;
		        }

		        public View getGroupView(int groupPosition, boolean isExpanded, View convertView,
		                ViewGroup parent) {
		            TextView tv = getGenericTextView();
		            tv.setTextColor(Color.BLACK);
		            tv.setText(getGroup(groupPosition).toString());
		            return tv;
		        }

		        public boolean isChildSelectable(int groupPosition, int childPosition) {
		            return true;
		        }

		        public boolean hasStableIds() {
		            return true;
		        }

		    }
		    
		    
		    
		    public void firstRun(){
				
				String[] FROM = {Database_extra.ID};
				
				Context context = getApplicationContext();
				Database_extra speciesDB = new Database_extra(context);

				
				SQLiteDatabase initReadDB = speciesDB.getWritableDatabase();
				
				
				Cursor cursor = initReadDB.query(Database_extra.CANINE_TABLE, FROM, null, null, null, null, null);		
				
				int num = cursor.getCount();
				
				cursor.close();
				
				if(num == 0){
					
				    SQLiteDatabase initValuesdb = speciesDB.getWritableDatabase();
				    
				    
				    //-- Table Canine values to insert
				    ContentValues t1v1 = new ContentValues();
				    t1v1.put(Database_extra.TYPE, "Lion");
				    t1v1.put(Database_extra.LATIN_NAME, "Panthera leo");
				    initValuesdb.insertOrThrow(Database_extra.CANINE_TABLE, null, t1v1);
				    
				    ContentValues t1v2 = new ContentValues();
				    t1v2.put(Database_extra.TYPE, "Leopard");
				    t1v2.put(Database_extra.LATIN_NAME, "Panthera pardus");
				    initValuesdb.insertOrThrow(Database_extra.CANINE_TABLE, null, t1v2);
				    
				    ContentValues t1v3 = new ContentValues();
				    t1v3.put(Database_extra.TYPE, "Cat");
				    t1v3.put(Database_extra.LATIN_NAME, "Felis catus");
				    initValuesdb.insertOrThrow(Database_extra.CANINE_TABLE, null, t1v3);
				    
				    
				    //-- Table Feline values to insert
				    ContentValues t2v1 = new ContentValues();
				    t2v1.put(Database_extra.TYPE, "Wolf");
				    t2v1.put(Database_extra.LATIN_NAME, "Canis lupus");
				    initValuesdb.insertOrThrow(Database_extra.FELINE_TABLE, null, t2v1);
				    
				    ContentValues t2v2 = new ContentValues();
				    t2v2.put(Database_extra.TYPE, "Fox");
				    t2v2.put(Database_extra.LATIN_NAME, "Vulpes vulpes");
				    initValuesdb.insertOrThrow(Database_extra.FELINE_TABLE, null, t2v2);
				    
				    ContentValues t2v3 = new ContentValues();
				    t2v3.put(Database_extra.TYPE, "Dog");
				    t2v3.put(Database_extra.LATIN_NAME, "Canis lupus familiaris");
				    initValuesdb.insertOrThrow(Database_extra.FELINE_TABLE, null, t2v3);
				    
				    
				    //-- Table Primate values to insert
				    ContentValues t3v1 = new ContentValues();
				    t3v1.put(Database_extra.TYPE, "Gorilla");
				    t3v1.put(Database_extra.LATIN_NAME, "Gorilla");
				    initValuesdb.insertOrThrow(Database_extra.PRIMATES_TABLE, null, t3v1);
				    
				    ContentValues t3v2 = new ContentValues();
				    t3v2.put(Database_extra.TYPE, "Chimpanzee");
				    t3v2.put(Database_extra.LATIN_NAME, "Pan troglodytes");
				    initValuesdb.insertOrThrow(Database_extra.PRIMATES_TABLE, null, t3v2);
				    
				    ContentValues t3v3 = new ContentValues();
				    t3v3.put(Database_extra.TYPE, "Human");
				    t3v3.put(Database_extra.LATIN_NAME, "Homo sapiens");
				    initValuesdb.insertOrThrow(Database_extra.PRIMATES_TABLE, null, t3v3);
					
				}
		
		    }
		    
		    
		    
		    public String getValues(int table){
				String ret = "";
		    	
		    	switch(table){
		    	case 0: ret = Database_extra.CANINE_TABLE;
		    		break;
		    	case 1: ret = Database_extra.FELINE_TABLE;
		    		break;
		    	case 2: ret = Database_extra.PRIMATES_TABLE;
		    		break;
		    	}
		    	
				return ret;
			}
		    
		    
		    

			public String getValues(int table, int row){
		    	
		    	int[] rowContentID = new int[20];
		    	String[] rowContentTYPE = new String[20];
		    	String[] rowContentLNAME = new String[20];
		    	
		    	Cursor cursor = null;
		    	
		    	String TABLE = null;
		    	
		    	switch(table){
		    	case 0: TABLE = Database_extra.CANINE_TABLE;
		    		break;
		    	case 1: TABLE = Database_extra.FELINE_TABLE;
		    		break;
		    	case 2: TABLE = Database_extra.PRIMATES_TABLE;
		    		break;
		    		default : TABLE = Database_extra.CANINE_TABLE;
		    	}
		    	
				String[] FROM = {Database_extra.ID, Database_extra.TYPE, Database_extra.LATIN_NAME};
				String WHERE = Database_extra.ID +" = " +row;
				
				Context context = getApplicationContext();
				Database_extra valuesDB = new Database_extra(context);
				
				SQLiteDatabase animalDB = valuesDB.getReadableDatabase();

				cursor = animalDB.query(TABLE, FROM, null, null, null, null, null);

				int c = 0;
				if (cursor.moveToFirst()) {
		            do {
		            	int id = cursor.getInt(0);
		            	String type = cursor.getString(1);
		            	String lname = cursor.getString(2);
		            	
		            	rowContentID[c] = id;
		            	rowContentTYPE[c] = type;
		            	rowContentLNAME[c] = lname;
		            	
		            	c++;
		            } while (cursor.moveToNext());
		            
		            cursor.close();
		        }
				
				String send = rowContentTYPE[row]+" also known as "+rowContentLNAME[row];
		    	return send;
		    }
		    
		    
		    
		    public int getValuesl(int table){
		    	
		    	String[] rowContentID = null;
		    	
		    	String TABLE = null;
		    	
		    	switch(table){
		    	case 0: TABLE = Database_extra.CANINE_TABLE;
		    		break;
		    	case 1: TABLE = Database_extra.FELINE_TABLE;
		    		break;
		    	case 2: TABLE = Database_extra.PRIMATES_TABLE;
		    		break;
		    	}
		    	
				String[] FROM = {Database_extra.ID};
				
				Context context = getApplicationContext();
				Database_extra valuesDB = new Database_extra(context);
				SQLiteDatabase animalDB = valuesDB.getReadableDatabase();

				Cursor cursor = animalDB.query(TABLE, FROM, null, null, null, null, null);
				
				cursor.getCount();
				/*
				int c = 0;
				if (cursor.moveToFirst()) {
		            do {
		            	String id = cursor.getString(0);
		            	
		            	rowContentID[c] = id;
		            	
		            	c++;
		            } while (cursor.moveToNext());
		            
		            cursor.close();
		        }*/
		    	
		    	return cursor.getCount();
		    }
		    
		    
		}


