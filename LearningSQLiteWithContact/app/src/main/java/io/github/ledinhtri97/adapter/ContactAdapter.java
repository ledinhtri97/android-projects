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
import io.github.ledinhtri97.model.Contact;

/**
 * Created by Anymo on 3/29/2017.
 */

public class ContactAdapter extends ArrayAdapter<Contact> {
    TextView txtName, txtPhone, txtEmail;

    @NonNull Activity context;
    @LayoutRes int resource;
    @NonNull List<Contact> objects;
    public ContactAdapter(@NonNull Activity context, @LayoutRes int resource, @NonNull List<Contact> objects) {
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

        Contact person = this.objects.get(position);
        txtName = (TextView) row.findViewById(R.id.txtName);
        txtPhone = (TextView) row.findViewById(R.id.txtPhone);
        txtEmail = (TextView) row.findViewById(R.id.txtEmail);

        txtName.setText(person.getName());
        txtPhone.setText(person.getPhome());
        txtEmail.setText(person.getEmail());


        return row;
    }
}
