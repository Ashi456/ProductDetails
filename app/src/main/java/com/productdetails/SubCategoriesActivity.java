package com.productdetails;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Ashish on 20-09-2018.
 */

public class SubCategoriesActivity extends AppCompatActivity{

    ListView listView;
    ArrayList<SubCategoriesActivity>

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getIntentData();
        listView = (ListView) findViewById(R.id.listView);
    }

    public void getIntentData(){

    }
}
