package com.framgia.framgia_json_httpurlconnection.screen.screen.repos;


import com.framgia.framgia_json_httpurlconnection.model.Repo;
import com.framgia.framgia_json_httpurlconnection.screen.BasePresenter;

import java.util.ArrayList;

/**
 * This specifies the contract between the view and the presenter.
 */
interface ReposContract {
    /**
     * View.
     */
    interface View {
        void showRepo(ArrayList<Repo> repos);

        String getUserInput();

    }

    /**
     * Presenter.
     */
    interface Presenter extends BasePresenter<View> {

        void loadRepos(boolean forceUpdate);

    }
}
