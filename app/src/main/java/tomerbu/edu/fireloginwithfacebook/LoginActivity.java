package tomerbu.edu.fireloginwithfacebook;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.Profile;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
<<<<<<< HEAD
<<<<<<< HEAD
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
=======
>>>>>>> 65f2acf393abc5dd31d2d7894c6fcac74c6a1449
=======
>>>>>>> 65f2acf393abc5dd31d2d7894c6fcac74c6a1449
import com.google.firebase.database.FirebaseDatabase;


public class LoginActivity extends AppCompatActivity {

<<<<<<< HEAD
<<<<<<< HEAD

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference userListID = database.getReference("userATA");
=======
>>>>>>> 65f2acf393abc5dd31d2d7894c6fcac74c6a1449
=======
>>>>>>> 65f2acf393abc5dd31d2d7894c6fcac74c6a1449
    private CallbackManager callbackManager;
    private FirebaseAuth mAuth;
    private String TAG = "Tomer";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        final Intent i=new Intent(this, MainActivity.class);

<<<<<<< HEAD
<<<<<<< HEAD
        final LoginButton loginButton = (LoginButton) findViewById(R.id.login_button);
        loginButton.setReadPermissions("email", "public_profile");

        callbackManager = CallbackManager.Factory.create();
        //       final DatabaseReference userListID = database.getReference("UserList").child("ID");
//        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
=======
=======
>>>>>>> 65f2acf393abc5dd31d2d7894c6fcac74c6a1449
        LoginButton loginButton = (LoginButton) findViewById(R.id.login_button);
        loginButton.setReadPermissions("email", "public_profile");

        callbackManager = CallbackManager.Factory.create();
<<<<<<< HEAD
>>>>>>> 65f2acf393abc5dd31d2d7894c6fcac74c6a1449
=======
>>>>>>> 65f2acf393abc5dd31d2d7894c6fcac74c6a1449

        // Callback registration
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                handleFacebookAccessToken(loginResult.getAccessToken());
<<<<<<< HEAD
<<<<<<< HEAD
                userListID.child(loginResult.getAccessToken().getUserId()).setValue("numw");


=======
>>>>>>> 65f2acf393abc5dd31d2d7894c6fcac74c6a1449
=======
>>>>>>> 65f2acf393abc5dd31d2d7894c6fcac74c6a1449
                startActivity(i);

            }
            @Override
            public void onCancel() {
                Log.d(TAG, "facebook:onCancel");
            }
            @Override
            public void onError(FacebookException e) {
                Log.d(TAG, "facebook:onError", e);
            }
        });
    }

    private void handleFacebookAccessToken(AccessToken token) {
        Log.d(TAG, "handleFacebookAccessToken:" + token);

        AuthCredential credential = FacebookAuthProvider.getCredential(token.getToken());
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "signInWithCredential:onComplete:" + task.isSuccessful());

                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Log.w(TAG, "signInWithCredential", task.getException());
                            Toast.makeText(LoginActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                        else startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    }
                });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}
