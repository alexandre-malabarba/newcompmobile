package com.example.xandcompmobile.view.UML.uniritter.repository;

import android.content.Context;
import android.util.Log;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.xandcompmobile.view.UML.uniritter.model.Photos;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class PhotosDataBase implements Response.Listener<JSONArray>, Response.ErrorListener {
    private static final String tagLog = "PhotosDataBase";

    private static List<Photos> photos;
    private static PhotosDataBase instance = null;

    private PhotosDataBase(Context context){
        super();
        if(photos == null){
            photos = new ArrayList<>();
            RequestQueue queue = Volley.newRequestQueue(context);
            String url = "https://jsonplaceholder.typicode.com/photos";
            JsonArrayRequest jaRequest = new JsonArrayRequest(
                    Request.Method.GET, url,
                    null, this, this);
            queue.add(jaRequest);
        }
    }

    public static List<Photos> getPhotos() { return photos; }

    public static PhotosDataBase getInstance(Context context){
        instance = new PhotosDataBase(context);
        return instance;
    }

    @Override
    public void onErrorResponse(VolleyError error) { Log.e(tagLog, tagLog+"/"+error.getMessage()); }

    @Override
    public void onResponse(JSONArray response) {
        for (int i=0;i< response.length();i++){
            try{
                JSONObject json = response.getJSONObject(i);
                photos.add( new Photos(
                        json.getInt("albumId"),
                        json.getInt("id"),
                        json.getString("title"),
                        json.getString("url"),
                        json.getString("thumbnailUrl")
                ) );
            }catch (JSONException e){
                e.printStackTrace();
            }
        }
    }
}
