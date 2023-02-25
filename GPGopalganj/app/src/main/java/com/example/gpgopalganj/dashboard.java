package com.example.gpgopalganj;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toolbar;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.gpgopalganj.ui.myadapter;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;

public class dashboard extends AppCompatActivity {

    ImageSlider imageSlider;
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    RelativeLayout relativeLayout1,relativeLayout2,relativeLayout3,relativeLayout4,relativeLayout5,relativeLayout6,relativeLayout7,relativeLayout8;

//    Toolbar toolbar;
//    DrawerLayout drawerLayout;
//    ActionBarDrawerToggle toggle;
//    NavigationView navigationView;
//    ViewPager viewPager;
//    Button button;
//    Fragment fragment = null;

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.sidemenu,menu);
//        return super.onCreateOptionsMenu(menu);
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();

        relativeLayout1 = findViewById(R.id.relative1);
        relativeLayout2 = findViewById(R.id.relative2);
        relativeLayout3 = findViewById(R.id.relative3);
        relativeLayout4 = findViewById(R.id.relative4);
        relativeLayout5 = findViewById(R.id.relative5);
        relativeLayout6 = findViewById(R.id.relative6);
        relativeLayout7 = findViewById(R.id.relative7);
        relativeLayout8 = findViewById(R.id.relative8);

        //viewPager image slide
//        viewPager = findViewById(R.id.viewPager);
//        List<Integer> imageList = new ArrayList<>();
//        imageList.add(R.drawable.gpgf);
//        imageList.add(R.drawable.gpgfront);
//        imageList.add(R.drawable.recentd);
//        imageList.add(R.drawable.gpgg);
//        imageList.add(R.drawable.princ);
//        myadapter myad = new myadapter(imageList);
//        viewPager.setAdapter(myad);

        //Image Slider
        imageSlider = findViewById(R.id.imageSlider);
        ArrayList<SlideModel> slideModels = new ArrayList<>();
        //slideModels.add(new SlideModel("https://www.gpgopalganj.ac.in/wp-content/uploads/sites/41/2021/08/file_6119248ad53d7.jpg", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://www.gpgopalganj.ac.in/wp-content/uploads/sites/41/2021/04/6bb7d95d-69b3-4fb5-acc7-aff84dd3ea77.jpg", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://www.gpgopalganj.ac.in/wp-content/uploads/sites/41/2022/02/file_6219d03f8e81c-scaled.jpg", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://www.gpgopalganj.ac.in/wp-content/uploads/sites/41/2022/01/file_61dc3be4e006c.jpg", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://www.gpgopalganj.ac.in/wp-content/uploads/sites/41/2022/01/file_61dc3c0c35ff6.jpg", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://www.gpgopalganj.ac.in/wp-content/uploads/sites/41/2022/01/file_61dc3afe2fdde.jpg", ScaleTypes.FIT));
        imageSlider.setImageList(slideModels,ScaleTypes.FIT);



//        toolbar = findViewById(R.id.toolbar);
//        drawerLayout = findViewById(R.id.drawerLayout);
//        navigationView = findViewById(R.id.navigationview);
////        navigationView.setItemIconTintList(null);
//        setSupportActionBar(toolbar);
//        toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
//        drawerLayout.addDrawerListener(toggle);
//        toggle.syncState();
//        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//
//                int id = item.getItemId();
//                switch (id){
//                    case R.id.nav_home:
//                        startActivity(new Intent(getApplicationContext(),dashboard.class));
//                        overridePendingTransition(0,0);
//                        break;
//                    case R.id.nav_logout:
//                        break;
//                    default:
//                        return true;
//                }
//                drawerLayout.closeDrawer(GravityCompat.START);
//                return true;
//            }
//        });

        relativeLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),dipartment.class));
            }
        });
        relativeLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),gallery.class));
            }
        });
        relativeLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),about.class));
            }
        });
        relativeLayout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),notice.class));
            }
        });
        relativeLayout5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),contact.class));
            }
        });
        relativeLayout6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), faq.class));
            }
        });
        relativeLayout7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),principal.class));
            }
        });
        relativeLayout8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ai.class));
            }
        });

    }

    @Override
    public void onBackPressed() {
//        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
//            drawerLayout.closeDrawer(GravityCompat.START);
//        }else {
//            super.onBackPressed();
//        }

        new AlertDialog.Builder(this).setMessage("Are you sure want to exit?").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        }).setNegativeButton("No",null).show();

    }
//    private void loadFragment(Fragment fragment){
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.replace(R.id.frame,fragment).commit();
//        drawerLayout.closeDrawer(GravityCompat.START);
//        fragmentTransaction.addToBackStack(null);
//    }

    public void logout(View v){
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(), Login.class));
        finish();
    }


}