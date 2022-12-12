package com.example.recyclerview_expandable_task;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ModelClass modelClass;
    AdapterClass adapterClass;
    List<ModelClass> modelClassList=new ArrayList<>();
    ImageView call,map,website;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            recyclerView=findViewById(R.id.recyclerviewid);
            call=findViewById(R.id.callid);
            map=findViewById(R.id.mapid);
            website=findViewById(R.id.webid);
            recyclerView.setHasFixedSize(true);

            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            adapterClass=new AdapterClass(getApplicationContext(),modelClassList);
            recyclerView.setAdapter(adapterClass);

            LoadTouristData();



        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    private void LoadTouristData() {

        modelClass=new ModelClass(R.drawable.gateway_ofindia,"Gateway of India",R.drawable.ic_baseline_arrow_drop_down_24,R.drawable.ic_baseline_call_24,R.drawable.ic_baseline_fmd_good_24,R.drawable.ic_baseline_open_in_browser_24,"987654321","https://www.bing.com/search?q=bangalore+palace&qs=n&form=QBRE&msbsrank=6_7__0&sp=-1&ghc=2&pq=bangalore+pala&sc=13-14&sk=&cvid=748F15CD45DB45D0B7B742BED9B2951F&ghsh=0&ghacc=1&ghpl=undefined",17.651268,76.725182);
        modelClassList.add(modelClass);
        modelClass=new ModelClass(R.drawable.lotus_temple,"Lotus Temple",R.drawable.ic_baseline_arrow_drop_down_24,R.drawable.ic_baseline_call_24,R.drawable.ic_baseline_fmd_good_24,R.drawable.ic_baseline_open_in_browser_24,"987654321","https://en.wikipedia.org/wiki/Mysore_Palace",17.651268,76.725182);
        modelClassList.add(modelClass);
        modelClass=new ModelClass(R.drawable.city_palace_jaipur,"City Palace, Jaipur",R.drawable.ic_baseline_arrow_drop_down_24,R.drawable.ic_baseline_call_24,R.drawable.ic_baseline_fmd_good_24,R.drawable.ic_baseline_open_in_browser_24,"987654321","https://sites.google.com",17.651268,76.725182);
        modelClassList.add(modelClass);
        modelClass=new ModelClass(R.drawable.tajmahal,"Taj Mahal",R.drawable.ic_baseline_arrow_drop_down_24,R.drawable.ic_baseline_call_24,R.drawable.ic_baseline_fmd_good_24,R.drawable.ic_baseline_open_in_browser_24,"987654321","https://www.lonelyplanet.com/articles/taj-mahal-visitor-limits",17.651268,76.725182);
        modelClassList.add(modelClass);
        modelClass=new ModelClass(R.drawable.bangalorepalace,"Bangalore Palace",R.drawable.ic_baseline_arrow_drop_down_24,R.drawable.ic_baseline_call_24,R.drawable.ic_baseline_fmd_good_24,R.drawable.ic_baseline_open_in_browser_24,"987654321","https://en.wikipedia.org/wiki/Mysore_Palace",17.651268,76.725182);
        modelClassList.add(modelClass);
        modelClass=new ModelClass(R.drawable.qutub_minar,"Qutub Minar",R.drawable.ic_baseline_arrow_drop_down_24,R.drawable.ic_baseline_call_24,R.drawable.ic_baseline_fmd_good_24,R.drawable.ic_baseline_open_in_browser_24,"987654321","https://sites.google.com",17.651268,76.725182);
        modelClassList.add(modelClass);

        modelClass=new ModelClass(R.drawable.gateway_ofindia,"Gateway of India",R.drawable.ic_baseline_arrow_drop_down_24,R.drawable.ic_baseline_call_24,R.drawable.ic_baseline_fmd_good_24,R.drawable.ic_baseline_open_in_browser_24,"987654321","https://sites.google.com",17.651268,76.725182);
        modelClassList.add(modelClass);
        modelClass=new ModelClass(R.drawable.lotus_temple,"Lotus Temple",R.drawable.ic_baseline_arrow_drop_down_24,R.drawable.ic_baseline_call_24,R.drawable.ic_baseline_fmd_good_24,R.drawable.ic_baseline_open_in_browser_24,"987654321","https://sites.google.com",17.651268,76.725182);
        modelClassList.add(modelClass);
        modelClass=new ModelClass(R.drawable.city_palace_jaipur,"City Palace, Jaipur",R.drawable.ic_baseline_arrow_drop_down_24,R.drawable.ic_baseline_call_24,R.drawable.ic_baseline_fmd_good_24,R.drawable.ic_baseline_open_in_browser_24,"987654321","https://sites.google.com",17.651268,76.725182);
        modelClassList.add(modelClass);
        modelClass=new ModelClass(R.drawable.tajmahal,"Taj Mahal",R.drawable.ic_baseline_arrow_drop_down_24,R.drawable.ic_baseline_call_24,R.drawable.ic_baseline_fmd_good_24,R.drawable.ic_baseline_open_in_browser_24,"987654321","www.google.com",17.651268,76.725182);
        modelClassList.add(modelClass);
        modelClass=new ModelClass(R.drawable.bangalorepalace,"Bangalore Palace",R.drawable.ic_baseline_arrow_drop_down_24,R.drawable.ic_baseline_call_24,R.drawable.ic_baseline_fmd_good_24,R.drawable.ic_baseline_open_in_browser_24,"987654321","www.google.com",17.651268,76.725182);
        modelClassList.add(modelClass);
        modelClass=new ModelClass(R.drawable.qutub_minar,"Qutub Minar",R.drawable.ic_baseline_arrow_drop_down_24,R.drawable.ic_baseline_call_24,R.drawable.ic_baseline_fmd_good_24,R.drawable.ic_baseline_open_in_browser_24,"987654321","www.google.com",17.651268,76.725182);
        modelClassList.add(modelClass);

        adapterClass.notifyDataSetChanged();

    }
}