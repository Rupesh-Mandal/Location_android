package com.deepak.location;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DistanceCalculateActivity extends AppCompatActivity {

    EditText editTextTextPersonName,editTextTextPersonName2,editTextTextPersonName3,editTextTextPersonName4;
    TextView textView2;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distance_calculate);
        button=findViewById(R.id.button);
        textView2=findViewById(R.id.textView2);

        List<Data> lList = new ArrayList<>();

        lList.add(new Data("4",4));
        lList.add(new Data("1",-1));
        lList.add(new Data("5",5));
        lList.add(new Data("8",8));

        Collections.sort(lList, new Comparator<Data>(){
            public int compare(Data obj1, Data obj2) {
                // ## Ascending order
//                return obj1.firstName.compareToIgnoreCase(obj2.firstName); // To compare string values
                 return Double.valueOf(obj1.id).compareTo(Double.valueOf(obj2.id)); // To compare integer values

                // ## Descending order
                // return obj2.firstName.compareToIgnoreCase(obj1.firstName); // To compare string values
                // return Integer.valueOf(obj2.empId).compareTo(Integer.valueOf(obj1.empId)); // To compare integer values
            }
        });

        for (int i=0;i<lList.size();i++){
            Log.e("abcd", String.valueOf(lList.get(i).name));
            Log.e("abcd", String.valueOf(lList.get(i).id));
        }

        button.setOnClickListener(view -> {
            double d=CalculationByDistance(new LatLng(26.7270712497105, 86.48068635825057),new LatLng(26.72841279967368, 86.48750989821893));
            textView2.setText(String.valueOf(d));
        });
    }

    public double CalculationByDistance(LatLng StartP, LatLng EndP) {
        int Radius = 6371;// radius of earth in Km
        double lat1 = StartP.latitude;
        double lat2 = EndP.latitude;
        double lon1 = StartP.longitude;
        double lon2 = EndP.longitude;
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(Math.toRadians(lat1))
                * Math.cos(Math.toRadians(lat2)) * Math.sin(dLon / 2)
                * Math.sin(dLon / 2);
        double c = 2 * Math.asin(Math.sqrt(a));
        double valueResult = Radius * c;
        double km = valueResult / 1;
        DecimalFormat newFormat = new DecimalFormat("####");
        int kmInDec = Integer.valueOf(newFormat.format(km));
        double meter = valueResult % 1000;
        int meterInDec = Integer.valueOf(newFormat.format(meter));
        Log.i("Radius Value", "" + valueResult + "   KM  " + kmInDec
                + " Meter   " + meterInDec);
        return Radius * c;
    }
}