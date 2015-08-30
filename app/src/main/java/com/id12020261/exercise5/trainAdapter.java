package com.id12020261.exercise5;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Nathan on 8/29/2015.
 */
public class trainAdapter extends ArrayAdapter<TrainData> {

    //Constructor for trainAdapter
    public trainAdapter(Context context, ArrayList<TrainData> trains) {
        super(context, 0, trains);
    }


    //Override GetView to set the custom adapter and aply data from trainData
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        TrainData train = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        // Lookup view for data population

        //Declatartion of layout items
        final TextView list_platform = (TextView) convertView.findViewById(R.id.list_platform_name);
        final TextView list_arrival_time = (TextView) convertView.findViewById(R.id.list_time_number);
        final TextView list_arrival_mins = (TextView) convertView.findViewById(R.id.list_time_mins);
        final ProgressBar list_progressbar = (ProgressBar) convertView.findViewById(R.id.list_individual_bar);
        final TextView list_status = (TextView) convertView.findViewById(R.id.list_status);


        final TextView list_destination_time = (TextView) convertView.findViewById(R.id.list_destination_time);
        final TextView list_destination = (TextView) convertView.findViewById(R.id.list_destination);
        // Populate the data into the template view using the data object
        list_platform.setText(train.mPlatform);
        list_arrival_time.setText((Integer.toString(train.mArrivalTime)));
        list_status.setText(train.mStatus);

        list_destination_time.setText(train.mDestinationTime);
        list_destination.setText(train.mDestination);

        LinearLayout green_square = (LinearLayout) convertView.findViewById(R.id.green_square);

        // Set on Click listener on linear layout
        green_square.setOnClickListener(new View.OnClickListener()
        {
            //Overriide onclick to call Asynctask and generate random number
            @Override
            public void onClick(View v)
            {



                new RefreshOne(list_arrival_time, list_arrival_mins, list_progressbar).execute();

                Random r = new Random();
                int number = r.nextInt(20 - 1 + 1) + 1;
                list_arrival_time.setText((Integer.toString(number)));

            }
        });


        // Return the completed view to render on screen
        return convertView;
    }
}
