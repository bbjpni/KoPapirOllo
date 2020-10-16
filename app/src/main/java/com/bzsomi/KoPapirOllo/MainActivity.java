package com.bzsomi.KoPapirOllo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.nio.channels.GatheringByteChannel;
import java.util.Random;

public class MainActivity extends AppCompatActivity{
    private ImageView imgC, imgH;
    private TextView textC, textG, textH;
    private Button btnK, btnP, btnO;

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
        imgC = findViewById(R.id.imgComputer);
        textC = findViewById(R.id.textComputer);
        textH = findViewById(R.id.textHuman);
        textG = findViewById(R.id.textMenet);
        imgH = findViewById(R.id.imgHuman);
        btnK = findViewById(R.id.btnKo);
        btnP = findViewById(R.id.btnPapir);
        btnO = findViewById(R.id.btnOllo);
    }

    public void Genrated(int tipp) {
        Random rnd = new Random();
        int szam = rnd.nextInt(3);
        if (szam == 0){imgC.setImageResource(R.drawable.rock);}
        else if (szam == 1){imgC.setImageResource(R.drawable.paper);}
        else if (szam == 2){imgC.setImageResource(R.drawable.scissors);}
        //textG.setText(tipp==0 && szam==2 || tipp == 1 && szam == 0 || tipp == 2 && szam == 1 ? "nyert" : szam == tipp ? "döntetlen" : "vesztet");
        String back = (tipp==0 && szam==2 || tipp == 1 && szam == 0 || tipp == 2 && szam == 1 ? "nyert" : szam == tipp ? "döntetlen" : "vesztet");
        Toast.makeText(getApplicationContext(), back, Toast.LENGTH_SHORT).show();
    }
}