package com.example.nilesh.anew;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        String[] names={"Nilesh","Pratik","Shubham","Aditya","Sachin","Maverick"};

        ListAdapter adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,names);
        ListView listView=(ListView)findViewById(R.id.listview);

        listView.setAdapter(adapter);
        registerForContextMenu(listView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Select a action ");
        menu.add(0,v.getId(),0,"Call");
        menu.add(0,v.getId(),0,"SMS");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(item.getTitle()=="Call"){
            Toast.makeText(getApplicationContext(),"call him",Toast.LENGTH_SHORT).show();
        }
        else if(item.getTitle()=="SMS"){
            Toast.makeText(getApplicationContext(),"SMS him",Toast.LENGTH_SHORT).show();
        }
        else{
            return false;
        }
        return true;




    }
}
