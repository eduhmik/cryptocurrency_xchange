package com.example.eduh_mik.x_change;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class welcome extends AppCompatActivity {

    Spinner spinner;
    String itemSelected, texts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        spinner =(Spinner)findViewById(R.id.spinner);
        //final String name = spinner.getSelectedItem().toString();
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.currency, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {



            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                itemSelected = parent.getItemAtPosition(position).toString();


                if (itemSelected.equals("BTC")) {
                    texts = "BTC";
                    Intent name = new Intent(welcome.this, MainActivity.class);
                    startActivity(name);


                } else if (itemSelected.equals("ETH")) {
                    texts = "ETH";
                    Intent name = new Intent(welcome.this, ethereum.class);
                    startActivity(name);
                }
                if (spinner.getCount() > 1 )
                    spinner.setSelection(0);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
