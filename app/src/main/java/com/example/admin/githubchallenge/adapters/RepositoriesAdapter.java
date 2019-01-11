package com.example.admin.githubchallenge.adapters;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.admin.githubchallenge.R;
import com.example.admin.githubchallenge.databinding.RecyclerItemBinding;
import com.example.admin.githubchallenge.models.Item;

import java.util.List;

public class RepositoriesAdapter extends RecyclerView.Adapter<RepositoriesAdapter.ViewHolder> {

    private List<Item> items;

    public RepositoriesAdapter(List<Item> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public RepositoriesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        RecyclerItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()),
                R.layout.recycler_item, viewGroup, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RepositoriesAdapter.ViewHolder holder, int i) {
        Item temp = items.get(i);
        holder.binding.tvRepositoryDesc.setText(temp.getDescription());
        holder.binding.tvRepositoryName.setText(temp.getName());
        holder.binding.tvRepositoryStars.setText(String.valueOf(temp.getStargazersCount() + " \u2605"));
        Glide.with(holder.itemView.getContext())
                .load(temp.getOwner().getAvatarUrl())
                .into(holder.binding.imageView);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        RecyclerItemBinding binding;

        public ViewHolder(@NonNull RecyclerItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
