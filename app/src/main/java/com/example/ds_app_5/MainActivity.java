package com.example.ds_app_5;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    View firstLine, secondLine, thirdLine, fourthLine;
    ImageView ivLogo;
    Animation top_to_down_anim, bouncing_animation,left_to_right_anim;
    TextView TvSlogan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();

        TvSlogan.setAnimation(left_to_right_anim);
        firstLine.setAnimation(top_to_down_anim);
        secondLine.setAnimation(top_to_down_anim);
        thirdLine.setAnimation(top_to_down_anim);
        fourthLine.setAnimation(top_to_down_anim);
        ivLogo.setAnimation(bouncing_animation);

        new Handler().postDelayed(()->{
            Intent i = new Intent(MainActivity.this, Home.class);
            startActivity(i);
            finish();
        }, 3000);
    }

    private void init()
    {
        firstLine = findViewById(R.id.firstLine);
        secondLine = findViewById(R.id.secondLine);
        thirdLine = findViewById(R.id.thirdLine);
        fourthLine = findViewById(R.id.fourthLine);
        ivLogo = findViewById(R.id.ivLogo);
        TvSlogan=findViewById(R.id.tvSlogan);

        top_to_down_anim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.top_to_down_animation);
        bouncing_animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.bouncing_animation);
        left_to_right_anim=AnimationUtils.loadAnimation(MainActivity.this,R.anim.left_to_right_animation);
    }
}