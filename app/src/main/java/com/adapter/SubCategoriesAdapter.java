package com.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.model.ProductCategories;
import com.productdetails.R;

import java.util.ArrayList;

/**
 * Created by Ashish on 20-09-2018.
 */

public class SubCategoriesAdapter extends BaseAdapter{

    Context context;
    ArrayList<ProductCategories> productCategories;

    public SubCategoriesAdapter(Context context, ArrayList<ProductCategories> productCategories){

        this.context = context;
        this.productCategories = productCategories;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){

            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.custom_categories,null);

            ViewHolder holder = new ViewHolder();
            holder.txt_name = (TextView)convertView.findViewById(R.id.txt_name);
            convertView.setTag(holder);
        }

        final ViewHolder holder = (ViewHolder) convertView.getTag();

        holder.txt_name.setText(productCategories.get(position).getName());

        return convertView;
    }

    @Override
    public int getCount() {
        return productCategories.size();
    }

    @Override
    public Object getItem(int position) {
        return productCategories.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class ViewHolder{

        public TextView txt_name;
    }
}
