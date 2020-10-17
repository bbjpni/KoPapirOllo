package com.bzsomi.KoPapirOllo;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.nio.channels.GatheringByteChannel;
import java.util.Random;

public class MainActivity extends AppCompatActivity{
    private ImageView imgC, imgH;
    private ImageView imgHH1, imgHH2, imgHH3, imgCH1, imgCH2, imgCH3;
    private TextView textC, textG, textH, textS;
    private Button btnK, btnP, btnO;
    int hpH, hpC, same;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intit();

        btnK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgH.setImageResource(R.drawable.rock);
                Genrated(0);
            }
        });
        btnP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgH.setImageResource(R.drawable.paper);
                Genrated(1);
            }
        });
        btnO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgH.setImageResource(R.drawable.scissors);
                Genrated(2);
            }
        });
    }

    private void intit() {
        imgCH1 = findViewById(R.id.imgComputerH1);
        imgCH2 = findViewById(R.id.imgComputerH2);
        imgCH3 = findViewById(R.id.imgComputerH3);
        imgHH1 = findViewById(R.id.imgHumanH1);
        imgHH2 = findViewById(R.id.imgHumanH2);
        imgHH3 = findViewById(R.id.imgHumanH3);
        imgC = findViewById(R.id.imgComputer);
        textC = findViewById(R.id.textComputer);
        textH = findViewById(R.id.textHuman);
        textS = findViewById(R.id.textSame);
        imgH = findViewById(R.id.imgHuman);
        btnK = findViewById(R.id.btnKo);
        btnP = findViewById(R.id.btnPapir);
        btnO = findViewById(R.id.btnOllo);
        hpC = 0;
        hpH = 0;
        same = 0;
    }

    public void Genrated(int tipp) {
        Random rnd = new Random();
        int szam = rnd.nextInt(3);
        if (szam == 0){imgC.setImageResource(R.drawable.rock);}
        else if (szam == 1){imgC.setImageResource(R.drawable.paper);}
        else if (szam == 2){imgC.setImageResource(R.drawable.scissors);}
        String back = (tipp==0 && szam==2 || tipp == 1 && szam == 0 || tipp == 2 && szam == 1 ? "nyert" : szam == tipp ? "döntetlen" : "vesztet");
        Toast.makeText(getApplicationContext(), back, Toast.LENGTH_SHORT).show();
        if (tipp==0 && szam==2 || tipp == 1 && szam == 0 || tipp == 2 && szam == 1){hpH++; HeartDown(false);}
        else if(szam == tipp){same++;}
        else{hpC++; HeartDown(true);}
        textS.setText("Döntetlenek száma: "+same);
        Alerter();
    }

    public void Alerter(){
        if (hpH == 3 ^ hpC == 3){
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("A játék véget ért!");
            alert.setMessage("Szeretne újra játszani");
            alert.setNegativeButton("Igen", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) { Reload(); }
            });
            alert.setPositiveButton("Nem", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) { System.exit(0); }
            });
            alert.setCancelable(false);
            alert.create().show();
        }
    }

    public void HeartUp(){
        imgCH1.setImageResource(R.drawable.heart2);
        imgCH2.setImageResource(R.drawable.heart2);
        imgCH3.setImageResource(R.drawable.heart2);
        imgHH1.setImageResource(R.drawable.heart2);
        imgHH2.setImageResource(R.drawable.heart2);
        imgHH3.setImageResource(R.drawable.heart2);
    }

    public void HeartDown(boolean player){
        if (hpC == 3 && player){ imgHH3.setImageResource(R.drawable.heart1); }
        else if (hpC == 2 && player){ imgHH2.setImageResource(R.drawable.heart1); }
        else if (hpC == 1 && player){ imgHH1.setImageResource(R.drawable.heart1); }
        else if (hpH == 3 && !player){ imgCH3.setImageResource(R.drawable.heart1); }
        else if (hpH == 2 && !player){ imgCH2.setImageResource(R.drawable.heart1); }
        else if (hpH == 1 && !player){ imgCH1.setImageResource(R.drawable.heart1); }
    }

    public void Reload(){
        intit();
        textS.setText("Döntetlenek száma: 0");
        HeartUp();
    }
}