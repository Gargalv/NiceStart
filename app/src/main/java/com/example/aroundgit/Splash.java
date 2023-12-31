package com.example.aroundgit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        openApp();

        ImageView thunder=findViewById(R.id.logoSplash);
        Animation myanim= AnimationUtils.loadAnimation(this,R.anim.blink);
        thunder.startAnimation(myanim);


        ImageView fondo=findViewById(R.id.fondo);

        Glide.with(this)
                .load("https://p4.wallpaperbetter.com/wallpaper/763/816/3/interstellar-movie-galaxy-stars-moon-planet-hd-wallpaper-preview.jpg")
                .transition(DrawableTransitionOptions.withCrossFade(50))
                .centerCrop()
                .placeholder(new ColorDrawable(this.getResources().getColor(R.color.teal_200)))
                .into(fondo);

    }

    private void openApp(){
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(Splash.this, LogIn.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        },5000);
    }
}