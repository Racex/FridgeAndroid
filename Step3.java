package com.example.cos.androidfridge;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Step3 extends AppCompatActivity {
    private EditText editText;
    private TextView textView;
    private Button buttonSubmit;
    private String SSID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step3);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        Bundle bundle = getIntent().getExtras();

        if(bundle.getString("Step2Extras")!= null)
        {
            SSID = bundle.getString("Step2Extras");
        }
        buttonSubmit = (Button) findViewById(R.id.buttonStep3Submit);
        editText = (EditText) findViewById(R.id.editTextStep3Passward);
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(), SSID+ " / "+ editText.getText() ,Toast.LENGTH_SHORT).show();
            }
        });
        textView = (TextView) findViewById(R.id.textViewStep3Information);
        textView.setText("Wybrałeś sieć " + SSID + " proszę podaj do niech hasło żeby lodówka mogła połączyć się z twoją siecia lokalną");
    }

}
