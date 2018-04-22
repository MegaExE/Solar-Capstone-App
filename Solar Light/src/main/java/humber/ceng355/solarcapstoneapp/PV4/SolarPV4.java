package humber.ceng355.solarcapstoneapp.PV4;

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


public class SolarPV4 extends Fragment {
    //declare view, viewpager and tabLayout
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

        //Creates the tab
        final  String tabs[]={"Data", "Log"};
        public sliderAdapter(FragmentManager fm) {
            super(fm);
        }

        //Check the selected tab to display the layout that tab
        @Override
        public Fragment getItem(int position) {
            if(position == 0){
                return new PV4CurrentData();
            }else{
                return new PV4History();
            }

        }

        @Override
        public int getCount() {
            return 2;
        }
        @Override
        public CharSequence getPageTitle(int position) {
            return tabs[position];
        }
    }
}
