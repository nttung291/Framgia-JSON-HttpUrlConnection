package com.framgia.framgia_json_httpurlconnection.screen.screen.repos;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.framgia.framgia_json_httpurlconnection.R;
import com.framgia.framgia_json_httpurlconnection.model.Repo;
import com.framgia.framgia_json_httpurlconnection.screen.BaseRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nttungg on 2/7/18.
 */

public class ReposAdapter extends  BaseRecyclerViewAdapter<ReposAdapter.ViewHolder> {

    private LayoutInflater layoutInflater;
    private ArrayList<Repo> mrepos = new ArrayList<>();

    public ReposAdapter(@NonNull Context context) {
        super(context);
    }

    public void replaceData(@NonNull List<Repo> repos) {
        mrepos.clear();
        mrepos.addAll(repos);
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (layoutInflater == null){
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        View itemview = layoutInflater.inflate(R.layout.item_repos,parent,false);
        return new ViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindData(mrepos.get(position));
    }

    @Override
    public int getItemCount() {
        return mrepos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView nameRepo;
        private TextView url;
        public ViewHolder(View itemView) {
            super(itemView);
            nameRepo = itemView.findViewById(R.id.textView_repoName);
            url = itemView.findViewById(R.id.textView_repoUrl);
        }

        public void bindData(Repo reposite){
            nameRepo.setText(reposite.getName());
            url.setText(reposite.getHtmlUrl());
        }
    }
}
