package vardhman.com.elm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RegisterActivity extends AppCompatActivity {

    private Spinner countryListSpinner;
    //List<String> countryList;
    TextView textView;
    String[] countryList = {"Afghanistan","Albania","Algeria","Australia","Bhutan","India"};
    String[] countyrcode = {"+93","+355","+213","+61","+975","+91"};
    private Button buttonLetsGo;

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
                startActivity(new Intent(RegisterActivity.this,HomeActivity.class));
            }
        });
    }
}
