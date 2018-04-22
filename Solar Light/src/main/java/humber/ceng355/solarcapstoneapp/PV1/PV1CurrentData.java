package humber.ceng355.solarcapstoneapp.PV1;

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

public class PV1CurrentData extends Fragment {
    public PV1CurrentData() {
    }

    //Declare Reference
    DatabaseReference myRef;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Connection to Firebase Database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference("PV1");
        View rootView = inflater.inflate(R.layout.fragment_solarpv1, container, false);
        return rootView;
    }

    public void onStart() {
        super.onStart();
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                for (DataSnapshot dss : dataSnapshot.getChildren()) {
                    //Retrieving the data stored on the firebase
                    String PV1_Date = dss.child("Date").getValue(String.class);
                    String PV1_Power = dss.child("Power").getValue(String.class);
                    String PV1_Daily = dss.child("Daily_yield").getValue(String.class);
                    String PV1_Total = dss.child("Total_yield").getValue(String.class);

                    //Declaring textviews
                    TextView PV1DateValueTV = getActivity().findViewById(R.id.Date_Value);
                    TextView PV1PowerValueTV = getActivity().findViewById(R.id.Power_Value);
                    TextView PV1DailyValueTV = getActivity().findViewById(R.id.Dialyyield_Value);
                    TextView PV1TotalValueTV = getActivity().findViewById(R.id.Totalyield_Value);

                    //Display the Date, Current Power, Daily yield and Total yield that PV1 stored on the firebase
                    PV1DateValueTV.setText(PV1_Date);
                    PV1PowerValueTV.setText(PV1_Power);
                    PV1DailyValueTV.setText(PV1_Daily);
                    PV1TotalValueTV.setText(PV1_Total);
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
