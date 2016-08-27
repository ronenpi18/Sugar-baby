package tomerbu.edu.fireloginwithfacebook;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationAdapter;

/**
 * Created by Tom on 23/08/2016.
 */

public class createChallenge extends AppCompatActivity {
    int white=Color.parseColor("#ffffff");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_challenge);

        AHBottomNavigation bottomNavigation = (AHBottomNavigation) findViewById(R.id.bottomBar);
        AHBottomNavigationAdapter navigationAdapter = new AHBottomNavigationAdapter(this, R.menu.bottombar);
        int[] colors={white,white,white,white};
        navigationAdapter.setupWithBottomNavigation(bottomNavigation,colors);
        bottomNavigation.setAccentColor(Color.parseColor("#70c7fd"));
        bottomNavigation.setInactiveColor(Color.parseColor("#62523c"));
        bottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {
                if(position==0){
                    startActivity(new Intent(createChallenge.this,MainActivity.class));
                }
                if(position==1){
                    startActivity(new Intent(createChallenge.this,live.class));
                }
                if(position==2){
                    Log.d("f","f");
                }
                if(position==3){
                    startActivity(new Intent(createChallenge.this,LoginActivity.class));
                }
                return true;
            }
        });
        bottomNavigation.setOnNavigationPositionListener(new AHBottomNavigation.OnNavigationPositionListener() {
            @Override
            public void onPositionChange(int y) {

            }
        });
    }

    protected void poopFunc(View view){
        Log.d("f","poop");

    }
    protected void cowFunc(View view){
        Log.d("f","cow");

    }
    protected void tomatoFunc(View view){
        Log.d("f","tomato");

    }
    protected void bombFunc(View view){
        Log.d("f","bomb");

    }
    protected void toiletFunc(View view){
        Log.d("f","toilet");

    }
    protected void zoabiFunc(View view){
        Log.d("f","zoabi");

    }
}
