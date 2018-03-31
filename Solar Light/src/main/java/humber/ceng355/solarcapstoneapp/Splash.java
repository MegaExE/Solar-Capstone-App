package humber.ceng355.solarcapstoneapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Solar Capstone
 * Raphael Najera, Johnson Liang, Adrian Caprini
 */

    public class Splash extends AppCompatActivity {
        //A delay time to show the icon for 5 seconds (loading screen)
        final int SPLASH_TIME = 3000;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.splashactivity);

            Thread thread = new Thread(){
                @Override
                public void run(){
                    try {
                        sleep(SPLASH_TIME);
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                    catch (InterruptedException ex){
                        ex.printStackTrace();
                    }
                }
            };
            thread.start();
        }
    }


