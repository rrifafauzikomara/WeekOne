package com.weekone.app.adapter;

import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.weekone.app.R;
import com.weekone.app.entity.Cuaca;

public class CuacaAdapter extends ArrayAdapter<Cuaca> {


    private final AppCompatActivity context;
    private final Cuaca[] cuaca;

    public CuacaAdapter(AppCompatActivity context, Cuaca[] cuaca) {
        super(context, R.layout.items, cuaca);
        this.context = context;
        this.cuaca = cuaca;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.items,null, true);
        TextView text = (TextView) rowView.findViewById(R.id.item_title);
        ImageView image = (ImageView) rowView.findViewById(R.id.item_image);
        text.setText(cuaca[position].getTitle());
        image.setBackgroundResource(cuaca[position].getImage());
        return rowView;
    }
}
