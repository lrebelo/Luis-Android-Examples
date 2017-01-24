package lrebelo.examples.android.intents;

import lrebelo.examples.android.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class IntentsAPPExample extends Activity{
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intents_app_example);
        
            	
    	Button callMailbutton = (Button) findViewById(R.id.intent_app_call_button1);
    	callMailbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	
            	EditText mailBox = (EditText) findViewById(R.id.intent_app_email_editText);
            	String stMail = mailBox.getText().toString();
            	
            	EditText txtBox = (EditText) findViewById(R.id.intent_app_txt_editText);
            	String stTxt = txtBox.getText().toString();
                
            	callMailApp(stMail,stTxt);
            	
            }
        });
    	
	}

	public void callMailApp(String mailBody, String emailAdd){
		
		Intent intMail = new Intent(Intent.ACTION_SEND);
		intMail.setType("text/plain");
		intMail.putExtra(Intent.EXTRA_EMAIL  , new String[]{emailAdd});
		intMail.putExtra(Intent.EXTRA_SUBJECT, "subject of email");
		intMail.putExtra(Intent.EXTRA_TEXT   , mailBody);
		try {
		    startActivity(Intent.createChooser(intMail, "Send mail..."));
		} catch (android.content.ActivityNotFoundException ex) {
		    Toast.makeText(this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
		}
		
	}
}
