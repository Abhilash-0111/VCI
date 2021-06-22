package com.competitiveexam.android.vci.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.competitiveexam.android.vci.PsetCA;
import com.competitiveexam.android.vci.R;
import com.competitiveexam.android.vci.VyapCard;
import com.competitiveexam.android.vci.cardact1;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class HomeFragment extends Fragment {
    private AdView mAdview14 ;
    private  AdView mAdview15 ;
    CardView card1 ;
    CardView card2 ;
    CardView card3 ;
    CardView card4 ;
    CardView card5 ;

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        mAdview14 =(AdView)root.findViewById(R.id.adView1);
        AdRequest adRequest9 = new AdRequest.Builder().build();
        mAdview14.loadAd(adRequest9);
        mAdview15 =(AdView)root.findViewById(R.id.adView2);
        AdRequest adRequest10 = new AdRequest.Builder().build();
        mAdview15.loadAd(adRequest10);


        // open activity
        card1 = (CardView) root.findViewById(R.id.card1);
        card1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openAct1();
            }
        });


        card2 = (CardView)  root.findViewById(R.id.card2);
        card2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openAct2();
            }
        });


        card3 = (CardView)  root.findViewById(R.id.card3);
        card3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openAct3();
            }
        });

        card4 = (CardView)  root.findViewById(R.id.card4);
        card4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openAct4();
            }
        });

        card5 = (CardView)  root.findViewById(R.id.card5);
        card5.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openAct5();
            }
        });

        return root;


    }


    protected void openAct1() {
        Intent intent = new Intent(getActivity(), cardact1.class);
        startActivity(intent);
    }
    protected void openAct2() {
        Intent intent = new Intent(getActivity(), cardact1.class);
        startActivity(intent);
    }
    protected void openAct3() {
        Intent intent = new Intent(getActivity(), cardact1.class);
        startActivity(intent);
    }
    protected void openAct4() {
        Intent intent = new Intent(getActivity(), PsetCA.class);
        startActivity(intent);
    }

    protected void openAct5() {
        Intent intent = new Intent(getActivity(), VyapCard.class);
        startActivity(intent);
    }



}
