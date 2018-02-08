package com.framgia.framgia_json_httpurlconnection.screen.screen.repos;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.framgia.framgia_json_httpurlconnection.R;
import com.framgia.framgia_json_httpurlconnection.model.Repo;
import com.framgia.framgia_json_httpurlconnection.screen.BaseActivity;

import java.util.ArrayList;


/**
 * Repos Screen.
 */
public class ReposActivity extends BaseActivity implements ReposContract.View , View.OnClickListener{

    ReposContract.Presenter mPresenter;
    private  RecyclerView recyclerView;
    private  ReposAdapter mAdapter;
    private Button mSearch;
    private EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repos);

        mEditText = findViewById(R.id.editText_username);
        mSearch = findViewById(R.id.button_search);
        mSearch.setOnClickListener(this);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new ReposAdapter(this);
        recyclerView.setAdapter(mAdapter);

        mPresenter = new ReposPresenter();
        mPresenter.setView(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.onStart();
    }

    @Override
    protected void onStop() {
        mPresenter.onStop();
        super.onStop();
    }


    @Override
    public void showRepo(ArrayList<Repo> repos) {
        mAdapter.replaceData(repos);
    }


    @Override
    public String getUserInput() {
        return mEditText.getText().toString().trim();
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_search :
                if (!mEditText.getText().toString().isEmpty()) {
                    mPresenter.loadRepos(true);
                }
                break;
        }
    }
}
