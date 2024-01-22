package com.example.aroundgit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class mainBN extends AppCompatActivity {
    private MenuItem prevMenuItem;
    private SectionsPagerAdapter sectionsPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bn);
//        binding = ActivityMainBnBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());

        //el adaptador coloca las Pages -los fragmentos con las diferentes vistas- dentro de la vista padre Viewpager del xml
        sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
//        ViewPager viewPager = binding.viewPager;
        ViewPager viewPager1 = findViewById(R.id.view_pager);
        viewPager1.setAdapter(sectionsPagerAdapter);

        // cast al xml
        BottomNavigationView mybottomNavView = findViewById(R.id.bottom_navigation);

        // crear badges
        BottomNavigationMenuView bottomNavigationMenuView =
                (BottomNavigationMenuView) mybottomNavView.getChildAt(0);
        View v = bottomNavigationMenuView.getChildAt(2);
        BottomNavigationItemView itemView = (BottomNavigationItemView) v;

        LayoutInflater.from(this)
                .inflate(R.layout.layout_badge, itemView, true);


        mybottomNavView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if(item.getItemId()==R.id.likes){
                    item.setChecked(true);
                    Toast.makeText(mainBN.this, "Likes clicked.", Toast.LENGTH_SHORT).show();
                    removeBadge(mybottomNavView,item.getItemId());
                    viewPager1.setCurrentItem(0);
                }else if(item.getItemId()==R.id.add){
                    item.setChecked(true);
                    Toast.makeText(mainBN.this, "Add clicked.", Toast.LENGTH_SHORT).show();
                    removeBadge(mybottomNavView,item.getItemId());
                    viewPager1.setCurrentItem(1);
                }else if(item.getItemId()==R.id.browse){
                    item.setChecked(true);
                    Toast.makeText(mainBN.this, "Browse clicked.", Toast.LENGTH_SHORT).show();
                    removeBadge(mybottomNavView,item.getItemId());
                    viewPager1.setCurrentItem(2);
                }else if(item.getItemId()==R.id.personal){
                    item.setChecked(true);
                    Toast.makeText(mainBN.this, "Personal clicked.", Toast.LENGTH_SHORT).show();
                    removeBadge(mybottomNavView,item.getItemId());
                    viewPager1.setCurrentItem(3);
                }
                return false;
            }
        });


//        here we listen to viewpager moves and set navigations items checked or not

        //Este metodo permite que al hacer scroll entre las pantallas no se cambie tambien el boton seleccionado del menu

        viewPager1.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);
                } else {
                    mybottomNavView.getMenu().getItem(0).setChecked(false);
                    mybottomNavView.getMenu().getItem(position).setChecked(true);
                    removeBadge(mybottomNavView, mybottomNavView.getMenu().getItem(position).getItemId());
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public static void removeBadge(BottomNavigationView bottomNavigationView, @IdRes int itemId) {
        BottomNavigationItemView itemView = bottomNavigationView.findViewById(itemId);
        if (itemView.getChildCount() == 3) {
            itemView.removeViewAt(2);
        }
    }

}