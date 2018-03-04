package com.example.project.fiesta1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class marriage extends AppCompatActivity {

    ImageButton imagedeco,imagecat,imagemake,imagetrans,imageout,imagemis,imagemedia,imagecake,imageenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marriage);

        try {

            imagedeco = (ImageButton) findViewById(R.id.imagedeco);
            imagedeco.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(marriage.this, deco.class);
                    startActivity(i);
                }
            });

            imagecat = (ImageButton) findViewById(R.id.imagecat);
            imagecat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Intent i = new Intent(MarriageActivity.this, Catering.class);
                    //startActivity(i);
                    // Toast.makeText(Home.this,"View caters",Toast.LENGTH_LONG).show();
                }
            });

            imagemake = (ImageButton) findViewById(R.id.imagemake);
            imagemake.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Intent i = new Intent(MarriageActivity.this, Makeup.class);
                    //  startActivity(i);
                    //Toast.makeText(Home.this,"View makeups",Toast.LENGTH_LONG).show();
                }
            });

            imagecake = (ImageButton) findViewById(R.id.imagecake);
            imagecake.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Intent i = new Intent(MarriageActivity.this, Cake.class);
                    //  startActivity(i);
                    //Toast.makeText(Home.this,"View makeups",Toast.LENGTH_LONG).show();
                }
            });

            imagetrans = (ImageButton) findViewById(R.id.imagetrans);
            imagetrans.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Intent i = new Intent(MarriageActivity.this, Transportation.class);
                    // startActivity(i);
                    //Toast.makeText(Home.this,"View makeups",Toast.LENGTH_LONG).show();
                }
            });

            imageout = (ImageButton) findViewById(R.id.imageout);
            imageout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Intent i = new Intent(MarriageActivity.this, Outfit.class);
                    // startActivity(i);
                    //Toast.makeText(Home.this,"View makeups",Toast.LENGTH_LONG).show();
                }
            });

            imagemis = (ImageButton) findViewById(R.id.imagemis);
            imagemis.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Intent i = new Intent(MarriageActivity.this, Miscellaneous.class);
                    //  startActivity(i);
                    //Toast.makeText(Home.this,"View makeups",Toast.LENGTH_LONG).show();
                }
            });

            imagemedia = (ImageButton) findViewById(R.id.imagemedia);
            imagemedia.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Intent i = new Intent(MarriageActivity.this, Media.class);
                    // startActivity(i);
                    //Toast.makeText(Home.this,"View makeups",Toast.LENGTH_LONG).show();
                }
            });

            imageenter = (ImageButton) findViewById(R.id.imageenter);
            imageenter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //  Intent i = new Intent(MarriageActivity.this, Entertainment.class);
                    //  startActivity(i);
                    //Toast.makeText(Home.this,"View makeups",Toast.LENGTH_LONG).show();
                }
            });
        }
        catch(Exception e){}
    }
}
