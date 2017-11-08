package demo04.com.frescostudy;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.facebook.drawee.view.SimpleDraweeView;

public class MainActivity extends AppCompatActivity {
    String url ="http://h.hiphotos.baidu.com/image/pic/item/0df431adcbef7609f486005527dda3cc7dd99e6f.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //找控件
        SimpleDraweeView sdv = (SimpleDraweeView) findViewById(R.id.sdv);
        //把网络图片地址转换成Uri
        Uri uri = Uri.parse(url);
        //显示图片
        sdv.setImageURI(uri);
    }
}
