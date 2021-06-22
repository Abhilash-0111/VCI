package com.competitiveexam.android.vci;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.competitiveexam.android.vci.Model.CAQues;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Locale;

public class PsetGS extends AppCompatActivity {

    Button b1,b2,b3,b4 ;
    public TextView t1_question,timertxt,correctans,wrongans ;
    int total = 1;
    int correct = 0 ;
    int wrong = 0 ;
    private TextToSpeech mtts ;
    private Button mButtonSpeak ;
    DatabaseReference reference ;
    CAQues question;
    AdView mAdview5;
    AdView mAdview6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pset_c);

        mAdview5 = findViewById(R.id.adView1);
        AdRequest adRequest5 = new AdRequest.Builder().build();
        mAdview5.loadAd(adRequest5);

        mAdview6 = findViewById(R.id.adView2);
        AdRequest adRequest6 = new AdRequest.Builder().build();
        mAdview6.loadAd(adRequest6);


        mButtonSpeak = findViewById(R.id.speechbutton) ;
        mtts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onInit(int status) {
                if(status == TextToSpeech.SUCCESS){
                    int result =  mtts.setLanguage(Locale.forLanguageTag("hin")) ;
                    if(result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED)
                    {
                        Log.e("TTS","Initialization filed") ;

                    } else {
                        mButtonSpeak.setEnabled(true);
                    }
                }
                else{
                    Log.e("TTS","failed") ;
                }

            }
        }) ;


        mButtonSpeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                speak();
            }
        });








        b1 = (Button)findViewById(R.id.button1);
        b2 = (Button)findViewById(R.id.button2);
        b3 = (Button)findViewById(R.id.button3);
        b4 = (Button)findViewById(R.id.button4);

        t1_question = (TextView)findViewById(R.id.questionstxt);
        timertxt = (TextView)findViewById(R.id.timertxt);
        correctans = (TextView)findViewById(R.id.correctans);
        wrongans = (TextView)findViewById(R.id.wrongans) ;

        updateQustion();







        // Write a message to the database

   /*     FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello, World!");*/
    }

    private void updateQustion(){

        if(total>30){
            total = 1 ;  //open result
            correct = 0 ;
            wrong = 0 ;
            wrongans.setText(String.valueOf(wrong));
            correctans.setText(String.valueOf(correct));

        }
        else{
            reference = FirebaseDatabase.getInstance().getReference().child("QuestionsGS").child(String.valueOf(total));
            reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    question = dataSnapshot.getValue(CAQues.class);
                    t1_question.setText(question.getQuetion());
                    b1.setText(question.getOption1());
                    b2.setText(question.getOption2());
                    b3.setText(question.getOption3());
                    b4.setText(question.getOption4());
                    String text = question.getQuetion() ;



                    b1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if(b1.getText().toString().equals(question.getAnswer()))
                            {
                                b1.setBackgroundColor(Color.GREEN);
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++ ;
                                        total++ ;
                                        correctans.setText(String.valueOf(correct));
                                        b1.setBackgroundColor(Color.parseColor("#ffffff"));
                                        updateQustion();
                                    }
                                }, 1500);
                            }
                            else{

                                wrong++ ;
                                total++ ;
                                wrongans.setText(String.valueOf(wrong));
                                b1.setBackgroundColor(Color.RED);
                                if(b2.getText().toString().equals(question.getAnswer())){
                                    b2.setBackgroundColor(Color.GREEN);
                                }
                                else if(b3.getText().toString().equals(question.getAnswer())){
                                    b3.setBackgroundColor(Color.GREEN);
                                }
                                else if(b4.getText().toString().equals(question.getAnswer())){
                                    b4.setBackgroundColor(Color.GREEN);
                                }

                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        b1.setBackgroundColor(Color.parseColor("#ffffff"));
                                        b2.setBackgroundColor(Color.parseColor("#ffffff"));
                                        b3.setBackgroundColor(Color.parseColor("#ffffff"));
                                        b4.setBackgroundColor(Color.parseColor("#ffffff"));
                                        updateQustion();
                                    }
                                },1500);

                            }
                        }
                    });

                    b2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if(b2.getText().toString().equals(question.getAnswer()))
                            {
                                b2.setBackgroundColor(Color.GREEN);
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++ ;
                                        total++ ;
                                        correctans.setText(String.valueOf(correct));
                                        b2.setBackgroundColor(Color.parseColor("#ffffff"));
                                        updateQustion();
                                    }
                                }, 1500);
                            }
                            else{

                                wrong++ ;
                                total++ ;
                                wrongans.setText(String.valueOf(wrong));
                                b2.setBackgroundColor(Color.RED);
                                if(b1.getText().toString().equals(question.getAnswer())){
                                    b1.setBackgroundColor(Color.GREEN);
                                }
                                else if(b3.getText().toString().equals(question.getAnswer())){
                                    b3.setBackgroundColor(Color.GREEN);
                                }
                                else if(b4.getText().toString().equals(question.getAnswer())){
                                    b4.setBackgroundColor(Color.GREEN);
                                }

                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        b1.setBackgroundColor(Color.parseColor("#ffffff"));
                                        b2.setBackgroundColor(Color.parseColor("#ffffff"));
                                        b3.setBackgroundColor(Color.parseColor("#ffffff"));
                                        b4.setBackgroundColor(Color.parseColor("#ffffff"));
                                        updateQustion();
                                    }
                                },1500);

                            }
                        }
                    });




                    b3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if(b3.getText().toString().equals(question.getAnswer()))
                            {
                                b3.setBackgroundColor(Color.GREEN);
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++ ;
                                        total++ ;
                                        correctans.setText(String.valueOf(correct));
                                        b3.setBackgroundColor(Color.parseColor("#ffffff"));
                                        updateQustion();
                                    }
                                }, 1500);
                            }
                            else{

                                wrong++ ;
                                total++ ;
                                wrongans.setText(String.valueOf(wrong));
                                b3.setBackgroundColor(Color.RED);
                                if(b2.getText().toString().equals(question.getAnswer())){
                                    b2.setBackgroundColor(Color.GREEN);
                                }
                                else if(b1.getText().toString().equals(question.getAnswer())){
                                    b3.setBackgroundColor(Color.GREEN);
                                }
                                else if(b4.getText().toString().equals(question.getAnswer())){
                                    b4.setBackgroundColor(Color.GREEN);
                                }

                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        b1.setBackgroundColor(Color.parseColor("#ffffff"));
                                        b2.setBackgroundColor(Color.parseColor("#ffffff"));
                                        b3.setBackgroundColor(Color.parseColor("#ffffff"));
                                        b4.setBackgroundColor(Color.parseColor("#ffffff"));
                                        updateQustion();
                                    }
                                },1500);

                            }
                        }
                    });



                    b4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if(b4.getText().toString().equals(question.getAnswer()))
                            {
                                b4.setBackgroundColor(Color.GREEN);
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++ ;
                                        total++ ;
                                        correctans.setText(String.valueOf(correct));
                                        b4.setBackgroundColor(Color.parseColor("#ffffff"));
                                        updateQustion();
                                    }
                                }, 1500);
                            }
                            else{

                                wrong++ ;
                                total++ ;
                                wrongans.setText(String.valueOf(wrong));
                                b4.setBackgroundColor(Color.RED);
                                if(b2.getText().toString().equals(question.getAnswer())){
                                    b2.setBackgroundColor(Color.GREEN);
                                }
                                else if(b3.getText().toString().equals(question.getAnswer())){
                                    b3.setBackgroundColor(Color.GREEN);
                                }
                                else if(b1.getText().toString().equals(question.getAnswer())){
                                    b4.setBackgroundColor(Color.GREEN);
                                }

                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        b1.setBackgroundColor(Color.parseColor("#ffffff"));
                                        b2.setBackgroundColor(Color.parseColor("#ffffff"));
                                        b3.setBackgroundColor(Color.parseColor("#ffffff"));
                                        b4.setBackgroundColor(Color.parseColor("#ffffff"));
                                        updateQustion();
                                    }
                                },1500);

                            }
                        }
                    });






                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }

    }  //end of update class




    private void speak() {

        String text = question.getQuetion() ;
        mtts.setPitch(1f) ;
        mtts.setSpeechRate(1f);
        mtts.speak(text,TextToSpeech.QUEUE_FLUSH,null) ;




    }

    protected  void onDestroy(){
        if(mtts != null){
            mtts.stop();
            mtts.shutdown();
        }
        super.onDestroy();
    }


}



