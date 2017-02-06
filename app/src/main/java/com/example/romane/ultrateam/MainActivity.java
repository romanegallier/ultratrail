package com.example.romane.ultrateam;

import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;

public class MainActivity extends AppCompatActivity implements View.OnClickListener   {
    TabHost tabHost;
    Button rx_button;
    Button setting_button;
    Button tx_send;
    Button tx_on;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TabHost host = (TabHost)findViewById(R.id.tabHost);
        host.setup();

        //Tab 1
        TabHost.TabSpec spec = host.newTabSpec("Tab One");
        spec.setContent(R.id.tab1);
        spec.setIndicator("Tab One");
        host.addTab(spec);

        //Tab 2
        spec = host.newTabSpec("Rx");
        spec.setContent(R.id.Rx);
        spec.setIndicator("Rx");
        host.addTab(spec);

        //Tab 3
        spec = host.newTabSpec("Tx");
        spec.setContent(R.id.Tx);
        spec.setIndicator("Tx");
        host.addTab(spec);

        rx_button = (Button) findViewById(R.id.rx_button);
        rx_button.setOnClickListener(this);
        setting_button = (Button) findViewById(R.id.tab1_button);
        setting_button.setOnClickListener(this);
        tx_send = (Button) findViewById(R.id.tx_send);
        tx_on=(Button) findViewById(R.id.tx_on);
        tx_send.setOnClickListener(this);
        tx_on.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

        if (v==rx_button){
            if (rx_button.getText()=="ON"){
                rx_button.setText("OFF");
            }
            else rx_button.setText("ON");
        }

        if (v==setting_button){
            if (setting_button.getText()=="ON"){
                setting_button.setText("OFF");
            }
            else setting_button.setText("ON");
        }
        if(v==tx_on){
            if (tx_on.getText()=="ON"){
                tx_on.setText("OFF");
            }
            else tx_on.setText("ON"); //active l'envoie
        }
        if(v==tx_send){
            EditText j= (EditText) findViewById(R.id.tx_editText1);
            String message = j.getText().toString();// le message a envoye
            j.setText("");

        }
    }
}
