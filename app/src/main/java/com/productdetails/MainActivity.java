package com.productdetails;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.adapter.ProductAdapter;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.model.Product;
import com.model.ProductCategories;
import com.model.ProductRankings;
import com.model.SubCategories;
import com.viewmodel.MainPresenter;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.utils.Constants.addToRequestQueue;
import static com.utils.Constants.url;

public class MainActivity extends AppCompatActivity implements MainPresenter.View,AdapterView.OnItemClickListener{

    ListView listView;
    ArrayList<Product> products = new ArrayList<>();
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        mainPresenter = new MainPresenter(this);
        callWebApi();
    }

    @Override
    public void updateListView(ArrayList<ProductCategories> productCategories) {

        listView.setAdapter(new ProductAdapter(MainActivity.this,productCategories));
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    public void callWebApi(){

        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {

                try {


                    JsonParser jsonParser = new JsonParser();
                    JsonElement jsonElement = jsonParser.parse(s);
                    Gson gson = new Gson();
                    Product product = gson.fromJson(jsonElement,Product.class);
                    mainPresenter.setListView(product);



                }catch (Exception e){

                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

                try{

                    String response = new String(volleyError.networkResponse.data);
                    System.out.println("Error Response:- " + response);

                }catch (Exception e){

                    e.printStackTrace();
                }

            }
        });

        addToRequestQueue(request,"",MainActivity.this);
    }
}
