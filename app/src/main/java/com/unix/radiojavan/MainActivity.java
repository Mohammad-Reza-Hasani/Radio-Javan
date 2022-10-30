package com.unix.radiojavan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.OnReceiveContentListener;
import android.view.View;

import com.google.android.material.navigation.NavigationBarView;
import com.unix.radiojavan.adapter.TabsAdapter;
import com.unix.radiojavan.databinding.ActivityMainBinding;
import com.unix.radiojavan.fragment.CategoryFragment;
import com.unix.radiojavan.fragment.FavoriteFragment;
import com.unix.radiojavan.fragment.HomeFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());




        binding.bottomMenu.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {


                    case R.id.item_home:
                        binding.pagerMain.setCurrentItem(0);
                        binding.bottomMenu.getMenu().findItem(R.id.item_home).setChecked(true);
                        break;

                    case R.id.item_category:
                        binding.pagerMain.setCurrentItem(1);
                        binding.bottomMenu.getMenu().findItem(R.id.item_category).setChecked(true);
                        break;
                    case R.id.item_favorite:
                        binding.pagerMain.setCurrentItem(2);
                        binding.bottomMenu.getMenu().findItem(R.id.item_favorite).setChecked(true);
                        break;

                }

                return false;
            }
        });


        binding.pagerMain.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);

                switch (position) {

                    case 0:
                        binding.bottomMenu.getMenu().findItem(R.id.item_home).setChecked(true);
                        break;

                    case 1:
                        binding.bottomMenu.getMenu().findItem(R.id.item_category).setChecked(true);
                        break;

                    case 2:
                        binding.bottomMenu.getMenu().findItem(R.id.item_favorite).setChecked(true);
                        break;
                }


            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });

        binding.pagerMain.setUserInputEnabled(false);
    }

    @Override
    protected void onResume() {
        super.onResume();

        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new HomeFragment());
        fragmentList.add(new CategoryFragment());
        fragmentList.add(new FavoriteFragment());

        TabsAdapter tabsAdapter = new TabsAdapter(this, fragmentList);
        binding.pagerMain.setAdapter(tabsAdapter);
    }
}