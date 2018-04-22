package humber.ceng355.solarcapstoneapp.PV3;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import humber.ceng355.solarcapstoneapp.R;

import static android.content.ContentValues.TAG;


/**
 * Solar Capstone
 * Raphael Najera, Johnson Liang, Adrian Caprini
 */

public class PV3Port2CurrentData extends Fragment {
    public PV3Port2CurrentData() {
    }

    //Declare database reference
    DatabaseReference myRef;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Connection to Firebase Database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference("PV3b");
        View rootView = inflater.inflate(R.layout.fragment_solarpv3port2, container, false);

        return rootView;
    }

    public void onStart(){
        super.onStart();

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.

                for(DataSnapshot dss : dataSnapshot.getChildren()) {
                    //Retrieving the data stored on the firebase
                    String PV3_Date = dss.child("Date").getValue(String.class);
                    Double PV3_BatteryVolt = dss.child("BatteryVoltage").getValue(Double.class);
                    Double PV3_Power = dss.child("Power").getValue(Double.class);
                    Double PV3_VACin = dss.child("VACin").getValue(Double.class);

                    //Declaring textviews
                    TextView PV3DateTV = getActivity().findViewById(R.id.Date_Value2);
                    TextView PV3BatteryVoltTV = getActivity().findViewById(R.id.BatteryVolt_Value2);
                    TextView PV3PowerTV = getActivity().findViewById(R.id.Power_Value);
                    TextView PV3VACinTV = getActivity().findViewById(R.id.VACin_Value2);

                    //Display the Date, BatteryVolt, Power and VACin that PV3b stored on the firebase
                    PV3DateTV.setText(PV3_Date);
                    PV3BatteryVoltTV.setText(Double.toString(PV3_BatteryVolt));
                    PV3PowerTV.setText(Double.toString(PV3_Power));
                    PV3VACinTV.setText(Double.toString(PV3_VACin));
                }

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });


    }

}
