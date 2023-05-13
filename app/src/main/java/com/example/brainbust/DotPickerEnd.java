package com.example.brainbust;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class BrainBustEnd extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.brain_bust_end);
        initGUI();

    }

    private void initGUI() {
        TextView myScore = findViewById(R.id.brain_bust_score);
        TextView myCorrect = findViewById(R.id.brain_bust_correct);
        TextView myStreak = findViewById(R.id.brain_bust_streak);

        Bundle b = getIntent().getExtras();
        String score = String.valueOf((int) b.get("score"));
        myScore.setText(score);
        String correctAnswers = String.valueOf((int) b.get("correctAnswers"));
        myCorrect.setText(correctAnswers);
        String streak = String.valueOf((int) b.get("streak"));
        myStreak.setText(streak);

        Button btnNext = findViewById(R.id.brain_bust_end_btn_next);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to launch the BrainBustPlay activity
                Intent i = new Intent(BrainBustEnd.this, BrainBustMain.class);
                startActivity(i);
            }
        });

    }


}