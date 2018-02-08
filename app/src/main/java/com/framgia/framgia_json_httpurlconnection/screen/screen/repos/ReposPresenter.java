package com.framgia.framgia_json_httpurlconnection.screen.screen.repos;

import android.view.View;

import com.framgia.framgia_json_httpurlconnection.model.Repo;
import com.framgia.framgia_json_httpurlconnection.remote.FetchDataFromUrl;
import com.framgia.framgia_json_httpurlconnection.remote.OnFetchDataListener;

import java.util.ArrayList;

/**
 * Listens to user actions from the UI ({@link ReposActivity}), retrieves the data and updates
 * the UI as required.
 */
final class ReposPresenter implements ReposContract.Presenter,OnFetchDataListener{
    private static final String TAG = ReposPresenter.class.getName();

    private ReposContract.View mView;

    public ReposPresenter() {
    }

    @Override
    public void setView(ReposContract.View view) {
        mView = view;
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onStop() {
    }

    @Override
    public void loadRepos(boolean forceUpdate) {
        loadRepos(mView.getUserInput());
    }

    @Override
    public void onFetchDataSuccess(ArrayList<Repo> repos) {
       if (repos != null){
           processRepos(repos);
       }
    }

    private void processRepos(ArrayList<Repo> repos) {
        if (repos.isEmpty()) {

        } else {
            mView.showRepo(repos);
        }
    }

    private void loadRepos(String username) {
        new FetchDataFromUrl(ReposPresenter.this).execute(
                "https://api.github.com/users/" + username + "/repos");
    }

}
