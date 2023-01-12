package com.example;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuProvider;

import com.example.splash.R;
import com.example.splash.databinding.ActivityMenuBinding;

public class MenuActivity extends AppCompatActivity  {

    private ActivityMenuBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ListView menuList = (ListView) findViewById(R.id.list);
        menuList.setClickable(true);

        String[] items = { getResources().getString(R.string.menu_item_play),
                getResources().getString(R.string.menu_item_scores),
                getResources().getString(R.string.menu_item_settings),
                getResources().getString(R.string.menu_item_help) };

        ArrayAdapter<String> adapt = new ArrayAdapter<String>(this, R.layout.list, items);

        menuList.setAdapter(adapt);

        menuList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                switch (position){
                    case 0:
                        Intent intent = new Intent(MenuActivity.this, SelectorActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Toast.makeText(MenuActivity.this, "2", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(MenuActivity.this, "3", Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(MenuActivity.this, "4", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.search:
                Toast.makeText(this, "Buscador", Toast.LENGTH_LONG ).show();
                return true;
            case R.id.categoria1:
                Toast.makeText(this, "Categoria 1", Toast.LENGTH_LONG ).show();
                return true;
            case R.id.categoria2:
                Toast.makeText(this, "Categoria 2", Toast.LENGTH_LONG ).show();
                return true;
            case R.id.settings:
                Toast.makeText(this, "Ajustes", Toast.LENGTH_LONG ).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
