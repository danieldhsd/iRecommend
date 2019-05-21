package com.example.irecomend;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);



        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera

        LatLng itauna = new LatLng(-20.056512,  -44.572482);
        mMap.addMarker(new MarkerOptions().position(itauna).title("Marcar em Itauna"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(itauna));


        CameraPosition update = new CameraPosition(itauna, 15, 0, 0);
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(update), 3000, null);

        mMap.setOnMapClickListener( new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick (LatLng latLng) {
                //função clear
                //mMap.clear();
                MarkerOptions options = new MarkerOptions() ;
                options.position( latLng ) ;
                mMap.addMarker( options ) ;
                startActivity(new Intent(MapsActivity.this, TelaCadastroEvento.class));
                //mMap.addMarker(new MarkerOptions().position(new LatLng(latitude, longitude)).title("Marker"));
            }
        });
    }



}
