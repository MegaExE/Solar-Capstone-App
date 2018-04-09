package humber.ceng355.solarcapstoneapp.PV3;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import humber.ceng355.solarcapstoneapp.R;


/**
 * Solar Capstone
 * Raphael Najera, Johnson Liang, Adrian Caprini
 */


public class SolarPV3 extends Fragment {
    View view;
    ViewPager viewPager;
    TabLayout tabLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.sample, container, false);

        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        viewPager.setAdapter(new sliderAdapter(getChildFragmentManager()));
        tabLayout = (TabLayout) view.findViewById(R.id.sliding_tabs);
        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(viewPager);
            }
        });

        return view;
    }
    private class sliderAdapter extends FragmentPagerAdapter {

        final  String tabs[]={"Inverters","Charge Controllers", "Inverters Log", "Charge Controllers Log"};
        public sliderAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if(position == 0){
                return new PV3Port1CurrentData();
            }
            else if(position == 1){
                return new PV3Port2CurrentData();
            }
            else if(position == 2){
                return new PV3Port1History();
            } else{
                return new PV3Port2History();
            }

        }

        @Override
        public int getCount() {
            return 4;
        }
        @Override
        public CharSequence getPageTitle(int position) {
            return tabs[position];
        }
    }
}
