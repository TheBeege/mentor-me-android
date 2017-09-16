package com.beegeworks.education.mentorme;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.beegeworks.education.mentorme.search.SearchMentorActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This is called by the new mentor button. It sends to the activity where a
     * user can create a new mentor profile for the first time.
     */
    public void setupNewMentor(@SuppressWarnings("UnusedParameters") View view) {
        Intent intent = new Intent(this, NewMentorActivity.class);
        startActivity(intent);
    }

    public void searchMentors(View view) {
        Intent intent = new Intent(this, SearchMentorActivity.class);
        startActivity(intent);
    }
}
