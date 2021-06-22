package com.competitiveexam.android.vci;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView t1 ;
    TextView t2 ;
    TextView t3 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        t1 = (TextView) findViewById(R.id.corans) ;
        t2 = (TextView)findViewById(R.id.wroans) ;
        t3 = (TextView)findViewById(R.id.totalans) ;


        StringBuffer sb2 = new StringBuffer();
        sb2.append("Wrong Answers: " + PsetCA.getWrong() + "\n");
        StringBuffer sb3 = new StringBuffer();
        sb3.append("Final Score: " + PsetCA.getCorrect() + "\n");
        t1.setText(sb2);
        t3.setText(sb3);
        PsetCA.wrongg = 0 ;
        PsetCA.correctt = 0 ;

    }
}
