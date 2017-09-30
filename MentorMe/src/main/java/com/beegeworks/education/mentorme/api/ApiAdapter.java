package com.beegeworks.education.mentorme.api;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.beegeworks.education.mentorme.BuildConfig;
import com.beegeworks.education.mentorme.api.dto.NewUserDto;
import com.beegeworks.education.mentorme.api.form.NewUserForm;

import static android.support.v4.content.ContextCompat.startActivity;

// https://developer.android.com/training/volley/requestqueue.html
public class ApiAdapter {

    private static ApiAdapter mInstance;
    private RequestQueue mRequestQueue;
    private ImageLoader mImageLoader;
    private Context mCtx;

    private ApiAdapter(Context context) {
        mCtx = context;
        mRequestQueue = getRequestQueue();

        mImageLoader = new ImageLoader(mRequestQueue,
                new ImageLoader.ImageCache() {
                    private final LruCache<String, Bitmap>
                            cache = new LruCache<>(20);

                    @Override
                    public Bitmap getBitmap(String url) {
                        return cache.get(url);
                    }

                    @Override
                    public void putBitmap(String url, Bitmap bitmap) {
                        cache.put(url, bitmap);
                    }
                });
    }

    public static synchronized ApiAdapter getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new ApiAdapter(context);
        }
        return mInstance;
    }

    public NewUserDto createNewUser(NewUserForm newUserForm, final Context context, Class destinationActivity) {
        final Intent intent = new Intent(context, destinationActivity);

        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.POST,
                BuildConfig.API_URL + "user",
                newUserForm.getJsonObject(),
                new Response.Listener<NewUserDto>() {

                    @Override
                    public void onResponse(NewUserDto response) {

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                intent.putExtra("response", error.toString());
                startActivity(context, intent, null);
            }
        }
        );
        newUserForm.getJsonObject();
        return null;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            // getApplicationContext() is key, it keeps you from leaking the
            // Activity or BroadcastReceiver if someone passes one in.
            mRequestQueue = Volley.newRequestQueue(mCtx.getApplicationContext());
        }
        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }

    public ImageLoader getImageLoader() {
        return mImageLoader;
    }
}
