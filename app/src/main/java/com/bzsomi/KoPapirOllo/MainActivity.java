package com.bzsomi.KoPapirOllo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView imgC, imgH;
    private TextView textC, textG, textH;
    private Button btnK, btnP, btnO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intit();

        btnK.setOnClickListener(imgHuman.setImageResource(R.drawable.rock));
        btnP.setOnClickListener(this);
        btnO.setOnClickListener(this);
    }

    private void intit(){
        imgC = findViewById(R.id.imgComputer);
        textC = findViewById(R.id.textComputer);
        textH = findViewById(R.id.textHuman);
        textG = findViewById(R.id.textMenet);
        imgH = findViewById(R.id.imgHuman);
        btnK = findViewById(R.id.btnKo);
        btnP = findViewById(R.id.btnPapir);
        btnO = findViewById(R.id.btnOllo);
    }

    @Override
    public void onClick(View v) {
        int viewId = v.getId();
    }
}