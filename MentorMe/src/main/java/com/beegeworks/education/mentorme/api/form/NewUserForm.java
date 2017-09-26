package com.beegeworks.education.mentorme.api.form;

import android.util.Log;

import com.beegeworks.education.mentorme.util.ApplicationException;

import org.json.JSONException;
import org.json.JSONObject;

import lombok.Getter;

@Getter
public class NewUserForm {
    private JSONObject jsonObject;

    public void setUsername(String username) {
        try {
            jsonObject.put("username", username);
        } catch (JSONException e) {
            reportSettingFailure(e, "username", username);
            throw new ApplicationException("Failed to set username");
        }
    }

    public void setPassword(String password) {
        try {
            jsonObject.put("password", password);
        } catch (JSONException e) {
            reportSettingFailure(e, "password", password);
            throw new ApplicationException("Failed to set password");
        }
    }

    public void setDisplayName(String displayName) {
        try {
            jsonObject.put("displayName", displayName);
        } catch (JSONException e) {
            reportSettingFailure(e, "displayName", displayName);
            throw new ApplicationException("Failed to set display name");
        }
    }

    public void setEmail(String email) {
        try {
            jsonObject.put("email", email);
        } catch (JSONException e) {
            reportSettingFailure(e, "email", email);
            throw new ApplicationException("Failed to set email");
        }
    }

    private void reportSettingFailure(JSONException e, String field, String value) {
        Log.e(NewUserForm.class.getName(), "Failed to set field " + field + " to value " + value, e);
    }
}
