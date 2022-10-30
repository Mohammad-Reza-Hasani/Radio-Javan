package com.unix.radiojavan.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.unix.radiojavan.adapter.MusicsAdapter;
import com.unix.radiojavan.databinding.FragmentFavoriteBinding;
import com.unix.radiojavan.db.RoomDb;


public class FavoriteFragment extends Fragment {

    FragmentFavoriteBinding binding;
    RoomDb roomDb;

    public FavoriteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFavoriteBinding.inflate(getLayoutInflater());

        roomDb = RoomDb.getInstance(getActivity());
        binding.recyclerFavorite.setAdapter(new MusicsAdapter(getActivity(),roomDb.idao().getMusicList() ));
        binding.recyclerFavorite.setLayoutManager(new GridLayoutManager(getActivity(),2));
        binding.recyclerFavorite.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);

        return binding.getRoot();
    }
}