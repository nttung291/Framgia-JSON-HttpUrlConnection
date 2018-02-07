package com.framgia.framgia_json_httpurlconnection;

import com.framgia.framgia_json_httpurlconnection.model.Repo;

import java.util.ArrayList;

/**
 * Created by daolq on 11/8/17.
 */

public interface OnFetchDataListener {
    void onFetchDataSuccess(ArrayList<Repo> repos);
}
