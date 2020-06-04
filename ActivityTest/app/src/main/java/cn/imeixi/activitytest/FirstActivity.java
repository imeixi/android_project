package cn.imeixi.activitytest;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    private static final String TAG = "FirstActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        Button button1 = findViewById(R.id.button_1_1);
        button1.setOnClickListener(new View.OnClickListener() {
            //          显示调用Intent
            @Override
            public void onClick(View v) {
                Toast.makeText(FirstActivity.this, "You click Button 1",
                        Toast.LENGTH_SHORT).show();

                String data = "Hello SecondActivity!";
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                intent.putExtra("extra_data", data);
                startActivity(intent);

                Log.d(TAG, "onClick: send message to second activity");
            }
        });

        //隐示调用Intent
        Button button2 = findViewById(R.id.button_1_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("ACTION_START");
                intent.addCategory("MY_CATEGORY");
                startActivity(intent);
            }
        });

        //跳转到网页,使用默认浏览器
        Button button3 = findViewById(R.id.button_1_3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.baidu.com"));
                intent.setData(Uri.parse("openapp.jdmobile://virtual?params={\"category\":\"jump\",\"des\":\"productDetail\",\"sourceValue\":\"sourceValue_test\",\"sourceType\":\"sourceType_test\",\"skuId\":\"1217501\"}"));
                startActivity(intent);
            }
        });

        //跳转到网页，指定chrome浏览器
        Button button4 = findViewById(R.id.button_1_4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                //                intent.setData(Uri.parse("http://www.baidu.com"));
                intent.setData(Uri.parse("https://h5.m.jd.com/babelDiy/Zeus/3ii5tgLwwPTAMBBqcCZpbEc6nYrh/index.html"));
                // 设置chrome为默认打开到浏览器
                intent.setClassName("com.android.chrome", "com.google.android.apps.chrome.Main");
                startActivity(intent);
            }
        });
        //跳转到网页
        Button button5 = findViewById(R.id.button_1_5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //                Intent intent = new Intent(Intent.ACTION_VIEW);
                //                intent.setData(Uri.parse("http://www.baidu.com"));
                Uri uri = Uri.parse("https://www.baidu.com");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(Intent.createChooser(intent, "选择浏览器"));
            }
        });

        Button buttonClose = findViewById(R.id.close);
        buttonClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();  //销毁activity
            }
        });
    }

    //    创建菜单
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    //    定义菜单选中行为
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(FirstActivity.this, "You click Add.", Toast.LENGTH_LONG).show();
                break;
            case R.id.remove_item:
                Toast.makeText(FirstActivity.this, "You click Remove.", Toast.LENGTH_LONG).show();
                break;
            case R.id.close_item:
                finish();
                break;
            default:
        }
        return true;
    }
}
