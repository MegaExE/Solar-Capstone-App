package humber.ceng355.solarcapstoneapp.PV2;

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

public class PV2CurrentData extends Fragment {
    public PV2CurrentData() {
    }

    //Declare Reference
    DatabaseReference myRef;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Connection to Firebase Database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference("PV2");
        View rootView = inflater.inflate(R.layout.fragment_solarpv2, container, false);




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
                    String PV2_Date = dss.child("Date").getValue(String.class);
                    String PV2_Power = dss.child("Power").getValue(String.class);
                    String PV2_Daily = dss.child("Daily_yield").getValue(String.class);
                    String PV2_Total = dss.child("Total_yield").getValue(String.class);
                    //Declaring textviews
                    TextView PV1DateValueTV = getActivity().findViewById(R.id.Date_Value);
                    TextView PV1PowerValueTV = getActivity().findViewById(R.id.Power_Value);
                    TextView PV1DailyValueTV = getActivity().findViewById(R.id.Dialyyield_Value);
                    TextView PV1TotalValueTV = getActivity().findViewById(R.id.Totalyield_Value);


                    //Display the Date, Current Power, Daily yield and Total yield that PV1 stored on the firebase
                    PV1DateValueTV.setText(PV2_Date);
                    PV1PowerValueTV.setText(PV2_Power.trim());
                    PV1DailyValueTV.setText(PV2_Daily.trim());
                    PV1TotalValueTV.setText(PV2_Total.trim());
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
