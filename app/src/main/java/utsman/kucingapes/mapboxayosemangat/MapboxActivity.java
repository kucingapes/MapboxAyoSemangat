package utsman.kucingapes.mapboxayosemangat;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.annotations.MarkerOptions;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;

public class MapboxActivity extends BaseLocation implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Mapbox.getInstance(getApplicationContext(), getString(R.string.token_mapbox));
        setContentView(R.layout.activity_mapbox);
        mapView = findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);
    }

    @Override
    public void onMapReady(MapboxMap mapboxMap) {
        MapboxActivity.this.mapboxMap = mapboxMap;
        enableLocationPlugin();
        myLocationBtn();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference("data");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot ds: dataSnapshot.getChildren()) {
                    Double lng = ds.child("lng").getValue(Double.class);
                    Double lat = ds.child("lat").getValue(Double.class);
                    String title = ds.child("title").getValue(String.class);
                    String snip = ds.child("subtitle").getValue(String.class);

                    addMarker(lng, lat, title, snip);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void myLocationBtn() {
        findViewById(R.id.mylocation).setOnClickListener(view ->
                initializeLocationEngine()
        );
    }

    private void addMarker(Double lat, Double lng, String title, String snip) {
        mapboxMap.addMarker(new MarkerOptions()
                .position(new LatLng(lng, lat))
                .title(title)
                .snippet(snip));
    }
}