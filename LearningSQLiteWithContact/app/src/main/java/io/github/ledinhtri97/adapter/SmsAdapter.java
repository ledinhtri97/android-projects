package io.github.ledinhtri97.adapter;

import android.app.Activity;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import io.github.ledinhtri97.learningsqlitewithcontact.R;
import io.github.ledinhtri97.model.Sms;

/**
 * Created by Anymo on 3/29/2017.
 */

public class SmsAdapter extends ArrayAdapter<Sms> {

    TextView txtSms;

    @NonNull Activity context;
    @LayoutRes int resource;
    @NonNull List<Sms> objects;
    public SmsAdapter(@NonNull Activity context, @LayoutRes int resource, @NonNull List<Sms> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.objects=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = this.context.getLayoutInflater();
        View row = inflater.inflate(resource, null);

        Sms sms = this.objects.get(position);

        txtSms = (TextView) row.findViewById(R.id.txtSms);
        txtSms.setText(sms.getSms());

        return row;
    }
}
