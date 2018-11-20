package morandoso.android.com;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import morandoso.android.com.R;

public class saude extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saude);

        getSupportActionBar().hide();
    }
}
