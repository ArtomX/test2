package com.example.eremey.test2.listFragments;

/**
 * Created by Eremey on 22.11.2016.
 */
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.eremey.test2.models.Product;
import com.example.eremey.test2.adaptersForFragments.ProductListAdapter;
import com.example.eremey.test2.R;

import java.util.ArrayList;
import java.util.List;

public class MainListFragment extends ListFragment{
    String [] data=new String [] {"one","two","three","four","five"};


    private ProductListAdapter adapter;
    private List<Product> mProductList;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mProductList=new ArrayList<>();
        mProductList.add(new Product(1,"Iphone 1",200,"Apple", R.drawable.black));
        mProductList.add(new Product(2,"Iphone 1",200,"Apple",R.drawable.black));
        mProductList.add(new Product(3,"Iphone 1",200,"Apple",R.drawable.black));
        mProductList.add(new Product(4,"Iphone 1",200,"Apple",R.drawable.black));
        mProductList.add(new Product(5,"Iphone 1",200,"Apple",R.drawable.black));
        mProductList.add(new Product(6,"Iphone 1",200,"Apple",R.drawable.black));
        mProductList.add(new Product(7,"Iphone 1",200,"Apple",R.drawable.black));
        mProductList.add(new Product(8,"Iphone 1",200,"Apple",R.drawable.black));
        mProductList.add(new Product(9,"Iphone 1",200,"Apple",R.drawable.black));
        mProductList.add(new Product(10,"Iphone 1",200,"Apple",R.drawable.black));
        mProductList.add(new Product(11,"Iphone 1",200,"Apple",R.drawable.black));
        mProductList.add(new Product(12,"Iphone 1",200,"Apple",R.drawable.black));
        mProductList.add(new Product(13,"Iphone 1",200,"Apple",R.drawable.black));
        mProductList.add(new Product(14,"Iphone 1",200,"Apple",R.drawable.black));

        adapter=new ProductListAdapter(getActivity(),mProductList);
        setListAdapter(adapter);

        //ArrayAdapter <String> adapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,data);
        //setListAdapter(adapter);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState){
        return inflater.inflate(R.layout.for_adapter_after,null);
    }


}
