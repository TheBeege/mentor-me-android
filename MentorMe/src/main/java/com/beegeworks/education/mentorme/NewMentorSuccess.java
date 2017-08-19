package com.beegeworks.education.mentorme;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class NewMentorSuccess extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_mentor_success);
        Intent intent = getIntent();

        TextView statusTextView = (TextView) findViewById(R.id.new_mentor_success_text);
        statusTextView.setText(intent.getStringExtra("response"));
    }
}
