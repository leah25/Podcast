package com.example.podcast;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private Sound[] soundList;
    private SoundAdapter soundAdapter;
    private MediaPlayer mediaPlayer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.track_list_view);
        loadMusic();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                loadMusic();
                Sound sound = soundList[i];
                if(mediaPlayer!= null){
                    if(mediaPlayer.isPlaying()){
                        mediaPlayer.stop();
                        mediaPlayer.reset();
                        sound.setPlaying(false);
                    }
                }try {
                    mediaPlayer = MediaPlayer.create(MainActivity.this, sound.getId());
                    if(mediaPlayer.isPlaying()){
                        mediaPlayer.stop();
                        mediaPlayer.reset();
                        sound.setPlaying(false);
                    }else {
                        mediaPlayer.start();
                        sound.setPlaying(true);
                    }

                }catch (Exception e){
                    Log.e("Exception", e.getMessage());

                }



            }
        });
    }

    public void loadMusic(){
        soundList = new Sound[]{
                new Sound("3 min",R.raw.both,false,"3:40","First Music Track"),
                new Sound("3 min",R.raw.soul,false,"3:40","Second Music Track"),
                new Sound("3 min",R.raw.water,false,"3:40","Third Music Track"),
        };
        soundAdapter = new SoundAdapter( MainActivity.this, soundList);
        listView.setAdapter(soundAdapter);
        soundAdapter.notifyDataSetChanged();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mediaPlayer!= null){
            if(mediaPlayer.isPlaying()){
                mediaPlayer.stop();
                mediaPlayer.reset();

            }
        }
    }
}