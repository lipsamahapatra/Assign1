package com.firstapplication.assign1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.squareup.picasso.Picasso;

/**
 * Created by Varsha on 13-02-2016.
 */
class VivzAdapter extends ArrayAdapter<String>
{
    Context context;
    int[] images;
    String[] titleArray;
    String[] descriptionArray;
    public Firebase firebase;
    VivzAdapter(Context c,String[] titles,int imgs[],String[] desc)
    {
        super(c,R.layout.single_row,R.id.textView,titles);
        this.context=c;
        this.images=imgs;
        this.titleArray=titles;
        this.descriptionArray=desc;
        Firebase.setAndroidContext(getContext());
        firebase = new Firebase("https://gdgassignment.firebaseio.com/");
    }

    @Override
    public View getView(final int position,View convertView,ViewGroup parent) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row= inflater.inflate(R.layout.single_row,parent,false);
        final ImageView myImage= (ImageView) row.findViewById(R.id.imageView);
        final TextView mytitle= (TextView) row.findViewById(R.id.textView);
        final TextView mydescription= (TextView) row.findViewById(R.id.textView2);

        myImage.setImageResource(images[position]);
        mytitle.setText(titleArray[position]);
        mydescription.setText(descriptionArray[position]);
        firebase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                mytitle.setText(String.valueOf(dataSnapshot.child(String.valueOf(position)).child("Name").getValue()));
                mydescription.setText(String.valueOf(dataSnapshot.child(String.valueOf(position)).child("Relation").getValue()));
                Picasso.with(getContext()).load(String.valueOf(dataSnapshot.child(String.valueOf(position)).child("ImageUrl").getValue()))
                        .into(myImage);

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }
        });
        return row;
    }

}