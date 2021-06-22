package com.competitiveexam.android.vci;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.cardview.widget.CardView;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {



    private AppBarConfiguration mAppBarConfiguration;
    public CardView card1 ;
    public CardView card2 ;
    public CardView card3 ;
    public CardView card4 ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Message", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
                R.id.nav_tools, R.id.nav_share, R.id.nav_send)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);


        // open activity





            try
            {
                //Your Login Credentials
                String username = "siksha";
                String password = "Server@123";

//Single or Multiple mobiles numbers separated by comma
                String to = "919752218855";

//method
                String smsmethod = "simpleMsg";

//Message type
                String msgtype = "text";

//Your approved sender name
                String sendername = "SGCSMS";

//Your message to send, Add URL encoding here.
                String textmessage = "Boiler efficiency is  ";


                URLConnection myURLConnection=null;
                URL myURL=null;
                BufferedReader reader=null;

//encode the message content
                String encoded_message= URLEncoder.encode(textmessage,(UTF_8.toString()));

//Send SMS API
                String apiUrl="https://www.smsgateway.center/SMSApi/rest/send?";

                StringBuilder sgcPostContent= new StringBuilder(apiUrl);
                sgcPostContent.append("userId="+username);
                sgcPostContent.append("password="+password);
                sgcPostContent.append("sendMethod="+smsmethod);
                sgcPostContent.append("msgType="+msgtype);
                sgcPostContent.append("senderId="+sendername);
                sgcPostContent.append("&mobile="+to);
                sgcPostContent.append("&msg="+encoded_message);

                apiUrl = sgcPostContent.toString();

                //prepare connection
                myURL = new URL(apiUrl);
                myURLConnection =(URLConnection) myURL.openConnection();
                myURLConnection.connect();
                reader= new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()));

                //read the output
                String output;
                while ((output = reader.readLine()) != null)
                    //print output
                    Log.d("OUTPUT", ""+output);

                //Close connection
                reader.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }





        }


    public void openAct1() {
        Intent intent = new Intent(this, cardact1.class);
        startActivity(intent);
    }
    public void openAct2() {
        Intent intent = new Intent(this, cardact1.class);
        startActivity(intent);
    }
    public void openAct3() {
        Intent intent = new Intent(this, cardact1.class);
        startActivity(intent);
    }
    public void openAct4() {
        Intent intent = new Intent(this, PsetCA.class);
        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
