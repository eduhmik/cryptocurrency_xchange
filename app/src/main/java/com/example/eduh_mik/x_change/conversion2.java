package com.example.eduh_mik.x_change;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.TintTypedArray;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class conversion2 extends AppCompatActivity {
    TextView title;
    TextView detail, result;
    ImageView image;
    EditText et;
    Double baseCurrency, num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion2);
        title = (TextView) findViewById(R.id.item_title);
        detail = (TextView) findViewById(R.id.item_detail);
        image = (ImageView) findViewById(R.id.item_image2);
        result = (TextView) findViewById(R.id.tv5);
        et = (EditText) findViewById(R.id.et1);

        String titleresult = getIntent().getStringExtra("title");
        String Detailresult = getIntent().getStringExtra("detail");
        image.setImageResource(R.drawable.eth_logo);
        title.setText(titleresult);
        detail.setText(Detailresult);
//to convert the string to double
        num = Double.parseDouble(Detailresult.toString());
        //baseCurrency = Double.parseDouble(et.getText().toString());


//button to do the conversion
        Button button=(Button)findViewById(R.id.ib1) ;
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String str1 = et.getText().toString();

                if (TextUtils.isEmpty(str1)) {
                    et.setError("Please enter your base currency");
                    et.requestFocus();
                    return;
                }

                baseCurrency = Double.parseDouble(str1);

                double answer = convert(num, baseCurrency);
                result.setText(String.valueOf(answer));
            }

        });
    }

    public double convert(double num, double baseCurrency) {


        return (double)  (baseCurrency / num);

    }
}




