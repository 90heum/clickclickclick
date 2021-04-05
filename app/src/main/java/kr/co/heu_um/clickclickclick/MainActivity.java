package kr.co.heu_um.clickclickclick;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;
import java.util.Collections;


public class MainActivity extends AppCompatActivity {

    ImageView btn;
    ImageView[] btnarr=new ImageView[12];


    ImageView btnfirst;
    int imageIndex=0;

    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Sample AdMob app ID: ca-app-pub-3940256099942544~3347511713
        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");

        mAdView=findViewById(R.id.adView);

        AdRequest adRequest= new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);



        ArrayList<Integer> arr= new ArrayList<>();
        for(int i=0; i<btnarr.length; i++){
            arr.add(i);
        }
        Collections.shuffle(arr);

        for(int i=0; i<btnarr.length; i++){
            btnarr[i]=findViewById(R.id.btn01+i);
            btnarr[i].setTag(arr.get(i));
        }






        btnfirst=(ImageView)findViewById(R.id.imageButton01);


    }

    public void clickBtn(View v){
        Button btn=(Button)v;
    }
    public void clickBtn01(View v){
        btnfirst.setVisibility(View.INVISIBLE);
    }





}