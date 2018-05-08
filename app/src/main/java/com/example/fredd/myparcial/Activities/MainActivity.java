package com.example.fredd.myparcial.Activities;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.fredd.myparcial.Fragments.RandomFragment;
import com.example.fredd.myparcial.Fragments.UserFragment;
import com.example.fredd.myparcial.R;

public class MainActivity extends AppCompatActivity implements UserFragment.OnFragmentInteractionListener, RandomFragment.OnFragmentInteractionListener{

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            switch (item.getItemId()){
                case R.id.navigation_user:
                    fragmentTransaction.replace(R.id.fragment_container, new UserFragment()).commit();
                    mTextMessage.setText(R.string.title_user);
                    return true;
                case R.id.navigation_random:
                    fragmentTransaction.replace(R.id.fragment_container, new UserFragment()).commit();
                    mTextMessage.setText(R.string.title_random);
                    return  true;
            }
            UpdateFragment(item);
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        UserFragment userFragment = new UserFragment();

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, userFragment).commit();

    }

    public void UpdateFragment(MenuItem item){
        Fragment newFragment = null;
        switch (item.getItemId()) {
            case R.id.navigation_user:
                newFragment = new UserFragment();break;
            case R.id.navigation_random:
                newFragment = new RandomFragment();break;
        }
        getSupportFragmentManager().
                beginTransaction().
                replace(R.id.fragment_container, newFragment).
                commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
