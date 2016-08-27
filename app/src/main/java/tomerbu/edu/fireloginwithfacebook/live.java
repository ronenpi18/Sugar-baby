package tomerbu.edu.fireloginwithfacebook;

import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Tom on 23/08/2016.
 */

public class live extends AppCompatActivity {
    ProgressBar mProgressBar;
    TextView timeView;
    private static boolean stop;
    private static int from;
    private static int pixelPerMeter;
    private static int widthOfLine;
    private  CountDownTimer countDownTimer;
    int white=Color.parseColor("#ffffff");
    ImageView pin;
    View line;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");
        myRef.setValue("test");
        stop=false;
        from=0;
        AHBottomNavigation bottomNavigation = (AHBottomNavigation) findViewById(R.id.bottomBar);
        AHBottomNavigationAdapter navigationAdapter = new AHBottomNavigationAdapter(this, R.menu.bottombar);
        int[] colors={white,white,white,white};
        navigationAdapter.setupWithBottomNavigation(bottomNavigation,colors);
        bottomNavigation.setAccentColor(Color.parseColor("#70c7fd"));
        bottomNavigation.setInactiveColor(Color.parseColor("#62523c"));
        bottomNavigation.setCurrentItem(1);
        pin=(ImageView) findViewById(R.id.distancePin);
        line=(View) findViewById(R.id.line);
        bottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {
                stop=true;
                if(position==0){
                    Intent i=new Intent(live.this,MainActivity.class);
                    startActivity(i);
                }
                if(position==1){
                    Log.d("f","f");
                }
                if(position==2){
                    Log.d("f","f");
                }
                if(position==3){
                    Log.d("f","f");
                }
                return true;
            }
        });
        MainActivity.bottomNavigation.setOnNavigationPositionListener(new AHBottomNavigation.OnNavigationPositionListener() {
            @Override
            public void onPositionChange(int y) {

            }
        });

        mProgressBar = (ProgressBar) findViewById(R.id.progressbar);
        timeView = (TextView) findViewById(R.id.timeView);
        //get the distance challenge and the time to complete
    }
    protected void onStart(){
        super.onStart();
        startTimer(30);
        Log.d("width",line.getWidth()+"");
    }
    private void startTimer(final int sec) {
        mProgressBar.setRotation(270.0f);
        mProgressBar.setMax(sec);
        countDownTimer= new CountDownTimer(sec * 1000, 500) {
            // 500 means, onTick function will be called at every 500 milliseconds
            @Override
            public void onTick(long leftTimeInMilliseconds) {
                if (stop == true) {
                    Log.d("stop", "s");
                    countDownTimer.cancel();
                    timeView.setText("STOP");
                } else {
                    //get how much he ran until now
                    animation(3);
                    long seconds = leftTimeInMilliseconds / 1000;
                    mProgressBar.setProgress((int) seconds);
                    timeView.setText(String.format(String.format("%02d", seconds % 60)));
                    // format the textview to show the easily readable format
                }
            }
            @Override
            public void onFinish() {
                timeView.setText("STOP");

            }
        }.start();

    }
    private void animation(int width) {
        width = width * pixelPerMeter + from;
        if (width >= widthOfLine&&widthOfLine!=0) {
            stop = true;
        } else {
            TranslateAnimation trans = new TranslateAnimation(from, width, 0, 0);
            from = width;
            trans.setDuration(500);

            AlphaAnimation alpha = new AlphaAnimation(0, 1);

            AnimationSet combine = new AnimationSet(true);
            combine.addAnimation(trans);
            combine.addAnimation(alpha);

            pin.startAnimation(combine);
        }
    }

    private void calculate(int distanceInMeter){
        pixelPerMeter=widthOfLine/distanceInMeter;
    }
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        //test need to change
        widthOfLine=line.getWidth();
        calculate(100);
    }
}
