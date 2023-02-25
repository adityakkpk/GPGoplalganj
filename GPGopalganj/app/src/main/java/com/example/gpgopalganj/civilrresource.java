package com.example.gpgopalganj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class civilrresource extends AppCompatActivity {
    RelativeLayout relativeLayout1,relativeLayout2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_civilrresource);

        relativeLayout1 = findViewById(R.id.relative1);
        relativeLayout2 = findViewById(R.id.relative2);

        relativeLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),civilrclassroom.class));
            }
        });
        relativeLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),civilrlab.class));
            }
        });
    }
}