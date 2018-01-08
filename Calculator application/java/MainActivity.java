package com.bignerdranch.android.calculator2;

        import android.content.DialogInterface;
        import android.content.Intent;
        import android.os.Bundle;
        import android.support.v7.app.AlertDialog;
        import android.support.v7.app.AppCompatActivity;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;

/*Calculator2 Activity*/
public class MainActivity extends AppCompatActivity {
    EditText num1; //첫번째 값을 받는 EditText 변수.
    EditText num2; //두번째 값을 받는 EditText 변수.
    TextView result; //결과값을 화면에 표시하는 변수.
    double n1,n2; //숫자를 받는 변수.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num1 = (EditText) findViewById(R.id.num1);
        num2 = (EditText) findViewById(R.id.num2);
        result = (TextView) findViewById(R.id.result);

    }


    /*OptionsMenu*/
    public boolean onCreateOptionsMenu(Menu menu) {
                getMenuInflater().inflate(R.menu.menu, menu);
                return true;
            }
    public boolean onPrepareOptionsMenu(Menu menu) {
    return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
                int menu_id = item.getItemId();

                    switch (menu_id) {
                    case R.id.quitmenu:
                        /*quit버튼을 누르면 Dialog창이 실행됨.*/
                        final TextView result_text = (TextView) findViewById(R.id.result);
                        AlertDialog.Builder qu = new AlertDialog.Builder(MainActivity.this);
                        qu.setTitle("Caution");
                        qu.setMessage("계산을 종료하시겠습니까?");

                        /*Dialog창에서 Yes버튼을 눌렀을 때 발생하는 리스너*/
                        qu.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int i) {

                                /*인텐트를 사용해서 Calculator2Activity -> GotoAcitivity로 메시지 전달.*/
                                Intent intent = new Intent(MainActivity.this, GotoActivity.class);
                                /*메시지의 내용 : result_text라는 TextView의 값을 string값으로 전달.*/
                                /*이 때 키 값은 key로 설정함.*/
                                intent.putExtra("key", result_text.getText().toString());
                                setResult(intent);
                                finish();

                            }
                        });

                        /*Dialog창에서 No버튼을 눌렀을 때 발생하는 리스너*/
                        qu.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int i) {
                                dialog.dismiss(); //화면에서 다이얼로그를 종료.
                            }
                        });

                        qu.show();

                        return true;

                    /*reset버튼을 눌렀을 때 동작*/
                    case R.id.resetmenu:

                        num1.setText(null);
                        num2.setText(null);
                        result.setText(null);

                        return true;
                }
                return MainActivity.super.onOptionsItemSelected(item);
            }


            /*계산 버튼 눌렀을 때 동작하는 메서드 - xml코드에 메서드명을 명시함.*/
            public void add(View v) {
                n1 = Double.parseDouble(num1.getText().toString());
                n2 = Double.parseDouble(num2.getText().toString());
                result.setText(n1 + "+" + n2 + "=" + Double.toString(n1 + n2));
            }

            public void sub(View v) {
                n1 = Double.parseDouble(num1.getText().toString());
                n2 = Double.parseDouble(num2.getText().toString());
                result.setText(n1 + "-" + n2 + "=" + Double.toString(n1 - n2));
            }

            public void mul(View v) {
                n1 = Double.parseDouble(num1.getText().toString());
                n2 = Double.parseDouble(num2.getText().toString());
                result.setText(n1 + "*" + n2 + "=" + Double.toString(n1 * n2));
            }

            public void div(View v) {
                n1 = Double.parseDouble(num1.getText().toString());
                n2 = Double.parseDouble(num2.getText().toString());
                result.setText(n1 + "/" + n2 + "=" + Double.toString(n1 / n2));
            }
        }



