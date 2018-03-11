package humber.ceng355.solarcapstoneapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * Solar Capstone
 * Raphael Najera, Johnson Liang, Adrian Caprini
 */

public class SolarPV3 extends Fragment {
    public SolarPV3() {
    }

    //DatabaseReference myRef;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Connection to Firebase Database
       // FirebaseDatabase database = FirebaseDatabase.getInstance();
       // myRef = database.getReference("PV3");
        View rootView = inflater.inflate(R.layout.fragment_solarpv3, container, false);

        return rootView;
    }

    public void onStart(){
        super.onStart();

      /*  myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.


                for(DataSnapshot dss : dataSnapshot.getChildren()) {
                    //Retrieving the data stored on the firebase
                    String PV3_Date = dss.child("Date").getValue(String.class);
                    String PV3_Power = dss.child("Power").getValue(String.class);
                    String PV3_Daily = dss.child("Daily_yield").getValue(String.class);
                    String PV3_Total = dss.child("Total_yield").getValue(String.class);
                    //Declaring textviews
                    TextView PV1DateValueTV = getActivity().findViewById(R.id.PV3_Date_Value);
                    TextView PV1PowerValueTV = getActivity().findViewById(R.id.PV3_Power_Value);
                    TextView PV1DailyValueTV = getActivity().findViewById(R.id.PV3_Dialyyield_Value);
                    TextView PV1TotalValueTV = getActivity().findViewById(R.id.PV2_Totalyield_Value);


                    //Display the Date, Current Power, Daily yield and Total yield that PV1 stored on the firebase
                    PV1DateValueTV.setText(PV3_Date);
                    PV1PowerValueTV.setText(PV3_Power);
                    PV1DailyValueTV.setText(PV3_Daily);
                    PV1TotalValueTV.setText(PV3_Total);
                }

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });*/


    }

}
