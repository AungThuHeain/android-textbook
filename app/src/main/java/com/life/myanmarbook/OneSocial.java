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

public class OneSocial extends AppCompatActivity {

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
                "အခန်း ၁ မောင်မောင်နှင့်သူငယ်ချင်းများ",
                "အခန်း ၂ မိသားစုနှင့် နေအိမ်",
                "အခန်း ၃ ကျွန်ုပ်တို့ စားသုံးသော အစားအစာများ",
                "အခန်း ၄ ကျွန်ုပ်တို့ဝတ်ဆင်သော အဝတ်အထည်နှင့် အသုံးအဆောင်များ",
                "အခန်း ၅ မိုးလေဝသ အခြေအနေအလိုက် ကျွန်ုပ်တို့၏ နေထိုင်မှု",
                "အခန်း ၆ ကျွန်ုပ်အားကျဂုဏ်ယူရသော သမိုင်းဝင်ခေါင်းဆောင်များ",

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