package io.github.ledinhtri97.learningdateandtimepicker;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import io.github.ledinhtri97.model.TimePickerFragmentMain;


public class MainActivity extends AppCompatActivity {

    static TextView txtDate, txtTime;
    static ImageButton btnDate, btnTime;
    static Calendar calendar = Calendar.getInstance();
    static SimpleDateFormat smpD_1=new SimpleDateFormat("dd/MM/yyyy");
    static SimpleDateFormat smpD_2=new SimpleDateFormat("HH:mm");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
    }

    private void addEvents() {
        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleDatePicker();
            }
        });
        btnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleTimePicker();
            }
        });
    }

    private void handleTimePicker() {
        DialogFragment timePickerDialog = new TimePickerFragment();
        timePickerDialog.show(getFragmentManager(), "Time");
    }

    private void handleDatePicker() {
        /*final DatePickerDialog.OnDateSetListener callBack = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                txtDate.setText(smpD_1.format(calendar.getTime()));
            }
        };
        DatePickerDialog datePickerDialog=new DatePickerDialog(
                MainActivity.this,
                callBack,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
        );
        datePickerDialog.show();*/
        DialogFragment datePickerDialog = new DatePickerFragment();
        datePickerDialog.show(getFragmentManager(), "Date");
    }

    private void addControls() {
        txtDate= (TextView) findViewById(R.id.txtDate);
        txtTime= (TextView) findViewById(R.id.txtTime);
        btnDate= (ImageButton) findViewById(R.id.btnDate);
        btnTime= (ImageButton) findViewById(R.id.btnTime);

        calendar=Calendar.getInstance();
        txtDate.setText(smpD_1.format(calendar.getTime()));
        txtTime.setText(new SimpleDateFormat("HH:mm").format(calendar.getTime()));

    }

    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener{

        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, month);
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            txtDate.setText(smpD_1.format(calendar.getTime()));
        }

        @RequiresApi(api = Build.VERSION_CODES.N)
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), AlertDialog.THEME_DEVICE_DEFAULT_DARK,
                    this, year, month, day);
        }
    }

    public static class TimePickerFragment extends DialogFragment
            implements TimePickerDialog.OnTimeSetListener{

        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
            calendar.set(Calendar.MINUTE, minute);
            txtTime.setText(smpD_2.format(calendar.getTime()));
        }

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current time as the default values for the picker
            calendar = Calendar.getInstance();
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            int minute = calendar.get(Calendar.MINUTE);

            // Create a new instance of TimePickerDialog and return it
            return new TimePickerDialog(getActivity(), AlertDialog.THEME_DEVICE_DEFAULT_DARK,
                    this, hour, minute,
                    DateFormat.is24HourFormat(getActivity()));
        }
    }
}
