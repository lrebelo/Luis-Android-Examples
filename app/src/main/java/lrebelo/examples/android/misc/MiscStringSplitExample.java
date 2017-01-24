package lrebelo.examples.android.misc;

import lrebelo.examples.android.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MiscStringSplitExample extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.misc_string_split_example);
        
        Button split_theString_button = (Button) findViewById(R.id.splitButton);
        split_theString_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	
            	EditText nameBox = (EditText) findViewById(R.id.text_to_split);
            	String splitValue = nameBox.getText().toString();
            	
            	String[] splits = {};
            	splits = splitValue.split(" ");
            	
            	int i = 0;
            	while(i!= splits.length){
            		TextView to_see = (TextView) findViewById(R.id.misc_split_results);
            		to_see.append(splits[i]+"\n");
            		i++;
            	}
            	
            	
            	
            	
            	
            }
        });
        
    }

}
