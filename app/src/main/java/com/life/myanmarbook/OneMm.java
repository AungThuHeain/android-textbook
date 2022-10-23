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

public class OneMm extends AppCompatActivity {

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
                "ရင်းရင်းနှီးနှီးမိတ်ဆက်ကြရအောင်",
                "ဗျည်းကဗျာ လင်္ကာများ ရွတ်ဖတ်ရေးစို့လား ၁",
                "ဗျည်းကဗျာ လင်္ကာများ ရွတ်ဖတ်ရေးစို့လား ၂",
                "ဗျည်းကဗျာ လင်္ကာများ ရွတ်ဖတ်ရေးစို့လား ၃",
                "ဗျည်းကဗျာ လင်္ကာများ ရွတ်ဖတ်ရေးစို့လား ၄",
                "ဆိုမယ်ရေးမယ် ပုံပြောမယ်",
                "သရလက္ခဏာသိမှတ်စရာ ဗျည်းနဲ့တွဲကြမှာ ၁",
                "သရလက္ခဏာသိမှတ်စရာ ဗျည်းနဲ့တွဲကြမှာ ၂",
                "သရလက္ခဏာသိမှတ်စရာ ဗျည်းနဲ့တွဲကြမှာ ၃",
                "ဗျည်းနဲ့သလက္ခဏာ ပေါင်းစပ်တွဲကြမှာ ၁",
                "ဗျည်းနဲ့သလက္ခဏာ ပေါင်းစပ်တွဲကြမှာ ၂",
                "စိတ်ဝင်စားဖွယ် ပုံပြောမယ် ကဗျာကလေးလည်းနားထောင်ကွယ်",
                "ဝေါဟာရများ"
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