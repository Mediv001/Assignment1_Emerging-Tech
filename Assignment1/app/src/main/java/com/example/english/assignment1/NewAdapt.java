package com.example.english.assignment1;

import android.app.Activity;
import android.app.LauncherActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by english on 02/03/2016.
 */
class NewAdapt extends BaseAdapter {
    Context context;
    ArrayList<ToItem> data;

    private static LayoutInflater inflater = null;

    public NewAdapt(Context context, ArrayList<ToItem> data) {
        // TODO Auto-generated constructor stub
        this.context = context;
        this.data = data;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void delete_item(int position) {
        data.remove(getItem(position));
        this.notifyDataSetChanged();
    }

    public void add(ToItem dat){
        data.add(dat);
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    static class ViewHolderItem {
        TextView textViewItem;
        CheckBox checked;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final ViewHolderItem viewHolder;

        if(convertView==null){

            // inflate the layout
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.checkbox, parent, false);

            // well set up the ViewHolder
            viewHolder = new ViewHolderItem();
            viewHolder.textViewItem = (TextView) convertView.findViewById(R.id.textview);
            viewHolder.checked = (CheckBox) convertView.findViewById(R.id.check);

            // store the holder with the view.
            convertView.setTag(viewHolder);

        }else{
            // we've just avoided calling findViewById() on resource everytime
            // just use the viewHolder
            viewHolder = (ViewHolderItem) convertView.getTag();
        }

        // object item based on the position
        Object objectItem = getItem(position);


        // assign values if the object is not null
        if(objectItem != null) {
            viewHolder.checked.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    data.get(position).setChecked(isChecked);
                }
            });
            // get the TextView from the ViewHolder and then set the text (item name) and tag (item ID) values
            viewHolder.textViewItem.setText(data.get(position).data);
            viewHolder.textViewItem.setTag(getItemId(position));
            viewHolder.checked.setChecked(data.get(position).isChecked());
        }
        return convertView;
    }
}
