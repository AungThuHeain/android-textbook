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

public class OneMath extends AppCompatActivity {

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
                "အခန်း ၁ တစ်ဆယ်အထိကိန်းများ",
                "အခန်း ၂ မည်မျှနှင့် မည်မျှ",
                "အခန်း ၃ သုည",
                "အခန်း ၄ နောက်ထပ်ဘာလာမလဲ",
                "အခန်း ၅ ကျွန်ုပ်တို့ပတ်ဝန်းကျင်ရှိပုံများ",
                "အခန်း ၆ အပေါင်းသင်ခန်းစာ ၁",
                "အခန်း ၇ အနုတ်သင်ခန်းစာ ၁",
                "အခန်း ၈ ကိန်းသုံးလုံးဖြင့်တွက်ချက်ခြင်း သင်ခန်းစာ ၁",
                "အခန်း ၉ ဘယ်ဟာကပိုရှည်သလဲ နိူင်းယှဉ်ကြမယ်",
                "အခန်း ၁၀ နှစ်ဆယ်အထိကိန်းများ",
                "အခန်း ၁၁ အပေါင်း သင်ခန်းစာ ၂",
                "အခန်း ၁၂ အနုတ်သင်ခန်းစာ ၂",
                "အခန်း ၁၃ ဘယ်အချိန်မှာဘာလုပ်သလဲ",
                "အခန်း ၁၄ ကိန်းသုံးလုံးဖြင့်တွက်ချက်ခြင်း သင်ခန်းစာ ၂",
                "အခန်း ၁၅ နေရာအဆင့်ပြကိန်းများ",
                "အခန်း ၁၆ ပုံများဆွဲသားခြင်း",
                "အခန်း ၁၇ ကိန်းကြီးများ",
                "အခန်း ၁၈ ကိန်းကြီးများပေါင်းခြင်းနှင့် နုတ်ခြင်း"
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