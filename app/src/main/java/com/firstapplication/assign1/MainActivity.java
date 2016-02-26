package com.firstapplication.assign1;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView list;
    String[] titles;
    String[] description;
    int[] images={R.drawable.brother,R.drawable.cousin,R.drawable.daddy,R.drawable.mother,R.drawable.sister};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
Resources res=getResources();
titles=res.getStringArray(R.array.titles);

        description=res.getStringArray(R.array.description);
        list= (ListView) findViewById(R.id.listView);
        VivzAdapter adapter=new VivzAdapter(this,titles,images,description);
        list.setAdapter(adapter);
        }
        }
