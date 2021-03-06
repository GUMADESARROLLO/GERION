package com.guma.desarrollo.caronte.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.guma.desarrollo.caronte.R;

import java.util.ArrayList;

/**
 * Created by maryan.espinoza on 13/01/2017.
 */

public class MyCustomAdapter extends ArrayAdapter<Tipificaciones> {

    private ArrayList<Tipificaciones> countryList;

    public MyCustomAdapter(Context context, int textViewResourceId,
                           ArrayList<Tipificaciones> countryList) {
        super(context, textViewResourceId, countryList);
        this.countryList = new ArrayList<Tipificaciones>();
        this.countryList.addAll(countryList);
    }

    private class ViewHolder {
        TextView code;
        CheckBox name;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;
        if (convertView == null) {
            LayoutInflater vi = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = vi.inflate(R.layout.tipicaciones_info, null);

            holder = new ViewHolder();
            holder.code = (TextView) convertView.findViewById(R.id.code);
            holder.name = (CheckBox) convertView.findViewById(R.id.checkBox1);
            convertView.setTag(holder);

            holder.name.setOnClickListener( new View.OnClickListener() {
                public void onClick(View v) {
                    CheckBox cb = (CheckBox) v ;
                    Tipificaciones country = (Tipificaciones) cb.getTag();
                    //Toast.makeText(getContext().getApplicationContext(),"Clicked on Checkbox: " + cb.getText() +" is " + cb.isChecked(),Toast.LENGTH_LONG).show();
                    country.setSelected(cb.isChecked());
                }
            });
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        Tipificaciones country = countryList.get(position);
        holder.code.setText(" (" +  country.getCode() + ")");
        holder.name.setText(country.getName());
        holder.name.setChecked(country.isSelected());
        holder.name.setTag(country);

        return convertView;

    }



}
