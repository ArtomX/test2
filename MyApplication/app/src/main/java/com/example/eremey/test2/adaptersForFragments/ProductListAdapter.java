package com.example.eremey.test2.adaptersForFragments;

/**
 * Created by Eremey on 22.11.2016.
 */
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.eremey.test2.models.Product;
import com.example.eremey.test2.R;

import java.util.List;

/**
 * Created by Eremey on 15.11.2016.
 */

public class ProductListAdapter extends BaseAdapter {

    private Context mContext;
    private List<Product> mProductList;

    public ProductListAdapter(Context mContext, List<Product> mProductList) {
        this.mContext = mContext;
        this.mProductList = mProductList;
    }

    public ProductListAdapter(List<Product> mProductList) {

    }

    @Override
    public int getCount() {
        return mProductList.size();
    }

    @Override
    public Object getItem(int position) {
        return mProductList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View v=View.inflate(mContext, R.layout.item_product_list,null);
        TextView tvName=(TextView) v.findViewById(R.id.tv_name);
        TextView tvPrice=(TextView) v.findViewById(R.id.tv_price);
        TextView tvDescription=(TextView) v.findViewById(R.id.tv_description);
        ImageView tvImage=(ImageView) v.findViewById(R.id.tv_image);

        tvName.setText(mProductList.get(position).getName());
        tvPrice.setText(mProductList.get(position).getPrice()+" $");
        tvDescription.setText(mProductList.get(position).getDescription());
        tvImage.setImageResource(mProductList.get(position).getImage());
        v.setTag(mProductList.get(position).getId());
        return v;
    }
}
