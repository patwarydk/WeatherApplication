package com.example.mehrabpatwary.weatherapplication;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;




/**
 * A simple {@link Fragment} subclass.
 */
public class CurrentWeather extends Fragment {

    private TextView tempTV;


    public CurrentWeather() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_current_weather, container, false);
        tempTV = view.findViewById(R.id.temparature);


        return view;






    }

}
