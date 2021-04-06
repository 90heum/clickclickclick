package kr.co.heu_um.clickclickclick;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;
import java.util.Collections;


public class MainActivity extends AppCompatActivity {

    ImageView btn;
    ImageView[] btnarr = new ImageView[12];


    ImageView btnfirst;
    int imageIndex = 0;
    TextView tv;

    private AdView mAdView;
    Button reButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Sample AdMob app ID: ca-app-pub-3940256099942544~3347511713
        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");

        mAdView = findViewById(R.id.adView);
        tv = findViewById(R.id.tv);
        reButton = findViewById(R.id.btn_retry);

        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        gameSetting();

        btnfirst = (ImageView) findViewById(R.id.imageButton01);


    }

    public void clickBtn(View v) {

        int tag = (int) v.getTag();
        if (imageIndex == tag) {
            v.setVisibility(View.INVISIBLE);
            imageIndex++;
            if (imageIndex >= 12) {
                tv.setText("Clear");
                reButton.setEnabled(true);
            } else {
                tv.setText("" + (imageIndex + 1));
            }
        }
    }

    public void clickBtn01(View v) {
        btnfirst.setVisibility(View.INVISIBLE);
    }

    public void gameSetting(){
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < btnarr.length; i++) {
            arr.add(i);
        }
        Collections.shuffle(arr);

        for (int i = 0; i < btnarr.length; i++) {
            btnarr[i] = findViewById(R.id.btn01 + i);
            btnarr[i].setImageResource(R.drawable.btn01 + arr.get(i));
            btnarr[i].setTag(arr.get(i));
        }
    }


    public void clickRetry(View view) {
//        Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show();
        gameSetting();
        for (int i =0; i < btnarr.length; i++){
            btnarr[i].setVisibility(View.VISIBLE);
        }
        imageIndex =0;
        tv.setText("1");
        reButton.setEnabled(false);
    }
}