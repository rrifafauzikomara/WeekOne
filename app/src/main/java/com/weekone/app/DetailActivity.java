package com.weekone.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView detailImage = (ImageView) findViewById(R.id.detail_image);
        TextView detailTitle = (TextView) findViewById(R.id.detail_title);
        TextView detailDesc = (TextView) findViewById(R.id.detail_desc);

        if (getIntent() != null) {
            Bundle bundle = getIntent().getExtras();
            detailImage.setBackgroundResource(bundle.getInt("image"));
            detailTitle.setText(bundle.getString("title"));
            detailDesc.setText(bundle.getString("desc"));
        } else {
            Toast.makeText(this, "Data tidak tersedia.", Toast.LENGTH_LONG).show();
        }

        //membuat back button toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    //membuat fungsi back dengan mengirim data session
    @Override
    public boolean onSupportNavigateUp() {
        Intent intent = new Intent(DetailActivity.this, MainActivity.class);
        startActivity(intent);
        return true;
    }

}
