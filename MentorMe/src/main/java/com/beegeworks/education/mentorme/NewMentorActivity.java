package com.beegeworks.education.mentorme;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class NewMentorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_mentor);
    }

    public void submitRegistration(View view) {
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String apiPath = "user";

        JSONObject userDataJson = new JSONObject();
        try {
            userDataJson.put("username", ((EditText) findViewById(R.id.new_mentor_username_form)).getText().toString());
            userDataJson.put("password", ((EditText) findViewById(R.id.new_mentor_password_form)).getText().toString());
            userDataJson.put("displayName", ((EditText) findViewById(R.id.new_mentor_display_name_form)).getText().toString());
            userDataJson.put("email", ((EditText) findViewById(R.id.new_mentor_email_form)).getText().toString());
            userDataJson.put("skill", ((EditText) findViewById(R.id.new_mentor_skill_form)).getText().toString());
            userDataJson.put("skillExperience", ((EditText) findViewById(R.id.new_mentor_skill_experience_description_form)).getText().toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        // Request a JSON response from the provided URL.
        JsonObjectRequest createNewUserRequest = new JsonObjectRequest(
                Request.Method.POST,
                BuildConfig.API_URL + apiPath,
                userDataJson,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("new mentor activity", "onResponse: lol");
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("new mentor activity", "That didn't work!");
            }
        });
        // Add the request to the RequestQueue.
        queue.add(createNewUserRequest);
    }
}
