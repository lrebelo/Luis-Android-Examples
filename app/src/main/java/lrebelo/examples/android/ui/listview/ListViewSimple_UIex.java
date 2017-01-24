package lrebelo.examples.android.ui.listview;

/*NOTES************************************************
 *		   **ListViewSimple_UIex.java**
 * 
 * 				  Luis Rebelo
 * 
 * 			Kingston University London
 * 					2014/2105
 * 
 *****************************************************/


import android.app.ExpandableListActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ExpandableListView.OnChildClickListener;

public class ListViewSimple_UIex extends ExpandableListActivity implements OnChildClickListener {
	
	ExpandableListAdapter eListAdapter;
	
	private String[] groups = { "Felines","Canines","Primates" };
    private String[][] children = {
    		{"Lion","Leopard","Kitten"},
    		{"Wolf","Fox","Dog"},
    		{"Gorila","Chimp","Human"} 
    };
    
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

	     registerForContextMenu(getExpandableListView());
	    }
	 
	 /* NOTES :: The function bellow works in a similar way to the Button click listeners,
	  * 		but once clicked it returns the location of that click within the hierarchy
	  * 		of the ListView
	  */
	 public boolean onChildClick( ExpandableListView parent, View v, int groupPosition,int childPosition,long id) {
		 Toast.makeText(this,"It's a " + children[groupPosition][childPosition] + " from the " + groups[groupPosition] +" family.", Toast.LENGTH_SHORT).show();
		 return true;
	   }
	 
	    
	    public class AnimalListAdapter extends BaseExpandableListAdapter {
	        
	        
	        public Object getChild(int groupPosition, int childPosition) {
	            return children[groupPosition][childPosition];
	        }

	        public long getChildId(int groupPosition, int childPosition) {
	            return childPosition;
	        }

	        public int getChildrenCount(int groupPosition) {
	            return children[groupPosition].length;
	        }

	        public TextView getGenericView() {
	        	
	            // Layout parameters for the ExpandableListView
	            AbsListView.LayoutParams lp = new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 64);

	            TextView tv = new TextView(ListViewSimple_UIex.this);
	            tv.setLayoutParams(lp);
	            
	            // Center the text vertically and 'stuck' to the left side of the layout
	            tv.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
	            
	            // Set the text starting position, 
	            tv.setPaddingRelative(45, 0, 0, 0);
	            
	            return tv;
	        }
	        
	        public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
	            TextView tv = getGenericView();
	            tv.setText(getChild(groupPosition, childPosition).toString());
	            return tv;
	        }

	        public Object getGroup(int groupPosition) {
	            return groups[groupPosition];
	        }

	        public int getGroupCount() {
	            return groups.length;
	        }

	        public long getGroupId(int groupPosition) {
	            return groupPosition;
	        }

	        public View getGroupView(int groupPosition, boolean isExpanded, View convertView,
	                ViewGroup parent) {
	            TextView tv = getGenericView();
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
	}

