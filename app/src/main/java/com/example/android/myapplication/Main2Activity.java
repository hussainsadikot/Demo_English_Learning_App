package com.example.android.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import java.util.HashMap;
import java.util.Map;

public class Main2Activity extends AppCompatActivity {

    private TextSwitcher textSwitcherTile,textSwitcherDefinition;
    private int  arrayIndex=0;


    private Button iknow,idont,reveal;
    private  String[] words={"a","b","c","d"};
    private  String[] words_definition={"apple","ball","cat","dog"};
    private TextView textView_title, textView_definition, tvProgressMaster,tvProgressLearning;
    private ProgressBar progressBar,progressBarMaster,progressBarLearning;
    private Map <String,String> map =new HashMap<>();
    private int progressMaster = 0;
    private int progressLearning = 0;
    private int counter =0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        for(int i = 0; i<=words.length-1;i++) {
            map.put(words[i], words_definition[i]);
        }


        progressBarMaster= findViewById(R.id.progressbar_master);
        tvProgressMaster = findViewById(R.id.tv_progress_master);
        progressBarMaster.setProgress(0);
        progressBarLearning =findViewById(R.id.progressbar_learning);
        progressBarLearning.setProgress(0);
        tvProgressLearning = findViewById(R.id.learning_progress_tv);
        textSwitcherTile = findViewById(R.id.tv_word_title);
        textSwitcherDefinition =findViewById(R.id.tv_definition_word);
        textSwitcherTile = findViewById(R.id.tv_word_title);
        textSwitcherDefinition =findViewById(R.id.tv_definition_word);
        reveal = findViewById(R.id.reveal_button);
        idont =findViewById(R.id.i__dont_know_button);
        iknow =findViewById(R.id.i_know_button);
        textSwitcherDefinition.setVisibility(View.GONE);
        idont.setVisibility(View.GONE);
        iknow.setVisibility(View.GONE);

        reveal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                idont.setVisibility(View.VISIBLE);
                iknow.setVisibility(View.VISIBLE);
                textSwitcherDefinition.setVisibility(View.VISIBLE);
                reveal.setVisibility(View.GONE);
            }
        });

        iknow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            //method
                nextWordAndDefinition();
                if (progressBarMaster.getProgress() <= progressBarMaster.getMax()){
                    progressBarMaster.incrementProgressBy(1);
                    counter++;
                    progressMaster++;
                    String curruntprogressnumberforMaster = Integer.toString(progressBarMaster.getProgress());
                    String msg = " You have mastered "+curruntprogressnumberforMaster+" out of 50"+progressMaster;
                    tvProgressMaster.setText(msg);
                }
                if(counter ==6){
                    counter =0;
                    progressLearning--;
                    progressBarLearning.setProgress(progressLearning);
                    String curruntprogressnumberforLearning = Integer.toString(progressBarLearning.getProgress());
                    String msg2 = " You are learning "+curruntprogressnumberforLearning+" out of 50"+progressLearning;
                    tvProgressLearning.setText(msg2);
                }

               revealNextWord();
            }
        });
        idont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                nextWordAndDefinition();
                progressLearning++;
                progressBarLearning.setProgress(progressLearning);
                String curruntprogressnumberforLearning = Integer.toString(progressBarLearning.getProgress());
                String msg2 = " You are learning "+curruntprogressnumberforLearning+" out of 50"+progressLearning;
                tvProgressLearning.setText(msg2);
                revealNextWord();
            }
        });

        textSwitcherTile.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                 textView_title = new TextView(Main2Activity.this);
                 textView_title.setTextColor(Color.BLUE);
                 textView_title.setTextSize(60);
                 textView_title.setGravity(Gravity.CENTER_HORIZONTAL);
                 return textView_title;
            }
        });
        textSwitcherDefinition.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                textView_definition = new TextView(Main2Activity.this);
                textView_definition.setTextColor(Color.BLUE);
                textView_definition.setTextSize(20);
                return textView_definition;

            }
        });
        textSwitcherTile.setText(words[arrayIndex]);
        textSwitcherDefinition.setText(words_definition[arrayIndex]);



    }

    private void revealNextWord() {
        textSwitcherDefinition.setVisibility(View.GONE);
        idont.setVisibility(View.GONE);
        iknow.setVisibility(View.GONE);

        reveal.setVisibility(View.VISIBLE);
    }

    private void nextWordAndDefinition() {
        if(arrayIndex== words.length-1){
            arrayIndex = 0;
            textSwitcherTile.setText(words[arrayIndex]);
            textSwitcherDefinition.setText(words_definition[arrayIndex]);
        }else{
            textSwitcherTile.setText(words[++arrayIndex]);
            textSwitcherDefinition.setText(words_definition[arrayIndex]);
        }


    }

}
