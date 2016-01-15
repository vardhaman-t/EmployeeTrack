package vardhman.com.elm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private Spinner countryListSpinner;
    //List<String> countryList;
    TextView textView;
    String[] countryList = {"Afghanistan","Albania","Algeria","Australia","Bhutan","India"};
    String[] countyrcode = {"+93","+355","+213","+61","+975","+91"};
    private Button buttonLetsGo;
     EditText mobileNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        countryListSpinner = (Spinner)findViewById(R.id.countryListSpinner);
        textView = (TextView)findViewById(R.id.countryCodeTextView);
        buttonLetsGo = (Button)findViewById(R.id.buttonLetsGo);
        countryListSpinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, countryList));
        countryListSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Log.e("Position :", "" + i);
                textView.setText(countyrcode[i]);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        buttonLetsGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // startActivity(new Intent(RegisterActivity.this,HomeActivity.class));



                String phoneNo = mobileNumber.getText().toString();
                String sms = "Hi , Just SMSed to say hello";
			  //String sms = textSMS.getText().toString();

			  try {
				SmsManager smsManager = SmsManager.getDefault();
				smsManager.sendTextMessage(phoneNo, null, sms, null, null);
				Toast.makeText(getApplicationContext(), "SMS Sent!",
							Toast.LENGTH_LONG).show();
				 startActivity(new Intent(RegisterActivity.this,HomeActivity.class));
			  } catch (Exception e) {
				Toast.makeText(getApplicationContext(),
					"SMS faild, please try again later!",
					Toast.LENGTH_LONG).show();
				e.printStackTrace();

			  }
                   /*

                String _mobileNumber =mobileNumber.getText().toString();
                String messageText = "Hi , Just SMSed to say hello";

                Intent sendIntent = new Intent(Intent.ACTION_VIEW);
                sendIntent.setData(Uri.parse("sms:" + _mobileNumber));
                sendIntent.putExtra("sms_body", messageText);
                startActivity(sendIntent);
                */

                /*  String no=mobileno.getText().toString();
                String msg=message.getText().toString();

                //Getting intent and PendingIntent instance
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                PendingIntent pi=PendingIntent.getActivity(getApplicationContext(), 0, intent,0);

                //Get the SmsManager instance and call the sendTextMessage method to send message
                SmsManager sms=SmsManager.getDefault();
                sms.sendTextMessage(no, null, msg, pi,null);

                Toast.makeText(getApplicationContext(), "Message Sent successfully!",
                    Toast.LENGTH_LONG).show();
                  */
            }
        });
    }
}
