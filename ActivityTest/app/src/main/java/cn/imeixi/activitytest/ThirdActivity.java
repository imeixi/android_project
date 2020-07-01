package cn.imeixi.activitytest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ThirdActivity extends BaseActivity {

    private static final String TAG = "ThirdActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        Log.d(TAG, "Task id is: " + getTaskId());

        Button button = findViewById(R.id.button_3_1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 添加返回数据，销毁前吧数据返回给前一个Activity
                Intent intent = new Intent();
                intent.putExtra("msg", "Hello, This is from ThirdActivity return to First Activity");
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        Button button2 = findViewById(R.id.button_3_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityCollector.finishAll();
            }
        });
    }

    @Override
    public void onBackPressed() {
        //添加返回数据，销毁前吧数据返回给前一个Activity
        Intent intent = new Intent();
        intent.putExtra("msg", "Hello, This Message is from ThirdActivity return to First Activity");
        setResult(RESULT_OK, intent);
        finish();
    }
}
