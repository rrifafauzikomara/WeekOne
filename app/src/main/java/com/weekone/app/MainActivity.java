package com.weekone.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.weekone.app.adapter.CuacaAdapter;
import com.weekone.app.entity.Cuaca;

public class MainActivity extends AppCompatActivity {

    private Cuaca[] cuaca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();

        ListView listView = (ListView) findViewById(R.id.main_list);
        CuacaAdapter cuacaAdapter = new CuacaAdapter(this, cuaca);
        listView.setAdapter(cuacaAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("image", cuaca[position].getImage());
                bundle.putString("title", cuaca[position].getTitle());
                bundle.putString("desc", cuaca[position].getDesc());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    private void initData() {
        cuaca = new Cuaca[] {
                new Cuaca(R.drawable.art_clear, "Cerah", "Saat ini cuaca sedang cerah."),
                new Cuaca(R.drawable.art_light_clouds, "Berawan", "Saat ini cuaca sedang berawan."),
                new Cuaca(R.drawable.art_clouds, "Mendung", "Saat ini cuaca sedang mendung."),
                new Cuaca(R.drawable.art_light_rain, "Gerimis", "Saat ini cuaca sedang hujan.")
        };
    }
}
