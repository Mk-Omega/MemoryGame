package com.org.memorygame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    CardView c1, c2;
    TextView p1, p2;
    ImageView r1_1, r1_2, r1_3, r2_1, r2_2, r2_3;

    Integer[] cardsArray = {101, 102, 103, 201, 202, 203};

    int img101, img102, img103, img201, img202, img203;

    int Fcard, Scard;
    int Fclick, Sclick;
    int cardNumber = 1;
    int turn = 1;
    int playerPoints = 0, cpuPoints = 0;

    public MediaPlayer correct, incorrect, finish;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        correct = MediaPlayer.create(this, R.raw.correct);
        incorrect = MediaPlayer.create(this, R.raw.incorrect);
        finish = MediaPlayer.create(this, R.raw.ending);

        c1 = findViewById(R.id.c1);
        c2 = findViewById(R.id.c2);
        p1 = findViewById(R.id.p1);
        p2 = findViewById(R.id.p2);
        r1_1 = findViewById(R.id.r1_1);
        r1_2 = findViewById(R.id.r1_2);
        r1_3 = findViewById(R.id.r1_3);
        r2_1 = findViewById(R.id.r2_1);
        r2_2 = findViewById(R.id.r2_2);
        r2_3 = findViewById(R.id.r2_3);

        r1_1.setTag("0");
        r1_2.setTag("1");
        r1_3.setTag("2");
        r2_1.setTag("3");
        r2_2.setTag("4");
        r2_3.setTag("5");

        frontCardResources();

        Collections.shuffle(Arrays.asList(cardsArray));

        c2.setCardBackgroundColor(Color.parseColor("#eeeeee"));
        p2.setTextColor(Color.GRAY);

        c1.setCardBackgroundColor(Color.parseColor("#150485"));
        p1.setTextColor(Color.WHITE);


        r1_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int card = Integer.parseInt((String) v.getTag());
                execute(r1_1, card);
            }
        });

        r1_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int card = Integer.parseInt((String) v.getTag());
                execute(r1_2, card);
            }
        });

        r1_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int card = Integer.parseInt((String) v.getTag());
                execute(r1_3, card);
            }
        });

        r2_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int card = Integer.parseInt((String) v.getTag());
                execute(r2_1, card);
            }
        });

        r2_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int card = Integer.parseInt((String) v.getTag());
                execute(r2_2, card);
            }
        });

        r2_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int card = Integer.parseInt((String) v.getTag());
                execute(r2_3, card);
            }
        });
    }

    private void execute(ImageView iv, int card){
        if(cardsArray[card] == 101){
            iv.setImageResource(img101);
        }
        else if(cardsArray[card] == 102){
            iv.setImageResource(img102);
        }
        else if(cardsArray[card] == 103){
            iv.setImageResource(img103);
        }
        else if(cardsArray[card] == 201){
            iv.setImageResource(img201);
        }
        else if(cardsArray[card] == 202){
            iv.setImageResource(img202);
        }
        else if(cardsArray[card] == 203){
            iv.setImageResource(img203);
        }

        if(cardNumber == 1){
            Fcard = cardsArray[card];

            if(Fcard > 200){
                Fcard = Fcard - 100;
            }
            cardNumber = 2;
            Fclick = card;

            iv.setEnabled(false);
        }
        else if(cardNumber == 2){
            Scard = cardsArray[card];

            if(Scard > 200){
                Scard = Scard - 100;
            }
            cardNumber = 1;
            Sclick = card;

            r1_1.setEnabled(false);
            r1_2.setEnabled(false);
            r1_3.setEnabled(false);
            r2_1.setEnabled(false);
            r2_2.setEnabled(false);
            r2_3.setEnabled(false);

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    calculate();
                }
            }, 1000);
        }
    }

    private void calculate(){
        if(Fcard == Scard){
            if(Fclick == 0){
                r1_1.setVisibility(View.INVISIBLE);
            }
            else if(Fclick == 1){
                r1_2.setVisibility(View.INVISIBLE);
            }
            else if(Fclick == 2){
                r1_3.setVisibility(View.INVISIBLE);
            }
            else if(Fclick == 3){
                r2_1.setVisibility(View.INVISIBLE);
            }
            else if(Fclick == 4){
                r2_2.setVisibility(View.INVISIBLE);
            }
            else if(Fclick == 5){
                r2_3.setVisibility(View.INVISIBLE);
            }

            if(Sclick == 0){
                r1_1.setVisibility(View.INVISIBLE);
            }
            else if(Sclick == 1){
                r1_2.setVisibility(View.INVISIBLE);
            }
            else if(Sclick == 2){
                r1_3.setVisibility(View.INVISIBLE);
            }
            else if(Sclick == 3){
                r2_1.setVisibility(View.INVISIBLE);
            }
            else if(Sclick == 4){
                r2_2.setVisibility(View.INVISIBLE);
            }
            else if(Sclick == 5){
                r2_3.setVisibility(View.INVISIBLE);
            }

            if(turn == 1){
                playerPoints++;
                p1.setText("Player 1: " + playerPoints);
                correct.start();
            }
            else if(turn == 2){
                cpuPoints++;
                p2.setText("Player 2: " + cpuPoints);
                correct.start();
            }
        }
        else{
            r1_1.setImageResource(R.drawable.back);
            r1_2.setImageResource(R.drawable.back);
            r1_3.setImageResource(R.drawable.back);
            r2_1.setImageResource(R.drawable.back);
            r2_2.setImageResource(R.drawable.back);
            r2_3.setImageResource(R.drawable.back);

            if(turn == 1){
                turn = 2;
                c2.setCardBackgroundColor(Color.parseColor("#150485"));
                p2.setTextColor(Color.WHITE);
                c1.setCardBackgroundColor(Color.parseColor("#eeeeee"));
                p1.setTextColor(Color.GRAY);
                incorrect.start();
            }
            else if(turn == 2){
                turn = 1;
                c2.setCardBackgroundColor(Color.parseColor("#eeeeee"));
                p2.setTextColor(Color.GRAY);
                c1.setCardBackgroundColor(Color.parseColor("#150485"));
                p1.setTextColor(Color.WHITE);
                incorrect.start();
            }
        }

        r1_1.setEnabled(true);
        r1_2.setEnabled(true);
        r1_3.setEnabled(true);
        r2_1.setEnabled(true);
        r2_2.setEnabled(true);
        r2_3.setEnabled(true);

        checkEnd();
    }

    private void checkEnd(){
        if(r1_1.getVisibility() == View.INVISIBLE &&
                r1_2.getVisibility() == View.INVISIBLE &&
                r1_3.getVisibility() == View.INVISIBLE &&
                r2_1.getVisibility() == View.INVISIBLE &&
                r2_2.getVisibility() == View.INVISIBLE &&
                r2_3.getVisibility() == View.INVISIBLE)
        {
            finish.start();

            MaterialAlertDialogBuilder dialogBuilder = new MaterialAlertDialogBuilder(this);
            dialogBuilder.setTitle("Message").setMessage("Game Over! \n Player 1: " + playerPoints + "\n Player 2: " + cpuPoints)
            .setCancelable(false).setPositiveButton("New Game", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(i);
                    finish();
                }
            })
            .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    System.exit(0);
                }
            }).show();
        }
    }

    private void frontCardResources(){
        img101 = R.drawable.c1;
        img102 = R.drawable.c2;
        img103 = R.drawable.c3;
        img201 = R.drawable.c1_copy;
        img202 = R.drawable.c2_copy;
        img203 = R.drawable.c3_copy;
    }
}