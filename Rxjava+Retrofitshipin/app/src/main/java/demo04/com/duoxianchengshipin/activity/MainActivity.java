package demo04.com.duoxianchengshipin.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import demo04.com.duoxianchengshipin.MyCustomCircleArrowView;
import demo04.com.duoxianchengshipin.R;

public class MainActivity extends AppCompatActivity {
    private MyCustomCircleArrowView myCustomCircleArrowView;
    private int speed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myCustomCircleArrowView = (MyCustomCircleArrowView) findViewById(R.id.my_view);

    }

    public void onClick(View view) {
        myCustomCircleArrowView.setColor(Color.BLUE);
    }

    public void add(View view) {
        speed = myCustomCircleArrowView.speed();

        if (speed==10){
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        }
    }

    public void slow(View view) {
        myCustomCircleArrowView.slowDown();
    }


    public void pauseOrStart(View view) {
        myCustomCircleArrowView.pauseOrStart();
    }
}
