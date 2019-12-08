package com.example.myapplication.news;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.news.adapter.ArticleAdapter;
import com.example.myapplication.news.models.ArticleModel;
import com.example.myapplication.news.models.NewsModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsFragment extends Fragment {

    private static final String API_KEY="e1dd2effb17648119d21759a0d5b7ee5";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.news_fragment_layout ,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final RecyclerView mainRecycler = getActivity().findViewById(R.id.news_recycler_view);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        mainRecycler.setLayoutManager(linearLayoutManager);

        final NewsInterface newsService =NewsClient.getClient().create(NewsInterface.class);

        Call<NewsModel> call = newsService.getLatestNews("top-headlines","us", API_KEY);

        call.enqueue(new Callback<NewsModel>() {
            @Override
            public void onResponse(Call<NewsModel> call, Response<NewsModel> response) {
                if(response.body().getStatus().equals("ok")) {
                    Toast.makeText(getContext(),"ok" ,Toast.LENGTH_LONG).show();
                    List<ArticleModel> articleList = response.body().getArticles();
                    final ArticleAdapter mainArticleAdapter = new ArticleAdapter(articleList);
                    mainRecycler.setAdapter(mainArticleAdapter);
                }

            }

            @Override
            public void onFailure(Call<NewsModel> call, Throwable t) {
                Toast.makeText(getContext() , " failed" , Toast.LENGTH_LONG).show();

            }
        });

    }
}
