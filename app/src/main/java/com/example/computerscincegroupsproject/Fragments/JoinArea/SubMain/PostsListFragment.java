package com.example.computerscincegroupsproject.Fragments.JoinArea.SubMain;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.viewpager2.widget.ViewPager2;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.bumptech.glide.Glide;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.computerscincegroupsproject.Adapter.SpaceMainPageViewPagerAdapter;
import com.example.computerscincegroupsproject.R;
import com.example.computerscincegroupsproject.databinding.FragmentPostsListBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

import jp.wasabeef.glide.transformations.ColorFilterTransformation;


public class PostsListFragment extends Fragment {
    private FragmentPostsListBinding binding;
    private String id;
    private BottomNavigationView bottomNavigationView;
    private NavController controller;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentPostsListBinding.inflate(inflater, container, false);
        bottomNavigationView = requireActivity().findViewById(R.id.bottomNavigationView);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.tabLayout.addTab(binding.tabLayout.newTab().setId(112).setText("Dash board").setIcon(R.drawable.ic_dashboard));
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Students").setId(455).setIcon(R.drawable.ic_peopls));
        SpaceMainPageViewPagerAdapter adapter = new SpaceMainPageViewPagerAdapter(requireActivity(), " ");
        binding.viewPager.setAdapter(adapter);
        binding.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                binding.viewPager.setCurrentItem(tab.getPosition(), true);
//                Glide.with(requireActivity())
//                        .asDrawable()
//                        .load(tab.getIcon())
//                        .transform(new ColorFilterTransformation(R.color.primaryLightColor))
//                        .addListener(new RequestListener<Drawable>() {
//                            @Override
//                            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
//                                Log.d("Glide Exception", "onLoadFailed: error in load drawable: " + e.getMessage());
//                                return false;
//                            }
//
//                            @Override
//                            public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
//                                requireActivity().runOnUiThread(() -> tab.setIcon(resource));
//                                return true;
//                            }
//                        });
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        binding.viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);

            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                binding.tabLayout.selectTab(binding.tabLayout.getTabAt(position), true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });
    }


}