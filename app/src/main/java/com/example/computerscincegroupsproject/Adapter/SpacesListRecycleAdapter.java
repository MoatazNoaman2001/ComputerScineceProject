package com.example.computerscincegroupsproject.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.example.computerscincegroupsproject.databinding.SpaceItemBinding;
import com.example.computerscincegroupsproject.models.Space;

import java.util.List;

public class SpacesListRecycleAdapter extends ListAdapter<Space , SpacesListRecycleAdapter.ViewHolder> {
    private RequestManager manager;
    public SpacesListRecycleAdapter(Context context) {
        super(new SpaceDiffCallListener());
        manager = Glide.with(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(SpaceItemBinding.inflate(LayoutInflater.from(parent.getContext()) , parent , false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private SpaceItemBinding binding;
        public ViewHolder(SpaceItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bindView(Space space , RequestManager imageLoader){
            binding.SpaceName.setText(space.getName());
            binding.Creator.setText(space.getMainAdmin());
            imageLoader.load(space.getImageUri()).into(binding.spaceImage);
        }
    }

    static class SpaceDiffCallListener extends DiffUtil.ItemCallback<Space>{

        @Override
        public boolean areItemsTheSame(@NonNull Space oldItem, @NonNull Space newItem) {
            return oldItem.equals(newItem);
        }

        @Override
        public boolean areContentsTheSame(@NonNull Space oldItem, @NonNull Space newItem) {
            return false;
        }
    }
}
