package com.framgia.framgia_json_httpurlconnection;

import android.os.AsyncTask;
import com.framgia.framgia_json_httpurlconnection.model.Repo;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by nttungg on 2/7/18.
 */

public class FetchDataFromUrl extends AsyncTask<String,Void,ArrayList<Repo>> {

    private OnFetchDataListener mOnFetchDataListener;
    private ArrayList<Repo> repoArrayList = new ArrayList<>();
    public FetchDataFromUrl(OnFetchDataListener onFetchDataListener) {
        mOnFetchDataListener = onFetchDataListener;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected ArrayList<Repo> doInBackground(String... strings) {
        try {
            String json = getJSONStringFromURL(strings[0]);
            JSONArray jsonarray = new JSONArray(json);
            repoArrayList = Repo.fromJson(jsonarray);
            return repoArrayList;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(ArrayList<Repo> repos) {
        super.onPostExecute(repos);
        mOnFetchDataListener.onFetchDataSuccess(repos);
    }

    private String getJSONStringFromURL(String urlString) throws IOException, JSONException {

        HttpURLConnection urlConnection = null;

        URL url = new URL(urlString);

        urlConnection = (HttpURLConnection) url.openConnection();

        urlConnection.setRequestMethod("GET");
        urlConnection.setReadTimeout(10000 /* milliseconds */);
        urlConnection.setConnectTimeout(15000 /* milliseconds */);

        urlConnection.setDoOutput(true);

        urlConnection.connect();

        BufferedReader br=new BufferedReader(new InputStreamReader(url.openStream()));

        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line+"\n");
        }
        br.close();

        String jsonString = sb.toString();

        urlConnection.disconnect();
        return jsonString;
    }
}
