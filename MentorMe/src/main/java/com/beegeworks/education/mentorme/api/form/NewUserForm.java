package com.beegeworks.education.mentorme.api.form;

import android.util.Log;

import com.beegeworks.education.mentorme.util.ApplicationException;

import org.json.JSONException;
import org.json.JSONObject;

import lombok.Getter;

@Getter
public class NewUserForm {
    @Getter
    private JSONObject jsonObject;

    public void setUsername(String username) {
        setFormField("username", username);
    }

    public void setPassword(String password) {
        setFormField("password", password);
    }

    public void setDisplayName(String displayName) {
        setFormField("displayName", displayName);
    }

    public void setEmail(String email) {
        setFormField("email", email);
    }

    public void setSkill(String skill) {
        setFormField("skill", skill);
    }

    public void setSkillExperience(String skillExperience) {
        setFormField("skillExperience", skillExperience);
    }

    private void setFormField(String fieldName, String fieldValue) {
        try {
            jsonObject.put(fieldName, fieldValue);
        } catch (JSONException e) {
            reportSettingFailure(e, fieldName, fieldValue);
            throw new ApplicationException("Failed to set " + fieldName);
        }
    }

    private void reportSettingFailure(JSONException e, String field, String value) {
        Log.e(NewUserForm.class.getName(), "Failed to set field " + field + " to value " + value, e);
    }
}
