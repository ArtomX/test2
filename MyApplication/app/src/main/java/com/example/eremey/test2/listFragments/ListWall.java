package com.example.eremey.test2.listFragments;

import android.app.ListFragment;
import android.os.Bundle;
import android.widget.ArrayAdapter;

/**
 * Created by Eremey on 23.11.2016.
 */

public class ListWall extends ListFragment {
    String [] data=new String []{"one","two","three","four","five"};
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter <String> adapter=new ArrayAdapter <String> (getActivity(),android.R.layout.simple_list_item_1,data);
        setListAdapter(adapter);

    }
}
