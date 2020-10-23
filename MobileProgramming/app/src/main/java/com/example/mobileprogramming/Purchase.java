package com.example.mobileprogramming;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Purchase extends AppCompatActivity {
    private TextView text_purchase1;
    private TextView text_purchase2;
    private TextView price_purchase1;
    private TextView price_purchase2;
    private TextView total_price;
    private Button btn_purchasetohome;
    private Button btn_purchasetoend;
    private EditText input_adr;
    private EditText input_pn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase);
        total_price = findViewById(R.id.total_price);
        btn_purchasetoend = findViewById(R.id.btn_purchasetoend);
        btn_purchasetohome = findViewById(R.id.btn_purchasetohome);
        input_adr = findViewById(R.id.input_adr);
        input_pn = findViewById(R.id.input_pn);

        Intent intent2 = getIntent();
        String getCase = getIntent().getStringExtra("Case");


        switch (getCase) {
            case "both":

                text_purchase1 = (TextView)findViewById(R.id.text_purchase1);
                String str_purchase1 = intent2.getStringExtra("String");
                text_purchase1.setText(str_purchase1);

                text_purchase2 = (TextView)findViewById(R.id.text_purchase2);
                String str_purchase2 = intent2.getStringExtra("String2");
                text_purchase2.setText(str_purchase2);

                price_purchase1 = (TextView)findViewById(R.id.price_purchase1);
                String pri_purchase1 = intent2.getStringExtra("Strprice");
                price_purchase1.setText(pri_purchase1);

                price_purchase2 = (TextView)findViewById(R.id.price_purchase2);
                String pri_purchase2 = intent2.getStringExtra("Strprice2");
                price_purchase2.setText(pri_purchase2);

                int temp = Integer.parseInt(pri_purchase1);
                int temp2 = Integer.parseInt(pri_purchase2);
                int result = temp + temp2;
                total_price.setText(String.valueOf(result));

                break;

            case "one":

                text_purchase1 = findViewById(R.id.text_purchase1);
                String str_purchase3 = intent2.getStringExtra("String");
                text_purchase1.setText(str_purchase3);

                price_purchase1 = findViewById(R.id.price_purchase1);
                String pri_purchase3 = intent2.getStringExtra("Strprice");
                price_purchase1.setText(pri_purchase3);
                total_price.setText(pri_purchase3);



                break;

            case "two":

                text_purchase2 = findViewById(R.id.text_purchase2);
                String str_purchase4 = intent2.getStringExtra("String2");
                text_purchase2.setText(str_purchase4);

                price_purchase2 = findViewById(R.id.price_purchase2);
                String pri_purchase4 = intent2.getStringExtra("Strprice2");
                price_purchase2.setText(pri_purchase4);
                total_price.setText(pri_purchase4);

        }
        btn_purchasetohome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent4);
            }
        });
        btn_purchasetoend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if(input_adr.getText().toString().length() == 0){
                   Toast.makeText(getApplicationContext(), "주소를 입력해주세요", Toast.LENGTH_SHORT).show();
               }else if(input_pn.getText().toString().length() ==0){
                   Toast.makeText(getApplicationContext(), "연락처를 입력해주세요", Toast.LENGTH_SHORT).show();
               }
                else{
                   Toast.makeText(getApplicationContext(), "구매에 완료했습니다", Toast.LENGTH_SHORT).show();
                   Intent intent4 = new Intent(getApplicationContext(), MainActivity.class);
                   startActivity(intent4);
               }
            }
        });
    }
}