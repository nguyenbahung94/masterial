package com.example.nbhung.masterial.CoverFlow;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nbhung.masterial.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by nbhung on 8/15/2017.
 */

public class MovieAdapter extends BaseAdapter {
    private List<Movie> movieList;
    private Context mContext;

    public MovieAdapter(List<Movie> movieList, Context mContext) {
        this.movieList = movieList;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return movieList.size();
    }

    @Override
    public Object getItem(int position) {
        return movieList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        if (rowView != null) {
            rowView = LayoutInflater.from(mContext).inflate(R.layout.layout_item, null);
            TextView name = (TextView) rowView.findViewById(R.id.label);
            ImageView imageView = (ImageView) rowView.findViewById(R.id.image);

            Picasso.with(mContext).load(movieList.get(position).getUrl()).into(imageView);
            name.setText(movieList.get(position).getName());
        }
        return rowView;
    }
}
