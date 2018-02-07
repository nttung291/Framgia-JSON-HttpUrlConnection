package com.framgia.framgia_json_httpurlconnection;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.framgia.framgia_json_httpurlconnection.adapter.ReposAdapter;
import com.framgia.framgia_json_httpurlconnection.model.Repo;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnFetchDataListener{

    private EditText mEditText;
    private Button mSearch;
    private ProgressDialog dialog;
    private ListRepos listRepos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUI();
        loadData();
    }


    private void setUI() {
        mEditText = findViewById(R.id.editText_username);
        mSearch = findViewById(R.id.button_search);
    }

    private void loadData() {
        Log.d("TAG", "loadData: " + "AAAA");
        dialog = new ProgressDialog(this);
        dialog.setMessage("Loading");
        mSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = mEditText.getText().toString();
                if (username.isEmpty()) {
                    return;
                }
//                dialog.show();
                new FetchDataFromUrl(MainActivity.this).execute(
                        "https://api.github.com/users/" + username + "/repos");
            }
        });
    }


    @Override
    public void onFetchDataSuccess(ArrayList<Repo> repos) {
        ArrayList<Repo> items = repos;
        Log.d("TAG", "onFetchDataSuccess: " + items.size());
        dialog.dismiss();
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ReposAdapter adapter = new ReposAdapter(this,items);
        recyclerView.setAdapter(adapter);
    }
}
