package com.example.brainbust;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BrainBustMain extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.brain_bust_main);
        initGUI();

    }

    private void initGUI() {
        Button btnPlay = findViewById(R.id.main_btn_play);
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to launch the BrainBustPlay activity
                Intent i = new Intent(BrainBustMain.this, BrainBustPlay.class);
                startActivity(i);
            }
        });

        Button btnInstructions = findViewById(R.id.main_btn_instructions);
        btnInstructions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to launch the BrainBustInstructions activity
                Intent j = new Intent(BrainBustMain.this, BrainBustInstructions.class);
                startActivity(j);
            }
        });
    }


}