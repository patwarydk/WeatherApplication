package com.example.mehrabpatwary.weatherapplication;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private boolean isFahrenheit = false;

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewpager);

        tabLayout.addTab(tabLayout.newTab().setText("Current"));
        tabLayout.addTab(tabLayout.newTab().setText("Forecast"));

        TestPagerAdapter adapter = new TestPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    //Toolbar Menu Part

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem search = menu.findItem(R.id.search);
        MenuItem celcius = menu.findItem(R.id.celcius);
        MenuItem fahrenheit = menu.findItem(R.id.fahrenheit);

        if (!isFahrenheit) {
            fahrenheit.setVisible(true);
            celcius.setVisible(false);
        } else {
            fahrenheit.setVisible(false);
            celcius.setVisible(true);
        }
        return true;
    }


    private class TestPagerAdapter extends FragmentPagerAdapter {
        private int tabCount;

        public TestPagerAdapter(FragmentManager fm, int tabCount) {
            super(fm);
            this.tabCount = tabCount;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new Current();
                case 1:
                    return new Forecast();

            }
            return null;
        }

        @Override
        public int getCount() {
            return tabCount;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {

            switch (position){
                case 0:
                    return "Current";
                case 1:
                    return "Forecast";
            }
            return  null;
        }
    }
}