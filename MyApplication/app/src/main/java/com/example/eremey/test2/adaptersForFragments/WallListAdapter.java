package com.example.eremey.test2.adaptersForFragments;

/**
 * Created by Eremey on 25.11.2016.
 */
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.eremey.test2.R;
import com.example.eremey.test2.models.Wall;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;

public class WallListAdapter extends ArrayAdapter<Wall> {
    ArrayList<Wall> products;
    Context context;
    int resourse;
    public WallListAdapter(Context context, int resource, ArrayList<Wall> products) {
        super(context, resource, products);
        this.products=products;
        this.context=context;
        this.resourse=resource;
    }

    public  View getView(int position,View convertView,ViewGroup parent){
        if(convertView==null) {
            LayoutInflater layoutInflater=(LayoutInflater) getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView=layoutInflater.inflate(R.layout.wall_adapter,null,true);
        }
        Wall product=getItem(position);
        ImageView imageView=(ImageView) convertView.findViewById(R.id.imageViewProduct);
        Picasso.with(context).load(product.getImage()).into(imageView);
        TextView txtName=(TextView) convertView.findViewById(R.id.textName);
        txtName.setText(product.getName());

        return convertView;
    }
}
