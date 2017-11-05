package demo04.com.lyz11_04lianxi;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private RadioGroup radio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radio = (RadioGroup) findViewById(R.id.radio);
        radio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                switch (i){
                    case R.id.bt1:
                        getFragment(new One());
                        break;
                    case R.id.bt2:
                        getFragment(new Two());
                        break;
                    case R.id.bt3:
                        getFragment(new Three());
                        break;
                    case R.id.bt4:
                        getFragment(new Four());
                        break;
                    case R.id.bt5:
                        getFragment(new Five());
                        break;
                }
            }
        });




    }

    private void getFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame,fragment).commit();
    }
}
