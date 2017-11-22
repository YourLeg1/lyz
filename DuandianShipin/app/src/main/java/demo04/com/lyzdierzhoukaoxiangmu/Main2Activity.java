package demo04.com.lyzdierzhoukaoxiangmu;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.MediaController;
import android.widget.VideoView;

public class Main2Activity extends AppCompatActivity {

    private VideoView video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        video = (VideoView) findViewById(R.id.video);
        Intent intent = getIntent();
        String shipin = intent.getStringExtra("shipin");
        Uri uri = Uri.parse(shipin);
        video.setMediaController(new MediaController(this));
        video.setVideoURI(uri);
        video.requestFocus();


    }
}
