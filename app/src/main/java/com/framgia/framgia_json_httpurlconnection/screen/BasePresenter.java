package com.framgia.framgia_json_httpurlconnection.screen;

/**
 * Created by le.quang.dao on 10/03/2017.
 */

public interface BasePresenter<T> {

    void setView(T view);

    void onStart();

    void onStop();
}
