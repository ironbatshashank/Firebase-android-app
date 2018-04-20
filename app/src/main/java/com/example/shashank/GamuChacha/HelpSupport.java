package com.example.shashank.GamuChacha;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class HelpSupport extends AppCompatActivity {

    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_support);

            if(getSupportActionBar() != null) {
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                getSupportActionBar().setDisplayShowHomeEnabled(true);

    }

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent (Intent.ACTION_VIEW , Uri.parse("mailto:" + "shashanksri65@gmail.com"));
                    intent.putExtra(Intent.EXTRA_SUBJECT, "Issues");
                    startActivity(intent);
                }catch(ActivityNotFoundException e){

                }
            }
        });

        }

    //public boolean onOptionsItemSelected(MenuItem item) {
      //  if(item.getItemId() == android.R.id.home)
    //@Override
      //      finish();
        //return super.onOptionsItemSelected(item);
    //}
}
