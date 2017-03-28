package io.github.ledinhtri97.adapter;

import android.app.Activity;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import io.github.ledinhtri97.learningadvandelistview.R;
import io.github.ledinhtri97.model.ListApp;

/**
 * Created by Anymo on 3/23/2017.
 */

public class ListAppAdapter extends ArrayAdapter<ListApp> {

    //screen use this layout
    @NonNull private Activity context;
    //layout cho tung dong muon hien thi, resource o day la item.xml
    @LayoutRes private int resource;
    //danh sach nguon du lieu muon hien thi len giao dien
    @NonNull private List<ListApp> objects;
    public ListAppAdapter(@NonNull Activity context,
                          @LayoutRes int resource,
                          @NonNull List<ListApp> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.objects=objects;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //layoutInflater dung de build cai layout (xml file layout)
        //binh thuong thanh code java ma android xu dung duoc
        LayoutInflater inflater=this.context.getLayoutInflater();
        View row=inflater.inflate(this.resource, null); //this.resource la item.xml

        TextView txtInfo= (TextView) row.findViewById(R.id.txtInfo);
        TextView txtPhone= (TextView) row.findViewById(R.id.txtPhone);

        ImageButton btnDrupal = (ImageButton) row.findViewById(R.id.btnDrupal);
        ImageButton btnBalloon = (ImageButton) row.findViewById(R.id.btnBalloon);
        ImageButton btnCal = (ImageButton) row.findViewById(R.id.btnCal);
        ImageButton btnCamera = (ImageButton) row.findViewById(R.id.btnCamera);
        ImageButton btnEmail = (ImageButton) row.findViewById(R.id.btnEmail);

        final ListApp listApp=this.objects.get(position);
        txtInfo.setText(listApp.getInfo());
        txtPhone.setText(listApp.getPhone());

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleViewEmail(listApp);
            }
        });

        //quan trong, phai return row, neu de mac dinh se bao loi
        return row;
    }

    private void handleViewEmail(ListApp listApp) {
        Toast.makeText(this.context, "You choose " + listApp.getInfo(), Toast.LENGTH_SHORT).show();
    }
}
