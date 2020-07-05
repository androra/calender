package com.example.calender;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button calender;
    TextView setdate;
    private DatePickerDialog.OnDateSetListener onDateSetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calender = findViewById(R.id.calender);
        setdate = findViewById(R.id.setdate);

        calender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //some ways to get Date

         //get current date :- 1 way
                /*SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
                String date2 = sdf2.format(System.currentTimeMillis());*/

         //get current date :- 2 way
                /* SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                 Calendar c = Calendar.getInstance();
                 String date = sdf.format(c.getTime());*/

                //create calender with dialog :- 3rd way
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                //simple (Calender type view)
                DatePickerDialog dialog = new DatePickerDialog(MainActivity.this,onDateSetListener, year, month, day);

                //horizontal (horizontal view)
                //DatePickerDialog dialog = new DatePickerDialog(MainActivity.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth,onDateSetListener, year, month, day);

                //validate calender(No past date)
                //dialog.getDatePicker().setMinDate(System.currentTimeMillis());

                //validate calender(No future date)
                dialog.getDatePicker().setMaxDate(System.currentTimeMillis());

                //dialog backgroung
                //dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                //dialog show
                dialog.show();
            }
        });
        onDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                month = month + 1;

                String date=  day + "/" + month + "/" + year;
                setdate.setText(date);
            }
        };
    }
}