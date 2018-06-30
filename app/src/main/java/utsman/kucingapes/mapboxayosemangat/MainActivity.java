package utsman.kucingapes.mapboxayosemangat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnMap).setOnClickListener(view ->
                startActivity(new Intent(getApplicationContext(), MapboxActivity.class))
        );

        findViewById(R.id.btnList).setOnClickListener(view ->
                startActivity(new Intent(getApplicationContext(), ListActivity.class))
        );
    }
}
