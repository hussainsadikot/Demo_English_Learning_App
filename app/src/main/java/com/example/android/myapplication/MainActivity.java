package com.example.android.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    TopicAdapter topicAdapter;
    List<Topics> topics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);
        topics = new ArrayList<>();
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        topics.add( new Topics(1,"Art and Culture","0 of 50  words mastered"));
        topics.add( new Topics(2,"Geography and places","0 of 50  words mastered"));
        topics.add( new Topics(3,"Health and fitness","0 of 50  words mastered"));
        topics.add( new Topics(4,"History and events","0 of 50  words mastered"));
        topics.add( new Topics(5,"Natural sciences and nature","0 of 50  words mastered"));
        topics.add( new Topics(6,"People and self","0 of 50  words mastered"));
        topics.add( new Topics(7,"Philosophy and thinking","0 of 50  words mastered"));
        topics.add( new Topics(8,"Religion and spirituality","0 of 50  words mastered"));
        topics.add( new Topics(9,"Social sciences and society","0 of 50  words mastered"));
        topics.add( new Topics(10,"Technology and applied sciences","0 of 50  words mastered"));

        topicAdapter = new TopicAdapter(this,topics);
        topicAdapter.setOnItemClickListener(new TopicAdapter.OnItemClickListener() {

            @Override
            public void onButtonClick(int position) {
                Toast.makeText(MainActivity.this, "Go to List of Words", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this,Main2Activity.class));
            }
        });
        recyclerView.setAdapter(topicAdapter);

    }
}
