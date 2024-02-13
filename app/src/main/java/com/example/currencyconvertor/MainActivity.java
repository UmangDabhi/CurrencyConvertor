package com.example.currencyconvertor;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
     Button btnConvert;
     EditText priceText;
     Spinner sp1,sp2;
     TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnConvert = findViewById(R.id.btnConvert);
        priceText = findViewById(R.id.price);
        sp1 = findViewById(R.id.spinner1);
        sp2 = findViewById(R.id.spinner2);
        resultText = findViewById(R.id.resultText);

        String[] list= {"USD","INR","EUR"};
        
        ArrayAdapter ad;
        ad = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,list);
        sp1.setAdapter(ad);
        sp2.setAdapter(ad);
        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sp1Text = sp1.getSelectedItem().toString();
                String sp2Text = sp2.getSelectedItem().toString();
                double result = 0;
                switch (sp1Text){
                    case "USD":
                        switch (sp2Text){
                            case "USD":
                                resultText.setText(priceText.getText());
                                break;
                            case "INR":
                                result =(double) Integer.parseInt(priceText.getText().toString()) * 82;
                                resultText.setText("Result: " + result);
                                break;
                            case "EUR":
                                result = (double)Integer.parseInt(priceText.getText().toString()) * 0.90;
                                resultText.setText("Result: " + result);
                                break;
                            default:
                                break;
                        }
                         break;
                    case "INR":
                        switch (sp2Text){
                            case "USD":
                                result =(double) Integer.parseInt(priceText.getText().toString()) / 82;
                                resultText.setText("Result: " + result);
                                break;
                            case "INR":
                                resultText.setText(priceText.getText());
                                break;
                            case "EUR":
                                result =(double) Integer.parseInt(priceText.getText().toString()) /90;
                                resultText.setText("Result: " + result);
                                break;
                            default:
                                break;
                        }
                        break;
                    case "EUR":
                        switch (sp2Text){
                            case "USD":
                                result =(double) Integer.parseInt(priceText.getText().toString()) / 0.90;
                                resultText.setText("Result: " + result);
                                break;
                            case "INR":
                                result = (double)Integer.parseInt(priceText.getText().toString()) * 90;
                                resultText.setText("Result: " + result);
                                break;
                            case "EUR":
                                resultText.setText(priceText.getText());
                                break;
                            default:
                                break;
                        }
                        break;
                    default:
                        break;
                }

            }
        });

    }


}