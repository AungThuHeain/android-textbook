package com.life.myanmarbook;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class OneEng extends AppCompatActivity {

    ListView lsview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_mm);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        //admob banner code
        AdView mAdView = findViewById(R.id.adView);
        AdRequest BannerAdRequest = new AdRequest.Builder().build();
        mAdView.loadAd(BannerAdRequest);


        lsview = (ListView) findViewById(R.id.lstview);

        String[] chapter = {
                "Unit 1 My Friend",
                "Unit 2 Things around us",
                "Unit 3 Colours",
                "Unit 4 Parts of the Body",
                "Unit 5 Food and Drink",
                "Unit 6 Fruits",
                "Unit 7 English for our class",
                "Unit 8 My Family",
        };

        ArrayAdapter< String > adapter = new ArrayAdapter < String > (this, android.R.layout.simple_list_item_1, chapter) {

            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

                View view = super.getView(position, convertView, parent);

                TextView mytxt = (TextView) view.findViewById(android.R.id.text1);
                return view;
            }
        };

        lsview.setAdapter(adapter);


        lsview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView < ? > parent, View view, int position, long id) {

                String iteam = lsview.getItemAtPosition(position).toString();

                Intent start = new Intent(getApplicationContext(), PdfOpener.class);
                start.putExtra("PdfFieName", iteam);
                startActivity(start);

            }
        });
    }
}