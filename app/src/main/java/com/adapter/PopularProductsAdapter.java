package com.adapter;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.model.SubCategories;
import com.model.Variants;
import com.productdetails.R;

import java.util.ArrayList;

import static com.utils.Constants.getFormattedDate;

/**
 * Created by Ashish on 20-09-2018.
 */

public class PopularProductsAdapter extends BaseAdapter{

    Context context;
    ArrayList<SubCategories> subCategories;
    Dialog dialog;

    public PopularProductsAdapter(Context context, ArrayList<SubCategories> subCategories){

        this.context = context;
        this.subCategories = subCategories;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        if(convertView == null){

            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.custom_sub_categories,null);

            ViewHolder holder = new ViewHolder();
            holder.txt_name = (TextView)convertView.findViewById(R.id.txt_name);
            holder.txt_date_added = (TextView)convertView.findViewById(R.id.txt_date_added);
            holder.txt_tax = (TextView)convertView.findViewById(R.id.txt_tax);
            holder.btn_check_colors = (Button)convertView.findViewById(R.id.btn_check_colors);
            convertView.setTag(holder);
        }

        final ViewHolder holder = (ViewHolder) convertView.getTag();

        holder.txt_name.setText(subCategories.get(position).getName());
        holder.txt_date_added.setText(getFormattedDate(subCategories.get(position).getDate_added()));
        holder.txt_tax.setText(subCategories.get(position).getTax().getName()+" : " + subCategories.get(position).getTax().getValue());
        holder.btn_check_colors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showPopUp(subCategories.get(position).getVariants());

            }
        });

        return convertView;
    }

    @Override
    public int getCount() {
        return subCategories.size();
    }

    @Override
    public Object getItem(int position) {
        return subCategories.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class ViewHolder{

        public TextView txt_name;
        public TextView txt_date_added;
        public TextView txt_tax;
        public Button btn_check_colors;
    }

    public void showPopUp(ArrayList<Variants> variants){

        dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.variant);
        ListView list = (ListView) dialog.findViewById(R.id.list);

        list.setAdapter(new ProductVariantAdapter(context,variants));

        dialog.show();
    }
}
