package com.pinko;

import android.content.Context;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.TileOverlay;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.maps.android.heatmaps.HeatmapTileProvider;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class HeatmapHelper {


    public static void addHeatMap(Context context, GoogleMap map) {
        List<LatLng> latLngs = null;

        // Get the data: latitude/longitude positions of police stations.
        try {
            latLngs = readItems(context);
        } catch (JSONException | FileNotFoundException e) {
            Toast.makeText(context, "Problem reading list of locations.", Toast.LENGTH_LONG).show();
        }

        if (latLngs == null || latLngs.isEmpty()) {
            return;
        }

        // Create a heat map tile provider
        HeatmapTileProvider provider = new HeatmapTileProvider.Builder()
                .data(latLngs)
                .build();

        // Add a tile overlay to the map, using the heat map tile provider.
        TileOverlay overlay = map.addTileOverlay(new TileOverlayOptions().tileProvider(provider));


        map.moveCamera(CameraUpdateFactory.newLatLngZoom(latLngs.get(0), 1f));
    }

    private static List<LatLng> readItems(Context context) throws JSONException, FileNotFoundException {
        List<LatLng> result = new ArrayList<>();

        File path = context.getExternalFilesDir(null);
        File file = new File(path, "export-0.csv");


        InputStream inputStream = new FileInputStream(file);

        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                double lat = Double.parseDouble(values[0]);
                double lng = Double.parseDouble(values[1]);
                result.add(new LatLng(lat, lng));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
