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

public class MainActivity extends AppCompatActivity {

    ListView lsview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                "Grade 1 မြန်မာဖတ်စာ",
                "Grade 1 English",
                "Grade 1 သင်္ချာ",
                "Grade 1 သိပ္ပံပညာ",
                "Grade 1 လူမှုရေး",
                "Grade 1 စာရိတ္တနှင့် ပြည်သူ့နီတိ",
                "Grade 1 ဘဝတွက်တာကျွမ်းကျင်စရာ",
                "Grade 1 ကာယပညာ",
                "Grade 1 အနုပညာ(ပန်းချီ)",
                "Grade 1 အနုပညာ(ဂီတ)",
                "Made With Love by `Team Yso`",
                "Download Textbook(pdf file)",
                "Grade 2 မြန်မာဖတ်စာ",
                "Grade 2 English",
                "Grade 2 သင်္ချာ",
                "Grade 2 သိပ္ပံပညာ",
                "Grade 2 လူမှုရေး",
                "Grade 2 စာရိတ္တနှင့် ပြည်သူ့နီတိ",
                "Grade 2 ဘဝတွက်တာကျွမ်းကျင်စရာ",
                "Grade 2 ကာယပညာ",
                "Grade 2 အနုပညာ(ပန်းချီ)",
                "Grade 2 အနုပညာ(ဂီတ)",
                "Made With Love by `Team Yso`",
                "Download Textbook(pdf file)",
                "Grade 3 မြန်မာဖတ်စာ",
                "Grade 3 English",
                "Grade 3 သင်္ချာ",
                "Grade 3 သိပ္ပံပညာ",
                "Grade 3 လူမှုရေး",
                "Grade 3 စာရိတ္တနှင့် ပြည်သူ့နီတိ",
                "Grade 3 ဘဝတွက်တာကျွမ်းကျင်စရာ",
                "Grade 3 ကာယပညာ",
                "Grade 3 အနုပညာ(ပန်းချီ)",
                "Grade 3 အနုပညာ(ဂီတ)",
                "Made With Love by `Team Yso`",
                "Download Textbook(pdf file)",
                "Grade 4 မြန်မာဖတ်စာ",
                "Grade 4 English",
                "Grade 4 သင်္ချာ",
                "Grade 4 သိပ္ပံပညာ",
                "Grade 4 လူမှုရေး",
                "Grade 4 စာရိတ္တနှင့် ပြည်သူ့နီတိ",
                "Grade 4 ဘဝတွက်တာကျွမ်းကျင်စရာ",
                "Grade 4 ကာယပညာ",
                "Grade 4 အနုပညာ(ပန်းချီ)",
                "Grade 4 အနုပညာ(ဂီတ)",
                "Made With Love by `Team Yso`",
                "Download Textbook(pdf file)",
                "Grade 7 မြန်မာဖတ်စာ",
                "Grade 7 English",
                "Grade 7 သင်္ချာ ၁",
                "Grade 7 သင်္ချာ ၂",
                "Grade 7 သိပ္ပံပညာ",
                "Grade 7 ပထဝီဝင်",
                "Grade 7 သမိုင်း",
                "Grade 7 စာရိတ္တနှင့် ပြည်သူ့နီတိ",
                "Grade 7 ဘဝတွက်တာကျွမ်းကျင်စရာ",
                "Grade 7 ကာယပညာ",
                "Grade 7 အနုပညာ(ပန်းချီ)",
                "Grade 7 အနုပညာ(ဂီတ)",
                "Made With Love by `Team Yso`",
                "Download Textbook(pdf file)",
                "Grade 8 မြန်မာသဒ္ဒါ အတွဲ ၁",
                "Grade 8 ဇာတကဝတ္ထုများ",
                "Grade 8 မြန်မာကဗျာလက်ရွေးစင်",
                "Grade 8 English",
                "Grade 8 သင်္ချာ ၁",
                "Grade 8 သင်္ချာ ၂",
                "Grade 8 သိပ္ပံပညာ",
                "Grade 8 ပထဝီဝင်",
                "Grade 8 သမိုင်း",




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

                Intent start = new Intent(getApplicationContext(), LessonOpener.class);
                start.putExtra("PdfFieName", iteam);
                startActivity(start);

            }
        });
    }
}