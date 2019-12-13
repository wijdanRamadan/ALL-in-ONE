package com.example.myapplication.news;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.news.adapter.ArticleAdapter;
import com.example.myapplication.news.models.ArticleModel;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class NewsFragment extends Fragment {

    private static final String API_KEY = "e1dd2effb17648119d21759a0d5b7ee5";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.news_fragment_layout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final RecyclerView mainRecycler = getActivity().findViewById(R.id.news_recycler_view);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        mainRecycler.setLayoutManager(linearLayoutManager);

        final NewsInterface newsService = NewsClient.getClient().create(NewsInterface.class);
        newsService.getLatestNews("top-headlines", "us", API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(newsModel -> {
                    List<ArticleModel> articleModel = newsModel.getArticles();
                    ArticleAdapter articleAdapter = new ArticleAdapter(articleModel);
                    mainRecycler.setAdapter(articleAdapter);
                });


    }
}
