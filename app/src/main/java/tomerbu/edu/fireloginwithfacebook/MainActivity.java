package tomerbu.edu.fireloginwithfacebook;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by Ronen ₪ Tom on 23/08/2016.
 */

public class MainActivity extends AppCompatActivity {

    private String username = "";
    Button createChallengeBtn;
    public static AHBottomNavigation bottomNavigation;
    private static final String TAG = "TomerBu";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createChallengeBtn = (Button) findViewById(R.id.createChallenge);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user == null) {
            startActivity(new Intent(this, LoginActivity.class));

//            Toast.makeText(MainActivity.this, user.toString(), Toast.LENGTH_SHORT).show();
        } else {
            //    userListID.setValue();
            username = user.getDisplayName();
            Log.d(TAG, user.getDisplayName());
            Log.d(TAG, user.getEmail());
            Log.d(TAG, user.getPhotoUrl().toString());
        }
            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    // This method is called once with the initial value and again
                    // whenever data at this location is updated.
                    String value = dataSnapshot.getValue(String.class);
                    Log.d(TAG, "Value is: " + value);
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                    Log.w(TAG, "Failed to read value.", error.toException());
                }
            });

            bottomNavigation = (AHBottomNavigation) findViewById(R.id.bottomBar);
            AHBottomNavigationAdapter navigationAdapter = new AHBottomNavigationAdapter(this, R.menu.bottombar);
            int[] colors = {R.color.white, R.color.white, R.color.white, R.color.white};
            navigationAdapter.setupWithBottomNavigation(bottomNavigation, colors);
            bottomNavigation.setAccentColor(Color.parseColor("#fec471"));
            bottomNavigation.setInactiveColor(Color.parseColor("#62523c"));
            bottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
                @Override
                public boolean onTabSelected(int position, boolean wasSelected) {
                    Log.d("bbb", position + "");
                    if (position == 0) {
                        Log.d("f", "f");
                    }
                    if (position == 1) {
                        Intent i = new Intent(MainActivity.this, live.class);
                        startActivity(i);
                    }
                    if (position == 2) {
                        Log.d("f", "f");
                    }
                    if (position == 3) {
                        startActivity(new Intent(MainActivity.this, LoginActivity.class));
                    }
                    return true;
                }
            });
            bottomNavigation.setOnNavigationPositionListener(new AHBottomNavigation.OnNavigationPositionListener() {
                @Override
                public void onPositionChange(int y) {
                    // Manage the new y position
                }
            });

            createChallengeBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(MainActivity.this, createChallenge.class));
                }
            });

    }
}
