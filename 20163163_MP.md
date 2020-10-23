# Project Indroduce

- **상품 선택 페이지** : Relative Layout 사용
  - 2개의 상품의 이미즈를 화면에 출력하고 상품의 제품명, 가격 정보 표시
  - 각 상품을 체크박스를 통해 선택하고 아래에 버튼으로 구매 혹은 장바구니 버튼을 클릭
  - 상품을 하나도 선택하지 않고 장바구니 또는 구매 버튼을 클릭하면 메시지를 출력
  - 장바구니 버튼을 클릭하면 장바구니 페이지로 이동
  - 구매 버튼을 클릭하면 구매 페이지로 이동
- **장바구니 페이지** : Linear Layout 사용
  - 상품 선택 페이지에서 선택한 상품의 이미지를 출력하고 상품의 제품명, 가격 정보 표시
  - 각 상품을 체크박스를 통해 선택하고 구매하기 버튼을 누르면 구매 페이지로 이동
  - 상품을 하나도 선택하지 않고 구매 버튼을 클릭하면 메시지를 출력
  - 홈으로 가기 버튼을 누르면 상품 선택 페이지로 이동
- **구매 페이지** : Table Layout 사용
  - 상품 선택 페이지나 장바구니 페이지에서 선택한 상품의 제품명, 가격 정보와 결재할 액수를 출력
  - 주소 정보와 연락처를 입력하는 창을 출력. 주소 정보나 연락처를 입력하지 않으면 메시지 출력
  - 구매 버튼을 누르면 첫 번째 페이지로 이동
  - 홈으로 가기 버튼을 누르면 상품 선택 페이지로 이동

# Development Environment & Version

- Android Grandle Plugin Version : 4.0.1
- Grandle Version : 6.1.1
- Compile SDK version : 29 (API 29 : Android 10.0(Q))
- Build Tools Version : 30.0.2
- minSdkVersion : 21
- TargetSdkVersion : 29
- Development OS : macOS Catelina 10.15.7

## Code Explain

**구매 페이지**

```Java
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
```

-상품을 선택하고 장바구니, 구매페이지로 넘어가기 위한 intent를 2개 만들었다.

-각 intent에 상품명과 가격을 넣어주었다.

```java
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
```

-장바구니에 담기 버튼이나 구매하기 버튼을 클릭하면 check_jacket1, check_jacket2를 이용하여 선택된 상품에 따라서 intent에 "Case"에 String value를 넘겨준다.

-이 Case에 따라서 장바구니 페이지와 구매 페이지가 작동한다.

**장바구니 페이지**

```java
final Intent intent3 = getIntent();
String getCase = getIntent().getStringExtra("Case");
```

-상품 선택 페이지에서 넘겨준 intent를 받아오고, "Case"에 담긴 String value를 String 변수 getCase에 담는다.

```java
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
```

-getCase를 통해 어떤 상품이 선택됐느냐에 따라서 다른 처리를 해준다.

-getCase를 통해 상품 선택 페이지에서 선택된 상품의 이미지, 상품명, 가격정보를 출력하고 해당 상품의 수만큼 checkbox의 속성을 VISIBLE로 바꾼다.

```java
btn_baskettohome.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent4 = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent4);
    }
});
```

-홈으로 가기 버튼을 클릭하면 상품 선택 페이지로 이동한다.



```java
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
```

-상품을 선택하고 구매하기 버튼을 누르면 체크박스를 통해 어떤 상품을 선택했냐에 따라 intent의 "Case"에 다른 값을 넣어주고 구매하기 페이지로 이동한다.

-상품을 선택하지 않고 구매하기 버튼을 누르면 상품을 메시지를 출력한다.



**구매 페이지**

```java
Intent intent2 = getIntent();
String getCase = getIntent().getStringExtra("Case");
```

-상품 선택 페이지나 장바구니 페이지에서 넘겨준 intent를 받는다.



```java
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
```

-getCase를 통해 어떤 상품이 선택됐느냐에 따라서 다른 처리를 해준다.

-getCase를 통해 전 페이지에서 선택된 상품의 상품명, 가격정보를 출력하고 총 결재할 금액을 출력한다.



```java
btn_purchasetohome.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent4 = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent4);
    }
});
```

-홈으로 가기 버튼을 누르면 상품 선택 페이지로 이동한다.



```java
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
```

-주소 정보나 연락처를 입력하지 않고 구매하기 버튼을 누르면 메시지를 출력한다.

-주소 정보와 연락처를 입력하고 구매하기 버튼을 누르면 메시지를 출력하고 상품 선택 페이지로 이동한다. 



## Screenshot


<div>
  <img width="475" alt="스크린샷 2020-10-22 오후 4 46 06" src="https://user-images.githubusercontent.com/26623611/96971452-12afa500-1550-11eb-82ff-e4b78b247bf5.png">
  <img width="475" alt="스크린샷 2020-10-22 오후 4 46 16" src="https://user-images.githubusercontent.com/26623611/96971455-13e0d200-1550-11eb-9c2b-0da597df8a78.png">
  <img width="475" alt="스크린샷 2020-10-22 오후 4 46 24" src="https://user-images.githubusercontent.com/26623611/96971461-15aa9580-1550-11eb-9847-2e0f48530bd0.png">
</div>


## 개발 후 느낀 점

- 데이터베이스를 연동하지 못한 점에서 아쉽다. 추후에 팀 프로젝트에서는 데이터베이스를 연동할 수 있게 공부를 할 계획이다.
- 여러 Layout을 사용해서 Activity를 구성을 해서 공부에 도움이 더 되었다.
- 인텐트를 통해 TextView 등을 넘기고 받는 과정을 단순화할 필요가 있다고 느꼈다.

