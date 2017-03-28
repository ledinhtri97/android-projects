package io.github.ledinhtri97.adapter;

import android.app.Activity;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.util.List;

import io.github.ledinhtri97.learninggridview.R;

/**
 * Created by Anymo on 3/25/2017.
 */

public class HinhAdapter extends ArrayAdapter<Integer> {
    @NonNull Activity context; @LayoutRes int resource; @NonNull List objects;
    public HinhAdapter(@NonNull Activity context, @LayoutRes int resource, @NonNull List objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.objects=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=this.context.getLayoutInflater();
        View row= inflater.inflate(this.resource, null);
        ImageView img = (ImageView) row.findViewById(R.id.imgHinh);
        img.setImageResource((Integer) this.objects.get(position));

        return row;
    }
}
