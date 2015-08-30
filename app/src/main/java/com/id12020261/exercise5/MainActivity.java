package com.id12020261.exercise5;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;


public class MainActivity extends ActionBarActivity {

    trainAdapter mAdapter;
    int mArrivalTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mArrivalTime = 10;
        populateTrainList();


        }
    public void populateTrainList() {
        // Construct the data source
        ArrayList<TrainData> arrayOfTrains = TrainData.GetTrains();
        // Create the adapter to convert the array to views
        mAdapter = new trainAdapter(this, arrayOfTrains);
        // Attach the adapter to a ListView
        ListView listView = (ListView) findViewById(R.id.train_list);
        listView.setAdapter((ListAdapter) mAdapter);


        mAdapter.add(new TrainData("Albion Park Platform 1",7,"On time","Allawah","14:11"));
        mAdapter.add(new TrainData("Arncliffe platform 2", 8, "Late", "Central", "14:34"));
        mAdapter.add(new TrainData("Artarmion Platform 3", 18, "On time", "Ahfield", "15:01"));
        mAdapter.add(new TrainData("Berowra Platfform 4", 3, "Late", "Beverly", "15:18"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        ListView listView = (ListView) findViewById(R.id.train_list);
        ProgressBar progressbar = (ProgressBar) findViewById(R.id.main_progress_bar);
        TextView list_arrival_time = (TextView) findViewById((R.id.list_time_number));

        switch (item.getItemId())
        {
            case R.id.action_settings:
                System.exit(0);
                break;

            case R.id.menu_add:
                mAdapter.add(new TrainData("Chatswood Platform 1",8,"Late","Horsby","17:15"));
                break;

            case R.id.menu_delete:
                mAdapter.clear();
                break;

            case R.id.sync_button:
                new RefreshAll(listView,progressbar).execute();
                Random r = new Random();
                int number = r.nextInt(20 - 1 + 1) + 1;
                list_arrival_time.setText((Integer.toString(number)));
                break;
        }



        return super.onOptionsItemSelected(item);
    }


    public void RandomNumber(){

        int min = 1;
        int max = 20;

        Random r = new Random();
        mArrivalTime = r.nextInt(max - min + 1) + min;
        mAdapter.notifyDataSetChanged();

    }
}
class RefreshAll extends AsyncTask {

    ListView mMainListview;
    ProgressBar mMainProgressBar;

    public RefreshAll(ListView listview, ProgressBar progressBar) {
        this.mMainListview = listview;
        this.mMainProgressBar = progressBar;



    }


    @Override
    protected Object doInBackground(Object[] params) {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    protected void onPreExecute() {

        mMainListview.setVisibility(View.INVISIBLE);
        mMainProgressBar.setVisibility(View.VISIBLE);

        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Object o) {

        mMainListview.setVisibility(View.VISIBLE);
        mMainProgressBar.setVisibility(View.INVISIBLE);


        super.onPostExecute(o);
    }


    }
class RefreshOne extends AsyncTask {


    TextView mNumberTextView;
    TextView mMinsTextView;
    ProgressBar mListProgressBar;



    public RefreshOne(TextView textView,TextView textView2, ProgressBar progressBar) {

        this.mNumberTextView = textView;
        this.mMinsTextView = textView2;
        this.mListProgressBar = progressBar;




    }


    @Override
    protected Object doInBackground(Object[] params) {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    protected void onPreExecute() {



        mNumberTextView.setVisibility(View.GONE);
        mMinsTextView.setVisibility(View.GONE);
        mListProgressBar.setVisibility(View.VISIBLE);

        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Object o) {

        mNumberTextView.setVisibility(View.VISIBLE);
        mMinsTextView.setVisibility(View.VISIBLE);
        mListProgressBar.setVisibility(View.GONE);


        super.onPostExecute(o);
    }
}



