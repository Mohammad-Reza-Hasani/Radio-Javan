package com.unix.radiojavan.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.unix.radiojavan.R;
import com.unix.radiojavan.adapter.CategoryAdapter;
import com.unix.radiojavan.api.ApiCaller;
import com.unix.radiojavan.databinding.FragmentCategoryBinding;
import com.unix.radiojavan.models.CategoryModel;
import com.unix.radiojavan.models.IResponseMessage;


public class CategoryFragment extends Fragment {

    FragmentCategoryBinding binding;
    ApiCaller apiCaller;

    public CategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       binding =FragmentCategoryBinding.inflate(getLayoutInflater());
       apiCaller= new ApiCaller();
       apiCaller.getCategoryList(new IResponseMessage() {
           @Override
           public void onResponse(Object responseMessage) {

               CategoryModel categoryModel = (CategoryModel) responseMessage;
               binding.recyclerCategory.setAdapter(new CategoryAdapter(getActivity(),categoryModel.getCategoryList()));
               binding.recyclerCategory.setLayoutManager(new GridLayoutManager(getActivity(),2));
               binding.recyclerCategory.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
           }

           @Override
           public void onFailure(String errorResponseMassage) {

           }
       });
        return binding.getRoot();
    }
}