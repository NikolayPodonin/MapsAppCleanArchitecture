package podonin.android.com.mapsappcleanarchitecture.view.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import podonin.android.com.mapsappcleanarchitecture.R;
import podonin.android.com.mapsappcleanarchitecture.view.fragment.MapsFragment;

public class ContainerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction()
                .replace(R.id.fragment_container, MapsFragment.newInstance(), MapsFragment.class.getName())
                .commit();
    }
}
