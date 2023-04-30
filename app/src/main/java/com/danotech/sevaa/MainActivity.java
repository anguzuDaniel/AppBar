package com.danotech.sevaa;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.danotech.sevaa.UI.fragments.CardSettingsFragment;
import com.danotech.sevaa.UI.fragments.CreditCardFragment;
import com.danotech.sevaa.UI.fragments.SettingsFragment;
import com.danotech.sevaa.UI.fragments.HomeFragment;
import com.danotech.sevaa.UI.fragments.SubscriptionsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // navigation bars
        bottomNavigationView = findViewById(R.id.bottom_navigation_view);

        replaceFragment(new HomeFragment());

        bottomNavigationView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()) {
                case R.id.home:
                    replaceFragment(new HomeFragment());
                    break;
                case R.id.cards:
                    replaceFragment(new CreditCardFragment());
                    break;
                case R.id.wallet:
                    replaceFragment(new SubscriptionsFragment());
                    break;
                case R.id.more:
                    replaceFragment(new SettingsFragment());
                    break;
            }
            return true;
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.top_menu, menu);
        return true;
    }

    public void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_frame, fragment);
        fragmentTransaction.commit();
    }

}