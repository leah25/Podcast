package com.example.podcast;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class SoundAdapter  extends BaseAdapter {
    private Context context;
    private Sound[] sound;

    SoundAdapter(Context context, Sound[] sound){
        this.context = context;
        this.sound = sound;
    }


    @Override
    public int getCount() {
        return sound.length;
    }

    @Override
    public Object getItem(int i) {
        return sound[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Sound sounds = (Sound) getItem(i);
         ViewHolder holder ;

        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.sound_item,viewGroup, false);
            holder = new ViewHolder();
            holder.trackImage = view.findViewById(R.id.track_image);
            holder.titleText = view.findViewById(R.id.track_title);
            view.setTag(holder);
        }
        else{

           holder = (ViewHolder) view.getTag();


        }
        holder.titleText.setText(sounds.getName());

        if(sounds.isPlaying())
        {
            holder.trackImage.setImageResource(R.drawable.ic_pause);
        }else{
            holder.trackImage.setImageResource(R.drawable.ic_play);

        }
        return view;
    }

    static class  ViewHolder{

        ImageView trackImage;
        TextView titleText;


    }
}
