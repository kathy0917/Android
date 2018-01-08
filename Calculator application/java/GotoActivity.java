package com.bignerdranch.android.calculator2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class GotoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goto);

       TextView goto_result = (TextView) findViewById(R.id.Res);

        /*인텐트를 사용해서 Calculator2 Activity로부터 result결과 값 전달받음.*/
        /*이 때 key로 설정한 값을 받음.*/
        Intent intent = getIntent();
        String data = intent.getStringExtra("key");

        /*goto_result라는 TextView에 전달받은 결과값 표시
        TextUtils : Text를 위한 Util을 제공해 줌.*/

        /*data변수가 빈 문자열이 아닐 경우 TextView에 data값도 함께 표시.
         data변수가 빈 문자열일 경우 TextView에 Result문자열만 표시.*/
        if(TextUtils.isEmpty(data)==false) {
            goto_result.setText("Result: " + data);
        }
        else{
            goto_result.setText("Result: ");
        }


        Button Cal = (Button)findViewById(R.id.Goto);
        Cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GotoActivity.this, MainActivity.class);

                startActivity(intent);
            }
        });
    }
}

