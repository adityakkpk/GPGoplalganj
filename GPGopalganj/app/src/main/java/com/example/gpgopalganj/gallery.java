package com.example.gpgopalganj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class gallery extends AppCompatActivity {
    RelativeLayout relativeLayoutPic1,relativeLayoutPic2,relativeLayoutPic3,relativeLayoutPic4,relativeLayoutPic5,relativeLayoutPic6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        relativeLayoutPic1 = findViewById(R.id.relative1);
        relativeLayoutPic2 = findViewById(R.id.relative2);
        relativeLayoutPic3 = findViewById(R.id.relative3);
        relativeLayoutPic4 = findViewById(R.id.relative4);
        relativeLayoutPic5 = findViewById(R.id.relative5);
        relativeLayoutPic6 = findViewById(R.id.relative6);


        relativeLayoutPic1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), pica.class));
            }
        });
        relativeLayoutPic2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), picb.class));
            }
        });
        relativeLayoutPic3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), picc.class));
            }
        });
        relativeLayoutPic4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), picd.class));
            }
        });
        relativeLayoutPic5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), pice.class));
            }
        });
//        relativeLayoutPic6.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getApplicationContext(), picf.class));
//                Toast.makeText(gallery.this, "Development is in under Process", Toast.LENGTH_SHORT).show();
//            }
//        });
    }
}