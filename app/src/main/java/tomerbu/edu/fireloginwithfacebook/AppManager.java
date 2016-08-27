package tomerbu.edu.fireloginwithfacebook;

import android.app.Application;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;

/**
<<<<<<< HEAD
<<<<<<< HEAD
 * Created by Ronen on 23/08/2016.
=======
 * Created by tomerbuzaglo on 23/06/2016.
>>>>>>> 65f2acf393abc5dd31d2d7894c6fcac74c6a1449
=======
 * Created by tomerbuzaglo on 23/06/2016.
>>>>>>> 65f2acf393abc5dd31d2d7894c6fcac74c6a1449
 */
public class AppManager extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);
    }
}
