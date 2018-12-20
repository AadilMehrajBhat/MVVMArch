package com.aadilmehraj.android.mvvmarch.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aadilmehraj.android.mvvmarch.R;
import com.aadilmehraj.android.mvvmarch.adapter.CategoryListAdapter;
import com.aadilmehraj.android.mvvmarch.service.model.Category;

public class CategoryListFragment extends Fragment {


    RecyclerView mrecyclerView;
    private CategoryListAdapter adapter;
     Category category;

    public CategoryListFragment() {

    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.category_list_fragment,container,false);

        mrecyclerView = view.findViewById(R.id.categoryRecyclerView);
        mrecyclerView.setHasFixedSize(true);
        mrecyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        adapter = new CategoryListAdapter(getContext(),category);
        adapter.setCategories(category);
        mrecyclerView.setAdapter(adapter);

        return view;

    }
}
