package com.example.computerscincegroupsproject.Fragments.JoinArea;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.computerscincegroupsproject.Adapter.SpacesListRecycleAdapter;
import com.example.computerscincegroupsproject.R;
import com.example.computerscincegroupsproject.databinding.FragmentSpacesListBinding;

public class SpacesList extends Fragment {
    private FragmentSpacesListBinding binding;
    private NavController controller;




    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSpacesListBinding.inflate(inflater , container , false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        controller = Navigation.findNavController(requireView());
        binding.floatingActionButton.setOnClickListener(view1 -> controller.navigate(R.id.action_spacesList_to_JoinSpaceFragment));
        binding.RecycleView.addOnChildAttachStateChangeListener(new RecyclerView.OnChildAttachStateChangeListener() {
            @Override
            public void onChildViewAttachedToWindow(@NonNull View view) {
                view.setOnClickListener(view1 -> controller.navigate(R.id.action_spacesList_to_SpaceMainPageFragment));
            }

            @Override
            public void onChildViewDetachedFromWindow(@NonNull View view) {

            }
        });
        binding.RecycleView.setAdapter(new SpacesListRecycleAdapter(requireContext()));
    }
}