package lrebelo.examples.android.misc;

import lrebelo.examples.android.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MiscExamplesMenu extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.misc_examples_menu);
        
        
        Button gotoStringSplitButton = (Button) findViewById(R.id.gotoStringSplitButton);
        gotoStringSplitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	
            	goToStringSplit();
            	
            }
        });
        
        
    }
    
    public void goToStringSplit(){
    	Intent intStringSplit = new Intent(this, MiscStringSplitExample.class);
    	startActivity(intStringSplit);
    }

}
