package com.firstapplication.assign1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Varsha on 13-02-2016.
 */
class VivzAdapter extends ArrayAdapter<String>
{
    Context context;
    int[] images;
    String[] titleArray;
    String[] descriptionArray;
    VivzAdapter(Context c,String[] titles,int imgs[],String[] desc)
    {
        super(c,R.layout.single_row,R.id.textView,titles);
        this.context=c;
        this.images=imgs;
        this.titleArray=titles;
        this.descriptionArray=desc;
    }

    @Override
    public View getView(int position,View convertView,ViewGroup parent) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row= inflater.inflate(R.layout.single_row,parent,false);
        ImageView myImage= (ImageView) row.findViewById(R.id.imageView);
        TextView mytitle= (TextView) row.findViewById(R.id.textView);
        TextView mydescription= (TextView) row.findViewById(R.id.textView2);
        myImage.setImageResource(images[position]);
        mytitle.setText(titleArray[position]);
        mydescription.setText(descriptionArray[position]);
        return row;
    }

}