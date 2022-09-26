package com.example.computerscincegroupsproject.Fragments.JoinArea;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.example.computerscincegroupsproject.R;
import com.example.computerscincegroupsproject.databinding.FragmentSpaceMainPageBinding;

public class SpaceMainPageFragment extends Fragment {

    private FragmentSpaceMainPageBinding binding;
    private NavController controller;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSpaceMainPageBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        NavHostFragment hostFragment= (NavHostFragment) getChildFragmentManager().findFragmentById(R.id.fragmentContainerView2);
        controller = hostFragment.getNavController();
        NavigationUI.setupWithNavController(binding.bottomNavigationView , controller);
        NavigationUI.setupWithNavController(binding.miniToolBar  , controller);
        controller.addOnDestinationChangedListener((navController, navDestination, bundle) -> {
            binding.miniToolBar.setNavigationIcon(R.drawable.ic_back_ios);
            binding.miniToolBar.setNavigationIconTint(Color.WHITE);
            if (navDestination.getId() == R.id.postsListFragment){
                binding.miniToolBar.setNavigationOnClickListener(view1 -> {
                    requireActivity().onBackPressed();
                });
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}