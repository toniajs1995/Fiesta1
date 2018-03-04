package com.example.project.fiesta1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class client extends AppCompatActivity {

    private ImageButton imageMarriage;
    private ImageButton imageBirthday;
    private ImageButton imageBaptism;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);

        firebaseAuth=FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser()==null){
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }

        FirebaseUser user= firebaseAuth.getCurrentUser();


        imageMarriage=(ImageButton)findViewById(R.id.imageMarriage);
        imageMarriage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(client.this, marriage.class);
                startActivity(i);
            }
        });

        imageBirthday=(ImageButton)findViewById(R.id.imageBirthday);
        imageBirthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent i = new Intent(CprofileActivity.this, BirthdayActivity.class);
                //startActivity(i);
                //Toast.makeText(Home.this,"View caters",Toast.LENGTH_LONG).show();
            }
        });

        imageBaptism=(ImageButton)findViewById(R.id.imageBaptism);
        imageBaptism.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent i = new Intent(CprofileActivity.this, BaptismActivity.class);
                //startActivity(i);
                //Toast.makeText(Home.this,"View makeups",Toast.LENGTH_LONG).show();
            }
        });

    }
}
