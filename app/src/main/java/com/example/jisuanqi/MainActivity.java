package com.example.jisuanqi;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;

        import android.view.View;
        import android.view.View.OnClickListener;
        import android.widget.Button;
        import android.widget.TextView;
        import android.widget.Toast;




public class MainActivity extends Activity {

    // 私有变量
    private int option = 0;
    private boolean newdigital = true;
    private double a = 0, b = 0;
    private Button btnOne;
    private Button btnTwo;
    private Button btnThree;
    private Button btnFour;
    private Button btnFive;
    private Button btnSix;
    private Button btnSeven;
    private Button btnEight;
    private Button btnNine;
    private Button btnZero;
    private Button btnAdd;
    private Button btnCut;
    private Button btnMultiply;
    private Button btnDivide;
    private Button btnEqual;
    private Button btnSpot;
    private Button btnReset;
    private Button btnDel;
    private Button btnSqu;
    boolean clr_flag;    //判断et编辑文本框中是否清空

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 初始化控件
        btnOne = (Button) findViewById(R.id.one);
        btnTwo = (Button) findViewById(R.id.two);
        btnThree = (Button) findViewById(R.id.three);
        btnFour = (Button) findViewById(R.id.four);
        btnFive = (Button) findViewById(R.id.five);
        btnSix = (Button) findViewById(R.id.six);
        btnSeven = (Button) findViewById(R.id.seven);
        btnEight = (Button) findViewById(R.id.eight);
        btnNine = (Button) findViewById(R.id.nine);
        btnZero = (Button) findViewById(R.id.zero);
        btnAdd = (Button) findViewById(R.id.add);
        btnCut = (Button) findViewById(R.id.cut);
        btnMultiply = (Button) findViewById(R.id.multiply);
        btnDivide = (Button) findViewById(R.id.divide);
        btnEqual = (Button) findViewById(R.id.equal);
        btnSpot = (Button) findViewById(R.id.spot);
        btnReset = (Button) findViewById(R.id.reset);
        btnDel = (Button) findViewById(R.id.del);
        btnSqu = (Button) findViewById(R.id.squ);

        btnOne.setOnClickListener(lisenter);
        btnTwo.setOnClickListener(lisenter);
        btnThree.setOnClickListener(lisenter);
        btnFour.setOnClickListener(lisenter);
        btnFive.setOnClickListener(lisenter);
        btnSix.setOnClickListener(lisenter);
        btnSeven.setOnClickListener(lisenter);
        btnEight.setOnClickListener(lisenter);
        btnNine.setOnClickListener(lisenter);
        btnZero.setOnClickListener(lisenter);
        btnAdd.setOnClickListener(lisenter);
        btnCut.setOnClickListener(lisenter);
        btnMultiply.setOnClickListener(lisenter);
        btnDivide.setOnClickListener(lisenter);
        btnEqual.setOnClickListener(lisenter);
        btnReset.setOnClickListener(lisenter);
        btnSpot.setOnClickListener(lisenter);
        btnDel.setOnClickListener(lisenter);
        btnSqu.setOnClickListener(lisenter);
    }


    private OnClickListener lisenter = new OnClickListener() {//点击事件

        public void onClick(View v) {

            TextView text = (TextView) findViewById(R.id.text);
            String s = text.getText().toString();
            Button btn = (Button) v;
            String t = (String) btn.getText();
            if (btn.getId() == R.id.zero || btn.getId() == R.id.one
                    || btn.getId() == R.id.two || btn.getId() == R.id.three
                    || btn.getId() == R.id.four || btn.getId() == R.id.five
                    || btn.getId() == R.id.six || btn.getId() == R.id.seven
                    || btn.getId() == R.id.eight || btn.getId() == R.id.nine) {
                if (newdigital) {
                    text.setText(s + t);
                } else {
                    text.setText(s);
                    newdigital = false;
                }
                return;
            }

            // 加
            if (btn.getId() == R.id.add) {
                a = Double.parseDouble(s);
                option = 1;
                text.setText("");
                return;

            }

            // 减
            if (btn.getId() == R.id.cut) {
                a = Double.parseDouble(s);
                option = 2;
                text.setText("");
                return;
            }

            // 乘
            if (btn.getId() == R.id.multiply) {
                a = Double.parseDouble(s);
                option = 3;
                text.setText("");
                return;
            }

            // 除
            if (btn.getId() == R.id.divide){
                a = Double.parseDouble(s);
                option = 4;
                text.setText("");
                return;
            }
            //x的y次方
            if (btn.getId() == R.id.squ){
                a = Double.parseDouble(s);
                option = 5;
                text.setText("");
                return;
            }

            // 清除
            if (btn.getId() == R.id.reset){//清空全部
                a = 0;
                b = 0;
                option = 0;
                newdigital = true;
                text.setText("");
                return;
            }
            if (btn.getId()==R.id.del){//删除
                if(clr_flag){
                    clr_flag=false;
                    s="";
                    text.setText("");
                }
                else if(s!=null&&!s.equals("")){
                    text.setText(s.substring(0,s.length()-1));
                }
                return;
            }

            // .
            if (btn.getId() == R.id.spot){
                if (s.indexOf(".") == -1)
                    if (s.trim().startsWith("0")) {
                        text.setText("0.");
                        newdigital = true;
                    } else {
                        text.setText(s + ".");

                    }
                return;
            }

            // =
            if (btn.getId() == R.id.equal){
                b = Double.parseDouble(s);
                switch (option) {
                    case 1:
                        text.setText(String.valueOf(a + b));
                        break;
                    case 2:
                        text.setText(String.valueOf(a - b));
                        break;
                    case 3:
                        text.setText(String.valueOf(a * b));
                        break;
                    case 4: {
                        if (b != 0) {
                            text.setText(String.valueOf(a / b));
                        } else {
                            Toast.makeText(MainActivity.this, "除数不能为0",
                                    Toast.LENGTH_SHORT).show();
                            text.setText("");
                            a = 0;
                            b = 0;
                            option = 0;
                            newdigital = true;
                            return;
                        }
                        break;
                    }
                    case 5:
                        text.setText(String.valueOf(Math.pow(a, b)));
                        break;

                }
                return;
            }
        }

    };

}