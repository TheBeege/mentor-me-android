package com.beegeworks.education.mentorme;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.beegeworks.education.mentorme.api.ApiAdapter;
import com.beegeworks.education.mentorme.api.form.NewUserForm;

import org.json.JSONObject;

public class NewMentorActivity extends AppCompatActivity {

    private static final String TAG = "NewMentorActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_mentor);
    }

    public void submitRegistration(View view) {
        // Instantiate the RequestQueue.
        String apiPath = "user";

        NewUserForm newUserForm = new NewUserForm();
        newUserForm.setUsername(((EditText) findViewById(R.id.new_mentor_username_form)).getText().toString());
        newUserForm.setPassword(((EditText) findViewById(R.id.new_mentor_password_form)).getText().toString());
        newUserForm.setDisplayName(((EditText) findViewById(R.id.new_mentor_display_name_form)).getText().toString());
        newUserForm.setEmail(((EditText) findViewById(R.id.new_mentor_email_form)).getText().toString());
        newUserForm.setSkill(((EditText) findViewById(R.id.new_mentor_skill_form)).getText().toString());
        newUserForm.setSkillExperience(((EditText) findViewById(R.id.new_mentor_skill_experience_description_form)).getText().toString());

        Log.d(TAG, "url: " + BuildConfig.API_URL + apiPath);

        // Request a JSON response from the provided URL.
        final Intent intent = new Intent(this, NewMentorSuccess.class);
        JsonObjectRequest createNewUserRequest = new JsonObjectRequest(
                Request.Method.POST,
                BuildConfig.API_URL + apiPath,
                newUserForm.getJsonObject(),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(TAG, "onResponse: lol");
                        intent.putExtra("response", response.toString());
                        startActivity(intent);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "That didn't work! -- " + error.toString());
                intent.putExtra("response", error.toString());
                startActivity(intent);
            }
        });
        // Add the request to the RequestQueue.
        ApiAdapter.getInstance(this.getApplicationContext()).getRequestQueue().add(createNewUserRequest);
    }
}
