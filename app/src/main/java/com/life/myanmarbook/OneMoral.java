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

public class OneMoral extends AppCompatActivity {

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
                "သင်ခန်းစာ ၁ ပိုပိုတို့မိသားစု",
                "သင်ခန်းစာ ၂ လူကြီးမိဘများကို ကူညီပါ",
                "သင်ခန်းစာ ၃ အိမ်၌ယဉ်ကျေးခြင်း",
                "သင်ခန်းစာ ၄ လိမ်ညာ၍မပြောတော့ပါ",
                "သင်ခန်းစာ ၅ ဖြူဖြူ၏နောင်တ",
                "သင်ခန်းစာ ၆ တာဝန်ကျေသူ",
                "သင်ခန်းစာ ၇ ကျင့်ဝတ်လိုက်နာ ညီငယ်ရာ",
                "သင်ခန်းစာ ၈ လူကလေးရဲ့ ရိုးသာမှု",
                "သင်ခန်းစာ ၉ ယဉ်ကျေးပျူငှာဆက်ဆံပါ",
                "သင်ခန်းစာ ၁၀ ယုံကြည်ရသူ",
                "သင်ခန်းစာ ၁၁ စာနာတက်သူ",
                "သင်ခန်းစာ ၁၂ ပူစူးသိတဲ့တရားမျှတမှု",
                "သင်ခန်းစာ ၁၃ တပည့်ဝတ်",
                "သင်ခန်းစာ ၁၄ နိုင်ငံချစ်သူ",
                "သင်ခန်းစာ ၁၅ မင်္ဂလာနံနက်ခင်း",
                "သင်ခန်းစာ ၁၆ လှပစေခြင် တို့ဝန်းကျင်"
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