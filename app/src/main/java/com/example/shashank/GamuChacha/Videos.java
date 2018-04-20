package com.example.shashank.GamuChacha;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.Vector;

public class Videos extends AppCompatActivity {

    RecyclerView recyclerView;

    Vector<YoutubeVideo> youtubeVideos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //LOAD VIDEO LIST
        youtubeVideos.add(new YoutubeVideo("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/H5liStrbZsg\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>")); //set width and height to 100%
        youtubeVideos.add(new YoutubeVideo("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/9oyMGiF8Hp4\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>"));
        youtubeVideos.add(new YoutubeVideo("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/sqRKVJwBzOg\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>"));
        youtubeVideos.add(new YoutubeVideo("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/e_GmQ0IF3ts\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>"));
        youtubeVideos.add(new YoutubeVideo("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/kUvAdfzYj9I\" frameborder=\"0\" allow=\"autoplay; encrypted-media\" allowfullscreen></iframe>"));

        VideoAdapter videoAdapter = new VideoAdapter(youtubeVideos);

        recyclerView.setAdapter(videoAdapter);
    }
}
