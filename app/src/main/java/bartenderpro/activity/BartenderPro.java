package bartenderpro.activity;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

import com.example.eduar.bartenderpro.R;
import com.google.firebase.auth.FirebaseAuth;

import bartenderpro.fragment.LoginFragment;

public class BartenderPro extends AppCompatActivity {

    FirebaseAuth fbAuth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        if (fbAuth.getCurrentUser() != null)
            fbAuth.signOut();

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame_container, new LoginFragment());
        ft.commit();


    }
}