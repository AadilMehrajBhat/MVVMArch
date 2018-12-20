package com.aadilmehraj.android.mvvmarch.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.aadilmehraj.android.mvvmarch.R;
import com.aadilmehraj.android.mvvmarch.service.model.Category;
import com.aadilmehraj.android.mvvmarch.service.model.CategoryItem;
import com.bumptech.glide.Glide;

import java.util.List;

public class CategoryListAdapter extends RecyclerView.Adapter<CategoryListAdapter.CategoryViewHolder> {


    private Context mContext;
    private Category mcategory;

    public CategoryListAdapter(Context mContext, Category mcategory) {
        this.mContext = mContext;
        this.mcategory = mcategory;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.main_category_list_item,viewGroup,false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int i) {

        CategoryItem categoryItem= mcategory.getCategoryItems().get(i);
        holder.bind(categoryItem);


    }

    @Override
    public int getItemCount() {
        if (mcategory!=null){
            return mcategory.getCategoryItems().size();
        }
        return 0;
    }
    public void setCategories(Category categories){
        mcategory=categories;
        notifyDataSetChanged();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder{

        TextView mcategoryName;
        ImageView mcategoryImage;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            mcategoryName = itemView.findViewById(R.id.category_name);
            mcategoryImage = itemView.findViewById(R.id.category_imageView);

        }
        void bind(CategoryItem item){
            mcategoryName.setText(item.getTitle());
            Glide.with(mContext).load(item.getUrl()).into(mcategoryImage);
        }
    }
}