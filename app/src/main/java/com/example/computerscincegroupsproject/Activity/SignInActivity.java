package com.example.computerscincegroupsproject.Activity;

import android.os.Bundle;

import com.example.computerscincegroupsproject.R;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.computerscincegroupsproject.databinding.ActivitySignInactivityBinding;

public class SignInActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivitySignInactivityBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySignInactivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_sign_inactivity);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();

    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_sign_inactivity);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}