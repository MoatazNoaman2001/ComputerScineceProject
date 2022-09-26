package com.example.computerscincegroupsproject.Adapter;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.computerscincegroupsproject.Fragments.JoinArea.SubMain.SubSubMain.DashBoard;
import com.example.computerscincegroupsproject.Fragments.JoinArea.SubMain.SubSubMain.StudentQuestionsFragment;

public class SpaceMainPageViewPagerAdapter extends FragmentStateAdapter{
    private final String groupId;
    public SpaceMainPageViewPagerAdapter(@NonNull FragmentActivity fragmentActivity, String groupId) {
        super(fragmentActivity);
        this.groupId = groupId;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Bundle bundle = new Bundle();
        bundle.putString("gid" , groupId);
        switch (position){
            case 0 -> {
                DashBoard dashBoard = new DashBoard();
                dashBoard.setArguments(bundle);
                return dashBoard;
            }
            case 1 ->{
                StudentQuestionsFragment studentQuestionsFragment = new StudentQuestionsFragment();
                studentQuestionsFragment.setArguments(bundle);
                return studentQuestionsFragment;
            }
        }
        return new DashBoard();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}