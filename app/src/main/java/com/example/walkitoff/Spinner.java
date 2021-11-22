package com.example.walkitoff;

import android.view.View;
import android.widget.AdapterView;

public class Spinner implements AdapterView.OnItemSelectedListener{

    public static String selection = "";

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        selection = adapterView.getItemAtPosition( i ).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
