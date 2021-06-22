package com.competitiveexam.android.vci;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.textclassifier.ConversationActions;
import android.widget.Button;
import android.widget.ProgressBar;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class cardact1 extends AppCompatActivity {
    Button button1 ;
    Button button2 ;
    Button button3 ;
    Button button4 ;
    AdView mAdView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card1);

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        button1 = (Button)findViewById(R.id.Qbutton1);
        button1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openchap1();
            }
        });
        button2 = (Button)findViewById(R.id.Qbutton2);
        button2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openchap2();
            }
        });
        button3 = (Button)findViewById(R.id.Qbutton3);
        button3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openchap3();
            }
        });
        button4 = (Button)findViewById(R.id.Qbutton4);
        button4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openchap4();
            }
        });


    }



    public void openchap1(){
        Intent intent1 = new Intent(this, PsetReas.class);
        startActivity(intent1);
    }



    public void openchap2(){
        Intent intent2 = new Intent(this, PsetApti.class);
        startActivity(intent2);
    }
    public void openchap3(){
        Intent intent3 = new Intent(this,PsetGS.class);
        startActivity(intent3);
    }
    public void openchap4(){
        Intent intent4 = new Intent(this,PsetEng.class);
        startActivity(intent4);
    }



}
