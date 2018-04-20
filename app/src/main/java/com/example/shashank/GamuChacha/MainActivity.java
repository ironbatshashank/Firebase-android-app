package com.example.shashank.GamuChacha;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        //fab.setOnClickListener(new View.OnClickListener() {
          //  @Override
           // public void onClick(View view) {
          //      Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
            //            .setAction("Action", null).show();
        //    }
        //});

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

     @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
         if (id == R.id.Fb) {

            Intent facebookIntent = getOpenFacebookIntent(MainActivity.this);
            startActivity(facebookIntent);
        } else if (id == R.id.Insta) {
            Intent instagramIntent = getOpenInstagramIntent(MainActivity.this);
            startActivity(instagramIntent);
        }


        return super.onOptionsItemSelected(item);
    }

    public static Intent getOpenFacebookIntent(Context context) {

        try {
            context.getPackageManager()
                    .getPackageInfo("com.facebook.android", 0); //Checks if FB is even installed.
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("fb://page/Gamuchacha20")); //Trys to make intent with FB's URI
        } catch (Exception e) {
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.facebook.com/Shashanksrivastava")); //catches and opens a url to the desired page
        }
    }

    public static Intent getOpenInstagramIntent(Context context) {

        try {
            context.getPackageManager()
                    .getPackageInfo("com.instagram.android", 0); //Checks if Instagram is even installed.
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.instagram.com/accounts/login/")); //Trys to make intent with Instagram's URI
        } catch (Exception e) {
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.instagram.com/shashank_.srivastava")); //catches and opens a url to the desired page
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.home) {
            // Handle the camera action

            Intent myIntent = new Intent(this, MainActivity.class);
            startActivity(myIntent);

        } else if (id == R.id.upload) {

            Intent myIntent = new Intent(this, UploadActivity.class);
            startActivity(myIntent);

        } else if (id == R.id.data) {

            Intent myIntent = new Intent(this, BaseLayout.class);
            startActivity(myIntent);

        } else if (id == R.id.share) {

            Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            String shareBody = "Your body here";
            String shareSub = "Your subject here";
            sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, shareSub);
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
            startActivity(Intent.createChooser(sharingIntent, "Share using"));

        } else if (id == R.id.help) {

            Intent myIntent = new Intent(this, HelpSupport.class);
            startActivity(myIntent);

        }
        else if (id == R.id.contact) {

            Intent myIntent = new Intent(this, BestAttack.class);
            startActivity(myIntent);

        }
        else if (id == R.id.about) {

            Intent myIntent = new Intent(this, BestLoot.class);
            startActivity(myIntent);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
