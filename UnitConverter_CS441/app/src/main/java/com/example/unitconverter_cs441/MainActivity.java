package com.example.unitconverter_cs441;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.EditText;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener {

    String[] sub = {" ", "AmazonPrime", "DisneyPlus", "HboGo", "Hulu",
            "Netflix", "NintendoOnline", "SpotifyPremium"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                convert(view);
            }
        });

        Spinner sub_spinner = findViewById(R.id.sub_spinner);
        sub_spinner.setOnItemSelectedListener(this);

        ArrayAdapter arr = new ArrayAdapter(this,android.R.layout.simple_spinner_item,sub);
        arr.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sub_spinner.setAdapter(arr);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void convert(View view){
        Spinner sub_spinner = findViewById(R.id.sub_spinner);
        EditText input = findViewById(R.id.int_input);
        TextView months = findViewById(R.id.text_output);
        TextView funds_needed = findViewById(R.id.text_output2);

        String subscription = (String) sub_spinner.getSelectedItem();
        int budget = Integer.valueOf(input.getText().toString());

        Converter.Subscription sub = Converter.Subscription.fromString(subscription);
        Converter converter = new Converter(sub);
        int result = converter.convert(budget);
        months.setText(String.valueOf(result));
        int remainder = converter.remainder(budget);
        funds_needed.setText(String.valueOf(remainder));
    }
}
