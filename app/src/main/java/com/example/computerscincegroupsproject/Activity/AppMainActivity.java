package com.example.computerscincegroupsproject.Activity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.example.computerscincegroupsproject.R;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.computerscincegroupsproject.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

public class AppMainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph())
                .setOpenableLayout(binding.drawerLayout)
                .build();

        NavigationUI.setupWithNavController(binding.toolbar, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.drawerView, navController);

        navController.addOnDestinationChangedListener((navController, navDestination, bundle) -> {
            if (navDestination.getId() != R.id.newsFragment) {
                binding.toolbar.setNavigationIcon(
                        ResourcesCompat.getDrawable(
                                getResources(), R.drawable.ic_back_ios, getTheme()
                        )
                );
            }else{
                binding.toolbar.setNavigationIcon(
                        ResourcesCompat.getDrawable(
                                getResources(), R.drawable.ic_round_menu_24, getTheme()
                        )
                );
            }
            binding.toolbar.setNavigationIcon(
                    tintDrawable(binding.toolbar.getNavigationIcon(), R.color.primaryDarkColor)
            );
        });
    }

    private Drawable tintDrawable(Drawable navigationIcon, int primaryDarkColor) {
        navigationIcon = DrawableCompat.wrap(navigationIcon);
        DrawableCompat.setTint(navigationIcon, ResourcesCompat.getColor(getResources(), primaryDarkColor, getTheme()));
        return navigationIcon;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}