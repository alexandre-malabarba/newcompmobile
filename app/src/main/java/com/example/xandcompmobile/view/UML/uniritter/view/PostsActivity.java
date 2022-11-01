package com.example.xandcompmobile.view.UML.uniritter.view;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.xandcompmobile.R;
import com.example.xandcompmobile.view.UML.uniritter.presenter.ListsPresenter;
import com.example.xandcompmobile.view.UML.uniritter.presenter.PresenterContract;

public class PostsActivity extends AppCompatActivity implements PresenterContract.view{
    private static final String tagLog = "PostsActivity";
    private PresenterContract.presenterLists presenterLists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);
        Log.d(tagLog, tagLog+"/onCreate");
        this.presenterLists = new ListsPresenter(this);

        presenterLists.setAdapterRVPosts(
                ((RecyclerView) findViewById(R.id.RVPosts)),
                getIntent().getStringExtra("ID_USER"),
                getIntent().getStringExtra("NOME_USER")
        );

    }

    @Override
    public void message(String msg) { /**/ }

    @Override
    public Activity getActivity() { return this; }
}
