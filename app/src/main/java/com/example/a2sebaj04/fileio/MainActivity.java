package com.example.a2sebaj04.fileio;

import android.app.AlertDialog;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.save_load, menu);
        return true;
    }


    public boolean onOptionsItemSelected(MenuItem item)
    {
        if(item.getItemId() == R.id.save)
        {
            // text file should be saved in the directory


            try
            {
                PrintWriter pw =
                        new PrintWriter( new FileWriter( Environment.getExternalStorageDirectory().getAbsolutePath() + "/textedit.txt"));

                EditText et = (EditText)findViewById(R.id.et);
                pw.println(et.getText().toString());

                pw.close(); // close the file to ensure data is flushed to file
            }
            catch(IOException e) {
                new AlertDialog.Builder(this).setMessage("ERROR: " + e).
                        setPositiveButton("OK", null).show();
            }

            return true;
        }
        else if(item.getItemId() == R.id.load)
        {

            return true;
        }
        return false;
    }



}
