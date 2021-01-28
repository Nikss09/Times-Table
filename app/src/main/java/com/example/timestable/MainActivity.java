package com.example.timestable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    int x;
    ListView listView;

    public void generate(int timesTableNumber){
        ArrayList<String> arrayList=new ArrayList<String>();
        for(int j=1;j<=10;j++){
            x=timesTableNumber*j;
            arrayList.add(Integer.toString(timesTableNumber)+"*"+Integer.toString(j)+"="+Integer.toString(x));
        }
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,arrayList);
        listView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=(ListView)findViewById(R.id.listView);
        final SeekBar seekBar=(SeekBar)findViewById(R.id.seekBar);


        seekBar.setMax(20);
        seekBar.setProgress(10);
        generate(10);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                int min=1;
                int timesTableNumber;

                if(i<min){
                    timesTableNumber=min;
                }
                else{
                    timesTableNumber=i;
                }

                generate(timesTableNumber);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}