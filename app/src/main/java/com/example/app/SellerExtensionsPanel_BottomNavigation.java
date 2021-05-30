package com.example.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;


import com.example.app.SellerExtensionsPanel.ChefHomeFragment;
import com.example.app.SellerExtensionsPanel.ChefProfileFragment;
import com.example.app.SellerExtensionsPanel.ChefOrderFragment;

public class SellerExtensionsPanel_BottomNavigation extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_extensions_panel__bottom_navigation);
        BottomNavigationView navigationView = findViewById(R.id.seller_bottom_navigation);
        navigationView.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()){
            case R.id.SellerHome:
                fragment=new ChefHomeFragment();
                break;
            
            case R.id.Orders:
                fragment=new ChefOrderFragment();
                break;
            case R.id.SellerProfile:
                fragment=new ChefProfileFragment();
                break;
        }
        return loadcheffragment(fragment);
    }

    private boolean loadcheffragment(Fragment fragment) {

        if (fragment != null){
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,fragment).commit();
            return true;
        }
        return false;
    }
}