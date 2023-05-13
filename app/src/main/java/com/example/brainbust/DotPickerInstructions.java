package com.example.brainbust;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class BrainBustInstructions extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.brain_bust_instructions);
        initGUI();

    }

    private void initGUI() {
        Button btnPlay = findViewById(R.id.instructions_btn_play);
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to launch the BrainBustPlay activity
                Intent i = new Intent(BrainBustInstructions.this, BrainBustPlay.class);
                startActivity(i);
            }
        });

        ImageButton btnBack = findViewById(R.id.instructions_btn_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to launch the BrainBustInstructions activity
                Intent j = new Intent(BrainBustInstructions.this, BrainBustMain.class);
                startActivity(j);
            }
        });
    }
}