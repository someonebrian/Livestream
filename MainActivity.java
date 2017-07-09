package com.brian.livestream;


import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.VideoView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    EditText rtspUrl ;
    Button playButton ;
    VideoView videoView ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //rtsp://54.169.166.180:1935/live/myStream
        rtspUrl = (EditText)this.findViewById(R.id.editText);
        playButton = (Button)this.findViewById(R.id.playButton);
        playButton.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
                PlayRtspStream(rtspUrl.getEditableText().toString());
            }
        });

        videoView = (VideoView)this.findViewById(R.id.rtspVideo);

    }

    //play rtsp stream
    private void PlayRtspStream(String rtspUrl){
        videoView.setVideoURI(Uri.parse(rtspUrl));
        videoView.requestFocus();
        videoView.start();
    }



}
