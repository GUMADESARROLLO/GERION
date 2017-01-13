package com.guma.desarrollo.caronte.Activitys;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.guma.desarrollo.caronte.Adapters.MyCustomAdapter;
import com.guma.desarrollo.caronte.Adapters.Tipificaciones;
import com.guma.desarrollo.caronte.R;

import java.util.ArrayList;



public class ReporteVistaActivity extends AppCompatActivity {

    MyCustomAdapter dataAdapter = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporte_vista);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("REPORTE DE VISITA");
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        //Generate list View from ArrayList
        displayListView();

    }


    private void displayListView() {
        //Array list of countries
        ArrayList<Tipificaciones> countryList = new ArrayList<Tipificaciones>();
        Tipificaciones country = null;



        for (int i=0;i<15;i++){
            country = new Tipificaciones("OP "+i,"Aliquam tincidunt mauris eu risus " + i,false);
            countryList.add(country);
        }

        dataAdapter = new MyCustomAdapter(this,R.layout.tipicaciones_info, countryList);
        ListView listView = (ListView) findViewById(R.id.listView1);

        listView.setAdapter(dataAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                Tipificaciones country = (Tipificaciones) parent.getItemAtPosition(position);
                //Toast.makeText(getApplicationContext(),"Clicked on Row: " + country.getName(),Toast.LENGTH_LONG).show();
            }
        });

    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if (id == 16908332){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

}




