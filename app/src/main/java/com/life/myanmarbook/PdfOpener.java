package com.life.myanmarbook;
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
public class PdfOpener extends AppCompatActivity {
    private static final String TAG = "PdfOpener";
//     Grade 1 myanmar start
    String onemm1 ="https://mmtextbook.s3.ap-southeast-1.amazonaws.com/g1/G1Text_Mm_Unit1_compressed.pdf";
    String onemm2 ="https://mmtextbook.s3.ap-southeast-1.amazonaws.com/g1/Myanmar/G1Text_Mm_Unit2_compressed.pdf";
    String onemm3 ="https://mmtextbook.s3.ap-southeast-1.amazonaws.com/g1/Myanmar/G1Text_Mm_Unit3_compressed.pdf";
    String onemm4 ="https://mmtextbook.s3.ap-southeast-1.amazonaws.com/g1/Myanmar/G1Text_Mm_Unit4_compressed.pdf";
    String onemm5 ="https://mmtextbook.s3.ap-southeast-1.amazonaws.com/g1/Myanmar/G1Text_Mm_Unit5_compressed.pdf";
    String onemm6 ="https://mmtextbook.s3.ap-southeast-1.amazonaws.com/g1/Myanmar/G1Text_Mm_Unit6_compressed.pdf";
    String onemm7 ="https://mmtextbook.s3.ap-southeast-1.amazonaws.com/g1/Myanmar/G1Text_Mm_Unit7_compressed.pdf";
    String onemm8 ="https://mmtextbook.s3.ap-southeast-1.amazonaws.com/g1/Myanmar/G1Text_Mm_Unit8_compressed.pdf";
    String onemm9 ="https://mmtextbook.s3.ap-southeast-1.amazonaws.com/g1/Myanmar/G1Text_Mm_Unit9_compressed.pdf";
    String onemm10 ="https://mmtextbook.s3.ap-southeast-1.amazonaws.com/g1/Myanmar/G1Text_Mm_Unit10_compressed.pdf";
    String onemm11 = "https://mmtextbook.s3.ap-southeast-1.amazonaws.com/g1/Myanmar/G1Text_Mm_Unit11_compressed.pdf";
    String onemm12 = "https://mmtextbook.s3.ap-southeast-1.amazonaws.com/g1/Myanmar/G1Text_Mm_Unit12_compressed.pdf";
    String onemm13 = "https://mmtextbook.s3.ap-southeast-1.amazonaws.com/g1/Myanmar/G1Text_Mm_glossary_compressed.pdf";
//    Grade 1 myanmar end
//    Grade 1 english start
    String oneeng1 ="https://mmtextbook.s3.ap-southeast-1.amazonaws.com/g1/Eng/G1Text_Eng_Unit1_compressed.pdf";
    String oneeng2 ="https://mmtextbook.s3.ap-southeast-1.amazonaws.com/g1/Eng/G1Text_Eng_Unit2_compressed.pdf";
    String oneeng3 ="https://mmtextbook.s3.ap-southeast-1.amazonaws.com/g1/Eng/G1Text_Eng_Unit3_compressed.pdf";
    String oneeng4 ="https://mmtextbook.s3.ap-southeast-1.amazonaws.com/g1/Eng/G1Text_Eng_Unit4_compressed.pdf";
    String oneeng5 ="https://mmtextbook.s3.ap-southeast-1.amazonaws.com/g1/Eng/G1Text_Eng_Unit5_compressed.pdf";
    String oneeng6 ="https://mmtextbook.s3.ap-southeast-1.amazonaws.com/g1/Eng/G1Text_Eng_Unit6_compressed.pdf";
    String oneeng7 ="https://mmtextbook.s3.ap-southeast-1.amazonaws.com/g1/Eng/G1Text_Eng_Unit7_compressed.pdf";
    String oneeng8 ="https://mmtextbook.s3.ap-southeast-1.amazonaws.com/g1/Eng/G1Text_Eng_Unit8_compressed.pdf";
    // Grade 1 english end
    //Grade 1 math start
    String onemath1 ="https://mmtextbook.s3.ap-southeast-1.amazonaws.com/g1/Math/G1Text_Math_Unit1_compressed.pdf";
    String onemath2 ="https://mmtextbook.s3.ap-southeast-1.amazonaws.com/g1/Math/G1Text_Math_Unit2_compressed.pdf";
    String onemath3 ="https://mmtextbook.s3.ap-southeast-1.amazonaws.com/g1/Math/G1Text_Math_Unit3_compressed.pdf";
    String onemath4 ="https://mmtextbook.s3.ap-southeast-1.amazonaws.com/g1/Math/G1Text_Math_Unit4_compressed.pdf";
    String onemath5 ="https://mmtextbook.s3.ap-southeast-1.amazonaws.com/g1/Math/G1Text_Math_Unit5_compressed.pdf";
    String onemath6 ="https://mmtextbook.s3.ap-southeast-1.amazonaws.com/g1/Math/G1Text_Math_Unit6_compressed.pdf";
    String onemath7 ="https://mmtextbook.s3.ap-southeast-1.amazonaws.com/g1/Math/G1Text_Math_Unit7_compressed.pdf";
    String onemath8 ="https://mmtextbook.s3.ap-southeast-1.amazonaws.com/g1/Math/G1Text_Math_Unit8_compressed.pdf";
    String onemath9 ="https://mmtextbook.s3.ap-southeast-1.amazonaws.com/g1/Math/G1Text_Math_Unit9_compressed.pdf";
    String onemath10 ="https://mmtextbook.s3.ap-southeast-1.amazonaws.com/g1/Math/G1Text_Math_Unit10_compressed.pdf";
    String onemath11="https://mmtextbook.s3.ap-southeast-1.amazonaws.com/g1/Math/G1Text_Math_Unit11_compressed.pdf";
    String onemath12 ="https://mmtextbook.s3.ap-southeast-1.amazonaws.com/g1/Math/G1Text_Math_Unit12_compressed.pdf";
    String onemath13 ="https://mmtextbook.s3.ap-southeast-1.amazonaws.com/g1/Math/G1Text_Math_Unit13_compressed.pdf";
    String onemath14 ="https://mmtextbook.s3.ap-southeast-1.amazonaws.com/g1/Math/G1Text_Math_Unit14_compressed.pdf";
    String onemath15 ="https://mmtextbook.s3.ap-southeast-1.amazonaws.com/g1/Math/G1Text_Math_Unit15_compressed.pdf";
    String onemath16 ="https://mmtextbook.s3.ap-southeast-1.amazonaws.com/g1/Math/G1Text_Math_Unit16_compressed.pdf";
    String onemath17 ="https://mmtextbook.s3.ap-southeast-1.amazonaws.com/g1/Math/G1Text_Math_Unit17_compressed.pdf";
    String onemath18 ="https://mmtextbook.s3.ap-southeast-1.amazonaws.com/g1/Math/G1Text_Math_Unit18_compressed.pdf";
    //Grade 1 math end
    //Grade 1 science start
    String onescience1 ="https://mmtextbook.s3.ap-southeast-1.amazonaws.com/g1/Science/G1Text_Science_Unit1_compressed.pdf";
    String onescience2 ="https://mmtextbook.s3.ap-southeast-1.amazonaws.com/g1/Science/G1Text_Science_Unit2_compressed.pdf";
    String onescience3 ="https://mmtextbook.s3.ap-southeast-1.amazonaws.com/g1/Science/G1Text_Science_Unit3_compressed.pdf";
    String onescience4 ="https://mmtextbook.s3.ap-southeast-1.amazonaws.com/g1/Science/G1Text_Science_Unit4_compressed.pdf";
    String onescience5 ="https://mmtextbook.s3.ap-southeast-1.amazonaws.com/g1/Science/G1Text_Science_Unit5_compressed.pdf";
    String onescience6 ="https://mmtextbook.s3.ap-southeast-1.amazonaws.com/g1/Science/G1Text_Science_Unit6_compressed.pdf";
    //Grade 1 science end
    PDFView pdfView;
    CircularProgressIndicator progress_circular;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_opener);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        //admob banner code
        AdView mAdView = findViewById(R.id.adView);
        AdRequest BannerAdRequest = new AdRequest.Builder().build();
        mAdView.loadAd(BannerAdRequest);


        pdfView = findViewById(R.id.pdfView);
        progress_circular = findViewById(R.id.progress_circular);
        progress_circular.setVisibility(View.VISIBLE);

        String getItam =getIntent().getStringExtra("PdfFieName");
//         grade one myanmr start
        if(getItam.equals("ရင်းရင်းနှီးနှီးမိတ်ဆက်ကြရအောင်")){
            new loadpdffromUrl().execute(onemm1);
        }
        if(getItam.equals("ဗျည်းကဗျာ လင်္ကာများ ရွတ်ဖတ်ရေးစို့လား ၁")){
            new loadpdffromUrl().execute(onemm2);
        }
        if(getItam.equals("ဗျည်းကဗျာ လင်္ကာများ ရွတ်ဖတ်ရေးစို့လား ၂")){
            new loadpdffromUrl().execute(onemm3);
        }
        if(getItam.equals("ဗျည်းကဗျာ လင်္ကာများ ရွတ်ဖတ်ရေးစို့လား ၃")){
            new loadpdffromUrl().execute(onemm4);
        }
        if(getItam.equals("ဗျည်းကဗျာ လင်္ကာများ ရွတ်ဖတ်ရေးစို့လား ၄")){
            new loadpdffromUrl().execute(onemm5);
        }
        if(getItam.equals("ဆိုမယ်ရေးမယ် ပုံပြောမယ်")){
            new loadpdffromUrl().execute(onemm6);
        }
        if(getItam.equals("သရလက္ခဏာသိမှတ်စရာ ဗျည်းနဲ့တွဲကြမှာ ၁")){
            new loadpdffromUrl().execute(onemm7);
        }
        if(getItam.equals("သရလက္ခဏာသိမှတ်စရာ ဗျည်းနဲ့တွဲကြမှာ ၂")){
            new loadpdffromUrl().execute(onemm8);
        }
        if(getItam.equals("သရလက္ခဏာသိမှတ်စရာ ဗျည်းနဲ့တွဲကြမှာ ၃")){
            new loadpdffromUrl().execute(onemm9);
        }
        if(getItam.equals("ဗျည်းနဲ့သလက္ခဏာ ပေါင်းစပ်တွဲကြမှာ ၁")){
            new loadpdffromUrl().execute(onemm10);
        }
        if(getItam.equals("ဗျည်းနဲ့သလက္ခဏာ ပေါင်းစပ်တွဲကြမှာ ၂")){
            new loadpdffromUrl().execute(onemm11);
        }
        if(getItam.equals("စိတ်ဝင်စားဖွယ် ပုံပြောမယ် ကဗျာကလေးလည်းနားထောင်ကွယ်")){
            new loadpdffromUrl().execute(onemm12);
        }
        if(getItam.equals("ဝေါဟာရများ")){
            new loadpdffromUrl().execute(onemm13);
        }
//grade one myanmar end
//grade one english start
        if(getItam.equals("Unit 1 My Friend")){
            new loadpdffromUrl().execute(oneeng1);
        }
        if(getItam.equals("Unit 2 Things around us")){
            new loadpdffromUrl().execute(oneeng2);
        }
        if(getItam.equals("Unit 3 Colours")){
            new loadpdffromUrl().execute(oneeng3);
        }
        if(getItam.equals("Unit 4 Parts of the Body")){
            new loadpdffromUrl().execute(oneeng4);
        }
        if(getItam.equals("Unit 5 Food and Drink")){
            new loadpdffromUrl().execute(oneeng5);
        }
        if(getItam.equals("Unit 6 Fruits")){
            new loadpdffromUrl().execute(oneeng6);
        }
        if(getItam.equals("Unit 7 English for our class")){
            new loadpdffromUrl().execute(oneeng7);
        }
        if(getItam.equals("Unit 8 My Family")){
            new loadpdffromUrl().execute(oneeng8);
        }

        //grade one english end
        //grade 1 math start
        if(getItam.equals("အခန်း ၁ တစ်ဆယ်အထိကိန်းများ")){
            new loadpdffromUrl().execute(onemath1);
        }
        if(getItam.equals("အခန်း ၂ မည်မျှနှင့် မည်မျှ")){
            new loadpdffromUrl().execute(onemath2);
        }
        if(getItam.equals("အခန်း ၃ သုည")){
            new loadpdffromUrl().execute(onemath3);
        }
        if(getItam.equals("အခန်း ၄ နောက်ထပ်ဘာလာမလဲ")){
            new loadpdffromUrl().execute(onemath4);
        }
        if(getItam.equals("အခန်း ၅ ကျွန်ုပ်တို့ပတ်ဝန်းကျင်ရှိပုံများ")){
            new loadpdffromUrl().execute(onemath5);
        }
        if(getItam.equals("အခန်း ၆ အပေါင်းသင်ခန်းစာ ၁")){
            new loadpdffromUrl().execute(onemath6);
        }
        if(getItam.equals("အခန်း ၇ အနုတ်သင်ခန်းစာ ၁")){
            new loadpdffromUrl().execute(onemath7);
        }
        if(getItam.equals("အခန်း ၈ ကိန်းသုံးလုံးဖြင့်တွက်ချက်ခြင်း သင်ခန်းစာ ၁")){
            new loadpdffromUrl().execute(onemath8);
        }
        if(getItam.equals("အခန်း ၉ ဘယ်ဟာကပိုရှည်သလဲ နိူင်းယှဉ်ကြမယ")){
            new loadpdffromUrl().execute(onemath9);
        }
        if(getItam.equals("အခန်း ၁၀ နှစ်ဆယ်အထိကိန်းများ")){
            new loadpdffromUrl().execute(onemath10);
        }
        if(getItam.equals("အခန်း ၁၁ အပေါင်း သင်ခန်းစာ ၂")){
            new loadpdffromUrl().execute(onemath11);
        }
        if(getItam.equals("အခန်း ၁၂ အနုတ်သင်ခန်းစာ ၂")){
            new loadpdffromUrl().execute(onemath12);
        }
        if(getItam.equals("အခန်း ၁၃ ဘယ်အချိန်မှာဘာလုပ်သလဲ")){
            new loadpdffromUrl().execute(onemath13);
        }
        if(getItam.equals("အခန်း ၁၄ ကိန်းသုံးလုံးဖြင့်တွက်ချက်ခြင်း သင်ခန်းစာ ၂")){
            new loadpdffromUrl().execute(onemath14);
        }
        if(getItam.equals("အခန်း ၁၅ နေရာအဆင့်ပြကိန်းများ")){
            new loadpdffromUrl().execute(onemath15);
        }
        if(getItam.equals("အခန်း ၁၆ ပုံများဆွဲသားခြင်း")){
            new loadpdffromUrl().execute(onemath16);
        }
        if(getItam.equals("အခန်း ၁၇ ကိန်းကြီးများ")){
            new loadpdffromUrl().execute(onemath17);
        }
        if(getItam.equals("အခန်း ၁၈ ကိန်းကြီးများပေါင်းခြင်းနှင့် နုတ်ခြင်း")){
            new loadpdffromUrl().execute(onemath18);
        }
        //Grade 1 math end
        //Grade 1 science start
        if(getItam.equals("အခန်း ၁ ကျွန်ပ်တို့၏ အနီးဆုံးပတ်ဝန်းကျင်")){
            new loadpdffromUrl().execute(onescience1);
        }
        if(getItam.equals("အခန်း ၂ ကျွန်ုပ်")){
            new loadpdffromUrl().execute(onescience2);
        }
        if(getItam.equals("အခန်း ၃ ကျွန်ုပ်တို့၏ပတ်ဝန်းကျင်ရှိ အပင်များ")){
            new loadpdffromUrl().execute(onescience3);
        }
        if(getItam.equals("အခန်း ၄ ကျွန်ုပ်တို့၏ ပတ်ဝန်းကျင်ရှိ  တိရစ္ဆာန်များ")){
            new loadpdffromUrl().execute(onescience4);
        }
        if(getItam.equals("အခန်း ၅ ကျွန်ပ်တို့၏ ကမ္ဘာမြေကြီး")){
            new loadpdffromUrl().execute(onescience5);
        }
        if(getItam.equals("အခန်း ၆ ကျွန်ပ်တို့၏ ကောင်းကင်")){
            new loadpdffromUrl().execute(onescience6);
        }


    }
    //create an async task to load pdf from URL.
    class loadpdffromUrl extends AsyncTask<String, Void, InputStream> implements OnLoadCompleteListener, OnErrorListener {
        @Override
        protected InputStream doInBackground(String... strings) {
            //We use InputStream to get PDF.
            InputStream inputStream = null;
            try {
                URL url = new URL(strings[0]);
                HttpURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
                if (urlConnection.getResponseCode() == 200) {
                    // if response is success. we are getting input stream from url and storing it in our variable.
                    inputStream = new BufferedInputStream(urlConnection.getInputStream());
                }
            } catch (IOException e) {
                //method to handle errors.
                e.printStackTrace();
                return null;
            }
            return inputStream;
        }
        @Override
        protected void onPostExecute(InputStream inputStream) {
            //after the executing async task we load pdf in to pdfview.
            pdfView.fromStream(inputStream).onLoad(this).onError(this).load();
        }
        @Override
        public void loadComplete(int nbPages) {
            progress_circular.setVisibility(View.GONE);
        }
        @Override
        public void onError(Throwable t) {
            progress_circular.setVisibility(View.GONE);
//            Toast.makeText(PdfOpener.this,"Error:" +t.getMessage(),Toast.LENGTH_SHORT).show();
            Toast.makeText(PdfOpener.this,"Please check your internet connection & try again",Toast.LENGTH_LONG).show();
        }
    }

}