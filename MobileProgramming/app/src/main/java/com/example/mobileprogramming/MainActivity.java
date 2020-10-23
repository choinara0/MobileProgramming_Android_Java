package com.example.mobileprogramming;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button btn_hometobasket;
    private Button btn_hometopurchase;
    private CheckBox check_jacket1;
    private CheckBox check_jacket2;
    private TextView text_jacket1;
    private TextView text_jacket2;
    private TextView price_jacekt1;
    private TextView price_jacket2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        check_jacket1 = findViewById(R.id.check_jacket1);
        check_jacket2 = findViewById(R.id.check_jacket2);
        btn_hometobasket = findViewById(R.id.btn_hometobasket);
        btn_hometopurchase = findViewById(R.id.btn_hometopurchase);
        text_jacket1 = findViewById(R.id.text_jacket1);
        text_jacket2 = findViewById(R.id.text_jacket2);
        price_jacekt1 = findViewById(R.id.price_jacket1);
        price_jacket2 = findViewById(R.id.price_jacket2);

        final Intent intent = new Intent(getApplicationContext(), ShoppingBasket.class);
        final Intent intent2 = new Intent(getApplicationContext(), Purchase.class);
        intent.putExtra("String", text_jacket1.getText());
        intent.putExtra("String2", text_jacket2.getText());
        intent.putExtra("Strprice", price_jacekt1.getText());
        intent.putExtra("Strprice2", price_jacket2.getText());
        intent2.putExtra("String", text_jacket1.getText());
        intent2.putExtra("String2", text_jacket2.getText());
        intent2.putExtra("Strprice", price_jacekt1.getText());
        intent2.putExtra("Strprice2", price_jacket2.getText());


        btn_hometobasket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(check_jacket1.isChecked()||check_jacket2.isChecked()){
                    if(check_jacket1.isChecked()&&check_jacket2.isChecked()) {
                        intent.putExtra("Case", "both");
                        startActivity(intent); }
                    else if(check_jacket1.isChecked()){
                        intent.putExtra("Case", "one");
                        startActivity(intent);
                    }
                    else if(check_jacket2.isChecked()){
                        intent.putExtra("Case", "two");
                        startActivity(intent);
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(), "상품을 선택해주세요", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btn_hometopurchase.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(check_jacket1.isChecked()||check_jacket2.isChecked()){
                    if(check_jacket1.isChecked()&&check_jacket2.isChecked()) {
                        intent2.putExtra("Case", "both");
                        startActivity(intent2); }
                    else if(check_jacket1.isChecked()){
                        intent2.putExtra("Case", "one");
                        startActivity(intent2);
                    }
                    else if(check_jacket2.isChecked()){
                        intent2.putExtra("Case", "two");
                        startActivity(intent2);
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(), "상품을 선택해주세요", Toast.LENGTH_SHORT).show();
                }
            }
        }));
    }

}