package com.example.shashank.GamuChacha;

/**
 * Created by shashank on 2/9/2018.
 */

public class YoutubeVideo {

    String videoUrl;

    public YoutubeVideo() {
    }

    public YoutubeVideo(String videoUrl) {

        this.videoUrl = videoUrl;
    }

    public String getVideoUrl() {

        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
}
