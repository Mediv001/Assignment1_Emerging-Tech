package com.example.english.assignment1;

import android.app.Activity;
import android.content.ClipData;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView MainList = (ListView) findViewById(R.id.list);
        ArrayList<ToItem> al_strings = new ArrayList<ToItem>();
        final NewAdapt cus = new NewAdapt(this, al_strings);
        Button but = (Button) findViewById(R.id.button01);
        MainList.setAdapter(cus);

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Addi(cus);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void Addi(NewAdapt aa){
        EditText tx = (EditText) findViewById(R.id.Edit);
        if(!(tx.getText().toString().isEmpty())) {
            ToItem ne = new ToItem(false, tx.getText().toString());
            aa.add(ne);
            aa.notifyDataSetChanged();
            /*Toast toast = Toast.makeText(getApplicationContext(), "Your item is added !",
                    Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.BOTTOM | Gravity.CENTER, 0, 0);
            toast.show();
        }
        else{
            Toast toast = Toast.makeText(getApplicationContext(), "No item to add !",
                    Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.BOTTOM|Gravity.CENTER, 0, 0);
            toast.show();*/
        }
        tx.setText("");
    }
}
