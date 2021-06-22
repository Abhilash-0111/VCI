package com.competitiveexam.android.vci;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.textclassifier.ConversationActions;
import android.widget.Button;
import android.widget.ProgressBar;

public class VyapCard extends AppCompatActivity {
    Button but1 ;
    Button but2 ;
    Button but3 ;
    Button but4 ;
    Button but5 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vyap_card);


        but1 = (Button)findViewById(R.id.Qbutton1);
        but1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openchap1();
            }
        });
        but2 = (Button)findViewById(R.id.Qbutton2);
        but2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openchap2();
            }
        });
        but3 = (Button)findViewById(R.id.Qbutton3);
        but3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openchap3();
            }
        });
        but4 = (Button)findViewById(R.id.Qbutton4);
        but4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openchap4();
            }
        });
        but5 = (Button)findViewById(R.id.Qbutton5);
        but5.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openchap5();
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
        Intent intent3 = new Intent(this,PsetEng.class);
        startActivity(intent3);
    }
    public void openchap5(){
        Intent intent3 = new Intent(this,PsetHind.class);
        startActivity(intent3);
    }



}
