package humber.ceng355.solarcapstoneapp.PV3;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;

import humber.ceng355.solarcapstoneapp.R;

import static android.content.ContentValues.TAG;


/**
 * Solar Capstone
 * Raphael Najera, Johnson Liang, Adrian Caprini
 */

public class PV3Port1History extends Fragment {
    public PV3Port1History() {
    }

    //Declare Database Reference
    DatabaseReference myRef;

    //Declare Arraylist
    ArrayList<String> Data;
    static ArrayList<String> arrayList;
    static ArrayAdapter<String> adapter;

    //Declare ListView
    ListView chl;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Connection to Firebase Database
       FirebaseDatabase database = FirebaseDatabase.getInstance();
       myRef = database.getReference("PV3a");
        view = inflater.inflate(R.layout.fragment_history_solarpv3port1, container, false);

        //This section will be storing the entries into a String
        String[] items = new String[0];

        //Create an ArrayList object to store the entries
        arrayList = new ArrayList<>(Arrays.asList(items));

        //Create an instance of ListView
        chl=(ListView) view.findViewById(R.id.list);

        return view;
    }

    public void onStart(){
        super.onStart();

        //Declare arraylist named data
        String[] t = new String[0];
        Data = new ArrayList<>(Arrays.asList(t));
        //Clear the arraylist and data
        Data.clear();
        arrayList.clear();

         myRef.addValueEventListener(new ValueEventListener() {
            @Override
          public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.

                for(DataSnapshot dss : dataSnapshot.getChildren()) {
                    //Retrieving the data stored on the firebase
                    String PV3_Date = dss.child("Date").getValue(String.class);
                    Double PV3_BatteryVolt = dss.child("BatteryVolt").getValue(Double.class);
                    Double PV3_VACin = dss.child("VACin").getValue(Double.class);
                    Double PV3_VACout = dss.child("VACout").getValue(Double.class);

                    //Stores the entries into the arraylist named Data
                    Data.add(PV3_Date + "   "+ Double.toString(PV3_BatteryVolt)+"V   "+ Double.toString(PV3_VACin)+"V   "+Double.toString(PV3_VACout)+"V");
                    // arrayList.add(PV1_Date + "  " + PV1_Power + " " + PV1_Daily);
                }
                for(int i = (Data.size()-1); i > (Data.size() - 25); i--) {
                    //Display the solar panel data on the Listview
                    arrayList.add(Data.get(i));
                }
                //Adds list to the listview
                adapter = new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_list_item_1, arrayList);
                chl.setAdapter(adapter);
            }

             @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }
}
