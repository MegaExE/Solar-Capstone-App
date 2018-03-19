package humber.ceng355.solarcapstoneapp.PV3;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Arrays;

import humber.ceng355.solarcapstoneapp.R;


/**
 * Solar Capstone
 * Raphael Najera, Johnson Liang, Adrian Caprini
 */

public class PV3History extends Fragment {
    public PV3History() {
    }

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
       //myRef = database.getReference("PV3");
        View rootView = inflater.inflate(R.layout.fragment_history_solarpv3, container, false);

        return rootView;
    }

    public void onStart(){
        super.onStart();

        String[] t = new String[0];
        Data = new ArrayList<>(Arrays.asList(t));

       /*  myRef.addValueEventListener(new ValueEventListener() {
            @Override
          public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.


                for(DataSnapshot dss : dataSnapshot.getChildren()) {
                    //Retrieving the data stored on the firebase
                    //String PV3_Date = dss.child("Date").getValue(String.class);
                    //String PV3_Power = dss.child("Power").getValue(String.class);
                    //String PV3_Daily = dss.child("Daily_yield").getValue(String.class);
                    //String PV3_Total = dss.child("Total_yield").getValue(String.class);

                    //Data.add(PV3_Date + "  " + PV3_Power + " " + PV3_Daily);
                
                    // arrayList.add(PV1_Date + "  " + PV1_Power + " " + PV1_Daily);
                }
               // for(int i = (Data.size()-1); i > (Data.size() - 10); i--) {


                 //   arrayList.add(Data.get(i));
               // }
                //Adds checkbox to the listview
              //  adapter = new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_list_item_1, arrayList);
               // chl.setAdapter(adapter);


            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
*/
    }


}
