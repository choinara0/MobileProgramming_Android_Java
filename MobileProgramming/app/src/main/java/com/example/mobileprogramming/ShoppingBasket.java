package com.example.mobileprogramming;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ShoppingBasket extends AppCompatActivity {

    private ImageView image_basket1;
    private ImageView image_basket2;
    private Button btn_baskettohome;
    private Button btn_baskettopurchase;
    private TextView text_basket1;
    private TextView text_basket2;
    private TextView price_basket1;
    private TextView price_basket2;
    private CheckBox check_basket1;
    private CheckBox check_basket2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_basket);

        btn_baskettohome = findViewById(R.id.btn_baskettohome);
        btn_baskettopurchase = findViewById(R.id.btn_baskettopurchase);
        check_basket1 = findViewById(R.id.check_basket1);
        check_basket2 = findViewById(R.id.check_basket2);
        check_basket1.setVisibility(View.INVISIBLE);
        check_basket2.setVisibility(View.INVISIBLE);

        final Intent intent3 = getIntent();
        String getCase = getIntent().getStringExtra("Case");

        switch (getCase) {
            case "both":
                check_basket1.setVisibility(View.VISIBLE);
                check_basket2.setVisibility(View.VISIBLE);
                image_basket1 = findViewById(R.id.image_basket1);
                image_basket1.setImageResource(R.drawable.jacket1);
                image_basket2 = findViewById(R.id.image_basket2);
                image_basket2.setImageResource(R.drawable.jacket2);

                text_basket1 = findViewById(R.id.text_basket1);
                String str_basket1 = "상품명 : " + intent3.getStringExtra("String");
                text_basket1.setText(str_basket1);

                text_basket2 = findViewById(R.id.text_basket2);
                String str_basket2 =  "상품명 : " + intent3.getStringExtra("String2");
                text_basket2.setText(str_basket2);

                price_basket1 = findViewById(R.id.price_basket1);
                String pri_basket1 = "가격 : " + intent3.getStringExtra("Strprice");
                price_basket1.setText(pri_basket1);

                price_basket2 = findViewById(R.id.price_basket2);
                String pri_basket2 = "가격 : " + intent3.getStringExtra("Strprice2");
                price_basket2.setText(pri_basket2);

                break;

            case "one":
                check_basket1.setVisibility(View.VISIBLE);
                image_basket1 = findViewById(R.id.image_basket1);
                image_basket1.setImageResource(R.drawable.jacket1);

                TextView text_basket3 = findViewById(R.id.text_basket1);
                String str_basket3 = "상품명 : " + intent3.getStringExtra("String");
                text_basket3.setText((str_basket3));

                price_basket1 = findViewById(R.id.price_basket1);
                String pri_basket3 = "가격 : " + intent3.getStringExtra("Strprice");
                price_basket1.setText(pri_basket3);

                break;

            case "two":
                check_basket1.setVisibility(View.VISIBLE);
                image_basket1 = findViewById(R.id.image_basket1);
                image_basket1.setImageResource(R.drawable.jacket2);
                TextView text_basket4 = findViewById(R.id.text_basket1);
                String str_basket4 = "상품명 : " + intent3.getStringExtra("String2");
                text_basket4.setText(str_basket4);

                price_basket1 = findViewById(R.id.price_basket1);
                String pri_basket4 = "가격 : " + intent3.getStringExtra("Strprice2");
                price_basket1.setText(pri_basket4);
        }

        btn_baskettohome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent4);
            }
        });

        btn_baskettopurchase.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent5 = new Intent(getApplicationContext(), Purchase.class);
                intent5.putExtra("String", intent3.getStringExtra("String"));
                intent5.putExtra("String2", intent3.getStringExtra("String2"));
                intent5.putExtra("Strprice", intent3.getStringExtra("Strprice"));
                intent5.putExtra("Strprice2", intent3.getStringExtra("Strprice2"));

                if(check_basket1.isChecked()||check_basket2.isChecked()) {
                    switch(intent3.getStringExtra("Case")){
                        case "both":
                            if(check_basket1.isChecked()&&check_basket2.isChecked()){
                                intent5.putExtra("Case", "both");
                                startActivity(intent5);
                            }
                            else if(check_basket1.isChecked()){
                                intent5.putExtra("Case", "one");
                                startActivity(intent5);
                            }
                            else if(check_basket2.isChecked()){
                                intent5.putExtra("Case", "two");
                                startActivity(intent5);
                            }
                            break;
                        case "one":
                            if(check_basket1.isChecked()){
                                intent5.putExtra("Case", "one");
                                startActivity(intent5);
                            }
                            else{
                                Toast.makeText(getApplicationContext(), "상품을 선택해주세요", Toast.LENGTH_SHORT).show();
                            }
                            break;
                        case "two":
                            if(check_basket1.isChecked()){
                                intent5.putExtra("Case", "two");
                                startActivity(intent5);
                            }
                            else{
                                Toast.makeText(getApplicationContext(), "상품을 선택해주세요", Toast.LENGTH_SHORT).show();
                            }
                            break;
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(), "상품을 선택해주세요", Toast.LENGTH_SHORT).show();
                }
            }
        }));
    }

}