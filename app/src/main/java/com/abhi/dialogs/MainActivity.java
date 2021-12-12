package com.abhi.dialogs;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void alertDialog(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Username Invalid");
        builder.setMessage("Enter Valid Username");

        EditText editText = new EditText(this);
        builder.setView(editText);

        builder.setPositiveButton("Continue", (dialog, which) -> {
            String s = editText.getText().toString();

            if (s.length() > 0)
                Toast.makeText(MainActivity.this, "Username Valid", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(MainActivity.this, "Username Invalid", Toast.LENGTH_SHORT).show();
            dialog.dismiss();
        });

        builder.setNegativeButton("Cancel", (dialog, which) -> {
            dialog.dismiss();
        });

        builder.setCancelable(false);
        builder.show();
    }

    public void customDialog(View view) {
        Dialog dialog = new Dialog(this);

        View tmp = LayoutInflater.from(this).inflate(R.layout.custom_layout, null);

        Button btn=tmp.findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Welcome", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        dialog.setContentView(tmp);
        dialog.show();
    }

    public void progressDialog(View view) {
        ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.setTitle("Loading...");
        progressDialog.setMessage("Your File is Being Uploaded");
        progressDialog.show();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void pickDate(View view) {
        DatePickerDialog datePickerDialog=new DatePickerDialog(this);
        datePickerDialog.setOnDateSetListener(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Toast.makeText(MainActivity.this, dayOfMonth+" / "+month+" / "+year, Toast.LENGTH_SHORT).show();
            }
        });
        datePickerDialog.show();
    }

    public void pickTime(View view) {
        TimePickerDialog timePickerDialog=new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                Toast.makeText(MainActivity.this, +hourOfDay+" : "+minute, Toast.LENGTH_SHORT).show();
            }
        },12,0,true);
        timePickerDialog.show();
    }
}