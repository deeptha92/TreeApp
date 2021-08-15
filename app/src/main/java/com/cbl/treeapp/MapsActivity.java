package com.cbl.treeapp;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.cbl.treeapp.databinding.ActivityMapsBinding;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    ArrayList<LatLng> arrayListTree = new ArrayList<LatLng>();
    LatLng sydney = new LatLng(-34, 151);
    LatLng marker2 = new LatLng(-31.08322, 150.91672);
    LatLng marker3 = new LatLng(-32.08975, 151.75000);
    LatLng marker4 = new LatLng(-27.84512, 153.2127800);
    LatLng marker5 = new LatLng(-32.2578400, 148.6054502);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        arrayListTree.add(sydney);
        arrayListTree.add(marker2);
        arrayListTree.add(marker3);
        arrayListTree.add(marker4);
        arrayListTree.add(marker5);
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
        for (LatLng arrayListTree : arrayListTree
        ) {
            mMap.addMarker(new MarkerOptions().position(arrayListTree).title("Marker"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(arrayListTree));
        }


    }
}