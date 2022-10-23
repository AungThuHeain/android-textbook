package com.life.myanmarbook;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnErrorListener;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
public class LessonOpener extends AppCompatActivity {
    private static final String TAG = "PdfOpener";


    PDFView pdfView;
    CircularProgressIndicator progress_circular;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_lesson_opener);

//        MobileAds.initialize(this, new OnInitializationCompleteListener() {
//            @Override
//            public void onInitializationComplete(InitializationStatus initializationStatus) {
//            }
//        });
//        //admob banner code
//        AdView mAdView = findViewById(R.id.adView);
//        AdRequest BannerAdRequest = new AdRequest.Builder().build();
//        mAdView.loadAd(BannerAdRequest);


        pdfView = findViewById(R.id.pdfView);
//        progress_circular = findViewById(R.id.progress_circular);
//        progress_circular.setVisibility(View.VISIBLE);

        String getItam =getIntent().getStringExtra("PdfFieName");

        if(getItam.equals("Made With Love by `Team Yso`")){
            Uri url = Uri.parse("https://www.ysochannel.com/support.php/");
            Intent start = new Intent(Intent.ACTION_VIEW,url);
            startActivity(start);
            finish();
        }
        if(getItam.equals("Download Textbook(pdf file)")){
            Uri uri = Uri.parse("https://www.ysochannel.com/textbook.php/");
            Intent start = new Intent(Intent.ACTION_VIEW,uri);
            startActivity(start);
            finish();
        }
        if(getItam.equals("Grade 1 မြန်မာဖတ်စာ")){
            Intent start = new Intent(getApplicationContext(), OneMm.class);
            startActivity(start);
            finish();
        }
        if(getItam.equals("Grade 1 English")){
            Intent start = new Intent(getApplicationContext(), OneEng.class);
            startActivity(start);
            finish();
        }
        if(getItam.equals("Grade 1 သင်္ချာ")){
            Intent start = new Intent(getApplicationContext(), OneMath.class);
            startActivity(start);
            finish();
        }
        if(getItam.equals("Grade 1 သိပ္ပံပညာ")){
            Intent start = new Intent(getApplicationContext(), OneScience.class);
            startActivity(start);
            finish();
        }
        if(getItam.equals("Grade 1 လူမှုရေး")){
            Intent start = new Intent(getApplicationContext(), OneSocial.class);
            startActivity(start);
            finish();
        }
        if(getItam.equals("Grade 1 စာရိတ္တနှင့် ပြည်သူ့နီတိ")){
            Intent start = new Intent(getApplicationContext(), OneMoral.class);
            startActivity(start);
            finish();
        }





    }


}