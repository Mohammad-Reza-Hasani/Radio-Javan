package com.unix.radiojavan.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;
import com.unix.radiojavan.R;
import com.unix.radiojavan.adapter.ArtistsAdapter;
import com.unix.radiojavan.adapter.BannerAdapter;
import com.unix.radiojavan.adapter.MusicsAdapter;
import com.unix.radiojavan.api.ApiCaller;
import com.unix.radiojavan.models.ArtistModel;
import com.unix.radiojavan.models.BaseModel;
import com.unix.radiojavan.models.IResponseMessage;


public class HomeFragment extends Fragment {


    RecyclerView recycler_new_musics;
    RecyclerView recycler_artists;
    ApiCaller apiCaller;
    ViewPager pager_musics;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);


        apiCaller = new ApiCaller();
        recycler_new_musics = view.findViewById(R.id.recycler_new_musics);
        recycler_artists = view.findViewById(R.id.recycler_artists);
        pager_musics = view.findViewById(R.id.pager_musics);
        DotsIndicator dotsIndicator = view.findViewById(R.id.dots_indicator);


        apiCaller.getLatestMusics(new IResponseMessage() {
            @Override
            public void onResponse(Object responseMessage) {
                Log.i("", "onResponse: ");

                BaseModel baseModel = (BaseModel) responseMessage;
                recycler_new_musics.setAdapter(new MusicsAdapter(getActivity(), baseModel.getOnlineMp3()));
                recycler_new_musics.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
                pager_musics.setAdapter(new BannerAdapter(getActivity(),baseModel.getOnlineMp3()));
                dotsIndicator.attachTo(pager_musics);
            }

            @Override
            public void onFailure(String errorResponseMassage) {
                Log.i("", "onFailure: ");
            }
        });

        apiCaller.getArtistsList(new IResponseMessage() {
            @Override
            public void onResponse(Object responseMessage) {
                ArtistModel artistModel = (ArtistModel) responseMessage;

                recycler_artists.setAdapter(new ArtistsAdapter(getActivity(), artistModel.getArtistList()));
                recycler_artists.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
            }

            @Override
            public void onFailure(String errorResponseMassage) {

            }
        });

        return view;
    }
}