package com.example.eremey.test2.listFragments;

import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.eremey.test2.R;
import com.example.eremey.test2.adaptersForFragments.WallListAdapter;
import com.example.eremey.test2.models.Wall;
import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKCallback;
import com.vk.sdk.VKScope;
import com.vk.sdk.VKSdk;
import com.vk.sdk.api.VKApi;
import com.vk.sdk.api.VKApiConst;
import com.vk.sdk.api.VKError;
import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.VKResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.vk.sdk.VKUIHelper.getApplicationContext;

/**
 * Created by Eremey on 25.11.2016.
 */

public class WallListFragment extends ListFragment {

   private  String [] scope=new String [] {VKScope.MESSAGES,VKScope.FRIENDS,VKScope.WALL,VKScope.AUDIO,VKScope.PHOTOS,VKScope.GROUPS,VKScope.PAGES,VKScope.OFFLINE,VKScope.STATUS,VKScope.VIDEO};
   ArrayList<Wall> arrayList;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
       VKSdk.login(this,scope);
        arrayList = new ArrayList<>();

    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (!VKSdk.onActivityResult(requestCode, resultCode, data, new VKCallback<VKAccessToken>() {
            @Override
            public void onResult( final VKAccessToken res) {

                VKRequest request=VKApi.wall()
                        .get(VKParameters.from(VKApiConst.OWNER_ID,"387458929",VKApiConst.COUNT,2));
                request.executeWithListener(new VKRequest.VKRequestListener(){

                    public void onComplete(VKResponse response){
                        super.onComplete(response);

                        try {
                            JSONObject jsonObject= (JSONObject) response.json.get("response");
                            JSONArray jsonArray=(JSONArray) jsonObject.get("items");

                            for( int i=0;i<jsonArray.length();i++){
                                JSONObject post=(JSONObject) jsonArray.get(i);

                                JSONArray array1= (JSONArray) post.get("attachments");
                                JSONObject array2 = (JSONObject) array1.get(0);

                                JSONObject array3= (JSONObject) array2.get("photo");
                                System.out.println("Вывод  :  " + array3.get("photo_75"));
                                arrayList.add(new Wall(array3.getString("photo_75"), array3.getString("photo_75")));

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                        WallListAdapter adapter = new WallListAdapter(
                                getApplicationContext(), R.layout.wall_adapter, arrayList
                        );
                        setListAdapter(adapter);
                    }

                });
                Toast.makeText(getApplicationContext(),"Good connection",Toast.LENGTH_LONG).show();
            }
            @Override
            public void onError(VKError error) {
                Toast.makeText(getApplicationContext()," Error",Toast.LENGTH_LONG).show();
            }
        })) {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }







    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.wall_adapter_after,null);
    }

}
