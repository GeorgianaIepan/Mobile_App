package com.example.mobileapp;

import android.content.Intent;
import android.os.Bundle;

import com.example.mobileapp.ui.login.LoginActivity;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.mobileapp.databinding.ActivityMyAccountBinding;

public class MyAccountActivity extends AppCompatActivity {

    private ActivityMyAccountBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMyAccountBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = binding.toolbarLayout;
        toolBarLayout.setTitle(getTitle());

        FloatingActionButton fab = binding.fab;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_home) {
            Intent intent = new Intent(MyAccountActivity.this, ScrollingActivity.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.action_produkt) {
            Intent intent = new Intent(MyAccountActivity.this, ProduktActivity.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.action_order) {
            Intent intent = new Intent(MyAccountActivity.this, CartActivity.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.action_my_account) {
            Intent intent = new Intent(MyAccountActivity.this, MyAccountActivity.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.action_settings) {
            Intent intent = new Intent(MyAccountActivity.this, SettingsActivity.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.action_login) {
            Intent intent = new Intent(MyAccountActivity.this, LoginActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}