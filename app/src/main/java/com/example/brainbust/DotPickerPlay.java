package com.example.brainbust;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import android.widget.Toast;


public class BrainBustPlay extends Activity {
    private int questionsPerGame = 5;
    private int correctAnswers = 0;
    private int counter = 0;
    private int score = 0;
    private int streak = 0;
    Map<Integer, ArrayList<String>> QA = new HashMap<Integer, ArrayList<String>>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.brain_bust_play);
        initQA();
        initGUI();

    }

    private void initQA() {
        QA.put(0, new ArrayList<String>(Arrays.asList("tetris_question1", "tetris_question1_answer", "tetris_question4_answer", "tetris_question3_answer")));
        QA.put(1, new ArrayList<String>(Arrays.asList("tetris_question2", "tetris_answer_option1", "tetris_question2_answer", "tetris_question3_answer")));
        QA.put(2, new ArrayList<String>(Arrays.asList("tetris_question3", "tetris_question5_answer", "tetris_question3_answer", "tetris_answer_option2")));
        QA.put(3, new ArrayList<String>(Arrays.asList("tetris_question4", "tetris_question3_answer", "tetris_question5_answer", "tetris_question4_answer")));
        QA.put(4, new ArrayList<String>(Arrays.asList("tetris_question5", "tetris_question5_answer", "tetris_question1_answer", "tetris_answer_option2")));
        QA.put(5, new ArrayList<String>(Arrays.asList("freq_question1", "freq_question1_answer", "freq_question1_option1", "freq_question1_option2")));
        QA.put(6, new ArrayList<String>(Arrays.asList("freq_question2", "freq_question2_option2", "freq_question2_option1", "freq_question2_answer")));
        QA.put(7, new ArrayList<String>(Arrays.asList("freq_question3", "freq_question3_option1", "freq_question3_answer", "freq_question3_option2")));
        QA.put(8, new ArrayList<String>(Arrays.asList("freq_question4", "freq_question4_option2", "freq_question4_option1", "freq_question4_answer")));
        QA.put(9, new ArrayList<String>(Arrays.asList("freq_question5", "freq_question5_answer", "freq_question5_option1", "freq_question5_option2")));
    }

    private void initGUI() {
        new CountDownTimer(questionsPerGame*5000, 5000) {
            private boolean isButtonClicked = false;
            Toast right = Toast.makeText(getApplicationContext(), "Correct!", Toast.LENGTH_LONG);
            Toast wrong = Toast.makeText(getApplicationContext(), "Wrong!", Toast.LENGTH_LONG);

            @Override
            public void onTick(long l) {
                right.cancel();
                wrong.cancel();
                Random random = new Random();
                int r = random.nextInt(QA.size());
                String question = QA.get(r).get(0);
                String option1 = QA.get(r).get(1);
                String option2 = QA.get(r).get(2);
                String option3 = QA.get(r).get(3);
                String answer = question + "_answer";

                ImageView imageView = findViewById(R.id.question);
                imageView.setImageResource(getResources().getIdentifier(question,"drawable", getPackageName()));

                ImageButton imageButton1 = findViewById(R.id.optionA);
                imageButton1.setImageResource(getResources().getIdentifier(option1,"drawable", getPackageName()));

                ImageButton imageButton2 = findViewById(R.id.optionB);
                imageButton2.setImageResource(getResources().getIdentifier(option2,"drawable", getPackageName()));

                ImageButton imageButton3 = findViewById(R.id.optionC);
                imageButton3.setImageResource(getResources().getIdentifier(option3,"drawable", getPackageName()));

                imageButton1.setEnabled(true);
                imageButton2.setEnabled(true);
                imageButton3.setEnabled(true);

                imageButton1.setOnClickListener(v -> {
                    imageButton1.setEnabled(false);
                    imageButton2.setEnabled(false);
                    imageButton3.setEnabled(false);
                    // Check answer
                    if (option1.equals(answer)) {
                        correctAnswers++;
                        counter++;
                        score += 500;
                        right.show();
                    }
                    else {
                        if (counter > 1) {
                            score += 200*counter;
                        }
                        if (counter > streak) {
                            streak = counter;
                        }
                        counter = 0;
                        wrong.show();
                    }
                });

                imageButton2.setOnClickListener(v -> {
                    imageButton1.setEnabled(false);
                    imageButton2.setEnabled(false);
                    imageButton3.setEnabled(false);
                    // Check answer
                    if (option2.equals(answer)) {
                        correctAnswers++;
                        counter++;
                        score+=500;
                        right.show();
                    }
                    else {
                        if (counter > 1) {
                            score += 200*counter;
                        }
                        if (counter > streak) {
                            streak = counter;
                        }
                        counter = 0;
                        wrong.show();
                    }
                });

                imageButton3.setOnClickListener(v -> {
                    imageButton1.setEnabled(false);
                    imageButton2.setEnabled(false);
                    imageButton3.setEnabled(false);
                    // Check answer
                    if (option3.equals(answer)) {
                        correctAnswers++;
                        counter++;
                        score+=500;
                        right.show();
                    }
                    else {
                        if (counter > 1) {
                            score += 200*counter;
                        }
                        if (counter > streak) {
                            streak = counter;
                        }
                        counter = 0;
                        wrong.show();
                    }
                });
            }

            @Override
            public void onFinish() {
                right.cancel();
                wrong.cancel();
                Intent i = new Intent(BrainBustPlay.this, BrainBustEnd.class);
                i.putExtra("score", score);
                i.putExtra("correctAnswers", correctAnswers);
                i.putExtra("streak", streak);
                startActivity(i);
            }
        }.start();

    }


}