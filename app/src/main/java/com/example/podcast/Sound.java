package com.example.podcast;

public class Sound {
    private  int id;
    private String name;
    private boolean isPlaying;
    private String time;
    private String duration;

   public Sound( String duration, int id, boolean isPlaying, String time, String name)
   {
       this.name =name;
       this.duration = duration;
       this.isPlaying = isPlaying;
       this.id= id;
       this.time = time;
   };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    public void setPlaying(boolean playing) {
        isPlaying = playing;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
